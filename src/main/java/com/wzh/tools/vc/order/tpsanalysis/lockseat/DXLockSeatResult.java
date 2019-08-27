package com.wzh.tools.vc.order.tpsanalysis.lockseat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author wangzehui
 * @date 2018/6/25 19:41
 */
@XmlAccessorType(XmlAccessType.FIELD)
//根元素
@XmlRootElement(name = "root")
public class DXLockSeatResult {

    @XmlElement(name = "errorCode")
    private String resultCode;

    @XmlElement(name = "errorMessage")
    private String resultMessage;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
