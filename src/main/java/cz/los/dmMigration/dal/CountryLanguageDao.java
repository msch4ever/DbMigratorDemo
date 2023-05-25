package cz.los.dmMigration.dal;

import cz.los.dmMigration.config.DbConfig;
import cz.los.dmMigration.model.CountryLanguage;

import java.util.List;

public class CountryLanguageDao extends AbstractDao {

    public CountryLanguageDao(DbConfig readConfig, DbConfig writeConfig) {
        super(readConfig, writeConfig);
    }

    public List<CountryLanguage> read() {
        return null;
    }

    public void write(CountryLanguage countryLanguage) {

    }

}
