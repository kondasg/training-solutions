package jdbc;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MetaDataDaoTest {

    private MetaDataDao metaDataDao;

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

        //flyway.clean();
        //flyway.migrate();

        metaDataDao = new MetaDataDao(dataSource);
    }

    @Test
    void testTableNames() {
        List<String> names = metaDataDao.getTableName();
        System.out.println(names);
    }


}