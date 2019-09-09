package com.wzh.tools.springboot.dao;

import com.wzh.tools.springboot.domain.entity.UserDataInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/8/27 19:47
 */
@Repository
public interface UserDao {

    UserDataInfo getUserInfo(@Param("userCode") String userCode);

    List<UserDataInfo> getUserList(@Param("userName") String userName);
}
