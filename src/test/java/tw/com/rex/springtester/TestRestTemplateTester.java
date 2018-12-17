package tw.com.rex.springtester;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 使用TestRestTemplate測試Controller
 */
@RunWith(SpringRunner.class)
// webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT是必須的，否則@Autowired會出錯
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRestTemplateTester {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void test() {
        String object = this.template.getForObject("/", String.class);
        System.out.println(object);
    }

}

