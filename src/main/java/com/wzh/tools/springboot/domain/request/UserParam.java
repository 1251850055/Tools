package com.wzh.tools.springboot.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/8/27 19:30
 */
@Data
@ApiModel(value = "用户请求实体类")
public class UserParam implements Serializable {
    private static final long serialVersionUID = 5373828888042874615L;

    /**
     * Validator 参数校验 pom <artifactId>spring-boot-starter-web</artifactId>
     * <p>
     * JSR提供的校验注解：
     *
     * @Null 被注释的元素必须为 null
     * @NotNull 被注释的元素必须不为 null
     * @AssertTrue 被注释的元素必须为 true
     * @AssertFalse 被注释的元素必须为 false
     * @Min(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
     * @Max(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
     * @DecimalMin(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
     * @DecimalMax(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
     * @Size(max=, min=)   被注释的元素的大小必须在指定的范围内
     * @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内
     * @Past 被注释的元素必须是一个过去的日期
     * @Future 被注释的元素必须是一个将来的日期
     * @Pattern(regex=,flag=) 被注释的元素必须符合指定的正则表达式
     * <p>
     * Hibernate Validator提供的校验注解：
     * @NotBlank(message =)   验证字符串非null，且长度必须大于0
     * @Email 被注释的元素必须是电子邮箱地址
     * @Length(min=,max=) 被注释的字符串的大小必须在指定的范围内
     * @NotEmpty 被注释的字符串的必须非空
     * @Range(min=,max=,message=) 被注释的元素必须在合适的范围内
     * csdn：https://blog.csdn.net/u013815546/article/details/77248003
     */


    @ApiModelProperty(value = "用户编码")
    private String userCode;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "用户手机号")
    private String userPhone;

    @ApiModelProperty(value = "页大小")
    private Integer rows = 10;

    @ApiModelProperty(value = "页码")
    private Integer currentPage = 1;

}
