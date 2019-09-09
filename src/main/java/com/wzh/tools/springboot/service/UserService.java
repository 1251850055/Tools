package com.wzh.tools.springboot.service;


import com.wzh.tools.springboot.domain.request.UserParam;
import com.wzh.tools.springboot.domain.response.UserData;
import com.wzh.tools.utils.dataresult.DataResult;
import com.wzh.tools.utils.dataresult.PageEntity;

import java.util.List;

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

    /**
     * 查询用户列表
     * @param userParam
     * @return
     */
    DataResult<PageEntity<List<UserData>>> getUserList(UserParam userParam);
}
