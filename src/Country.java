public class Country extends Contact {

    private final String name;
    private final String alpha2Code;
    private final String alpha3Code;
    private final String unitedNationsCode;
    private final String phoneCode;

    public Country(String phoneCode, String name, String alpha2Code, String alpha3Code, String unitedNationsCode) {
        this.unitedNationsCode = unitedNationsCode;
        this.alpha3Code = alpha3Code;
        this.alpha2Code = alpha2Code;
        this.name = name;
        this.phoneCode = phoneCode;
    }

    public String getName() {
        return name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public String getUnitedNationsCode() {
        return unitedNationsCode;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    @Override
    public String getContactAsString(){
        return "Country: " + name + " " + alpha2Code + " " + alpha3Code + " " + unitedNationsCode  + " " + phoneCode + "\n";
    }
}
