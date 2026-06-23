package utils;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties props = new Properties();
    static {
        try (InputStream is = Config.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            props.load(is);
        } catch (Exception e) {
            throw new RuntimeException("config.properties okunamadı", e);
        }
    }
    public static String get(String key) {
        return System.getProperty(key, props.getProperty(key));
    }
}