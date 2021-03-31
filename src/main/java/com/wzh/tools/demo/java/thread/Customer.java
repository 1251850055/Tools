package com.wzh.tools.demo.java.thread;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2021/3/31 14:32
 */

public class Customer implements Runnable {

    /**
     * 1.什么是Semaphore？
     * Semaphore是JDK提供的一个同步工具，它通过维护若干个许可证来控制线程对共享资源的访问。
     * 如果许可证剩余数量大于零时，线程则允许访问该共享资源；如果许可证剩余数量为零时，则拒绝线程访问该共享资源。
     * Semaphore所维护的许可证数量就是允许访问共享资源的最大线程数量。 所以，线程想要访问共享资源必须从Semaphore中获取到许可证。
     *
     * 2.Semaphore有哪些常用方法？
     * 有acquire方法和release方法。 当调用acquire方法时线程就会被阻塞，
     * 直到Semaphore中可以获得到许可证为止，然后线程再获取这个许可证。
     * 当调用release方法时将向Semaphore中添加一个许可证，如果有线程因为获取许可证被阻塞时，它将获取到许可证并被释放；
     * 如果没有获取许可证的线程， Semaphore只是记录许可证的可用数量。
     *
     * 3.Semaphore应用场景举例
     * 张三、李四和王五和赵六4个人一起去饭店吃饭，不过在特殊时期洗手很重要，饭前洗手也是必须的，
     * 可是饭店只有2个洗手池，洗手池就是不能被同时使用的公共资源，这种场景就可以用到Semaphore。
     *
     *
     * 网址:https://blog.csdn.net/huyaowei789/article/details/106690603/?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-0&spm=1001.2101.3001.4242
     */

    private Semaphore washbasin;

    private String name;

    public Customer(Semaphore washbasin, String name) {
        this.washbasin = washbasin;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
            SecureRandom random = new SecureRandom();
            washbasin.acquire();
            System.out.println(sdf.format(new Date()) + " " + name + " 开始洗手...");
            Thread.sleep((long) (random.nextDouble() * 5000) + 2000);
            System.out.println(sdf.format(new Date()) + " " + name + " 洗手完毕!");
            washbasin.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
