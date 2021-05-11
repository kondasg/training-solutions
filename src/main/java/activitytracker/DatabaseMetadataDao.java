package activitytracker;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMetadataDao {

    private final DataSource dataSource;

    public DatabaseMetadataDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getColumnsForTable(String table) {
        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            return getCols(databaseMetaData, table);
        } catch (SQLException se) {
            throw new IllegalArgumentException("Can't connect", se);
        }

    }

    private List<String> getCols(DatabaseMetaData databaseMetaData, String table) throws SQLException {
        try (ResultSet rs = databaseMetaData.getColumns(null, null, table, null)) {
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString(4);
                names.add(name);
            }
            return names;
        }
    }
}
