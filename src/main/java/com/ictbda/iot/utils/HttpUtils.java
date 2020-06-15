package com.ictbda.iot.utils;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @Author: Create by gsy
 * @Date: Create in 2020/6/12 9:15
 * @Description:
 * https://www.cnblogs.com/shamo89/p/10204479.html
 * https://www.cnblogs.com/zhi-leaf/p/8508071.html
 */
public class HttpUtils {
    public static String doPost(String uri, Map<String, String> map){
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 设置可输入
            connection.setDoInput(true);
            // 设置该连接是可以输出的
            connection.setDoOutput(true);
            // 设置请求方式
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write(objectMapper.writeValueAsString(map));
            pw.flush();
            pw.close();
            String s = method(connection);

            System.out.println(s);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String doGet(String uri){
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 设置该连接是可以输出的
            connection.setDoOutput(true);
            // 设置请求方式
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            String s = method(connection);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String method(HttpURLConnection connection){
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line;
            StringBuilder result = new StringBuilder();
            // 读取数据
            while ((line = br.readLine()) != null) {
                result.append(line + "\n");
            }
            connection.disconnect();
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
