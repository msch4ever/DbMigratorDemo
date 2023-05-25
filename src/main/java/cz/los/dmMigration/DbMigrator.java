package cz.los.dmMigration;

import cz.los.dmMigration.config.DbConfig;
import cz.los.dmMigration.config.DbConfigReader;
import cz.los.dmMigration.dal.CountryDao;
import cz.los.dmMigration.model.Country;
import cz.los.dmMigration.service.Service;

import java.util.List;

/**
 * This is an entry point of the program
 */
public class DbMigrator {

    private final Service service;

    public DbMigrator(Service service) {
        this.service = service;
    }

    public static void main(String[] args) {
        DbConfig read = DbConfigReader.readConfig("read");
        System.out.println(read);
        DbConfig write = DbConfigReader.readConfig("write");
        System.out.println(write);

        DbMigrator dbMigrator = new DbMigrator(new Service(new CountryDao(read, write)));
        dbMigrator.run();
    }

    private void run() {
        System.out.println("Starting DB migration...");
        List<Country> countries = service.readCountries();
        System.out.println("Countries fetched from source...");
        System.out.println("Moving data to destination...");
        service.saveCountries(countries);
        System.out.println("Data moved to the destination successfully...");
    }

}
