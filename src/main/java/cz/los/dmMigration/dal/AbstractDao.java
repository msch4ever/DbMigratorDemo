package cz.los.dmMigration.dal;

import cz.los.dmMigration.config.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDao {

    final DbConfig readConfig;
    final DbConfig writeConfig;

    public AbstractDao(DbConfig readConfig, DbConfig writeConfig) {
        this.readConfig = readConfig;
        this.writeConfig = writeConfig;
    }

    public Connection createReadConnection() throws SQLException {
        return DriverManager.getConnection(readConfig.getUrl(), readConfig.getUser(), readConfig.getPassword());
    }

    public Connection createWriteConnection() throws SQLException {
        return DriverManager.getConnection(writeConfig.getUrl(), writeConfig.getUser(),writeConfig.getPassword());
    }

}
