package jdbc;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ImagesDaoTest {

    private ImagesDao imagesDao;

    @BeforeEach
    void init() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3307/csxxdg_t360?useUnicode=true");
            dataSource.setUser("csxxdg_t360");
            dataSource.setPassword("sWRAiZGCTAGY");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect", se);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

        //flyway.clean(); //mert az AB táblákat nem akarom, hogy törölje
        //flyway.migrate();

        imagesDao = new ImagesDao(dataSource);
    }

    @Test
    void testSaveImage() {
        System.out.println("Start " + LocalDateTime.now());

        imagesDao.saveImage("programozasi-nyelv-informatika.png", ImagesDao.class.getResourceAsStream("/programozasi-nyelv-informatika.png"));

        System.out.println("Up stop " + LocalDateTime.now());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (InputStream is = imagesDao.getImage("programozasi-nyelv-informatika.png")) {
            is.transferTo(baos);
        } catch (IOException e) {
            throw new IllegalStateException("", e);
        }
        System.out.println("Stop " + LocalDateTime.now());

        assertTrue( baos.size() > 1_000_000);

        System.out.println("StopStop " + LocalDateTime.now());
    }
}