import com.huangdekai.JavaWeb.mySMBMS.pojo.User;
import com.huangdekai.JavaWeb.mySMBMS.service.user.UserService;
import com.huangdekai.JavaWeb.mySMBMS.service.user.UserServiceImpl;
import org.junit.Test;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/16 23:27
 * @Version: 1.0
 * @since: jdk11
 */
public class TestUserService {
    @Test
    public void testUserService(){
        UserService userService = new UserServiceImpl();
        User user = userService.login("admin", "1234567");
        System.out.printf(user.getUserPassword());
    }
}
