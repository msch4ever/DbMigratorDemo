package cz.los.dmMigration.service;

import cz.los.dmMigration.dal.CountryDao;
import cz.los.dmMigration.model.Country;

import java.util.List;

public class Service {

    private final CountryDao countryDao;

    public Service(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    public List<Country> readCountries() {
        return countryDao.read();
    }

    public void saveCountries(List<Country> countries) {
        System.out.printf("Saving %s countries in the destination DB!" + System.lineSeparator(), countries.size());
        countryDao.write(countries);
        /*for (Country country : countries) {
            countryDao.write(country);
        }*/
        System.out.println("Saving completed");
    }
}
