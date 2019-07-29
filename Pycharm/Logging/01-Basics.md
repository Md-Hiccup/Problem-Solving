# Logging in Python 

##  01 - Basics

####    Replacing Print
-   The problem with using "print" to output debugging information, is it does not work well in larger programs. The debug output interferes with application output and you typically end up commenting out or removing all this extra code when you are not debugging. 
-   The standard logging module provides an easy way to separate application output from debug output.
>   logging.debug("Some Message")

####    Log Output
-   There is no output because a default "Logger" instance was created for you by the "logging" module and the logging level was set to WARNING level. This default "Logger" is also known as the "root" Logger. 
-   The WARNING level is an example of how we can tag our log statements with a severity level and perform filtering based on the level.  
-   The "basicConfig()" function is a helper method for doing basic configuration of logging. Without any parameters, it will create a StreamHandler that writes logging output to the "stderr" output stream. We can also pass a keyword argument "level" to set the default logger level. 
>   logging.basicConfig(level=logging.DEBUG)

####    Levels
-   The logging module provides five logging levels. The levels allow you to control what messages are included in the output stream. Five levels is usually good for most applications, as having more levels just leads to confusion about which level to use. 

-   Each level is known by a constant (in all caps) and has a numeric value. The value comes into play when setting a log level on a logger. Only messages at the logger's current logging level or greater is output. 

```
LEVEL NAME         | FUNCTION                | VALUE
===================+=========================+==========
CRITICAL           | critical()              | 50
ERROR              | error()                 | 40
WARNING            | warning() or warn()     | 30
INFO               | info()                  | 20
DEBUG              | debug()                 | 10
```
>   logging.warning("Term greater than 50 years")

>   logging.info('Calling mortgage calculator')

####    Loggers
-   Typically you will get local Logger objects for each module and call logging functions on that object. This is done by calling "logging.getLogger()" which returns a Logger object for a given name. You should never directly create instances of a Logger object. 
-   Calling "logging.getLogger()" with no arguments, will return the root Logger. 

>   logger = logging.getLogger('mortgage')

>   logger.info('Calling mortgage calculator')

####    Multiple Loggers
-   Logger names can form a named hierarchy. This allows you to selectively enable log messages at any point in this hierarchy. You can create a new branch in the namespace by separating the logger instance name with periods. 
-   Example hierarchy with the corresponding getLogger() call:

```
ROOT                                        
logging.getLogger()
   |
   +-- "a"                                  
logging.getLogger("a")
   |    |
   |    +-- "a1"                            
logging.getLogger("a.a1")
   |    |    |
   |    |    +-- "aaa"                      
logging.getLogger("a.a1.aaa")
   |    |    |
   |    |    +-- "bbb"                      
logging.getLogger("a.a1.bbb")
   |    |
   |    +--- "b1"                           
logging.getLogger("a.b1")
   |
   +-- "b"                                  
logging.getLogger("b")
```
>   logger = logging.getLogger('mortgage')

>   logger = logging.getLogger('mortgage.rate')


####    Log Method
-   In our previous examples, we logged messages with different severity levels using helper functions such as logger.debug() or logger.warning(). This is the easiest way to log messages. 

-   If you need to dynamically change the log level (for example, escalate a warning to an error), then you can use the Logger "log()" method which takes the level as the first argument. 

>   logger = logging.getLogger('mortgage')

>   logger.log(logging.INFO, "Calling mortgage calculator")

####    Special Log Levels
-   We mentioned in a previous task, there are 5 severity levels : CRITICAL, ERROR, INFO, WARNING, DEBUG. 

-   There are a few exceptions. First, a few of the levels have several constants defined. FATAL can be used instead of CRITICAL. There is also a fatal() helper method for this level. Both CRITICAL and FATAL share the same numeric log level of 50. They can be used interchangeably. 

-   WARN can also be used as a shortcut for WARNING. They mean the same thing. 

-   NOTSET is a special constant that represents the lowest possible log severity level. It has a value of 0. You should not log messages with this severity level. It is used when configuring loggers in the logging hierarchy. 

>   logging.basicConfig(level=logging.NOTSET)

####    Selective Logging
-   When you can organize logging into a hierarchy, you can easily change the logging level at any point in this structure. This is a powerful way as narrowing your output to certain modules or subsystems. 

-   You can change the level in this structure by obtaining the logger instance at that level and calling the "setLevel" method with the desired log level. 

-   In this task, obtain a reference to the "mortgage.rate" logger instance and set its level to DEBUG. When we run this program, we will see all messages DEBUG level or higher for this logger.

>   logger = logging.getLogger('mortgage')

>   logger = logging.getLogger('mortgage.rate')

>   logging.basicConfig(level=logging.WARNING)

>   rate_logger = logging.getLogger("mortgage.rate")

>   rate_logger.setLevel(logging.DEBUG)
