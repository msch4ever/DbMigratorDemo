package cz.los.dmMigration;

import cz.los.dmMigration.config.DbConfig;
import cz.los.dmMigration.config.DbConfigReader;
import cz.los.dmMigration.dal.CountryDao;
import cz.los.dmMigration.model.Country;
import cz.los.dmMigration.persistance.DbCreator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class SandBox {

    public static void main(String[] args) throws Exception {

        DbConfig read = DbConfigReader.readConfig("read");
        System.out.println(read);

        DbConfig write = DbConfigReader.readConfig("write");
        System.out.println(write);

        CountryDao dao = new CountryDao(read, write);

        List<Country> result = dao.read();

        dao.write(result.get(0));
        //result.forEach(System.out::println);

    }
}
