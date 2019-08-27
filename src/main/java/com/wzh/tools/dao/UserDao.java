package com.wzh.tools.dao;

import com.wzh.tools.domain.entity.UserDataInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/8/27 19:47
 */
@Repository
public interface UserDao {

    UserDataInfo getUserInfo(@Param("userCode") String userCode);

}
