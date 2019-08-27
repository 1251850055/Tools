package com.wzh.tools.vc.order.tpsanalysis.lockseat;

/**
 * @author wangzehui
 * @date 2018/6/25 21:02
 */

public class HFHLockSeatResult {


    /**
     * api : ykse.partner.seat.lockSeats
     * v : 1.0
     * retCode : 0
     * retMsg : success
     * data : {"bizMsg":"锁座时间超出设定日期","bizCode":"LOCK_SEAT_OUT_DATE"}
     */

    private String api;
    private String v;
    private String retCode;
    private String retMsg;
    private DataBean data;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bizMsg : 锁座时间超出设定日期
         * bizCode : LOCK_SEAT_OUT_DATE
         */

        private String bizMsg;
        private String bizCode;

        public String getBizMsg() {
            return bizMsg;
        }

        public void setBizMsg(String bizMsg) {
            this.bizMsg = bizMsg;
        }

        public String getBizCode() {
            return bizCode;
        }

        public void setBizCode(String bizCode) {
            this.bizCode = bizCode;
        }
    }
}
