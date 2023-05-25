package cz.los.dmMigration.dal;

import cz.los.dmMigration.config.DbConfig;
import cz.los.dmMigration.model.Continent;
import cz.los.dmMigration.model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static cz.los.dmMigration.model.Country.*;

public class CountryDao extends AbstractDao {

    private static final String SELECT = "SELECT * FROM country;";
    private static final String INSERT = """
            INSERT INTO COUNTRY (
                CODE,
                NAME,
                CONTINENT,
                REGION,
                SURFACEAREA,
                INDEPYEAR,
                POPULATION,
                LIFEEXPECTANCY,
                GNP,
                GNPOLD,
                LOCALNAME,
                GOVERNMENTFORM,
                HEADOFSTATE,
                CAPITAL,
                CODE2
                )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
            """;


    public CountryDao(DbConfig readConfig, DbConfig writeConfig) {
        super(readConfig, writeConfig);
    }

    public List<Country> read() {
        System.out.println("Starting fetch of countries from source DB!");
        try(Connection connection = createReadConnection()) {
            PreparedStatement ps = connection.prepareStatement(SELECT);
            ResultSet rs = ps.executeQuery();
            List<Country> result = new ArrayList<>();

            while (rs.next()) {
                Country current = new Country(
                        rs.getString(CODE),
                        rs.getString(NAME),
                        Continent.findByValue(rs.getString(CONTINENT)),
                        rs.getString(REGION),
                        rs.getDouble(SURFACEAREA),
                        rs.getString(INDEPYEAR),
                        rs.getInt(POPULATION),
                        rs.getDouble(LIFEEXPECTANCY),
                        rs.getString(GNP),
                        rs.getString(GNPOLD),
                        rs.getString(LOCALNAME),
                        rs.getString(GOVERNMENTFORM),
                        rs.getString(HEADOFSTATE),
                        rs.getInt(CAPITAL),
                        rs.getString(CODE2)
                        );
                result.add(current);
            }
            System.out.printf("%s were fetched from source DB!" + System.lineSeparator(), result.size());
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("SNAFU");
        }
    }

    public void write(List<Country> countries) {
        try (Connection connection = createWriteConnection()) {
            PreparedStatement ps = connection.prepareStatement(INSERT);
            for (Country country : countries) {
                addToBatch(country, ps);
            }
            int[] rows = ps.executeBatch();
            if(rows.length == 0) {
                throw new SQLException("No country inserted!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("SNAFU");
        }
    }

    private void addToBatch(Country country, PreparedStatement ps) throws Exception {
            ps.setString(1, country.getCode());
            ps.setString(2, country.getName());
            ps.setString(3, country.getContinent().value);
            ps.setString(4, country.getRegion());
            ps.setDouble(5, country.getSurfaceArea());
            ps.setString(6, country.getIndepYear());
            ps.setInt(7, country.getPopulation());
            ps.setDouble(8, country.getLifeExpectancy());
            ps.setString(9, country.getGnp());
            ps.setString(10, country.getGnpOld());
            ps.setString(11, country.getLocalName());
            ps.setString(12, country.getGovernmentForm());
            ps.setString(13, country.getHeadOfState());
            ps.setInt(14, country.getCapital());
            ps.setString(15, country.getCode2());
            ps.addBatch();
    }

    public void write(Country country) {
        try (Connection connection = createWriteConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1, country.getCode());
            statement.setString(2, country.getName());
            statement.setString(3, country.getContinent().value);
            statement.setString(4, country.getRegion());
            statement.setDouble(5, country.getSurfaceArea());
            statement.setString(6, country.getIndepYear());
            statement.setInt(7, country.getPopulation());
            statement.setDouble(8, country.getLifeExpectancy());
            statement.setString(9, country.getGnp());
            statement.setString(10, country.getGnpOld());
            statement.setString(11, country.getLocalName());
            statement.setString(12, country.getGovernmentForm());
            statement.setString(13, country.getHeadOfState());
            statement.setInt(14, country.getCapital());
            statement.setString(15, country.getCode2());
            int rows = statement.executeUpdate();
            if(rows < 1) {
                throw new SQLException("No country inserted!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("SNAFU");
        }
    }

}
