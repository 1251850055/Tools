package com.wzh.tools.vc.order.tpsanalysis.lockseat;

/**
 * @author wangzehui
 * @date 2018/6/25 20:54
 */

public class DaDiLockSeatResult {
    /**
     * code : 20025
     * message : 该手机号下存在尚未出票或尚未取消的订单!
     */

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
