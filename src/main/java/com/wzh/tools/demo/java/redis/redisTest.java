package com.wzh.tools.demo.java.redis;

import redis.clients.jedis.Jedis;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/7/23 8:54
 */

public class redisTest {

    /**
     * 描述 redis 地址：https://github.com/microsoftarchive/redis/releases
     * 本地运行 redis-server.exe启动redis服务器
     * redis客户端 redis-cli.exe
     */
    public static void main(String[] args) {
        //1.链接redis
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作redis
        jedis.set("name", "wzh");
        //3.取出值
        System.out.println(jedis.get("name"));
        //4.关闭链接
        jedis.close();

    }

}
