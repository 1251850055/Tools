package com.wzh.tools.vc.tps.tpspromote.plana;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/3/19 9:51
 */

public class QueryCinemaInfo extends CXParamBean{
    private static final String QueryCinemaInfo_INTERFACENAME = "soap:QueryCinemaInfo";

    @XStreamAlias("pAppCode")
    private String pAppCode;
    @XStreamAlias("pCinemaCode")
    private String pCinemaCode;
    @XStreamAlias("pCompress")
    private String pCompress;
    @XStreamAlias("pVerifyInfo")
    private String pVerifyInfo;

    public String getpAppCode() {
        return pAppCode;
    }

    public void setpAppCode(String pAppCode) {
        this.pAppCode = pAppCode;
    }

    public String getpCinemaCode() {
        return pCinemaCode;
    }

    public void setpCinemaCode(String pCinemaCode) {
        this.pCinemaCode = pCinemaCode;
    }

    public String getpCompress() {
        return pCompress;
    }

    public void setpCompress(String pCompress) {
        this.pCompress = pCompress;
    }

    public String getpVerifyInfo() {
        return pVerifyInfo;
    }

    public void setpVerifyInfo(String pVerifyInfo) {
        this.pVerifyInfo = pVerifyInfo;
    }
}
