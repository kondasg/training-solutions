package jdbc;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {

    private DataSource connectDb() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3307/csxxdg_t360?useUnicode=true");
            dataSource.setUser("csxxdg_t360");
            dataSource.setPassword("sWRAiZGCTAGY");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect", se);
        }
        return dataSource;
    }

    private void insertDb(DataSource dataSource) {
        try (Connection conn = dataSource.getConnection();
//             Statement statement = conn.createStatement();
             PreparedStatement statement = conn.prepareStatement("INSERT INTO pizza (pizza_name, pizza_price) VALUES (?, ?)")) {

//            statement.executeUpdate("INSERT INTO pizza VALUES (NULL, 'John Doe', 10001)");
            statement.setString(1, "pizzaX");
            statement.setFloat(2, 10002);
            statement.executeUpdate();

        } catch (SQLException se) {
            throw new IllegalStateException("Can not INSERT", se);
        }
    }

    private void selectDb(DataSource dataSource) {
        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery("SELECT pizza_name FROM pizza")) {

            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("pizza_name");
                names.add(name);
            }
            System.out.println(names);
        } catch (SQLException se) {
            throw new IllegalStateException("Can not SELECT", se);
        }
    }

    private void preparedSelectDb(DataSource dataSource, int id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT pizza_name FROM pizza WHERE pizza_id = ?")) {
            statement.setInt(1, id);

            preparedSelect(statement);

        } catch (SQLException se) {
            throw new IllegalStateException("Can not prepared SELECT", se);
        }
    }

    private void preparedSelect(PreparedStatement statement) {
        try (ResultSet rs = statement.executeQuery()) {
            if (rs.next()) {
                String name = rs.getString("pizza_name");
                System.out.println(name);
            }
            throw new IllegalArgumentException("Not found");
        } catch (SQLException se) {
            throw new IllegalStateException("", se);
        }
    }

    public static void main(String[] args) {
        JDBCTest jdbcTest = new JDBCTest();
        DataSource dataSource = jdbcTest.connectDb();

        jdbcTest.insertDb(dataSource);
        jdbcTest.selectDb(dataSource);
        jdbcTest.preparedSelectDb(dataSource, 6);

    }
}
