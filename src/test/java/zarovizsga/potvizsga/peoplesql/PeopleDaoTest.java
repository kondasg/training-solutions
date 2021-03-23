package zarovizsga.potvizsga.peoplesql;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;
import zarovizsga.potvizsga.peoplesql.PeopleDao;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PeopleDaoTest {

    private PeopleDao peopleDao;

    @BeforeEach
    void init() throws SQLException {
        MariaDbDataSource dataSource;
        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3307/csxxdg_t360?useUnicode=true");
        dataSource.setUser("csxxdg_t360");
        dataSource.setPassword("sWRAiZGCTAGY");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

        peopleDao = new PeopleDao(dataSource);
    }


    @Test
    void findIpByName() {
        assertEquals("134.135.61.66", peopleDao.findIpByName("Brina", "Snibson"));
        assertEquals("97.203.249.128", peopleDao.findIpByName("Torrence", "Porteous"));
    }
}