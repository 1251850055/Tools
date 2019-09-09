package com.wzh.tools.springboot.domain.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/8/27 19:25
 */
@Data
public class UserDataInfo {

    private Integer id;

    private String userName;

    private String userCode;

    private String userPhone;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
