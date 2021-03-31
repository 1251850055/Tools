package com.wzh.tools.demo.java.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2021/3/31 11:13
 */

public class manualCreate {

    public static void main(String[] args) {
        //获取系统处理器个数，作为线程池数量
        int nThreads = Runtime.getRuntime().availableProcessors();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        /*
        * corePoolSize => 线程池核心线程数量
        * maximumPoolSize => 线程池最大数量
        * keepAliveTime => 空闲线程存活时间
        * unit => 时间单位
        * workQueue => 线程池所使用的缓冲队列
        * threadFactory => 线程池创建线程使用的工厂
        * handler => 线程池对拒绝任务的处理策略
        */
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        System.out.println(nThreads);
    }
}
