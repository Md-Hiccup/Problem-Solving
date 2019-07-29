# Logging in Python 

##  02 - Formatting

####    Custom Format String
-   You can customize how each log message is output by specifying a format string. 

-   This can be done by passing a "format" keyword argument to the "basicConfig" function. 

-   The following format string will output the human readable datetime, the severity level and the log message. 
'%(asctime)s %(levelname)s %(message)s' 

```
logging.basicConfig(level=logging.DEBUG,
                format='%(asctime)s %(levelname)s %(message)s')
```

####    Custom datetime format
-   In the previous task, we used the "%(asctime)s" format specifier to print a human readable datetime string. 

-   We can further customize the date/time output with the "datefmt" keyword argument in the call to "basicConfig()". The value is a "strftime" compatible format string. 

-   In this task, pass a "datefmt" string value that would print a date time looking like "Sun Feb 22 2015 09:33:25PM". 
-   Here's an example of some of the strftime() codes that can be used to create such a format string. 

```
Code | Description                                     | Example
=====+=================================================+==========
%A   | Weekday as locales full name                    | Wednesday
%a   | Weekday as locales abbreviated name             | Wed
%b   | Month as locales abbreviated name               | Jan
%d   | Day of the month                                | 02
%Y   | Year with century as a decimal number           | 2014
%I   | Hour (12-hour clock)                            | 05
%M   | Minute as a zero-padded decimal number          | 15
%S   | Second as a zero-padded decimal number          | 30
%p   | Locales equivalent of either AM or PM           | PM
```

>   logging.basicConfig(level=logging.DEBUG,                    format='%(asctime)s %(levelname)s %(message)s',datefmt='%a %b %d %Y %I:%M:%S%p')

####    Log Record Attributes
-   A LogRecord object is created when you call one of the logging functions, such as logging.debug(). This object contains attributes that can be included in the format string. Here are the most useful ones: 

```
Attribute   | Format string   | Description
============+=================+=================================
asctime     | %(asctime)s     | Human-readable date/time
levelname   | %(levelname)s   | Logging level string
filename    | %(filename)s    | Filename of current module
funcName    | %(funcName)s    | Name of current function
lineno      | %(lineno)d      | Line number of logging call
module      | %(module)s      | Module name (without .py)
message     | %(message)s     | Log Message
name        | %(name)s        | Logger instance name
process     | %(process)d     | Process ID
processName | %(processName)s | Process Name
thread      | %(thread)d      | Thread ID
threadName  | %(threadName)s  | Thread Name
```

-   Modify the format string to log: Human-readable date/time, level string, module name, current function and message. 
Log these in that order with spaces separating each attribute.

```
logging.basicConfig(level=logging.DEBUG,
        format='%(asctime)s %(levelname)s (module)s %(funcName)s %(message)s')
```


####    Exception
-   When an exception occurs, it's useful to include the entire traceback in your log file for diagnosing problems. 

-   You can use the "exception()" function on the Logger instance to gather the traceback information and do the formatting for you. It's similar to the "debug()" function, except you should only call "exception()" from an exception handler.

>   logger.exceptions("Exceptions occured")

####    Logging Objects
-   When you include an object in your log message, the object's __str__ method is called to return a string value for that object. 

-   If you run this task, you will notice the log message contains the __str__ generated string. 

-   If you want to use the __repr__ generated string, you will have to explicitly call repr() on your object. 

>   logger.debug('Created object: %s', repr(obj))

####    Limiting Output
-   When logging you should be aware of the type and size of data you might be logging. 

-   If you have a value that could be very large, such as long string, you might want to limit the output, so you don't make it difficult to look at your log output. 

-   One simple way to do this with string values is to use the format specification ".NNs", where NN is the number of characters to limit the string output. See the task for an example of this. 

-   In some cases, you might want to truncate an object, but indicate that the object was truncated. The common convention is to append the ellipses "..." to the end of the string to indicate there was more data. The following example shows how you could create a helper function that uses string slicing to do this. 

```
def truncate(obj, nlen):
    """ Convert 'obj' to string and truncate if greater than length"""
    str_value = str(obj)
    if len(str_value) > nlen:
        return str_value[:nlen-3] + '...'
    return str_value

if __name__ == '__main__':
    logging.basicConfig(level=logging.DEBUG)
    
    # Create a large list
    big_list = [1] * 2000
    
    # Truncate result (with ellipses)
    logging.debug('something happened with the list=%s', truncate(big_list, 30))
```

####    String Formation
-   As a Python developer, you are probably familiar with string formatting (or interpolation) using the "%" operator. For example: 

>   "Hello, %s" % ("John", ) 

will return the string result: 

>   "Hello, John" 

-   You may have noticed in some of our logging statements, we pass the string values separately, instead of using this style. 

-   This has the advantage that no time is spent formatting a string if the log message is going to be filtered out by the current severity level. 
