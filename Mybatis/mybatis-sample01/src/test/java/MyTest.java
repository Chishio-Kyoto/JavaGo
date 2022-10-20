import com.houle.pojo.User;
import com.houle.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.houle.utils.MybatisUtils;

import java.util.List;

public class MyTest {
    @Test
    public void selectUser() {
        SqlSession session = MybatisUtils.getSession();
        // 方法一:
        // List<User> users = session.selectList("com.houle.dao.UserDao.selectUser");
        // for (User user: users){
        //     System.out.println(user);
        // }
        System.out.println("********************");
        // 方法二:
        UserDao userDao = session.getMapper(UserDao.class);
        List<User> users01 = userDao.selectUser(1);

        System.out.println("user02: " + users01);
        session.close();
    }
}