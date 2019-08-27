package com.wzh.tools.vc.order.tpsanalysis.lockseat;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2018/10/30 10:11
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KgyLockSeatResult {

    /**
     * resultCode : 101103
     * resultMsg : 请查看返回结果说明
     * orderNo : null
     * seatInfos : null
     */

    private String resultCode;
    private String resultMsg;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
