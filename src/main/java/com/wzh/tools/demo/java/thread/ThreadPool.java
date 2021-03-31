package com.wzh.tools.demo.java.thread;

import java.util.concurrent.*;


/**
 * @author VC电影
 */
public class ThreadPool {

    private static ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(50);

    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            queue.put(i);
        }
        for (int j = 0; j < 50; j++) {
            service.submit(new Tatest());
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
    }

    private static class Tatest implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(queue.take() + "--" + Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
