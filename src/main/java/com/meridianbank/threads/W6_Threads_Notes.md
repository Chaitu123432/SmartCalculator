# PJP Week 6 - Hands-On 3
# Basics of Threads in Java

## Package

All Java classes are in:

com.meridianbank.threads

---

# Part A - Thread Lifecycle Trace

The exact order of the worker-thread output is not guaranteed because
t1 and t2 execute concurrently.

The guaranteed first line is:

Main | Before start

The following four worker lines will be printed:

TransferWorker-1 | STARTED
TransferWorker-1 | DONE
AuditLogger-1 | STARTED
AuditLogger-1 | DONE

However, the worker lines may be interleaved differently because the
threads are scheduled independently.

The guaranteed final line is:

Main | After join

This is because the main thread calls join() on both worker threads
before printing the final message.

---

# Part B - Answers

## B1. What is the state of t1 while it is inside Thread.sleep(100)?

TIMED_WAITING

---

## B2. Can 'Main | After join' print BEFORE both workers print 'DONE'?

No. join() makes the main thread wait until both worker threads have
completed.

---

## B3. What happens if t1.start() is replaced with t1.run()?

run() executes directly on the main thread instead of starting a new
thread, so the work is no longer performed concurrently.

---

# Part C - Notification Dispatcher

NotificationDispatcher implements Runnable.

Each dispatcher:

1. Prints the thread name and account ID.
2. Sleeps for 50 milliseconds to simulate network latency.
3. Prints the thread name and sent message.

The Demo class creates three threads for:

ACC001
ACC002
ACC003

All three threads are started and joined before:

All notifications dispatched.

---

# Key Thread Concepts

## start()

start() creates a new thread and causes its run() method to execute
on that new thread.

## run()

Calling run() directly does not create a new thread. The method executes
on the current thread.

## sleep()

Thread.sleep() pauses the currently executing thread for the specified
duration.

## join()

join() makes the calling thread wait until the target thread finishes.

## TIMED_WAITING

A thread is in the TIMED_WAITING state while it is waiting for a
specified amount of time, such as during Thread.sleep().