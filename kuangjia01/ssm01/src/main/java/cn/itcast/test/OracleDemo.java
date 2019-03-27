package cn.itcast.test;

import oracle.jdbc.OracleTypes;
import org.junit.Test;

import java.sql.*;

public class OracleDemo {

    @Test
    public void test1() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.80.88:1521:orcl", "itheima", "itheima");

            CallableStatement cstmt = connection.prepareCall("{call p_updatesal(?,?)}");
            cstmt.setObject(1, 7788);
            cstmt.registerOutParameter(2, OracleTypes.NUMBER);
            cstmt.execute();
            System.out.println(cstmt.getObject(2));

            cstmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.80.88:1521:orcl", "itheima", "itheima");

        PreparedStatement pstmt = connection.prepareStatement("select * from emp where empno = ?");

        pstmt.setObject(1, 7788);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            String ename = rs.getString("ename");
            System.out.println(ename);
        }

        rs.close();
        pstmt.close();
        connection.close();
    }
}
