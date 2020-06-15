package com.ictbda.iot;

import com.alibaba.fastjson.JSONObject;
import com.ictbda.iot.utils.HttpUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=IotApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IotApplicationTests {

    @Test
    public void test() {
        String pwd = "123456";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder ( );
        String s = encoder.encode (pwd);
        System.out.println ( s );
    }



    @Test
    public void test2() {
        String s = HttpUtils.doGet ("https://restapi.amap.com/v3/geocode/regeo?key=0b86e6c70aa11dfb95bee71e394dc2a9&location=116.310003,39.991957" );
        JSONObject jsonObject = JSONObject.parseObject (s);
        Map<String, Object> map = (Map<String, Object>) jsonObject.get ("regeocode");
        Object o = map.get ("addressComponent");
        System.out.println ( o );
        System.out.println ( s );
    }

}
