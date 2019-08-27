package com.wzh.tools.vc.order.tpsanalysis.lockseat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
//根元素
@XmlRootElement(name = "RealCheckSeatStateResult")
public class CMTSLockSeatResult {
	@XmlElement(name = "ResultCode")
	private String resultCode;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
}
