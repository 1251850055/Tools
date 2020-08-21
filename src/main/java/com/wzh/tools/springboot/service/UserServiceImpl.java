package com.wzh.tools.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzh.tools.springboot.dao.UserDao;
import com.wzh.tools.springboot.domain.entity.UserDataInfo;
import com.wzh.tools.springboot.domain.request.UserParam;
import com.wzh.tools.springboot.domain.response.UserData;
import com.wzh.tools.utils.dataresult.DataResult;
import com.wzh.tools.utils.dataresult.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            userData.setUserName(userDataInfo.getUserName());
            userData.setUserPhone(userDataInfo.getUserPhone());
            userData.setUserCode(userDataInfo.getUserCode());
            userData.setCreateTime(userDataInfo.getCreateTime());
            userData.setUpdateTime(userDataInfo.getUpdateTime());
        } catch (Exception e) {
            return DataResult.failed(-1, "查询用户信息失败");
        }
        return DataResult.success(userData);
    }

    @Override
    public DataResult<PageEntity<UserData>> getUserList(UserParam userParam) {
        List<UserData> listData = new ArrayList<>();
        //分页
        PageHelper.startPage(userParam.getCurrentPage(), userParam.getRows());
        try {
            List<UserDataInfo> userDataList = userDao.getUserList(userParam.getUserPhone());
            PageInfo<UserDataInfo> pageInfo = new PageInfo<>(userDataList);
            userDataList.forEach(userDataInfo -> {
                UserData userData = new UserData();
                userData.setId(userDataInfo.getId());
                userData.setUserName(userDataInfo.getUserName());
                userData.setUserCode(userDataInfo.getUserCode());
                userData.setUserPhone(userDataInfo.getUserPhone());
                listData.add(userData);
            });
            return DataResult.success(new PageEntity<>(userParam.getCurrentPage(), userParam.getRows(), (int) pageInfo.getTotal(), listData));
        } catch (Exception e) {
            return DataResult.failed(-1, "查询用户列表失败");
        }
    }
}
