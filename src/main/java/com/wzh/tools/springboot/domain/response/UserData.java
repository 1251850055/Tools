package com.wzh.tools.springboot.domain.response;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/8/27 19:30
 */
@Data
public class UserData implements Serializable {
    private static final long serialVersionUID = 5938943569805691416L;

    private Integer id;

    private String userName;

    private String userCode;

    private String userPhone;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
