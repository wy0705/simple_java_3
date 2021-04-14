import com.ease.architecture.config.WebConfig;
import com.ease.architecture.dao.mapper.UserMapper;
import com.ease.architecture.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
public class TestDao {


    @Autowired
    private UserMapper userMapper;


    @Test
    public void testMapper() {
        User aaa = userMapper.findByName("aaa");
        Assert.assertEquals("", aaa == null ? "" : aaa.getName());
    }
}
