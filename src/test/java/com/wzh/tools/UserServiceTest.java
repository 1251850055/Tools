package com.wzh.tools;

import com.alibaba.fastjson.JSONObject;
import com.wzh.tools.springboot.domain.response.UserData;
import com.wzh.tools.springboot.service.UserService;
import com.wzh.tools.utils.dataresult.DataResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserInfo(){
        DataResult<UserData> userInfo = userService.getUserInfo("20");
        System.out.println(JSONObject.toJSONString(userInfo));
    }

}
