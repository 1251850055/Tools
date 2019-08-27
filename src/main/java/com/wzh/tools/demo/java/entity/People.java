package com.wzh.tools.demo.java.entity;

import lombok.Data;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/6/14 14:09
 */
@Data
public class People {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 分组id
     */
    private Integer groupId;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 姓名
     */
    private String name;

    /**
     * 描述
     */
    private String description;


}
