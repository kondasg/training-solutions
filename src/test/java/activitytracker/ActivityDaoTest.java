package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    private ActivityDao activityDao;

    private final List<TrackPoint> trackPoints1 = List.of(
            new TrackPoint(LocalDateTime.of(2021, 1, 1, 10, 10, 0), 47.497913, 19.040236),
            new TrackPoint(LocalDateTime.of(2021, 1, 1, 10, 10, 1), 47.497912, 19.040232),
            new TrackPoint(LocalDateTime.of(2021, 1, 1, 10, 10, 2), 47.497913, 19.040236),
            new TrackPoint(LocalDateTime.of(2021, 1, 1, 10, 10, 3), 47.497913, 19.040236)
    );

    private final List<TrackPoint> trackPoints2 = List.of(
            new TrackPoint(LocalDateTime.of(2021, 1, 2, 11, 0, 0), 47.497913, 19.040236),
            new TrackPoint(LocalDateTime.of(2021, 1, 2, 11, 0, 1), 47.497912, 19.040232),
            new TrackPoint(LocalDateTime.of(2021, 1, 2, 11, 0, 2), 47.497913, 19.040236),
            new TrackPoint(LocalDateTime.of(2021, 1, 2, 11, 0, 3), 97.497913, 19.040236)
    );

    private final Activity activity1 = new Activity(
            LocalDateTime.of(2021, 1, 1, 10, 10), "abcd", ActivityType.BIKING, trackPoints1);
    private final Activity activity2 = new Activity(
            LocalDateTime.of(2021, 1, 2, 11, 0), "xyz", ActivityType.HIKING, trackPoints2);

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
        assertEquals(4, activity.getTrackPoints().size());
    }

    @Test
    void saveActivityWithoutTrackPoints() {
        activityDao.saveActivity(activity1);
        activityDao.saveActivity(activity2);
        Activity activity = activityDao.findActivityById(2);
        assertEquals("xyz", activity.getDesc());
        assertEquals(0, activity.getTrackPoints().size());
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

    @Test
    void getInsertId() {
        assertEquals(1, activityDao.saveActivity(activity1));
    }

    @Test
    void saveImageToActivity() {
        String fname = "mountain-bike.png";
        byte[] imageBytes;
        try {
            imageBytes = Files.readAllBytes(Path.of("src/test/resources/activitytracker/" + fname));
            Image image = new Image(fname, imageBytes);
            activityDao.saveImageToActivity(1, image);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read: " + fname, ioe);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (InputStream is = activityDao.loadImageToActivity(1, fname)) {
            is.transferTo(baos);
        } catch (IOException ioe) {
            throw new IllegalStateException("", ioe);
        }

        assertEquals(baos.size(), imageBytes.length);
    }
}