package com.wzh.tools.utils.enumerate;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/7/24 9:48
 */

public enum PayWayCodeEnum {
    ALIPAY("ALIPAY", "影院支付宝"),
    WXPAY("WXPAY", "影院微信支付"),
    VCDJQPAY("VCDJQPAY", "影院代金券"),
    VCDHQPAY("VCDHQPAY", "影院兑换券支付"),
    VCOFFLINEHYPAY("VCOFFLINEHYPAY", "线下会员卡支付"),
    VCZKQPAY("VCZKQPAY", "影院折扣券支付"),
    VCLPKPAY("VCLPKPAY", "影院礼品卡支付"),
    VCDLBPAY("VCDLBPAY", "影院哆啦宝支付"),
    WLDS("WLDS", "网络代售");

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    PayWayCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static PayWayCodeEnum valuesOf(String index) {
        switch (index) {
            case "影院支付宝":
                return ALIPAY;
            case "影院微信支付":
                return WXPAY;
            case "影院代金券":
                return VCDJQPAY;
            case "影院兑换券支付":
                return VCDHQPAY;
            case "线下会员卡支付":
                return VCOFFLINEHYPAY;
            case "影院折扣券支付":
                return VCZKQPAY;
            case "影院礼品卡支付":
                return VCLPKPAY;
            case "影院哆啦宝支付":
                return VCDLBPAY;
            default:
                return WLDS;
        }
    }
}
