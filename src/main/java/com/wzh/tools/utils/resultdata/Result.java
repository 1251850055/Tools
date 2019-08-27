package com.wzh.tools.utils.resultdata;


import java.io.Serializable;

/**
 * @Description:
 * @Author: vc
 * @Date: 2019/8/27 19:10
 */

abstract class Result implements Serializable {
    private static final long serialVersionUID = -5308103810673743579L;

    Result() {
    }

    public abstract Status getStatus();

}
