package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Installer {

    public void install(String folders) {
        Path path = Path.of(folders);
        if (!Files.exists(path) || !Files.isDirectory(path)) {
            throw new IllegalArgumentException("The given directory doesn't exist");
        }
        String installFile = "/install/install.txt";
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(Installer.class.getResourceAsStream(installFile)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.endsWith("/")) {
                    Files.createDirectories(path.resolve(line));
                } else {
                    Files.copy(Installer.class.getResourceAsStream("/install/" + line),
                            path.resolve(line), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read " + installFile + " file", e);
        }
    }
}
