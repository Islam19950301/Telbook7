import java.util.Objects;

public class Education extends PersonalInfo {

    private String level;
    private String institution;
    private Country country;
    private String city;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) throws OperationException {

        String validInputFormat = "[A-Z][a-z]+";

        if (level.matches(validInputFormat)) {
            this.level = level;
        } else {
            throw new OperationException("Incorrect input format, should be " + validInputFormat);
        }
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) throws OperationException {

        final String validInstitutionFormat = "[a-zA-Z-0-9 ]*";

        if (city.matches(validInstitutionFormat)) {
            this.institution = institution;
        } else {
            throw new OperationException("Incorrect input format, should be " + validInstitutionFormat);
        }
    }

    public Country getCountry() {
        return country;
    }


    public void setCountry(String countryName) throws OperationException {

        Country country = CountriesDictionary.getCountryByName(countryName);

        if (Objects.nonNull(country)) {
            this.country = country;
        } else {
            throw new OperationException("No such country found " + countryName);
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws OperationException {

        final String validCityFormat = "[a-zA-Z- ]*";

        if (city.matches(validCityFormat)) {
            this.city = city;
        } else {
            throw new OperationException("Incorrect input format, should be " + validCityFormat);
        }
    }

    @Override
    public String getPersonInfoAsString() {
        return"Education: " + city + " " + institution + " " + level + " " + "from /" + country.getContactAsString();
    }

}
