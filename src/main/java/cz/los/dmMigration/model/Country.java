package cz.los.dmMigration.model;

public class Country {

    public static final String CODE = "code";
    public static final String NAME = "name";
    public static final String CONTINENT = "continent";
    public static final String REGION = "region";
    public static final String SURFACEAREA = "surfaceArea";
    public static final String INDEPYEAR = "indepYear";
    public static final String POPULATION = "population";
    public static final String LIFEEXPECTANCY = "lifeExpectancy";
    public static final String GNP = "gnp";
    public static final String GNPOLD = "gnpOld";
    public static final String LOCALNAME = "localName";
    public static final String GOVERNMENTFORM = "governmentForm";
    public static final String HEADOFSTATE = "headOfState";
    public static final String CAPITAL = "capital";
    public static final String CODE2 = "code2";

    private String code;
    private String name;
    private Continent continent;
    private String region;
    private double surfaceArea;
    private String indepYear;
    private int population;
    private double lifeExpectancy;
    private String gnp;
    private String gnpOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    //private City capital;
    private int capital;
    private String code2;

    public Country(String code, String name, Continent continent, String region, double surfaceArea, String indepYear,
                   int population, double lifeExpectancy, String gnp, String gnpOld, String localName,
                   String governmentForm, String headOfState, int capital/*City capital*/, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.gnp = gnp;
        this.gnpOld = gnpOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.capital = capital;
        this.code2 = code2;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Continent getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public String getIndepYear() {
        return indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public String getGnp() {
        return gnp;
    }

    public String getGnpOld() {
        return gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public int getCapital() {
        return capital;
    }

    public String getCode2() {
        return code2;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent=" + continent +
                ", region='" + region + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", indepYear='" + indepYear + '\'' +
                ", population=" + population +
                ", lifeExpectancy=" + lifeExpectancy +
                ", gnp='" + gnp + '\'' +
                ", gnpOld='" + gnpOld + '\'' +
                ", localName='" + localName + '\'' +
                ", governmentForm='" + governmentForm + '\'' +
                ", headOfState='" + headOfState + '\'' +
                ", capital=" + capital +
                ", code2='" + code2 + '\'' +
                '}';
    }

}
