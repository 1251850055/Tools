package com.wzh.tools.demo.java.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * @author VC电影
 */
public class Xianchengchi {
    private static ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(50);

    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();

    public static void main(String[] args) throws InterruptedException {
        long qishi = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            queue.put(i);
        }
        for (int j = 0; j <50 ; j++) {
            service.submit(new Tatest());
        }

        long jieshu = System.currentTimeMillis();

        System.out.println("+++++++++++++++++++++++++++"+(jieshu - qishi));
    }

    private static class Tatest implements Runnable {
        @Override
        public void run() {
            while(true){
                try {
                    System.out.println(queue.take()+"--"+Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
