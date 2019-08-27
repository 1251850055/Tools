package com.wzh.tools.domain.response;

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

    private String name;

    private String userCode;

    private String phone;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
