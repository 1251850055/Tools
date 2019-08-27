package com.wzh.tools.vc.order.tpsanalysis;


import com.wzh.tools.utils.jax.JaxbUtil;
import com.wzh.tools.vc.order.tpsanalysis.buyticket.KgyBuyTicketResult;
import com.wzh.tools.vc.order.tpsanalysis.lockseat.*;

/**
 * @author wangzehui
 * @date 2018/6/25 17:49
 */

public class Test {

    //测试锁座错误
    public static void main(String[] args) {
        Test test = new Test();

        String responseCMTS = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><RealCheckSeatStateResult><SeatInfos/><ResultCode>101104</ResultCode><OrderNo></OrderNo></RealCheckSeatStateResult> ";
        CMTSLockSeatResult cmtsLockSeatResult = test.xmlToBean(responseCMTS, CMTSLockSeatResult.class);

        String a1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><SellTicketResult><ResultCode>101202</ResultCode><OrderNo></OrderNo><ValidCode></ValidCode></SellTicketResult>";
        System.out.println("满天星+++++++++++++++++++++++++++++++++++++++++" + cmtsLockSeatResult.getResultCode());

        CMTSLockSeatResult cmtsLockSeatResult1 = JaxbUtil.converyToJavaBean(responseCMTS, CMTSLockSeatResult.class);
        System.out.println("满天星2++++++++++++++++++++++++++++++++++++++" + cmtsLockSeatResult1.getResultCode());

        String responseDX = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <root> <status>0</status> <errorMessage>卡余额不足，总价为30元，卡余额为0.00元</errorMessage> <errorCode>510573</errorCode> <data/> </root> ";

        String a2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root>\n" +
                "\t        \t<status>0</status>\n" +
                "\t        \t<errorMessage>超出每次最多允许购买数</errorMessage>\n" +
                "\t        \t<errorCode>505526</errorCode>\n" +
                "\t        \t<data/>\n" +
                "\t        </root>";
        DXLockSeatResult dxLockSeatResult = test.xmlToBean(responseDX, DXLockSeatResult.class);
        System.out.println("鼎新+++++++++++++++++++++++++++++++++++++++++++" + dxLockSeatResult.getResultCode() + "。" + dxLockSeatResult.getResultMessage());

        String a3 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<reply><code>345</code><msg>订单所包含的影票中座位信息不存在</msg><version>3.0</version><costTime>147</costTime><cinemaCode>53040501</cinemaCode><cinemaName>云南玉溪印象影城</cinemaName><showCode>0518022800609703</showCode><channelShowCode>53040501181007829428</channelShowCode><tickets/></reply>";

        String responseHLN = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <reply><code>202</code><msg>渠道场次已失效。</msg><version>3.0</version><costTime>3</costTime><cinemaName/><showCode/></reply> ";
        HLNLockSeatResult hlnLockSeatResult = test.xmlToBean(responseHLN, HLNLockSeatResult.class);
        System.out.println("火烈鸟++++++++++++++++++++++++++++++++++++++++++++++" + hlnLockSeatResult.getResultCode() + "。" + hlnLockSeatResult.getResultMessage());


        String responseCX = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<LockSeatResult xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
                "   <ResultCode>100302</ResultCode>\n" +
                "   <Message>网络代售系统异常: 锁座失败(错误码：10208)</Message>\n" +
                "   <OrderCode/>\n" +
                "   <AutoUnlockDatetime/>\n" +
                "   <LockLength/>\n" +
                "   <FeatureAppNo/>\n" +
                "</LockSeatResult>";

        String a = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<SubmitOrderResult xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
                "   <ResultCode>100302</ResultCode>\n" +
                "   <Message>网络代售系统异常: 订单交易确认出错，传入数据中票价不符合要求（标准价32.0元，服务费-2.0元）(错误码：10252)</Message>\n" +
                "   <OrderCode/>\n" +
                "   <FeatureAppNo/>\n" +
                "   <PrintNo/>\n" +
                "   <VerifyCode/>\n" +
                "</SubmitOrderResult>";
        CXLockSeatBean cxLockSeatBean = test.xmlToBean(responseCX, CXLockSeatBean.class);
        System.out.println("辰星+++++++++++++++++++++++++++++++++++++++++++++" + cxLockSeatBean.getResultCode() + "。" + cxLockSeatBean.getResultMessage());


        String responseTH = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<reply><msg>电影票结算价不符。</msg><code>223</code><costTime>23</costTime></reply>";
        THLockSeatBean thLockSeatBean = test.xmlToBean(responseTH, THLockSeatBean.class);
        System.out.println("天河++++++++++++++++++++++++++++++++++++++++++++++++" + thLockSeatBean.getResultCode() + "," + thLockSeatBean.getResultMessage());

        //{"time":1529926872,"errno":300001,"error":"","data":[]}
        String jsonFilm = "{\"time\":1529926872,\"errno\":300001,\"error\":\"\",\"data\":[]}";
//        String responseFilm = JaxbUtil.JsonToXmlString(jsonFilm);
//        FilmLockSeatResult filmLockSeatResult = test.xmlToBean(responseFilm, FilmLockSeatResult.class);
//        System.out.println("1905+++++++++++++++++++++++++++++++++++++++++++++" + filmLockSeatResult.getResultCode());
        FilmLockSeatResult filmLockSeatResult = test.jsonToBean(jsonFilm, FilmLockSeatResult.class);
        System.out.println("JSon1905+++++++++++++++++++++++++++++++++++++++++++++" + filmLockSeatResult.getErrno());


        //{"code":20025,"message":"该手机号下存在尚未出票或尚未取消的订单!"}
        String jsonDaDi = "{\"code\":20025,\"message\":\"该手机号下存在尚未出票或尚未取消的订单!\"}";
//        String responseDaDi = JaxbUtil.JsonToXmlString(jsonDaDi);
//        DaDiLockSeatResult daDiLockSeatResult = test.xmlToBean(responseDaDi, DaDiLockSeatResult.class);
        DaDiLockSeatResult daDiLockSeatResult = test.jsonToBean(jsonDaDi, DaDiLockSeatResult.class);
        System.out.println("Json大地++++++++++++++++++++++++++++++++++++++++++++++++++" + daDiLockSeatResult.getCode() + "。" + daDiLockSeatResult.getMessage());


        //{"api":"ykse.partner.seat.lockSeats","v":"1.0","retCode":"0","retMsg":"success","data":{"bizMsg":"锁座时间超出设定日期","bizCode":"LOCK_SEAT_OUT_DATE"}}
        String jsonHFH = "{\"api\":\"ykse.partner.seat.lockSeats\",\"v\":\"1.0\",\"retCode\":\"0\",\"retMsg\":\"success\",\"data\":{\"bizMsg\":\"锁座时间超出设定日期\",\"bizCode\":\"LOCK_SEAT_OUT_DATE\"}}";
//        String responseHFH = JaxbUtil.JsonToXmlString(jsonHFH);
//        HFHLockSeatResult hfhLockSeatResult = test.xmlToBean(responseHFH, HFHLockSeatResult.class);
        HFHLockSeatResult hfhLockSeatResult = test.jsonToBean(jsonHFH, HFHLockSeatResult.class);
        System.out.println("JSON火凤凰+++++++++++++++++++++++++++++++++++++++++++++++" + hfhLockSeatResult.getData().getBizCode() + "。" + hfhLockSeatResult.getData().getBizMsg());


        //{"api":"ykse.lark.partner.seat.lockSeats","v":"1.0","retCode":"0","retMsg":"success","data":{"bizMsg":"场次未开售或停售","bizCode":"SCHEDULE_CLOSE_SALE","success":false}}
        String jsonHFHN = "{\"api\":\"ykse.lark.partner.seat.lockSeats\",\"v\":\"1.0\",\"retCode\":\"0\",\"retMsg\":\"success\",\"data\":{\"bizMsg\":\"场次未开售或停售\",\"bizCode\":\"SCHEDULE_CLOSE_SALE\"}}";
//        String responseHFHN = JaxbUtil.JsonToXmlString(jsonHFHN);
//        HFHLockSeatResult hfhnLockSeatResult = test.xmlToBean(responseHFHN, HFHLockSeatResult.class);
        HFHLockSeatResult hfhLockSeatResult1 = test.jsonToBean(jsonHFHN, HFHLockSeatResult.class);
        System.out.println("凤凰云智+++++++++++++++++++++++++++++++++++++++++++++++" + hfhLockSeatResult1.getData().getBizCode() + "。" + hfhLockSeatResult1.getData().getBizMsg());


//        //Vista
//        //{"ErrorDescription":"Ticket Type 0028 could not be added to the order because the booking fee override provided is below the minimum booking fee","Result":1,"AreaSummaryData":"","AvailableSeats":-1,"ExtendedResultCode":64,"MaxSeatsPerRow":0,"Order":null,"RedemptionsRemainingForVouchers":[],"SeatData":"","SeatDataLength":0,"SeatLayoutData":null,"SeatsNotAllocated":false,"SessionStatuses":[{"MaximumNumberOfSeatsPerRow":0,"NumberOfSeatsAvailable":0,"SessionId":18633}]}
//        String jsonVista = "{\"ErrorDescription\":\"Ticket Type 0028 could not be added to the order because the booking fee override provided is below the minimum booking fee\",\"Result\":1,\"AreaSummaryData\":\"\",\"AvailableSeats\":-1,\"ExtendedResultCode\":64,\"MaxSeatsPerRow\":0,\"Order\":null,\"RedemptionsRemainingForVouchers\":[],\"SeatData\":\"\",\"SeatDataLength\":0,\"SeatLayoutData\":null,\"SeatsNotAllocated\":false,\"SessionStatuses\":[{\"MaximumNumberOfSeatsPerRow\":0,\"NumberOfSeatsAvailable\":0,\"SessionId\":18633}]}";
//         VistaLockSeatResult vistaLockSeatResult = test.jsonToBean(jsonVista, VistaLockSeatResult.class);
//        System.out.println("Vista+++++++++++++++++++++++++++++++++++++++++++++++++" + vistaLockSeatResult.getSessionStatuses().get(0).getSessionId());

        //快购云购票code，msg
        String kgyBuyStr = " {\"onlineCode\":\"99158469\",\"tickets\":[{\"ticketNo\":\"4401122100238827\",\"seatNo\":\"0300000100100601\"}],\"validCode\":\"274410\",\"printCode\":\"747212\",\"resultCode\":\"0\",\"cinemaCode\":\"44011221\",\"orderStatus\":4,\"resultMsg\":\"操作成功。\"} ";
        KgyBuyTicketResult kgyBuyTicketResult = test.jsonToBean(kgyBuyStr, KgyBuyTicketResult.class);
        System.out.println("快购云购票+++++++++++++++++++++++++++++++++++++++++++++++" + kgyBuyTicketResult.getResultCode() + "。" + kgyBuyTicketResult.getResultMsg());


        //快购云锁座code,msg
        String kgyLockStr = "{\"resultCode\":\"223\",\"resultMsg\":\"未找到编码为的0300000300200101座位。\",\"orderNo\":null,\"seatInfos\":null}";
        KgyLockSeatResult kgyLockSeatResult = test.jsonToBean(kgyLockStr, KgyLockSeatResult.class);
        System.out.println("快购云锁座+++++++++++++++++++++++++++++++++++++++++++++++" + kgyLockSeatResult.getResultCode() + "。" + kgyLockSeatResult.getResultMsg());


    }


    private <T> T xmlToBean(String response, Class<T> c) {
        return JaxbUtil.converyToJavaBean(response, c);

    }

    private <T> T jsonToBean(String json, Class<T> c) {
        return JaxbUtil.jsonToJavaBean(json, c);
    }


}
