#### 为什么要用线程池

- 复用已创建的线程
- 控制并发的数量（主要原因）
- 对线程左统一管理

#### 线程池的原理

Java中的线程池顶层接口是`Executor`接口，`ThreadPoolExecutor`是这个接口的实现类。

##### ThreadPoolExecutor的构造方法

```java
// 七个参数的构造函数
public ThreadPoolExecutor(int corePoolSize,
                          int maximumPoolSize,
                          long keepAliveTime,
                          TimeUnit unit,
                          BlockingQueue<Runnable> workQueue,
                          ThreadFactory threadFactory,
                          RejectedExecutionHandler handler)
```

必需的5个参数的含义

- int corePoolSize

  线程池中**核心线程的最大值**，线程池中的核心线程一直存在，非核心线程闲置会被销毁

- int maximumPoolSize

  **线程总数最大值**，等于核心线程数 + 非核心线程数

- long keepAliveTime

  **非核心线程闲置超时时长**，超过此时间的非核心会被销毁，设置allowCoreThreadTimeOut(true)，也作用于核心线程。

- TimeUnit unit

  一个**枚举**类型，作为前面的时间的单位

- BlockingQueue<Runnable> workQueue

  阻塞队列，维护着**等待执行的Runnable任务对象**。

  常用的几个阻塞队列：

  - **LinkedBlockingQueue**

    链式阻塞队列，底层数据结构是**链表**，默认大小是`Integer.MAX_VALUE`，也可以指定大小。

  - **ArrayBlockingQueue**

    数组阻塞队列，底层数据结构是**数组**，需要指定队列的大小。

  - **SynchronousQueue**

    同步队列，内部容量为0，每个put操作必须等待一个take操作，反之亦然。

  - **DelayQueue**

    延迟队列，该队列中的元素只有当其指定的延迟时间到了，才能够从队列中获取到该元素 。

两个非必须的参数

- ThreadFactory threadFactory

  创建线程的**工厂** ，用于**批量创建线程**，统一在创建线程时设置一些参数，如是否守护线程、线程的优先级等。如果**不指定**，会新建一个**默认**的线程工厂。

- RejectedExecutionHandler handler

  **拒绝处理策略**，线程数量大于最大线程数就会采用拒绝处理策略，四种拒绝处理的策略为 ：

  - **ThreadPoolExecutor.AbortPolicy**：**默认拒绝处理策略**，丢弃任务并抛出RejectedExecutionException异常。
  - **ThreadPoolExecutor.DiscardPolicy**：丢弃新来的任务，但是不抛出异常。
  - **ThreadPoolExecutor.DiscardOldestPolicy**：丢弃队列头部（最旧的）的任务，然后重新尝试执行程序（如果再次失败，重复此过程）。
  - **ThreadPoolExecutor.CallerRunsPolicy**：由调用线程处理该任务。

##### ThreadPoolExecutor的策略

线程池本身有一个调度线程，用于管理布控整个线程池里的各种任务和事务，例如创建线程、销毁线程、任务队列管理、线程队列管理等等。线程池有以下几个状态：

- 线程池创建后处于**RUNNING**状态。

- 调用shutdown()方法后处于**SHUTDOWN**状态，线程池不能接受新的任务，清除一些空闲worker,会**等待阻塞队列的任务完成**。

- 调用shutdownNow()方法后处于**STOP**状态，线程池不能接受新的任务，**中断所有线程**，阻塞队列中没有被执行的任务**全部丢弃**。此时，poolsize=0,阻塞队列的size也为0。

- 当所有的任务已终止，ctl记录的”任务数量”为0，线程池会变为**TIDYING**状态。接着会执行terminated()函数。

  > ThreadPoolExecutor中有一个控制状态的属性叫ctl，它是一个AtomicInteger类型的变量。

- 线程池处在TIDYING状态时，**执行完terminated()方法之后**，就会由 **TIDYING -> TERMINATED**， 线程池被设置为TERMINATED状态。

##### 线程池主要的任务处理流程

处理任务的核心方法是`execute`

- 线程总数量 < corePoolSize，无论线程是否空闲，都会新建一个核心线程执行任务（让核心线程数量快速达到corePoolSize，在核心线程数量 < corePoolSize时）。**注意，这一步需要获得全局锁。**
- 线程总数量 >= corePoolSize时，新来的线程任务会进入任务队列中等待，然后空闲的核心线程会依次去缓存队列中取任务来执行（体现了**线程复用**）。
- 当**缓存队列满了**，说明这个时候任务已经多到爆棚，需要一些“临时工”来执行这些任务了。于是会**创建非核心线程**去执行这个任务。**注意，这一步需要获得全局锁。**
- 缓存队列满了， 且总线程数达到了maximumPoolSize，则会采取上面提到的**拒绝策略**进行处理。

为什么二次检查线程池的状态：

在**多线程**的环境下，线程池的状态是时刻发生变化的。很有可能刚获取线程池状态后线程池状态就改变了。判断是否将`command`加入`workqueue`是线程池之前的状态。倘若没有二次检查，万一线程池处于非**RUNNING**状态（在多线程环境下很有可能发生），那么`command`永远不会执行。

![img](http://concurrent.redspider.group/article/03/imgs/%E7%BA%BF%E7%A8%8B%E6%B1%A0%E4%B8%BB%E8%A6%81%E7%9A%84%E5%A4%84%E7%90%86%E6%B5%81%E7%A8%8B.png)

##### ThreadPoolExecutor如何做到线程复用

ThreadPoolExecutor在创建线程时，会将线程封装成**工作线程worker**,并放入**工作线程组**中，然后这个worker反复从阻塞队列中拿任务去执行。

**addWorker()的源码得多看看**

#### 四种常见线程池

##### newCachedThreadPool

```java
public static ExecutorService newCachedThreadPool() {
    return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                  60L, TimeUnit.SECONDS,
                                  new SynchronousQueue<Runnable>());
}
```

`CacheThreadPool`的**运行流程**如下：

- 提交任务进线程池。
- 因为**corePoolSize**为0的关系，**不创建核心线程**，线程池最大为Integer.MAX_VALUE。
- 尝试将任务添加到**SynchronousQueue**队列。
- 如果SynchronousQueue入列成功，等待被**当前运行的线程空闲后拉取执行**。如果当前没有空闲线程，那么就创建一个非核心线程，然后从SynchronousQueue拉取任务并在当前线程执行。
- 如果SynchronousQueue已有任务在等待，入列操作将会阻塞。

当需要执行很多**短时间**的任务时，CacheThreadPool的线程复用率比较高， 会显著的**提高性能**。而且线程60s后会回收，意味着即使没有任务进来，CacheThreadPool并**不会占用很多资源。**

##### newFixedThreadPool

```java
public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
}
```

只能创建核心线程，不能创建非核心线程。

**与CachedThreadPool的区别**：

- 因为 corePoolSize == maximumPoolSize ，所以FixedThreadPool**只会创建核心线程**。 而CachedThreadPool因为corePoolSize=0，所以**只会创建非核心线程**。
- 在 getTask() 方法，如果队列里没有任务可取，线程会一直**阻塞**在 LinkedBlockingQueue.take() ，线程不会被回收。 **CachedThreadPool会在60s后收回。**
- 由于线程不会被回收，会一直卡在阻塞，所以**没有任务的情况下， FixedThreadPool占用资源更多**。
- 都几乎不会触发拒绝策略，但是原理不同。FixedThreadPool是因为**阻塞队列可以很大（最大为Integer最大值），故几乎不会触发拒绝策略**；CachedThreadPool是因为**线程池很大（最大为Integer最大值），几乎不会导致线程数量大于最大线程数，**故几乎不会触发拒绝策略

##### newSingleThreadExecutor

```java
public static ExecutorService newSingleThreadExecutor() {
    return new FinalizableDelegatedExecutorService
        (new ThreadPoolExecutor(1, 1,
                                0L, TimeUnit.MILLISECONDS,
                                new LinkedBlockingQueue<Runnable>()));
}
```

有且仅有一个核心线程（ corePoolSize == maximumPoolSize=1），使用了LinkedBlockingQueue（容量很大），所以，**不会创建非核心线程**。所有任务按照**先来先执行**的顺序执行。如果这个唯一的线程不空闲，那么新来的任务会存储在任务队列里等待执行。

##### newScheduledThreadPool

```java
public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
    return new ScheduledThreadPoolExecutor(corePoolSize);
}

//ScheduledThreadPoolExecutor():
public ScheduledThreadPoolExecutor(int corePoolSize) {
    super(corePoolSize, Integer.MAX_VALUE,
          DEFAULT_KEEPALIVE_MILLIS, MILLISECONDS,
          new DelayedWorkQueue());
}
```

创建一个定长线程池，支持**定时**及**周期性任务**执行。