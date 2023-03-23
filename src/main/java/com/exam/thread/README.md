### THREADS

We have to make difference between process and thread.

![img.png](../../../../resources/thread/img.png)

![img.png](../../../../resources/thread/img_1.png)

#### Time-Slicing Algorithm

If PC has a single CPU:

![img.png](../../../../resources/thread/img_2.png)

If PC has a multiple CPU:

![img.png](../../../../resources/thread/img_3.png)

### Benefits of multithreading

- we can design responsive application
- Better resource utilization: default java app is single threaded. We can utilize more CPU cores with multiple threads.

### Disadvantage

- Multiple thread can modify same data because it is under same memory area. (process)
- Hard to test.

### Create Threads

- implement Runnable: We need to override: run().
  [example](RunnableMain.java)
- extend Thread:
  [example](ThreadMain.java)

### Daemon Thread vs Worker Thread

- Daemon threads are a low priority thread. Runs in the background( garbage collector)
- Usually we create daemon thread for I/O operations or services (NFC/Bluetooth communication)
- Daemon threads are terminated by JVM and when all other worker threads are terminated(finish execution)

  [example](daemonthread/Main.java)

### Priority of Threads

- We can give different priority to the threads (1-10)
- default is 5. Executed in a FIFS(first in first served)
- high priority served before lower, but depends on the underlying OS.