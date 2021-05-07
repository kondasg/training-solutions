package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    private final DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int saveActivity(Activity activity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(
                             "INSERT INTO `activities` (`start_time`, `activity_desc`, `activity_type`) " +
                                     "VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();

            return executeAndGetGeneratedKey(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Can't INSERT", se);
        }
    }

    private int executeAndGetGeneratedKey(PreparedStatement stmt) {
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getInt("id");
            } else {
                throw new SQLException("No key has generated");
            }
        } catch (SQLException se) {
            throw new IllegalArgumentException("Error by INSERT", se);
        }
    }

    public Activity findActivityById(long id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(
                             "SELECT `id`, `start_time`, `activity_desc`, `activity_type` " +
                                     "FROM `activities` WHERE `id` = ?")) {
            stmt.setLong(1, id);
            return getActivity(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Can't SELECT'", se);
        }
    }

    private Activity getActivity(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new Activity(
                        rs.getInt("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        ActivityType.valueOf(rs.getString("activity_type")));
            }
            throw new IllegalArgumentException("Can't find ID");
        } catch (SQLException se) {
            throw new IllegalArgumentException("Error by SELECT", se);
        }
    }

    public List<Activity> listActivities() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT `id`, `start_time`, `activity_desc`, `activity_type` FROM `activities`")) {
            List<Activity> activities = new ArrayList<>();
            while (rs.next()) {
                Activity activity = new Activity(
                        rs.getInt("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        ActivityType.valueOf(rs.getString("activity_type"))
                );
                activities.add(activity);
            }
            return activities;
        } catch (SQLException se) {
            throw new IllegalStateException("Can't SELECT'", se);
        }
    }
}
