package com.wzh.tools;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wzh.tools.springboot.dao")
public class ToolsApplication {


    /**
     * @Target(ElementType.TYPE) // 注解的适用范围，其中TYPE用于描述类、接口（包括包注解类型）或enum声明
     * @Retention(RetentionPolicy.RUNTIME) // 注解的生命周期，保留到class文件中（三个生命周期）
     * @Documented // 表明这个注解应该被javadoc记录
     * @Inherited // 子类可以继承该注解
     * @SpringBootConfiguration // 继承了Configuration，表示当前是注解类
     * @EnableAutoConfiguration // 开启springboot的注解功能，springboot的四大神器之一，其借助@import的帮助
     * @ComponentScan(excludeFilters = { // 扫描路径设置
     * @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
     * @Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
     * @param args
     */

    public static void main(String[] args) {
        SpringApplication.run(ToolsApplication.class, args);
        System.out.println("——————————————————————异地测试需导入user.sql脚本,修改数据库连接——————————————————————");
    }


}
