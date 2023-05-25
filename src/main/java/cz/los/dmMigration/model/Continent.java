package cz.los.dmMigration.model;

import java.util.Arrays;

public enum Continent {
    
    ASIA("Asia"),
    EUROPE("Europe"),
    N_AM("North America"),
    AFRICA("Africa"),
    OCEANIA("Oceania"),
    ANTARCTICA("Antarctica"),
    S_AM("South America"),
    N_A("N/A");
    
    public final String value;

    Continent(String value) {
        this.value = value;
    }

    public static Continent findByValue(String string) {
        return Arrays.stream(values()).filter(it -> it.value.equals(string)).findFirst().orElse(N_A);
    }
}
