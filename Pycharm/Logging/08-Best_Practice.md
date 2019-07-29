#   Logging

##  08 - Best Practice

####    Logger naming
-   Logger instances are typically named by using the __name__ builtin. When you organize your modules into packages, the logger name hierarchy will reflect the package structure. You can take advantage of this by being selective about logging levels. 

-   When you run a python script directly, the __name__ will take on the value "__main__". 

-   In this task, replace the module scoped logger instance using __name__ builtin.

```
import logging

logger = logging.getLogger(__name__)
```


####    Private Loggers
-   Most of our Logger instances have been defined at module scope. This is certainly the most convenient way to use logging, but in some cases you want to have more control over loggers. You can defer creating a logger instance until it's actually needed. 

-   In this example, we show how to create a private logger instance in the class constructor. We use the name of the current module and append the class name. This will allow us to enable selective logging on just the output from the class. 

1.  Complete the name of the FirstClass logger instance 
2.  Set the instance logger level to DEBUG 

-   You should not see any DEBUG output, except the log messages coming from the FirstClass object.

```
import logging

logger = logging.getLogger(__name__)

class FirstClass():
    def __init__(self):
        self.log = logging.getLogger(__name__ + '.first_class')

    def do_something(self):
        self.log.debug('FirstClass do_something() called')


class SecondClass():
    def __init__(self):
        self.log = logging.getLogger(__name__ + '.second_class')

    def do_something(self):
        self.log.debug('SecondClass do_something() called')

if __name__ == '__main__':
    logging.basicConfig(level=logging.WARNING)

    logger.debug('module scope log output')

    first = FirstClass()
    first.do_something()

    second = SecondClass()
    second.do_something()

    first_logger = logging.getLogger(__name__ + '.first_class')
    first_logger.setLevel(logging.DEBUG)
    first.do_something()
    second.do_something()
```

####    Conditional Logging
-   If you are calling an expensive function and passing the result to a logging statement, you may want to prevent that function from being called unless the current logging level is going to output the log message. 

-   This can be done by checking the return value from "isEnabledFor()" on the Logger object. This function takes the logging level, and if the logger is going to output the message, the return value is True. 

-   In this example, the root logger level is set to WARNING. We output a debug level log message, passing in the result of calculate_expensive_result(). This code executes, even though the debug level message is being filtered out. 

-   Add a conditional statement to not log this message if the log level will not apply to the handler.

```
import logging
import time

logger = logging.getLogger(__name__)

def calculate_expensive_result(timeout):
    time.sleep(timeout)
    return 1


if __name__ == '__main__':
    logging.basicConfig(level=logging.WARNING)

    if logger.isEnabledFor(logging.DEBUG):
        logger.debug('expensive_result=%d', calculate_expensive_result(5))

```


####    Logging in Libraries
-   You should typically not configure any logging handlers if you are writing a library. It is quite obnoxious for a library developer to do this, since it should be under the control of the developer using your library. 

-   If you are the developer of the library, then configure your logging handlers in a test application instead. 

-   Let's assume in this task, this is a library module. It explicitly creates a FileHandler and adds it to the module's logger at file scope. This is "NOT" a good practice. Let's at least replace this using the NullHandler, which will not write the logs anywhere. If the library user wants to log somewhere, he can do that himself at the application level.

```
# mortgage library
#
import logging
import math

logger = logging.getLogger(__name__)
logger.addHandler(logging.NullHandler())

def get_current_rate(years):
    logger.debug('Fetching current interest rate for %d years', years)
    rate = 5.3   # Stub external service call
    logger.debug('Service returned interest rate %f', rate)
    return rate

def get_monthly_payment(principal, years):
    logger.info('Calling mortgage calculator')

    if years > 50:
        logger.warn('Term greater than 50 years')

    mon_rate = get_current_rate(years)/1200
    payments = years * 12
    logger.debug('Number of monthly payments %d', payments)
    result = principal * (mon_rate/(1-math.pow((1+mon_rate), -payments)))

    logger.debug('Calculated result is %f', result)
    logger.debug('Leaving mortgage calculator')
    return result
```


####    Using the right levels
-   Using the right logging severity levels can be very subjective. This is one of the reasons why it's better to have fewer logging levels. It is important that you try to use the right level, so that you can set the most appropriate logging level in your application and not have too much information. 

-   In this task, there are some example log messages, and based on the message and context, try to pick the right severity level for each message. 

-   Remember, this could be very subjective, so click the Hint button to see what is expected.

```
import logging

if __name__ == '__main__':
    logging.basicConfig(level=logging.DEBUG)

    user_id = 1001
    ip = '10.0.0.15'
    port = 5555
    account_id = 3551
    version = '1.5.2'

    logging.log(logging.INFO, 'Service restarted - version %s', version)

    logging.log(logging.FATAL, 'Failed to connect to calculator service at ip=%s:%d', ip, port)

    logging.log(logging.INFO, 'Created user account id=%d', user_id)

    logging.log(logging.WARNING, 'User entered invalid account id=%d account_id=%d', user_id, account_id)

    logging.log(logging.CRITICAL, 'Could not connect to user database')

    logging.log(logging.DEBUG, 'DB Transaction created for updating user id=%d', user_id)
```


####    Using a Decorator
-   Writing custom logging decorators can help you cut down on some boilerplate logging code. 

-   In this example, we want to have our function "do_work" log when the function starts and finishes and also include how long it took to execute. 

-   We have written an example decorator for you. 

1.  Add the decorator to the "do_work" function 
2.  Set the appropriate log level to allow us to see the decorator results.


```
import logging
import time
import functools

def logging_decorator(f):
    @functools.wraps(f)
    def wrapper(*args, **kwargs):
        logging.debug('Entering %s', f.__name__)
        start = time.time()
        f(*args, **kwargs)
        end = time.time()
        logging.debug('Exiting %s in %-5.2f secs', f.__name__, end-start)

    return wrapper

@logging_decorator
def do_work(timeout):
    # Doing something expensive
    time.sleep(timeout)


if __name__ == '__main__':
    logging.basicConfig(level=logging.DEBUG)
    do_work(5)
```


####    Just enough context
-   What data to put into a log message can also be subjective. However, it's important to put enough data (context) into high severity messages to help identify the root cause of a problem. 

-   Many people do not like to run at a DEBUG level all the time, because it generates too much information and slows down their applications. DEBUG messages are also usually not too useful beyond initial development. If you want to run at the INFO level and higher (recommended) in normal operations, then you need those messages to have enough context to be useful in diagnosing problems. 

-   When an exception occurs, you might want to include some of the input values that were used leading up to that exception. If you are working with a database, you might simply need to include the table name and key value, so you could look up the data later. 

-   In this example, please include the most relevant piece of context data in the exception logging.

```
import logging

def do_service_lookup(service_address):
    try:
        raise Exception('Connection refused.')

    except:
        logging.exception(service_address)

if __name__ == '__main__':
    logging.basicConfig(level=logging.INFO)

    do_service_lookup('10.0.0.15')
```