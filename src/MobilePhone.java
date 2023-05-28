import java.util.Objects;

public class MobilePhone extends Contact {

    private String countryCode; //+7, +0, +1...
    private String msisdn;
    Country country;//7015657645

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryPhoneCode) throws OperationException {

        Country country = CountriesDictionary.getCountryByPhoneCode(countryPhoneCode);

        if (Objects.nonNull(country)) {
            this.country = country;
        } else {
            throw new OperationException("Either no such phone code or database contains no code for that country");
        }
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) throws OperationException {

        final String validInputFormat = "[0-9]{10}";

        if (msisdn.matches(validInputFormat)) {
            this.msisdn = msisdn;
        } else {
            throw new OperationException("msisdn format is incorrect should be" + validInputFormat);
        }
    }

    @Override
    public String getContactAsString() {
        return "MobileFone: " + getMsisdn() + " " + country.getContactAsString();
    }
}
