# Logging in Python 

##  03 - Basic Handlers

####    Basic file handler
-   Up to this point we have been outputting our logging information to stderr (console) output. This is useful for small programs, but as the amount of log output increases, it is useful to log the output to a file, so that you can go back and search the output for specific information. 

-   The logging module allows us to setup Handler objects to write the output to different destinations. The FileHandler is a built-in Handler object that writes log output to a file. 

-   In this task we can use the "basicConfig()" function to setup a FileHandler for us automatically. This is done by passing the "filename" keyword argument. Use the value of log_filename. The FileHandler created is automatically added to the root logger. 

-   After you successfully run this program, you should see a "basic_file.log" appear under the "Sandbox" folder in the Project view. The Sandbox should appear at the end of your project tree. You can double-click this file to see the contents. If the file does not appear, you can try collapsing and expanding the Sandbox folder. You should also note that nothing was logged to the console, because we replaced the default "stderr" stream handler with a FileHandler. 

-   If you run this task several times, you will notice the log messages are appended to the existing file every time we run the program. This is because the default file mode is to append to the log file.


```
logging.basicConfig(level=logging.DEBUG,
                    format='%(asctime)s %(levelname)s %(message)s',
                    filename='../../Sandbox/basic_file.log')
```

####    Basic Truncate log file
-   If you ran the previous task a few times, you will have noticed each time all the log messages were appended to the file. Sometimes, it is useful to truncate the log file each time you start the program to avoid having to sort through a large number of old log messages. 

-   You can do this by passing a "filemode" keyword argument to "basicConfig()" with a string value of "w". 

-   In this task, please change the default log file mode to start a new file each time the program is run.

```
logging.basicConfig(level=logging.DEBUG,
                    format='%(asctime)s %(levelname)s %(message)s',
                    filename='../../Sandbox/basic_file.log',
                    filemode='w')
```

####    Create file handler
-    Up to this point we have been relying on the "basicConfig()" function to help configure logging. You can also configure the logging objects yourself for more flexibility. 

-   In this task, we are going to create a FileHandler object ourselves and add this to the root logger. 

1.  Update the task to create a new FileHandler object. The first argument is the filename. Use "log_filename" for this task. 
2.  Next, we have to call addHandler() on the Logger object. In this task we are adding the handler to the root logger, so any child loggers will also be output to our handler. 

**Note**: To see the file "create_file_handler.log" in your Sandbox, you may have to collapse/expand the "Sandbox" folder in your Project view to see the new file created.

```
log_filename = '../../Sandbox/create_file_handler.log'
file_handler = logging.FileHandler(log_filename)

root_logger = logging.getLogger()
root_logger.addHandler(file_handler)
root_logger.setLevel(logging.DEBUG)
```

####    Set Formatter
-   In the previous task, you may have noticed the only thing output in our log file was the log message. 

-   This is because we have no Formatter object set on our handler. In previous examples, we have relied on "basicConfig()" to build a formatter for us. 

-   The Formatter is responsible for taking a LogRecord object and creating a string result that can be used by the Handler to output a log message. Each Handler has one Formatter. 

-   In this task we need to construct a "Formatter" object, passing it our format string. Then we need to call "setHandler" on our new file handler instance. 

```
log_filename = '../../Sandbox/file_handler_with_formatter.log'
file_handler = logging.FileHandler(log_filename)

fmt = logging.Formatter('%(asctime)s %(levelname)s %(message)s')
file_handler.setFormatter(fmt)

root_logger = logging.getLogger()
root_logger.addHandler(file_handler)
root_logger.setLevel(logging.DEBUG)
```

####    Multiple handlers
-   We have replaced the console (stderr) handler with the file handler. Sometimes, it's useful to log to both places at the same time. 

-   You can call "addHandler()" on a Logger multiple times. All of the Handler objects will receive the log messages. 

-   In this task, we have created a new StreamHandler instance. Instead of using "stderr" stream, you should pass "sys.stdout" to see how you could use another output stream. Then pass this StreamHandler instance to "addHandler()". 

-   You should also not forget to add the Formatter to the StreamHandler object. In this task, re-use the same Formatter you used with the FileHandler. You should also note you can specify different formatters for each handler.

```
    log_filename = '../../Sandbox/create_file_handler.log'
    file_handler = logging.FileHandler(log_filename)

    fmt = logging.Formatter('%(asctime)s %(levelname)s %(message)s')
    file_handler.setFormatter(fmt)

    root_logger = logging.getLogger()
    root_logger.addHandler(file_handler)

    stdout_handler = logging.StreamHandler(sys.stdout)
    stdout_handler.setFormatter(fmt)
    root_logger.addHandler(stdout_handler)

    root_logger.setLevel(logging.DEBUG)
```

####    Separate Handler Log levels
-   In some use cases you may want to log different severity levels to different handlers. 

-   You can do this by calling the "setLevel()" function on the Handler object. Only log messages with this level or greater will be written to the output stream. 

-   In this task, change the StreamHandler logging level to only output WARNING messages or higher. 

-   After running this task, you should notice if you load the "separate_levels.log" file, it contains all the log messages, and the console only showed the one WARN level message.

>   stdout_handler.setLevel(logging.WARNING)

####    