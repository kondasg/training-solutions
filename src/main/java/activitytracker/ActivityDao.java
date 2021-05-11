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

            int insertId = executeAndGetGeneratedKey(stmt);

            // TrackPoint t; //

            try (Connection conn2 = dataSource.getConnection()) {
                conn2.setAutoCommit(false);
                try (PreparedStatement stmt2 = conn2.prepareStatement(
                        "INSERT INTO `track_point` (`activities_id`, `time`, `lat`, `lon`) VALUES (?, ?, ?, ?)")) {
                    for (TrackPoint trackPoint : activity.getTrackPoints()) {
                        if (trackPoint.getLat() > 90 || trackPoint.getLat() < -90
                                || trackPoint.getLon() > 180 || trackPoint.getLon() < -180) {
                            throw new IllegalArgumentException();
                        }
                        stmt2.setInt(1, insertId);
                        stmt2.setTimestamp(2, Timestamp.valueOf(trackPoint.getTime()));
                        stmt2.setDouble(3, trackPoint.getLat());
                        stmt2.setDouble(4, trackPoint.getLon());
                        stmt2.executeUpdate();
                    }
                    conn2.commit();
                } catch (IllegalArgumentException iae) {
                    conn2.rollback();
                    System.out.println("Invalid lat/lon");
                }

            } catch (SQLException se) {
                throw new IllegalStateException("Can't INSERT track_point", se);
            }

            //

            return insertId;
        } catch (SQLException se) {
            throw new IllegalStateException("Can't INSERT activities", se);
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
            throw new IllegalArgumentException("Error by INSERT activities ID", se);
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
            throw new IllegalStateException("Can't SELECT activities'", se);
        }
    }

    private Activity getActivity(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                int activitiesId = rs.getInt("id");
                return new Activity(
                        activitiesId,
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        ActivityType.valueOf(rs.getString("activity_type")),
                        getTrackPoints(activitiesId));
            }
            throw new IllegalArgumentException("Can't find ID");
        } catch (SQLException se) {
            throw new IllegalArgumentException("Error by SELECT activities", se);
        }
    }

    private List<TrackPoint> getTrackPoints(int activityId) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(
                             "SELECT `id`, `activities_id`, `time`, `lat`, `lon` " +
                                     "FROM `track_point` WHERE `activities_id` = ?")) {
            stmt.setInt(1, activityId);
            return fillTrackPoints(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Can't SELECT track_point'", se);
        }
    }

    private List<TrackPoint> fillTrackPoints(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            List<TrackPoint> trackPoints = new ArrayList<>();
            while (rs.next()) {
                trackPoints.add(new TrackPoint(
                        rs.getInt("id"),
                        rs.getTimestamp("time").toLocalDateTime(),
                        rs.getDouble("lat"),
                        rs.getDouble("lon")));
            }
            return trackPoints;
        } catch (SQLException se) {
            throw new IllegalArgumentException("Error by SELECT track_point", se);
        }
    }

    public List<Activity> listActivities() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT `id`, `start_time`, `activity_desc`, `activity_type` FROM `activities`")) {
            List<Activity> activities = new ArrayList<>();
            while (rs.next()) {
                int activitiesId = rs.getInt("id");
                Activity activity = new Activity(
                        activitiesId,
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        ActivityType.valueOf(rs.getString("activity_type")),
                        getTrackPoints(activitiesId));
                activities.add(activity);
            }
            return activities;
        } catch (SQLException se) {
            throw new IllegalStateException("Can't SELECT activities", se);
        }
    }
}
