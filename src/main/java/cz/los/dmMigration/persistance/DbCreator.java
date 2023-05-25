package cz.los.dmMigration.persistance;

import cz.los.dmMigration.config.DbConfig;

import javax.sql.RowSet;
import javax.sql.rowset.RowSetFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * This is not actually used, but might be needed in future (YAGNI)
 */
public final class DbCreator {

    private DbCreator() {
    }

    public static void createWriteDb(DbConfig dbConfig) {
        try {
            String countryScript = Files.readString(Path.of("C:\\DEVELOPMENT\\REPO\\DbMigrator\\src\\main\\resources\\scripts\\country.sql"));
            String cityScript = Files.readString(Path.of("C:\\DEVELOPMENT\\REPO\\DbMigrator\\src\\main\\resources\\scripts\\city.sql"));
            String languageScript = Files.readString(Path.of("C:\\DEVELOPMENT\\REPO\\DbMigrator\\src\\main\\resources\\scripts\\countrylanguage.sql"));
            Connection con = DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUser(), dbConfig.getPassword());
            Statement statement = con.createStatement();
            statement.execute(countryScript);
            statement.execute(cityScript);
            statement.execute(languageScript);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
