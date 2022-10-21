import com.houle.dao.UserDao;
import com.houle.pojo.User;
import com.houle.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void selectUser() {
        SqlSession session = MybatisUtils.getSession();
        UserDao userDao = session.getMapper(UserDao.class);
        List<User> users = userDao.selectUserAll();

        System.out.println("all user: " + users.size());
        session.close();
        System.out.println("********************");
    }
}
