package zarovizsga.potpotvizsga.housecup;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseCup {

    private final DataSource dataSource;

    public HouseCup(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int getPointsOfHouse(String part) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement =
                     conn.prepareStatement("SELECT SUM(points_earned) AS pts FROM house_points WHERE house_name LIKE ?")) {
            statement.setString(1, part);

            return getResult(statement);

        } catch (SQLException se) {
            throw new IllegalStateException("Can't prepared SELECT", se);
        }
    }

    private int getResult(PreparedStatement statement) {
        try (ResultSet rs = statement.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("pts");
            }
            return 0;

        } catch (SQLException se) {
            throw new IllegalStateException("Can't prepared SELECT", se);
        }
    }
}
