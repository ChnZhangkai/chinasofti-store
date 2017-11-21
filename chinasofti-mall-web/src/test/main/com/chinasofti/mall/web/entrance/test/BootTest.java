package com.chinasofti.mall.web.entrance.test;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;


@RunWith(SpringRunner.class)
@SpringBootTest
@EnableEncryptableProperties
public class BootTest {
	@Autowired
    StringEncryptor stringEncryptor;//密码解码器自动注入
	
    @Test
    public void test() 
    	{ System.out.println(stringEncryptor.encrypt("dajiajiayou"));
    }
    @Test
    public void test2() 
    	{ System.err.println(stringEncryptor.decrypt("KXSSc4UB/CUdaxeRJZCJUQ=="));
    }
}
