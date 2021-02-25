package jdbc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JDBCTestDao {

    private final DataSource dataSource;

    public JDBCTestDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int create(String name, int price) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement =
                     conn.prepareStatement("INSERT INTO pizza (pizza_name, pizza_price) VALUES (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, name);
            statement.setFloat(2, price);
            statement.executeUpdate();

            return getIdByStatement(statement);

        } catch (SQLException se) {
            throw new IllegalStateException("Can not INSERT", se);
        }
    }

    public void create(List<String> names) { // Tranzakciókezelés
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement statement =
                         conn.prepareStatement("INSERT INTO pizza (pizza_name, pizza_price) VALUES (?, 1)")) {
                for (String name : names) {
                    if (name.startsWith("x")) {
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

    private int getIdByStatement(PreparedStatement statement) {
        try (ResultSet rs = statement.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
            throw new IllegalStateException("Can't ID");
        } catch (SQLException se) {
            throw new IllegalStateException("Can't ID", se);
        }
    }

    public List<String> list() {
        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery("SELECT pizza_name FROM pizza")) {

            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("pizza_name");
                names.add(name);
            }
            return names;
        } catch (SQLException se) {
            throw new IllegalStateException("Can not SELECT", se);
        }
    }

    public List<String> listOdd() { // Haladó ResultSet
        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = statement.executeQuery("SELECT pizza_name FROM pizza ORDER BY pizza_name")) {
            if (!rs.next()) {
                return Collections.emptyList();
            }
            List<String> names = new ArrayList<>();
            names.add(rs.getString("pizza_name"));
            while (rs.relative(2)) {
                names.add(rs.getString("pizza_name"));
            }
            return names;
        } catch (SQLException se) {
            throw new IllegalStateException("Can't connect", se);
        }
    }

    public void updateNames() { // Haladó ResultSet
        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = statement.executeQuery("SELECT * FROM pizza")) {
            while (rs.next()) {
                String name = rs.getString("pizza_name");
                if (name.contains("a")) {
                    rs.updateString("pizza_name", "Mr. " + name);
                    rs.updateRow();
                }
            }
        } catch (SQLException se) {
            throw new IllegalStateException("", se);
        }
    }

    public String find(int id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT pizza_name FROM pizza WHERE pizza_id = ?")) {
            statement.setInt(1, id);

            return preparedSelect(statement);

        } catch (SQLException se) {
            throw new IllegalStateException("Can not prepared SELECT", se);
        }
    }

    private String preparedSelect(PreparedStatement statement) {
        try (ResultSet rs = statement.executeQuery()) {
            if (rs.next()) {
                return rs.getString("pizza_name");
            }
            throw new IllegalArgumentException("Not found");
        } catch (SQLException se) {
            throw new IllegalStateException("", se);
        }
    }
}
