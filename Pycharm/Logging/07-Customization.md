#   Logging

##  07 - Customization

####    JSON Formatter
-   Writing your log messages out as structured JSON objects allows you to write programs to easily process your logs. 

-   In this task, we have created a new object called JSONFormatter that inherits from Formatter. The most important method to implement is the "format()" method which returns a string to be passed to a Handler. 

-   In this task, add the call to set this new formatter on the StreamHandler instance.

```
import logging
import json
import datetime
import traceback

class JsonFormatter(logging.Formatter):
    def format(self, record):
        if record.exc_info:
            exc = traceback.format_exception(*record.exc_info)
        else:
            exc = None

        return json.dumps({
            'msg': record.msg % record.args,
            'timestamp': datetime.datetime.utcfromtimestamp(record.created).isoformat() + 'Z',
            'func': record.funcName,
            'level': record.levelname,
            'module': record.module,
            'process_id': record.process,
            'thread_id': record.thread,
            'exception': exc
        })

if __name__ == '__main__':
    handler = logging.StreamHandler()

    fmt = JsonFormatter()
    handler.setFormatter(fmt)

    root_logger = logging.getLogger()
    root_logger.setLevel(logging.DEBUG)
    root_logger.addHandler(handler)

    try:
        raise Exception('This is an exception')
    except:
        root_logger.exception('caught exception')

    root_logger.warn('this is a test message')
    root_logger.debug('this request_id=%d name=%s', 1, 'John')
```


####    Smart Memory Handler
-   In a previous lesson we demonstrated the MemoryHandler class. This handler buffers log records and sends them to another handler after a specified number of records or a specified severity level is received. 

-   With one small change we can make a smarter version of this handler that only writes to another handler when an ERROR or higher message is logged. We could run our root logger at the DEBUG level, but instead of writing these to a file after a specified capacity is reached, we discard the oldest records until an ERROR or higher level log message. 

-   You can see how we implemented this in the shouldFlush() method of our SmartMemoryHandler. 

-   For this task, create a new instance of our SmartMemoryHandler using the same options as we used for our MemoryHandler. You can see this commented out above the answer placeholder. 

-   After you execute this code, you can load the file "smart_memory_handler.log" located under the Sandbox folder. Collapse and Expand this folder to ensure the file listing is refreshed. In this file you can see that there are only 2 log messages (as we specified). Only the most recent DEBUG message was included in the output. You can see how in this example this has given us enough information to help troubleshoot the exception.

```
log_filename = '../../Sandbox/smart_memory_handler.log'
file_handler = logging.FileHandler(log_filename, mode='w')

fmt = logging.Formatter('%(asctime)s %(levelname)s %(message)s')
file_handler.setFormatter(fmt)

# memory_handler = logging.handlers.MemoryHandler(capacity=2, target=file_handler)

memory_handler = SmartMemoryHandler(capacity=2, target=file_handler)
root_logger = logging.getLogger()
root_logger.addHandler(memory_handler)
root_logger.setLevel(logging.DEBUG)
```


####    Database Handler
-   The standard library does not include a database handler for storing log messages in a database. The Python logging system is easy to extend with our own database logging. Having log data in a database is useful for writing queries and reports against your log data. 

-   In this example, we have created a SQLite database handler. Since, the SQLite database module is included in the standard library, you don't have to install any databases. 

-   This custom handler will attempt to create the database table named 'logger' with the necessary schema to store most of the LogRecord attributes. 

-   In the Handler's emit() method we will insert the LogRecord data into the table. 

-   At the end of the task we write several queries to the database.

```
from __future__ import print_function
import logging
import logging.config
import datetime
import sqlite3 as sqlite


class DatabaseHandler(logging.Handler):
    """ Store log records in a sqlite database.
    """
    def __init__(self, filename):
        super(DatabaseHandler, self).__init__()
        self.db = sqlite.connect(filename)
        try:
            self.db.execute(
                        "CREATE TABLE logger(record_id INTEGER PRIMARY KEY, name TEXT," \
                        "asctime TEXT, level TEXT, funcName TEXT, lineno INTEGER," \
                        "module TEXT, message TEXT);")
            self.db.commit()

        except sqlite.OperationalError as e:
            logging.info('database filename=%s already exists', filename)


    def emit(self, record):
        if self.db:
            timestring = datetime.datetime.utcfromtimestamp(record.created).isoformat() + 'Z'
            message = record.msg % record.args

            self.acquire()
            try:
                self.db.execute("INSERT INTO logger(name, asctime, level, funcName, lineno, module, message) " \
                    "VALUES(?, ?, ?, ?, ?, ?, ?);",
                    (record.name, timestring, record.levelname, record.funcName, record.lineno, record.module, message))
                self.db.commit()
            finally:
                self.release()

    def close(self):
        self.db.close()
        self.db = None
        super(DatabaseHandler, self).close()


if __name__ == '__main__':
    db_filename = '../../Sandbox/log.db'

    log_config = {
        'version': 1,
        'handlers': {
            'db': {
                'class': 'db_handler.DatabaseHandler',
                'filename': db_filename
            }
        },
        'root': {
            'handlers': ['db'],
            'level': 'DEBUG'
        }
    }


    logging.config.dictConfig(log_config)
    logging.debug('Configured logging to database filename=%s', db_filename)

    logging.warn('root logger warning message')
    logging.debug('Connecting to database to read warning counts')

    db = sqlite.connect(db_filename)
    result = db.execute('select count(*) from logger where level="WARNING"')
    print('Number of WARNING log messages in database is %s' % result.fetchone()[0])

    result = db.execute('select count(*) from logger where level="DEBUG"')
    print('Number of DEBUG log messages in database is %s' % result.fetchone()[0])

```


####    Injecting Data
-   This task demonstrates how you can use a Filter to inject attributes into a LogRecord, and then format those attributes using a Formatter. This can be done in the Filter's "filter()" method, which is passed the "record" object containing the log attributes. 

-   This task also demonstrates how a Filter() can be configured using dictConfig(), something that is not possible using fileConfig(). In this example, the class name is specified directly in Python code. 

-   In this task, we have defined a "LogUserInjector" filter class. It exposes a public method "set_userid()" that can be called to set the current user ID. It stores this value in thread local storage, so each thread of execution can maintain a unique value while the thread is running, or until the next call to set the user ID. As log messages in the thread are logged, they are passed to our filter. The filter reads the user ID from thread local storage and injects this value into the LogRecord. We also added "%(user_id)s" to our formatting string, so every log message will contain this attribute.

```
import logging
import time
import random
import logging.config
import threading

class LogUserInjector(logging.Filter):
    thread_local_data = threading.local()

    def filter(self, record):
        record.user_id = self.thread_local_data.user_id
        return True

    @classmethod
    def set_userid(cls, user_id):
        cls.thread_local_data.user_id = user_id


def simulate_user(user_id):
    LogUserInjector.set_userid(user_id)

    logging.debug('user logged_in')
    time.sleep(random.random())
    logging.debug('user performed some activity')
    time.sleep(random.random())
    logging.debug('user logged_out')
    time.sleep(random.random())


if __name__ == '__main__':

    log_config = {
        'version': 1,
        'formatters': {
            'with_uid': {
                'format': '%(levelname)s - %(asctime)s - %(thread)s UID=%(user_id)d - %(message)s'
            }
        },
        'handlers': {
            'stderr': {
                'class': 'logging.StreamHandler',
                'formatter': 'with_uid',
                'filters': ['uid']
            }
        },
        'filters': {
            'uid': {
                '()': LogUserInjector
            }
        },
        'root': {
            'handlers': ['stderr'],
            'level': 'DEBUG'
        }
    }

    logging.config.dictConfig(log_config)

    threads = []
    for user_id in [1, 5, 2, 3]:
        thread = threading.Thread(target=simulate_user, args=(user_id,))
        thread.start()

    for thread in threads:
        thread.join()


```