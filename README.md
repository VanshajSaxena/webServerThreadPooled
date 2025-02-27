> A Simple Thread Pooled Multithreaded Web Server Implementation


I learned about threads and thread pools that are used to execute multiple
tasks concurrently, without having to create a separate process for each.

I also learned about how operating system handles threads across different processor cores and allow execution of different tasks without having to block the execution of main execution threads.

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
