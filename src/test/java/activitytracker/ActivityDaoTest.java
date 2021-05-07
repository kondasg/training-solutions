package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    private ActivityDao activityDao;
    private final Activity activity1 = new Activity(
            LocalDateTime.of(2021, 1, 1, 10, 10), "abcd", ActivityType.BIKING);
    private final Activity activity2 = new Activity(
            LocalDateTime.of(2021, 1, 2, 11, 0), "xyz", ActivityType.HIKING);

    @BeforeEach
    void init() throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3307/csxxdg_t360?useUnicode=true");
        dataSource.setUser("csxxdg_t360");
        dataSource.setPassword("sWRAiZGCTAGY");

        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("filesystem:src/test/resources/activitytracker/")
                .load();

        flyway.clean();
        flyway.migrate();

        activityDao = new ActivityDao(dataSource);
    }

    @Test
    void saveActivity() {
        activityDao.saveActivity(activity1);
        Activity activity = activityDao.findActivityById(1);
        assertEquals("abcd", activity.getDesc());
    }

    @Test
    void findActivityById() {
        activityDao.saveActivity(activity1);
        activityDao.saveActivity(activity2);
        Activity activity = activityDao.findActivityById(2);
        assertEquals("xyz", activity.getDesc());
    }

    @Test
    void listActivities() {
        activityDao.saveActivity(activity1);
        activityDao.saveActivity(activity2);
        List<Activity> activities = activityDao.listActivities();
        assertEquals(2, activities.size());
        assertEquals(ActivityType.HIKING, activities.get(1).getType());
    }
}