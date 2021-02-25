package jdbc;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

public class ImagesDao {

    private final DataSource dataSource;

    public ImagesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveImage(String filename, InputStream is) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO images (filename, content) VALUES (?, ?)")
        ) {
            ps.setString(1, filename);
            Blob blob = conn.createBlob();

            fillBlob(is, blob);

            ps.setBlob(2, blob);

            ps.executeUpdate();

        } catch (SQLException se) {
            throw new IllegalStateException("Can't connect", se);
        }

    }

    private void fillBlob(InputStream is, Blob blob) throws SQLException {
        try (OutputStream os = blob.setBinaryStream(1)) {
            is.transferTo(os);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write blob", ioe);
        }
    }

    public InputStream getImage(String name) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT content FROM images WHERE filename=?")) {
            ps.setString(1, name);
            return readInputStream(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Can't connect", se);
        }
    }

    private InputStream readInputStream(PreparedStatement ps) throws SQLException {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                Blob blob = rs.getBlob("content");
                return blob.getBinaryStream();
            }
            throw new IllegalStateException("Can't record");
        }
    }
}
