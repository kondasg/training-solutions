package zarovizsga.potvizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private final DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement =
                     conn.prepareStatement("SELECT ip_address FROM people WHERE first_name LIKE ? AND last_name LIKE ?")) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);

            return getResult(statement);

        } catch (SQLException se) {
            throw new IllegalStateException("Can't prepared SELECT", se);
        }

    }

    private String getResult(PreparedStatement statement) {
        try (ResultSet rs = statement.executeQuery()) {
            if (rs.next()) {
                return rs.getString("ip_address");
            }
            return "No result";

        } catch (SQLException se) {
            throw new IllegalStateException("Can't prepared SELECT", se);
        }
    }
}
