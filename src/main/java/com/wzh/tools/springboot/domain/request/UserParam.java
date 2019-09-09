package com.wzh.tools.springboot.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/8/27 19:30
 */
@Data
public class UserParam implements Serializable {
    private static final long serialVersionUID = 5373828888042874615L;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 页大小
     */
    private Integer rows = 10;

    /**
     * 页码
     */
    private Integer currentPage = 1;

}
