package com.neu.langsam.community;

import com.neu.langsam.community.util.SensitiveFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SensitiveTests {

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitiveFilter() {
        String test = "这里可以%%^赌%$博，可以嫖*^&^娼，可以吸毒，可以开票，哈哈哈！";
        test = sensitiveFilter.filter(test);
        System.out.println(test);
    }
}
