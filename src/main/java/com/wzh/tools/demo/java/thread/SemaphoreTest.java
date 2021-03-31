package com.wzh.tools.demo.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2021/3/31 14:33
 */

public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        //饭店里只用两个洗手池，所以初始化许可证的总数为2。
        Semaphore washbasin = new Semaphore(2);

        List<Thread> threads = new ArrayList<>(3);
        threads.add(new Thread(new Customer(washbasin, "张三")));
        threads.add(new Thread(new Customer(washbasin, "李四")));
        threads.add(new Thread(new Customer(washbasin, "王五")));
        threads.add(new Thread(new Customer(washbasin, "赵六")));
        for (Thread thread : threads) {
            thread.start();
            Thread.sleep(50);
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
