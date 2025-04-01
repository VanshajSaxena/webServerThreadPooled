> A Simple Thread Pooled Multithreaded Web Server Implementation


This project demonstrates the use of threads and thread pools that are used to
execute multiple tasks concurrently, without having to create a separate
process for each.


This was benchtested using JMeter for 500k requests per second, the logs for
which are available in the project directory.


### JMeter Benchtesting
``` shell
.
├── MultiThreaded
│   ├── Client.java
│   ├── jmeter.log # The application has been benchtested using JMeter for 100-500k requests.
│   ├── Server.java
│   └── 'Thread Group.jmx' # JMeter test plan
├── SingleThreaded
│   ├── Client.java
│   └── Server.java
└── ThreadPool
    └── Server.java
```
