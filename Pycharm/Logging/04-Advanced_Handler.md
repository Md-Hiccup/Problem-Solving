# Logging in Python 

##  04 - Advanced Handlers

####    Rotating Files
-   When you are logging a lot of data to a file, it can be difficult to use your log files if they become too large. The standard library offers a few special file handler implementations that can manage this problem for you. 

-   The RotatingFileHandler supports a maximum file length parameter. If a new log message is going to exceed that maximum length, the file is closed and a new file is created. This ensures your files are all a manageable size. The file length is specified in the maxBytes argument passed to the RotatingFileHandler constructor. 

-   Before the RotatingFileHandler starts a new file, it will rename the old log files with a number appended to each name. For example ".1", ".2". The most recent log data is always written to the log file without this extension. The second most recent data has the ".1" extension, and so forth. 

-   The RotatingFileHandler does one last thing, it keeps only the specific number of files. This is done in the backupCount argument. The oldest log files are removed. This allows us to keep a fixed limit on the space and number of files used by our logging. This is important for running systems over a long period of time. 

1.  Complete the import statement for the "logging.handlers" module. 
2.  Create a new instance of the RotatingFileHandler object 

-   After you run this task, you should see the files: "rotating.log", "rotating.log.1", and "rotating.log.2" under your Sandbox folder. The sandbox is located in your Project tree, near the bottom. If you do not see the files, try collapsing and expanding the Sandbox folder. 

-   Note: When you look at these log files, you will only see the most recent log messages.

```
import logging.handlers

file_handler = logging.handlers.RotatingFileHandler(log_filename,mode='a',maxBytes=max_file_size,backupCount=max_files)

```

####    Rotating files by time
-   In the previous task, we started new log files based on the file size. In some cases, it's useful to start a new log file after a specified time interval. When you are given a problem to diagnose at a specific time, it is easier to determine which log file contains the log information based on the filename. 

-   TimedRotatingFileHandler is similar to RotatingFileHandler() except you specify two interval parameters. The first argument "when" specifies the type of interval. Here are possible values (case insensitive): 
```
VALUE          TYPE OF INTERVAL
=============+======================'
'S'          | Seconds
'M'          | Minutes
'H'          | Hours
'D'          | Days
'W0'-'W6'    | Weekday (0=Monday)
'midnight'   | Roll over at midnight
```

-   The second argument is "interval" which is going to depend on the type of interval. Using a "when" value of "H" and an "interval" of "1" is going to roll over the log file every one hour. 

-   In this task, we have created a special filter that causes a delay between log records. This is to help demonstrate the rolling over behavior using time. 

-   Update the arguments to TimedRotatingFileHandler to rotate the log file every two seconds. 

-   After you execute this task, wait about 20 seconds, then look at the Sandbox folder for the "timed_rotation.log" files. You should note how the filename also has a date/time appended to it.

```
import logging.handlers

file_handler = logging.handlers.TimedRotatingFileHandler(log_filename,
                                                             when="S",
                                                             interval=2,
                                                             backupCount=4)
```

####    Memory Handler
-   The MemoryHandler is a special handler that provides buffering of log messages until it the specified capacity or a specified severity level. At that time, the buffered log messages are sent to another Handler. 

-   If you wanted to limit disk activity from the logger to less frequent intervals, the MemoryHandler is useful. 

-   MemoryHandler is defined in the "logging.handlers" module. It takes a "capacity" argument which is the number of log records, and a target which is an instance of another file handle. 

-   In this task, configure the MemoryHandler to use the FileHandler object.

```
import logging.handlers

log_filename = '../../Sandbox/memory_handler.log'
file_handler = logging.FileHandler(log_filename, mode='w')

fmt = logging.Formatter('%(asctime)s %(levelname)s %(message)s')
file_handler.setFormatter(fmt)

memory_handler = logging.handlers.MemoryHandler(capacity=2, target=file_handler)
```

####    HTTP handler
-   The standard library provides quite a few handlers. The following is a summary:
```
StreamHandler, FileHandler, NullHandler, RotatingFileHandler, TimedRotatingFileHandler, WatchedFileHandler,
SocketHandler, DatagramHandler, SysLogHandler, SMTPHandler, NTEventLogHandler, HTTPHandler, BufferingHandler,
and MemoryHandler.
```

-   In this last advanced handler task, we are going to demonstrate the HTTPHandler. This can be used to send log messages to a HTTP server. 

-   The Python standard library includes a built-in HTTP Server we are going to use in this task. If you are in Windows you need to open a command window that has Python in the path. If you are on a Unix-based system you need to open a local shell window. 

-   Enter the following in the new window: 
python -m SimpleHTTPServer 8080 

-   This should see a message such as "Serving HTTP on 0.0.0.0 port 8080". 

-   If you are already running a service on this port, you may need to make changes in this task. 

-   Once you have done that, update the task to use the HTTPHandler and pass it the host value of "127.0.0.1:8080" and "url" value of "/". The default HTTP method "GET" will be used. 

-   After you have run this code, you should see results from the SimpleHTTPServer window. You can then terminate the HTTP server with Control-C. If you were unable to get the HTTP server working, you can continue to the next task after you have made the changes. Just ignore the console warnings about not being able to connect. This would demonstrate a potential production issue for your system if the HTTP server was not available, so use this handler with caution.

```
import logging.handlers

http_handler = logging.handlers.HTTPHandler(host='127.0.0.1:8080',
                                                url='/',
                                                method='GET')

```

####    Shutdown
-   One thing you should be aware of when working with more advanced handlers, is how the logging system gracefully closes and cleans up any resources it is using. For example, if a handler is buffering log messages such as the MemoryHandler, then how does the logging system ensure those messages are handled. 

-   This is done through the "logging.shutdown()" function. The logging module will automatically register this function to be called when the interpreter is shutting down. So, normally you shouldn't have to worry about it. However, there are some cases where you might want to explicitly shutdown your handlers. For example, if you are debugging your handlers "close()" method or the handler is using some resources that may be uninitialized by the time the close() method is called. 

-   In this task, insert the call to explicitly shutdown the logging system.

```
import logging.handlers

logging.shutdown()

```

####    Removing Handlers
-   A handler can be removed from a logger using the Logger's removeHandler(). 

-   At some point in your life with the logging module, you will encounter a problem with duplicate log messages. The likely cause is an extra handler was inserted somewhere in your logger hierarchy. Since log messages are sent up the hierarchy to each handler, you can get the same output duplicated. One extremely useful module to use in debugging problems like this is the "logging_tree" module by Brandon Rhodes. I encourage you to try this module after this course. 

-   In this code, we are simulating two stream handlers that have been added to our logging hierarchy. 

-   Add the necessary code to leave the root handler, but remove all the handlers from the "A.B" logger. Since, removeHandler() takes a handler object, we have to get the handler from the handlers attribute on the Logger.

```
import logging.handlers

b_log = logging.getLogger('A.B')

# Remove all handlers attached to logger
while len(b_log.handlers):
    handler = b_log.handlers[0]
    b_log.removeHandler(handler)
```
