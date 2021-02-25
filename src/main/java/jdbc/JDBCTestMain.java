package jdbc;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

public class JDBCTestMain {

    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3307/csxxdg_t360?useUnicode=true");
            dataSource.setUser("csxxdg_t360");
            dataSource.setPassword("sWRAiZGCTAGY");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect", se);
        }

        JDBCTestDao jdbcTestDao = new JDBCTestDao(dataSource);
        jdbcTestDao.create("JancsÉsJuliska", 1234);

        List<String> names = jdbcTestDao.list();
        System.out.println(names);

        String name = jdbcTestDao.find(4);
        System.out.println(name);
    }
}
