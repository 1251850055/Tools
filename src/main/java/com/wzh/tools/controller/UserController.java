package com.wzh.tools.controller;

import com.google.common.base.Preconditions;
import com.wzh.tools.domain.request.UserParam;
import com.wzh.tools.domain.response.UserData;
import com.wzh.tools.service.UserService;
import com.wzh.tools.utils.resultdata.DataResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/8/27 19:02
 */
@Controller
@RequestMapping("/user/info")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户信息
     * @param userParam
     * @return
     */
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public DataResult<UserData> getUserInfo(@RequestBody UserParam userParam) {
        Preconditions.checkNotNull(userParam.getUserCode(), "用户编码不能为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(userParam.getUserCode()), "和上面校验效果一样");
        return userService.getUserInfo(userParam.getUserCode());
    }
}
