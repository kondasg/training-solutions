package properties;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class JavaTools {

    private final Properties properties;

    public JavaTools() {
        try (InputStreamReader reader = new InputStreamReader(
                DatabaseConfiguration.class.getResourceAsStream("/javatools.properties"),
                StandardCharsets.UTF_8)) {
            properties = new Properties();
            properties.load(reader);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    public Set<String> getToolKeys() {
        Set<String> keys = properties.stringPropertyNames();
        Set<String> result = new HashSet<>();
        for (String key : keys) {
            result.add(key.substring(0, key.indexOf('.')));
        }
        return result;
    }

    public Set<String> getTools() {
        Set<String> result = new HashSet<>();
        for (String key : getToolKeys()) {
            result.add(getName(key));
        }
        return result;
    }

    public String getName(String name) {
        return properties.getProperty(name + ".name");
    }

    public String getUrl(String url) {
        return properties.getProperty(url + ".url");
    }

}
