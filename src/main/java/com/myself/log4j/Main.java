package com.myself.log4j;



import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.util.datetime.DatePrinter;


import java.io.File;
import java.text.DateFormat;
import java.util.Date;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("===========程 序 启 动===========");
        // 当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
               // DateUtil 第三方jar包中的类z
        String now = DateFormat.getDateTimeInstance().toString();
        System.out.println("当前时间：" + now);
        //获取当前项目的根目录
        String relativelyPath=System.getProperty("user.dir");

        PropertyConfigurator.configure(relativelyPath+ "/src/main/resources/log4j.properties");

        //创建一个JSON对象
        JSONObject appObject = new JSONObject();
        //将数据添加到对象中
        appObject.put("type", "type_value");
        appObject.put("username", "username_value");
        appObject.put("password", "password_value");
        appObject.put("sendTime", "sendTime_value");
        int num=0;

            while (num<=100000) {
                logger.debug("debug..."+"json对象"+"第"+num+"次"+appObject.toString());
                logger.error("error..."+"json对象"+"第"+num+"次"+appObject.toString());
                num++;
                if(num==50000) num=0;

            }


        System.out.println("===========程 序 关 闭===========");
    }


}
