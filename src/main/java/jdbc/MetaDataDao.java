package jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetaDataDao {

    private final DataSource dataSource;

    public MetaDataDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getTableName() {
        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            return getTableNamesByMetaData(databaseMetaData);

        } catch (SQLException se) {
            throw new IllegalArgumentException("Can't connect", se);
        }
    }

    private List<String> getTableNamesByMetaData(DatabaseMetaData databaseMetaData) throws SQLException {
        try (ResultSet rs =
                     databaseMetaData.getTables(null, null, null, null)) {
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString(3);
                names.add(name);
            }
            return names;
        }
    }
}
