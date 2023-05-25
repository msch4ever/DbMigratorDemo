package cz.los.dmMigration.dal;

import cz.los.dmMigration.config.DbConfig;
import cz.los.dmMigration.model.City;

import java.util.List;

public class CityDao extends AbstractDao {

    public CityDao(DbConfig readConfig, DbConfig writeConfig) {
        super(readConfig, writeConfig);
    }

    public List<City> read() {
        return null;
    }

    public void write(City city) {

    }

}
