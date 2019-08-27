package com.wzh.tools.service;


import com.wzh.tools.domain.response.UserData;
import com.wzh.tools.utils.resultdata.DataResult;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/8/27 19:38
 */

public interface UserService {

    /**
     * 查询用户信息
     * @param userCode
     * @return
     */
    DataResult<UserData> getUserInfo(String userCode);
}
