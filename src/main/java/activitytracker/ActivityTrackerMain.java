package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {

    private final static List<Activity> activities = new ArrayList<>();

    static {
        Activity activity1 = new Activity(LocalDateTime.of(2021, 1, 1, 12, 10), "Miskolc - Ómassa", ActivityType.BIKING, null);
        Activity activity2 = new Activity(LocalDateTime.of(2021, 1, 4, 9, 0), "Miskolc-Felsőmajláth", ActivityType.HIKING, null);
        Activity activity3 = new Activity(LocalDateTime.of(2021, 1, 11, 19, 30), "DVTK", ActivityType.BASKETBALL, null);
        Activity activity4 = new Activity(LocalDateTime.of(2021, 1, 20, 8, 50), "Miskolc - Bükkszentkerszt", ActivityType.BIKING, null);

        activities.add(activity1);
        activities.add(activity2);
        activities.add(activity3);
        activities.add(activity4);
    }

    public static void main(String[] args) {

        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3307/csxxdg_t360?useUnicode=true");
            dataSource.setUser("csxxdg_t360");
            dataSource.setPassword("sWRAiZGCTAGY");
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }

        ActivityTrackerDao acDao = new ActivityTrackerDao(dataSource);

        acDao.crateActivities(activities);
        System.out.println(acDao.selectActivityById(3));
        System.out.println(acDao.selectActivities());
    }
}
