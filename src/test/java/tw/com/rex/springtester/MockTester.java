package tw.com.rex.springtester;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import tw.com.rex.springtester.dao.UserDao;
import tw.com.rex.springtester.service.BaseService;

import java.io.File;
import java.nio.file.Files;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockTester {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BaseService baseService;
    @Autowired
    private UserDao userDao;

    /**
     * test Controller return static HTML
     *
     * @throws Exception for MockMvc.perform()
     */
    @Test
    public void testControllerReturnStaticHtml() throws Exception {
        File login = new ClassPathResource("templates/index.html").getFile();
        String html = new String(Files.readAllBytes(login.toPath()));
        this.mockMvc.perform(get("/"))//
                .andExpect(status().isOk())//
                .andExpect(content().string(html))//
                .andDo(print());
    }

    @Test
    public void testBaseServiceServiceImpl() {
        long count = baseService.count();
        Assert.assertEquals("expected count is 1 but actual is " + count, 1, count);
    }

    /**
     * test UserDao
     */
    @Test
    public void testUserDao() {
        long count = userDao.count();
        Assert.assertEquals("expected count is 1 but actual is " + count, 1, count);
    }

}
