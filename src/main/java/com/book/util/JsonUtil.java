package com.book.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {

    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static ObjectMapper objectMapper  = new ObjectMapper();

    public static String objectToJson(Object object){
        try{

            return objectMapper.writeValueAsString(object);
        }catch (Exception e){
            logger.error(e.getMessage());
            return "数据转换异常";
        }
    }

}
