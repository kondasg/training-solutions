package jdbc;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

// CREATE TABLE trans (id INT AUTO_INCREMENT, NAME VARCHAR(10), PRIMARY KEY(id));
// SSH tunelen csatlokozom MariaDB serverhez

public class TransactionTest {

    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3307/csxxdg_t360?useUnicode=true");
            dataSource.setUser("csxxdg_t360");
            dataSource.setPassword("sWRAiZGCTAGY");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect", se);
        }

        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement()) {

            statement.executeUpdate("TRUNCATE TABLE trans");

        } catch (SQLException se) {
            throw new IllegalStateException("Can not TRUNCATE", se);
        }

        List<String> names = List.of("Jack", "Joe", "Jane");
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement statement =
                         conn.prepareStatement("INSERT INTO trans (name) VALUES (?)")) {
                for (String name : names) {
                    if (name.contains("n")) {
                        throw new IllegalArgumentException("Invalid name");
                    }
                    statement.setString(1, name);
                    statement.execute();
                }
                conn.commit();
            } catch (IllegalArgumentException iae) {
                conn.rollback();
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Can not INSERT", se);
        }
    }
}
