package cz.los.dmMigration.model;

public class CountryLanguage {

    private String countryCode;
    private String language;
    private boolean official;
    private String percentage;

    public String getCountryCode() {
        return countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isOfficial() {
        return official;
    }

    public String getPercentage() {
        return percentage;
    }
}
