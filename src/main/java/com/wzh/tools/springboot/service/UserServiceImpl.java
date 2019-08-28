package com.wzh.tools.springboot.service;

import com.wzh.tools.springboot.dao.UserDao;
import com.wzh.tools.springboot.domain.entity.UserDataInfo;
import com.wzh.tools.springboot.domain.response.UserData;
import com.wzh.tools.utils.dataresult.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/8/27 19:39
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public DataResult<UserData> getUserInfo(String userCode) {
        UserData userData = new UserData();
        try {
            UserDataInfo userDataInfo = userDao.getUserInfo(userCode);
            userData.setId(userDataInfo.getId());
            userData.setName(userDataInfo.getName());
            userData.setPhone(userDataInfo.getPhone());
            userData.setUserCode(userDataInfo.getUserCode());
            userData.setCreateTime(userDataInfo.getCreateTime());
            userData.setUpdateTime(userDataInfo.getUpdateTime());
        } catch (Exception e) {
            return DataResult.failed(-1, "查询失败");
        }
        return DataResult.success(userData);
    }
}
