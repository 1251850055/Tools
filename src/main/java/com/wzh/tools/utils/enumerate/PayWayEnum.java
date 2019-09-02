package com.wzh.tools.utils.enumerate;

public enum PayWayEnum {
    NOPAY{
      @Override
      public int getId(){return 0;}
      @Override
      public String getName(){return "默认";}
    },
    UNIONPAY {
        @Override
        public int getId() {
            return 1;
        }
        @Override
        public String getName() {
            return "银联";
        }
    }, //维乐享
    TENPAY {
        @Override
        public int getId() {
            return 2;
        }
        @Override
        public String getName() {
            return "财付通";
        }
    }, //唯生素
    ALIPAY {
        @Override
        public int getId() {
            return 3;
        }
        @Override
        public String getName() {
            return "VC支付宝";
        }
    }, //维乐享
    WEIXINPAY {
        @Override
        public int getId() {
            return 4;
        }
        @Override
        public String getName() {
            return "VC微信支付";
        }
    }, //维乐享
    REDPACKAGE {
        @Override
        public int getId() {
            return 5;
        }
        @Override
        public String getName() {
            return "VC代金券";
        }
    },  //VC红包
    OFFLINECARD {
        @Override
        public int getId() {
            return 6;
        }
        @Override
        public String getName() {
            return "线下会员卡支付";
        }
    },
    APPUNIONPAY {
        @Override
        public int getId() {
            return 7;
        }
        @Override
        public String getName() {
            return "银联支付";
        }
    }, //维乐享  APP
    DADIWEIXINPAY {
        @Override
        public int getId() {
            return 8;
        }
        @Override
        public String getName() {
            return "微信支付";
        }
    }, //大地直营服务号专用
    HIPIAOACCOUNTPAY {
        @Override
        public int getId() {
            return 9;
        }
        @Override
        public String getName() {
            return "哈票账户支付";
        }
    },
    EXCHANGEPAY {
        @Override
        public int getId() {
            return 10;
        }
        @Override
        public String getName() {
            return "VC兑换劵支付";
        }
    },
    BALANCEPAY {
        @Override
        public int getId() {
            return 11;
        }
        @Override
        public String getName() {
            return "余额支付";
        }
    },  //VC余额
    CHINAUNIONPAY {
        @Override
        public int getId() {
            return 12;
        }
        @Override
        public String getName() {
            return "中国银联";
        }
    },  //唯生素 H5
    PCCHINAUNIONPAY {
        @Override
        public int getId() {
            return 13;
        }
        @Override
        public String getName() {
            return "中国银联支付";
        }
    },  //唯生素 PC
    CINEMAREDPACKAGE {
        @Override
        public int getId() {
            return 14;
        }
        @Override
        public String getName() {
            return "影院代金劵";
        }
    }, //影院支付宝
    CINEMAALIPAY {
        @Override
        public int getId() {
            return 15;
        }
        @Override
        public String getName() {
            return "影院支付宝";
        }
    }, //唯生素(影院T+0专用)
    VCFILMALIPAY {
        @Override
        public int getId() {
            return 16;
        }
        @Override
        public String getName() {
            return "支付宝支付";
        }
    }, //唯生素
    CINEMABALANCEPAY {
        @Override
        public int getId() {
            return 17;
        }
        @Override
        public String getName() {
            return "影院余额支付";
        }
    }, //唯生素
    CINEMAEXCHANGEPAY {
        @Override
        public int getId() {
            return 19;
        }
        @Override
        public String getName() {
            return "影院兑换券支付";
        }
    }, //影院余额
    CINEMABWECHATPAY{
        @Override
        public int getId() {
            return 18;
        }
        @Override
        public String getName() {
            return "影院微信支付";
        }
    },
    //优惠券支付
    COUPONPAY{
        @Override
        public int getId(){return 20;}
        @Override
        public String getName(){return "优惠券支付";}
    },
    //VC活动优惠
    VCACTIVITY{
        @Override
        public int getId(){return 21;}
        @Override
        public String getName(){return "VC活动优惠";}
    },
    //影院活动优惠
    CINEMAACTIVITY{
        @Override
        public int getId(){return 22;}
        @Override
        public String getName(){return "影院活动优惠";}
    },
    //影院补贴金额（会员卡低于发行价出票补贴金额）
    SUBSIDY{
        @Override
        public int getId(){return 23;}
        @Override
        public String getName(){return "影院补贴";}
    },
    //影院对贴
    CINEMAPLUS{
        @Override
        public int getId(){return 24;}
        @Override
        public String getName(){return "影院对贴";}
    },
    CINEMACARD{
        @Override
        public int getId(){return 25;}
        @Override
        public String getName(){return "影院礼品卡支付";}
    },
    VCCARD{
        @Override
        public int getId(){return 26;}
        @Override
        public String getName(){return "VC礼品卡支付";}
    },
	VCDISCOUNT{
		@Override
		public int getId(){return 27;}
		@Override
		public String getName(){return "VC折扣券支付";}
	},
	CINEMADISCOUNT{
		@Override
		public int getId(){return 28;}
		@Override
		public String getName(){return "影院折扣券支付";}
	},
    CINEMADUOLABAO{
        @Override
        public int getId(){return 29;}
        @Override
        public String getName(){return "影院哆啦宝支付";}
    };
    public abstract int getId();

    public abstract String getName();

    /**
     * 根据支付id查支付方式
     */
    public static PayWayEnum getPayWayEnum(int payWayId) {
        switch (payWayId) {
            case 0:
                return PayWayEnum.NOPAY;
            case 1:
                return PayWayEnum.UNIONPAY;
            case 2:
                return PayWayEnum.TENPAY;
            case 3:
                return PayWayEnum.ALIPAY;
            case 4:
                return PayWayEnum.WEIXINPAY;
            case 5:
                return PayWayEnum.REDPACKAGE;
            case 6:
                return PayWayEnum.OFFLINECARD;
            case 7:
                return PayWayEnum.APPUNIONPAY;
            case 8:
                return PayWayEnum.DADIWEIXINPAY;
            case 9:
                return PayWayEnum.HIPIAOACCOUNTPAY;
            case 10:
                return PayWayEnum.EXCHANGEPAY;
            case 11:
                return PayWayEnum.BALANCEPAY;
            case 12:
                return PayWayEnum.CHINAUNIONPAY;
            case 13:
                return PayWayEnum.PCCHINAUNIONPAY;
            case 14:
                return PayWayEnum.CINEMAREDPACKAGE;
            case 15:
                return PayWayEnum.CINEMAALIPAY;
            case 16:
                return PayWayEnum.VCFILMALIPAY;
            case 17:
                return PayWayEnum.CINEMABALANCEPAY;
            case 18:
                return PayWayEnum.CINEMABWECHATPAY;
            case 19:
                return PayWayEnum.CINEMAEXCHANGEPAY;
            case 20:
                return PayWayEnum.COUPONPAY;
            case 21:
                return PayWayEnum.VCACTIVITY;
            case 22:
                return PayWayEnum.CINEMAACTIVITY;
            case 23:
                return PayWayEnum.SUBSIDY;
            case 24:
                return PayWayEnum.CINEMAPLUS;
            case 25:
                return PayWayEnum.CINEMACARD;
            case 26:
                return PayWayEnum.VCCARD;
			case 27:
				return PayWayEnum.VCDISCOUNT;
			case 28:
				return PayWayEnum.CINEMADISCOUNT;
            case 29:
                return PayWayEnum.CINEMADUOLABAO;
            default:
                return PayWayEnum.COUPONPAY;
        }
    }

    /**
     * 判断支付方式是否是T+0，“0”表示否；“1”表示是
     * @param payWayId
     * @return
     */
    public static int isTZero(int payWayId){
        switch (payWayId) {
            case 0:
                return 1;
            case 3:
                return 0;
            case 4:
                return 0;
            case 5:
                return 0;
            case 6:
                return 1;
            case 10:
                return 0;
            case 14:
                return 1;
            case 15:
                return 1;
            case 18:
                return 1;
            case 19:
                return 1;
            case 21:
                return 0;
            case 22:
                return 1;
            case 23:
                return 1;
            case 24:
                return 1;
            case 25:
                return 1;
            case 26:
                return 0;
			case 27:
				return 0;
			case 28:
				return 1;
            case 29:
                return 0;
            default:
                return 1;
        }
    }
}
