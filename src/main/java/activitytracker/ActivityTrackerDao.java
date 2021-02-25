package activitytracker;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class ActivityTrackerDao {

    private final DataSource dataSource;

    public ActivityTrackerDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void crateActivities(List<Activity> activities) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("INSERT INTO activities (start_time, activity_desc, activity_type) values (?, ?, ?)")) {
            for (Activity activity : activities) {
                stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
                stmt.setString(2, activity.getDesc());
                stmt.setString(3, activity.getType().toString());
                stmt.executeUpdate();
            }
        } catch (
                SQLException se) {
            throw new IllegalStateException("Can't insert", se);
        }
    }
}
