package Test;
//wjk
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;

import java.io.IOException;
import java.io.Reader;

//从 SqlSessionFactory 中获取 SqlSession
public class UserTest {
    public static void main(String[] args) {

        findUserById();
    }

    public static void findUserById() {

        String resources = "mybatis-config.xml";
        Reader reader = null;

        try {
            reader = Resources.getResourceAsReader(resources);

        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = sqlMapper.openSession();

        User user = session.selectOne("findUserById", 2);
        System.out.println(user);
        // System.out.println(user.getName());

        session.close();
    }
}
