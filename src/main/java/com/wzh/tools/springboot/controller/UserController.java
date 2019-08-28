package com.wzh.tools.springboot.controller;

import com.google.common.base.Preconditions;
import com.wzh.tools.springboot.domain.request.UserParam;
import com.wzh.tools.springboot.domain.response.UserData;
import com.wzh.tools.springboot.service.UserService;
import com.wzh.tools.utils.dataresult.DataResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/8/27 19:02
 */
@RestController
@RequestMapping("/user/info")
public class UserController {

    /**
     * 注解
     * @Controller 类中的方法可以直接通过返回String跳转到jsp、ftl、html等模版页面。在方法上加@ResponseBody注解，也可以返回实体对象。
     * @RestController 类中的所有方法只能返回String、Object、Json等实体对象，不能跳转到模版页面。
     * @RestController 相当于 @ResponseBody + @Controller。
     */

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
