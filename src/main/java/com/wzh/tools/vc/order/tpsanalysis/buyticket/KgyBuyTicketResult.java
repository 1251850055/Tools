package com.wzh.tools.vc.order.tpsanalysis.buyticket;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2018/10/30 10:11
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KgyBuyTicketResult {

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
