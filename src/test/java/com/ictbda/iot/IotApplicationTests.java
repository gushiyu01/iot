package com.ictbda.iot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=IotApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class IotApplicationTests {

    @Test
    public void test() {
        String pwd = "123456";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder ( );
        String s = encoder.encode (pwd);
        System.out.println ( s );
    }

}
