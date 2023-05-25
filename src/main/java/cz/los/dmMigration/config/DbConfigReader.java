package cz.los.dmMigration.config;

import java.io.FileInputStream;
import java.util.Properties;

public final class DbConfigReader {

    private static final String DATASOURCE_CONFIG_FILE = "C:\\DEVELOPMENT\\REPO\\DbMigrator\\src\\main\\resources\\db.config.properties";
    private static String URL = "datasource.%s.url";
    private static String USER = "datasource.%s.user";
    private static String PASSWORD = "datasource.%s.password";

    private DbConfigReader() {
    }

    /**
     * Creates {@link DbConfig}  based on data source argument provided
     * @param ds - datasource type. Either 'read' or 'write'
     * @return new  DbConfig
     */
    public static DbConfig readConfig(String ds) {
        try(FileInputStream is = new FileInputStream(DATASOURCE_CONFIG_FILE)) {
            Properties properties = new Properties();
            properties.load(is);
            String url = properties.getProperty(String.format(URL, ds));
            String user = properties.getProperty(String.format(USER, ds));
            String password = properties.getProperty(String.format(PASSWORD, ds));

            return new DbConfig(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("SNAFU");
        }
    }
}
