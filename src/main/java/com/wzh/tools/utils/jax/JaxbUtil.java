package com.wzh.tools.utils.jax;

import net.sf.json.JSONObject;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;


public class JaxbUtil  {
                                                                        
    /**                                                                 
     * xml转换成JavaBean                                                
     * @param xml                                                       
     * @param c                                                         
     * @return                                                          
     */                                                                 
    @SuppressWarnings("unchecked")                                      
    public static <T> T converyToJavaBean(String xml, Class<T> c) {     
        T t = null;                                                     
        try {                                                           
            JAXBContext context = JAXBContext.newInstance(c);           
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = (T) unmarshaller.unmarshal(new StringReader(xml));      
        } catch (Exception e) {                                         
            e.printStackTrace();                                        
        }                                                               
                                                                        
        return t;                                                       
    }

    /**
     * Json多层数据结构转换成xml
     * @param
     * @return
     */
    public static String JsonToXmlString(String jsonStr){
        JSONObject json = JSONObject.fromObject(jsonStr);
        StringBuffer sb = new StringBuffer("<xml>");
        for(Object key : json.keySet()){
            sb.append("<").append(key).append(">");
            Object value = json.get(key);
            sb.append(iteraorJson(value));
            sb.append("</").append(key).append(">");
        }
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 迭代判断value是否还包含jSONObject
     * @param value
     * @return
     */
    public static String iteraorJson(Object value){
        StringBuffer sb = new StringBuffer("");
        if((value.toString().contains(":"))){
            JSONObject json = ((JSONObject)value);
            for(Object key : json.keySet()){
                sb.append("<").append(key).append(">");
                Object value2 = json.get(key);
                sb.append(iteraorJson(value2));
                sb.append("</").append(key).append(">");
            }
        }else{
            sb.append(value);
        }
        return sb.toString();
    }


    /**
     * Json 转换成JavaBean
     *
     * @param json
     * @param c
     * @return
     */
    public static <T> T jsonToJavaBean(String json, Class<T> c) {
        T t = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        try {
            t = mapper.readValue(json, c);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

}                                                                       
                                                                        
