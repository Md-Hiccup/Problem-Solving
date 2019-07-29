#   Logging in Python

##  06 - Configuration

####    FileConfig Formatters
-   You can also load logging configuration from a file using "logging.fileConfig()". This function takes the filename of a ConfigParser based file. 

-   For the purpose of this course, we are going to write this file from the task code. In normal circumstances, you would maintain this configuration data in a separate file. 

-   Every logging config file needs to have the following sections: [loggers], [formatters] and [handlers] 

-   Each section needs a name specified "keys". The value could be one or more additional configuration sections you have to create. And each of those is going to contain name/value pairs based on the type of section. 

-   In the next few tasks we are going to explain this one small step at a time 

-   In this first task, we need to identify an instance name for a Formatter type object. Use the name "formatter1" in this task, although the name is an arbitrary identifier. You just have to use the same whenever you reference the same object.

-   Notice under the "[formatter_formatter1]" section there is another key/value pair for "format". This is the format string we have encountered in previous tasks. This is used to initialize the "formatter1" instance.

```
import logging
import logging.config

config = """
[formatters]
keys=formatter1

[handlers]
keys=handler1

[loggers]
keys=root

[formatter_formatter1]
format=%(asctime)s %(levelname)s %(message)s

[handler_handler1]
class=StreamHandler
args=()
formatter=formatter1

[logger_root]
handlers=handler1
level=DEBUG
"""

config_filename = 'logging.ini'

def write_config_file(filename, data):
    with open(filename, 'w') as fp:
        fp.write(data)


if __name__ == '__main__':
    write_config_file(config_filename, config)

    logging.config.fileConfig(config_filename)

    logging.debug('this is a debug message')
    logging.warning('this is a warning message')
```

####    FileConfig Handlers
-   In this task, we need to identify an instance name for a Handler object. Use the name "handler1". Again, the name is arbitrary, but has to match references to the same object. 

-   Notice under "[handler_handler1]", there are some additional keys used to initialize the "handler1" instance: 

-   "class" is the logging module class name (example: StreamHandler or FileHandler).

-   "args" is a tuple containing the arguments to the class constructor. Here we are going to use the default arguments, so are specifying an empty tuple. 

-   "formatter" is a key reference to a Formatter object. Here we are using "formatter1" because that is the instance we created in the previous task.

```
import logging.config

config = """
[formatters]
keys=formatter1

[handlers]
keys=handler1

[loggers]
keys=root

[formatter_formatter1]
format=%(asctime)s %(levelname)s %(message)s

[handler_handler1]
class=StreamHandler
args=()
formatter=formatter1

[logger_root]
handlers=handler1
level=DEBUG
"""
```

####    FileConfig Loggers
-   In this task we will configure our root Logger instance. This is done using the instance name "root". 

-   Under the "[logger_root]" section we need to configure additional key/values to complete the instance configuration: 

-   "handlers" is a list of key names for each instance of a handler we want to add to this Logger instance. 

-   "level" is the log severity level

```
import logging.config

config = """
[formatters]
keys=formatter1

[handlers]
keys=handler1

[loggers]
keys=root

[formatter_formatter1]
format=%(asctime)s %(levelname)s %(message)s

[handler_handler1]
class=StreamHandler
args=()
formatter=formatter1

[logger_root]
handlers=handler1
level=DEBUG
"""
```

####    FileConfig Multiple Handlers
-   In this task, we are going to add a File Handler object to our root logger instance, in addition to our Stream Handler. 

-   Use the instance name "file" in this task. It could be something else, but all the instances to this object must be the same. 

-   You will notice, under the [handler_file] section, we are specifying a tuple value with the "args" key. The first value in this tuple is the filename for this instance of the FileHandler. We are also referencing the same instance of the Formatter used by the StreamHandler.

```
import logging.config

config = """
[loggers]
keys=root

[formatters]
keys=formatter1

[handlers]
keys=handler1, file

[formatter_formatter1]
format=%(asctime)s %(levelname)s %(message)s

[handler_handler1]
class=StreamHandler
args=()
formatter=formatter1

[handler_file]
class=FileHandler
args=("../../Sandbox/file_config_example.log", )
formatter=formatter1

[logger_root]
handlers=handler1, file
level=DEBUG
"""
```

####    DictConfig
-   Logging configuration can also be specified as a Python dictionary. This makes it very easy to store configuration in an external JSON or YAML file, since parsers for those formats can return a native Python dict. 

-   There are four important keys with dictConfig. The first three are the same as in fileConfig(): "handlers", "formatters", "loggers". The fourth is a mandatory "version" key which at this time must be the integer value "1". 

-   In this task, you can see the structure of this dictionary in the "log_config" variable. The root logger is designated with an empty string '', under the "loggers" key. And under that key, you can see a "handlers" key which points to the name of an object defined under the "handlers" section. This is an array of handler keys, since we can have multiple handlers attached to a logger instance. 

    1.  Set the proper handler in the root logger 
    2.  Pass the logging configuration to dictConfig() 

-   After you execute this task, you will only see the last WARNING message. We will explain this in the next task.

```
import logging
import logging.config

logger = logging.getLogger(__name__)

if __name__ == '__main__':
    log_config = {
        'version': 1,
        'handlers': {
            'console': {
                'class': 'logging.StreamHandler',
                'formatter': 'formatter1',
                'stream': 'ext://sys.stdout'
            }

        },
        'formatters': {
            'formatter1': {
                'format': '%(asctime)s - %(levelname)s - %(message)s'
            }
        },
        'loggers': {
            '': {
                'level': 'DEBUG',
                'handlers': ['console', ]
            }
        }
    }

    logging.config.dictConfig(log_config)

    logger.warn('This is a warning')
    logger.debug('test')

    logging.root.warn('This is a root logger warning')
```

####    DictConfig Existing Loggers
-   In the previous task, only the root logger message was included in the output. 

-   This is because we created our "logger" instance at module scope, before we called dictConfig(). When dictConfig() was called it disabled any existing loggers. This is the default setting, but you can override this with the "disable_existing_loggers" key set to the value of "False", within the configuration dictionary. 


-   Update the configuration to prevent existing loggers from being disabled. 
-   After you execute this task, you should see all the log output. 

```
log_config = {
        'version': 1,
        'handlers': {
            'console': {
                'class': 'logging.StreamHandler',
                'formatter': 'formatter1',
                'stream': 'ext://sys.stdout'
            }

        },
        'formatters': {
            'formatter1': {
                'format': '%(asctime)s - %(levelname)s - %(message)s'
            }
        },
        'loggers': {
            '': {
                'level': 'DEBUG',
                'handlers': ['console', ]
            }
        },
        'disable_existing_loggers': False
    }
```

####    DictConfig root shortcut
-   There is a shortcut for defining the root logger. Instead of having an empty string key '' under the loggers key, you can create a top-level key called "root".

```
log_config = {
        'version': 1,
        'disable_existing_loggers': False,
        'handlers': {
            'console': {
                'class': 'logging.StreamHandler',
                'formatter': 'formatter1',
                'stream': 'ext://sys.stdout'
            }

        },
        'formatters': {
            'formatter1': {
                'format': '%(asctime)s - %(levelname)s - %(message)s'
            }
        },
        'root': {
            'level': 'DEBUG',
            'handlers': ['console', ]
        }
    }
```