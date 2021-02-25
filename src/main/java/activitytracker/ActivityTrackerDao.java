package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
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

    public Activity selectActivityById(int id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement("SELECT * FROM activities WHERE id = ?")) {
            stmt.setInt(1, id);
            return getActivity(stmt);
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can't SELECT'", se);
        }
    }

    private Activity getActivity(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new Activity(rs.getInt(1), rs.getTimestamp(2).toLocalDateTime(),
                        rs.getString(3), ActivityType.valueOf(rs.getString(4)));
            }
            throw new IllegalStateException("Can't find ID");
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by SELECT", sqle);
        }
    }

    public List<Activity> selectActivities() {
        try (Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM activities")) {
            List<Activity> activities = new ArrayList<>();
            while (rs.next()) {
                Activity activity = new Activity(
                        rs.getInt(1),
                        rs.getTimestamp(2).toLocalDateTime(),
                        rs.getString(3),
                        ActivityType.valueOf(rs.getString(4))
                );
                activities.add(activity);
            }
            return activities;
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can't SELECT'", se);
        }
    }
}
