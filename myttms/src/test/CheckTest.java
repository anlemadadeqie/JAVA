import com.ttms.dao.UserDAO;
import com.ttms.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hjh on 16-12-1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-MVC.xml"
        ,"classpath:config/spring-mybatis.xml"})

public class CheckTest {

    @Autowired
    UserDAO userDAO;

    @Test
    public void updateUser(){
        User user = new User();
        user.setType(0);
        user.setEmp_no("007");
        user.setEmp_pass("654321");
        userDAO.updateUser(user);

    }
}
