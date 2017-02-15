package org.lion;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() throws PropertyVetoException, ClassNotFoundException, SQLException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
        Connection conn = cpds.getConnection();
        Assert.assertNotNull(conn);
        PreparedStatement st = conn.prepareStatement("INSERT INTO user VALUES (NULL ,?,?,NULL,NULL )");
        st.setString(1, "lion" + System.currentTimeMillis());
        st.setInt(2, 10);
        int ret = st.executeUpdate();
        Assert.assertNotEquals(ret,0);
        st.close();
        conn.close();
    }

}
