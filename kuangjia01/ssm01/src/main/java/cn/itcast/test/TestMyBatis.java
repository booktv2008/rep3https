package cn.itcast.test;

import cn.itcast.dao.IAccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class TestMyBatis {

    @Test
    public void test(){

    }

    @Test
    public void run1() throws IOException {
        Account account = new Account();
        account.setName("xiaozhi");
        account.setMoney(888d);

        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        SqlSession session = factory.openSession();

        IAccountDao dao = session.getMapper(IAccountDao.class);

//        List<Account> accounts = accountDao.findAll();
//        System.out.println(accounts);
        dao.saveAccount(account);
        session.commit();

        session.close();
        in.close();
    }
}
