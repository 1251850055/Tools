package com.wzh.tools.utils.exception;

/**
 * 票券模块自定义异常
 *
 * @author wuya
 */
public class CouponException extends RuntimeException {

    private static final String DEFAULT_ERROR_CODE = "9999";

    /**
     *
     */
    private static final long serialVersionUID = 6402987655616847030L;

    /**
     * 自定义错误编码
     */
    private String code;

    /**
     * 自定义错误信息
     */
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CouponException(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public CouponException() {
        super();
    }

    public CouponException(Exception e) {
        super(e);
    }

    public CouponException(String code, String msg, Exception e) {
        super(e);
        this.code = code;
        this.msg = msg;
    }

    public CouponException(String msg) {
        super();
        this.code = DEFAULT_ERROR_CODE;
        this.msg = msg;
    }


}
