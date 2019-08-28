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

    private String userCode;


}
