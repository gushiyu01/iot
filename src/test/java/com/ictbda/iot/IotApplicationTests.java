package com.ictbda.iot;

import com.alibaba.fastjson.JSONObject;
import com.ictbda.iot.utils.CoordinateTransformUtil;
import com.ictbda.iot.utils.EFenceUtils;
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

        System.out.println ( Math.cos (1/6) );
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

    @Test
    public void test3(){
        boolean b = EFenceUtils.isInCircle (1000, 113.639834,34.753862, 113.648817,34.753884);
        System.out.println ( b );

        double[] doubles = CoordinateTransformUtil.bd09towgs84 (116.403963,39.915119);
        for (double aDouble : doubles) {
            System.out.println (aDouble );
        }

        double[] doubles1 = CoordinateTransformUtil.gcj02towgs84 (116.397451, 39.909187);
        for (double v : doubles1) {
            System.out.println ( v );
        }
    }

}
