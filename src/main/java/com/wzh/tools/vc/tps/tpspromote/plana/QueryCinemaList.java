package com.wzh.tools.vc.tps.tpspromote.plana;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/3/19 9:51
 */

public class QueryCinemaList extends CXParamBean{
    private static final String QueryCinemaList_INTERFACENAME = "soap:QueryCinemaList";


    @XStreamAlias("pAppCode")
    private String pAppCode;
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
