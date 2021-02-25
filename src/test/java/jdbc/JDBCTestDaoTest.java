package jdbc;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JDBCTestDaoTest {

    private JDBCTestDao jdbcTestDao;

    @BeforeEach
    void init() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3307/csxxdg_t360?useUnicode=true");
            dataSource.setUser("csxxdg_t360");
            dataSource.setPassword("sWRAiZGCTAGY");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect", se);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

        //flyway.clean(); //mert az AB táblákat nem akarom, hogy törölje
        //flyway.migrate();

        jdbcTestDao = new JDBCTestDao(dataSource);
    }

//    @Test // mivel nincs flyway.clean, ezért mindig +1 és hiba lenne
//    void testInsert() {
//        jdbcTestDao.create("Assert", 1);
//        assertEquals(13, jdbcTestDao.list().size());
//    }

    @Test
    void testById() {
        int autoId = jdbcTestDao.create("Kuka", 2);
        String name = jdbcTestDao.find(autoId);
        assertEquals("Kuka", name);
    }

//    @Test
//    void testCreates() {
//        jdbcTestDao.create(Arrays.asList("Jack Doe", "Jane Doe", "Joe Doe"));
//        assertEquals(16, jdbcTestDao.list().size());
//    }

    @Test
    void testRollback() {
        jdbcTestDao.create(Arrays.asList("Jack Doe", "xJane Doe", "Joe Doe"));
        assertEquals(0, jdbcTestDao.list().size());
    }

    @Test
    void testOdd() {
        assertEquals(5, jdbcTestDao.listOdd().size());
    }

    @Test
    void testUpdate() {
        jdbcTestDao.updateNames();
        System.out.println(jdbcTestDao.list());
    }
}