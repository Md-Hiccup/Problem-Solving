# Logging in Python 

##  05 - Filtering

####    Filter Objects
-   The Filter object allows fine grained control over what is included in the log output. 

-   You add Filter objects to Loggers or Handlers using the addFilter() method. You can also have more than one filter attached to each object. 

-   The LogRecord object for every log message is passed to the entire list of attached Filter objects. If a Filter returns a 0 value, the LogRecord is dropped and no further processing is done. 

-   The base Filter object filters based on a name in the module hierarchy. This usually is not very useful, therefore you will more often see new Filters inheriting from the base Filter object and implement more unique behavior. There are several examples of custom Filter objects in this course. 

-   Filters when applied to Logger objects are only checked when you call a log method on that object in the hierarchy. This is in contrast to Filters applied to Handler objects which are caller whenever a log record gets to the handler. 

```
import logging

logging.basicConfig(level=logging.DEBUG)

log_filter = logging.Filter('A')

logger1 = logging.getLogger('A')
logger1.addFilter(log_filter)
logger1.debug('This is written to log output')

logger3 = logging.getLogger('B')
logger3.addFilter(log_filter)
logger3.debug('This is NOT written to log output, because only names start with "B" are allowed by filter')
```


####    Sanitize Filter    
-   Filter objects can also perform in-place modification of LogRecord attributes. This can include changing values or adding new attributes. 

-   If you are developing a system that contains private user information, such as social security numbers, you should take extra precautions to protect that data. That should include any log messages that might reference that private data. 

-   In this task, we have created a Filter which sanitizes (hides) U.S. social security numbers. This is done by using a regular expression that searches for a given pattern. If it finds a match, that text is replaced with a generic placeholder value (XXX-XX-XXXX).    
    1.  A Filter should return a non-zero value if the log record should be passed to the handler or a 0 value if the filter should exclude the record. Update the return value for the SanitizeSSNFilter object we have created. 

    2.  Update the logging configuration to add this filter object to the root logger. 

```
import logging
import re

class SanitizeSSNFilter(logging.Filter):
    def filter(self, record):
        def replace_ssn(value):
            return re.sub('\d\d\d-\d\d-\d\d\d\d', 'XXX-XX-XXXX', value)

        record.msg = replace_ssn(record.msg)
        if record.args:
            newargs = [replace_ssn(arg) if isinstance(arg, str)
                       else arg for arg in record.args]
            record.args = tuple(newargs)

        return 2

if __name__ == '__main__':
    logging.basicConfig(level=logging.DEBUG)

    sanitize_filter = SanitizeSSNFilter()
    root = logging.getLogger()
    root.addFilter(sanitize_filter)

    root.debug('Nothing filtered here; user_id=%s', '100')
    root.debug('Log message containing a SSN=000-01-1000')
    root.warn('Log message containing a SSN=%s', '000-01-1001')
    root.debug('Log message containing a SSN=%s' % '000-01-1100')
    root.info('Log event: user_id=%s, SSN=%s, status=%d, result=%s', '100', '000-01-1100', 2, True)
```

####    Logger Propagate
-   When you log a message to a Logger, any Handler object's added to that Logger are going to emit the output. Given that Loggers are in a hierarchy, some of your child loggers may not have any Handler's attached. This would be a pain if you had to configure a Handler for every Logger child object. For this reason, every LogRecord will be passed to the parent Logger. And that will be passed to the Handler object's attached to that parent, this continues all the way up to the Root logger. 

-   That's why adding a Handler at the Root level will output the log records. 

-   In some cases you may not want this behavior, so in this task, set the 'propagate' attribute on the "logger3" instance to False to prevent the log record from being passed to the parent logger handler. 

-   If you are running Python 2.7, then after you execute this code you will notice the message "No handlers could be found for logger "B"". In the next task we can show how to eliminate this warning.

```
import logging

logging.basicConfig(level=logging.DEBUG)
log_filter = logging.Filter('A')
logger3 = logging.getLogger('B')
logger3.propagate = False
logger3.debug('This is NOT written to log output, because only names start with "B" are allowed by filter')
```

####    NullHandler
-   In the previous task, disabling propagation on a handler in the hierarchy gave us a warning message, under Python 2.7. We can explicitly silence this warning by adding a NullHandler handler object to the logger. This handler does not output any log records. This will work with both Python 2.7 and Python 3. NullHandler is not available in Python 2.6 or earlier.

```
import logging
logging.basicConfig(level=logging.DEBUG)
log_filter = logging.Filter('A')
logger = logging.getLogger('A')

logger.addHandler(logging.NullHandler())
```

####    Filtering on Handler
-   In a previous task, we showed adding a filter to a Logger object. Since, filters are only applied when the log method is called on a Logger, the filter has to be added to every logger that needs to have the filter applied. You can also add a filter to a Handler, and since the log records propagate up the hierarchy, the filter will be applied by the handler for all log records that reach it. 

```
import logging

logging.basicConfig(level=logging.DEBUG)
log_filter = logging.Filter('A')

root = logging.getLogger()
for handler in root.handlers:
    handler.addFilter(log_filter)

logger1 = logging.getLogger('A')
logger1.debug('This is written to log output')
```