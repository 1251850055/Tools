package com.wzh.tools.demo.java.thread;

import com.alibaba.nacos.api.utils.NetUtils;
import com.alibaba.nacos.api.utils.StringUtils;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2021/3/31 11:13
 * web:https://www.freesion.com/article/32671046670/
 */
@Service
public class ManualCreate {

    private static Logger logger = LoggerFactory.getLogger(ManualCreate.class);

    //获取机器核数，作为线程池数量
    private static int THREAD_COUNT = Runtime.getRuntime().availableProcessors();

    private static ThreadFactory NAME_THREAD_FACTORY = new ThreadFactoryBuilder().setNameFormat("demo-pool-wzhTest").build();

    /**
     * Semaphore也是一个线程同步的辅助类，可以维护当前访问自身的线程个数，并提供了同步机制。使用Semaphore可以控制同时访问资源的线程个数
     * 例如，实现一个文件允许的并发访问数。
     */
    private final Semaphore SEMAPHORE = new Semaphore(THREAD_COUNT);

    /**
     * 获取当前机器ip地址
     * private static final String ip = Inet4Address.getLocalHost().getHostAddress();
     */
    private static final String IP = NetUtils.localIP();

    /*
     * corePoolSize => 线程池核心线程数量
     * maximumPoolSize => 线程池最大数量
     * keepAliveTime => 空闲线程存活时间
     * unit => 时间单位
     * workQueue => 线程池所使用的缓冲队列
     * threadFactory => 线程池创建线程使用的工厂
     * handler => 线程池对拒绝任务的处理策略
     */
    private static ExecutorService SERVICE = new ThreadPoolExecutor(THREAD_COUNT, 200,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), NAME_THREAD_FACTORY, new ThreadPoolExecutor.AbortPolicy());

    private static BlockingQueue<Integer> QUEUE = new LinkedBlockingQueue<>();

    @PostConstruct
    public void init() {
        start();
        process();
    }

    public void start() {
        try {
            if (StringUtils.isBlank(IP)) {
                logger.error("未获取到主机ip地址");
                return;
            }
            //todo 可做解锁ip处理 情景举例：一个任务执行失败了，扔到重试表里，重试表有个locker字段，定时任务一直扫表，哪台机器哪个线程抢到任务locker放ip，然后当任务被线程处理，locker清除ip
            System.out.println("模拟:清除该ip锁定的任务后,睡眠2s");
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            return;
        }
        System.out.println("------------准备处理业务------------");
        SERVICE.submit(new RetryTask());
    }

    public void process() {
        for (int i = 0; i < THREAD_COUNT; i++) {
            SERVICE.submit(new Task());
        }
    }

    public static void main(String[] args) {

    }

    class RetryTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    //返回此信号灯中可用的许可证数量
                    int taskNum = SEMAPHORE.availablePermits();
                    System.out.println("------------允许TASK个数：" + taskNum);

                    if (taskNum == 0) {
                        Thread.sleep(1000);
                        continue;
                    }

                    if (taskNum > 0) {
                        long flagTime = System.currentTimeMillis();
                        //todo 比如根据taskNum 锁定重试任务表 where locker = ip limit taskNum
                        System.out.println("处理业务的机器为：" + IP + flagTime);
                    }

                    //QUEUE.put() 处理实体类
                    for (int i = 0; i < taskNum; i++) {
                        SEMAPHORE.acquire();
                        QUEUE.put(i);
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage());
                } finally {
                    logger.debug("休眠时间:" + new Date());
                }
            }
        }
    }


    /**
     * 业务处理
     */
    class Task implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    Integer take = QUEUE.take();
                    consume(take);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume(Integer i) {
        try {
            System.out.println("处理次数" + i);
        } catch (Exception exp) {
            logger.error("重试异常");
        } finally {
            SEMAPHORE.release();
        }
    }


}


