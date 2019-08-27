package com.wzh.tools.vc.tps.tpspromote.plana;

import com.thoughtworks.xstream.XStream;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/3/18 10:51
 */

public class Test {
    private final static String XML_DECLARATION = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
    private final static String CHENXING_XMLSTART = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://soap.ws.tsp.oristartech.com/\"><soapenv:Header/><soapenv:Body>";
    private final static String CHENXING_XMLEND = "</soapenv:Body></soapenv:Envelope>";
    private static HashMap<String, String> classStringHashMap = new HashMap<>(16);
    private static String interfaceName;
    private static String requestHeader;
    private static String requestTail;

    public static <T> String toXMLAndSetMap(Object obj, Class<T> c) throws NoSuchFieldException, IllegalAccessException {
        if (classStringHashMap.isEmpty()) {
            //获取接口名称属性
            Field fieldInterfaceName = c.getDeclaredField(c.getSimpleName() + "_INTERFACENAME");
            fieldInterfaceName.setAccessible(true);
            interfaceName = (String) fieldInterfaceName.get(null);
            //获取请求头
            Field fieldRequestHeader = c.getSuperclass().getDeclaredField(c.getSuperclass().getSimpleName() + "_XMLSTART");
            fieldRequestHeader.setAccessible(true);
            requestHeader = (String) fieldRequestHeader.get(null);
            //获取请尾
            Field fieldRequestTail = c.getSuperclass().getDeclaredField(c.getSuperclass().getSimpleName() + "_XMLEND");
            fieldRequestTail.setAccessible(true);
            requestTail = (String) fieldRequestHeader.get(null);
            classStringHashMap.put("interfaceName", interfaceName);
            classStringHashMap.put("requestHeader", requestHeader);
            classStringHashMap.put("requestTail", requestTail);
        } else {
            interfaceName = classStringHashMap.get("interfaceName");
            requestHeader = classStringHashMap.get("requestHeader");
            requestTail = classStringHashMap.get("requestTail");
        }
        XStream stream = new XStream();
        stream.alias(interfaceName, obj.getClass());
        return new StringBuffer(requestHeader).append(stream.toXML(obj)).append(requestTail).toString();
    }

    public static <T> String toXML(Object obj, Class<T> c) throws NoSuchFieldException, IllegalAccessException {
        //获取接口名称属性
        Field fieldInterfaceName = c.getDeclaredField(c.getSimpleName() + "_INTERFACENAME");
        fieldInterfaceName.setAccessible(true);
        String interfaceName = (String) fieldInterfaceName.get(null);
        //获取请求头
        Field fieldRequestHeader = c.getSuperclass().getDeclaredField(c.getSuperclass().getSimpleName() + "_XMLSTART");
        fieldRequestHeader.setAccessible(true);
        String requestHeader = (String) fieldRequestHeader.get(null);
        //获取请尾
        Field fieldRequestTail = c.getSuperclass().getDeclaredField(c.getSuperclass().getSimpleName() + "_XMLEND");
        fieldRequestTail.setAccessible(true);
        String requestTail = (String) fieldRequestHeader.get(null);
        XStream stream = new XStream();
        stream.alias(interfaceName, obj.getClass());
        return new StringBuffer(requestHeader).append(stream.toXML(obj)).append(requestTail).toString();
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        long startTime = System.currentTimeMillis();

//        methodOne();

        for (int i = 0; i < 20000; i++) {
            pkMethodTwo();
//            methodTwo();
//            methodThree();
        }


        long endTime = System.currentTimeMillis();
        System.out.println("耗时" + (endTime - startTime) + "毫秒");

    }

    private static void methodOne() {
        QueryCinemaList xmlBean = new QueryCinemaList();
        xmlBean.setpAppCode("HPUSER");
        xmlBean.setpCompress("0");
        xmlBean.setpVerifyInfo("90ac6f9e2cb26f7bee99d37e4f0e0304");

        //创建解析XML对象
        XStream xStream = new XStream();
        //声明XStream注解来源
        xStream.processAnnotations(QueryCinemaList.class);
        //设置别名, 默认会输出全路径
        xStream.alias("soap:QueryCinemaList", QueryCinemaList.class);
        //转为xml
        String xml = xStream.toXML(xmlBean);
        System.out.println(xml);
    }


    private static void methodTwo() throws NoSuchFieldException, IllegalAccessException {
        QueryCinemaList xmlBean = new QueryCinemaList();
        xmlBean.setpAppCode("HPUSER");
        xmlBean.setpCompress("0");
        xmlBean.setpVerifyInfo("90ac6f9e2cb26f7bee99d37e4f0e0304");
        String s = toXML(xmlBean, QueryCinemaList.class);
        System.out.println(s);
    }

    private static void methodThree() throws NoSuchFieldException, IllegalAccessException {
        QueryCinemaInfo xmlBean = new QueryCinemaInfo();
        xmlBean.setpAppCode("HPUSER");
        xmlBean.setpCompress("0");
        xmlBean.setpCinemaCode("1234567");
        xmlBean.setpVerifyInfo("90ac6f9e2cb26f7bee99d37e4f0e0304");
        String s = toXMLAndSetMap(xmlBean, QueryCinemaInfo.class);
        System.out.println(s);
    }

    private static void pkMethodTwo() {
        StringBuffer request = new StringBuffer();
        request.append(CHENXING_XMLSTART);
        request.append("<soap:QueryCinemaInfo><pAppCode>");
        request.append("HPUSER");
        request.append("</pAppCode><pCinemaCode>");
        request.append("123456787");
        request.append("</pCinemaCode><pCompress>");
        request.append("0");
        request.append("</pCompress><pVerifyInfo>");
        request.append("90ac6f9e2cb26f7bee99d37e4f0e0304");
        request.append("</pVerifyInfo></soap:QueryCinemaInfo>");
        request.append(CHENXING_XMLEND);
        System.out.println(request.toString());

    }


}
