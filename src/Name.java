public class Name extends PersonalInfo {

    private String firstname;
    private String surname;
    private String paternal;
    private String maternal;
    private String prefix; //Mr, Mrs, Bey, Aga, Professor

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) throws OperationException {

        final String validInpudFormat = "[A-Z][a-z]+";

        if (firstname.matches(validInpudFormat)) {
            this.firstname = firstname;

        } else {
            throw new OperationException("name  format is incorrect should be" + validInpudFormat);
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws OperationException {

        final String validInputFormat = "[A-Z][a-z]+";

        if (surname.matches(validInputFormat)) {
            this.surname = surname;

        } else {
            throw new OperationException("surname format is incorrect should be" + validInputFormat);
        }
    }

    public String getPaternal() {
        return paternal;
    }

    public void setPaternal(String paternal) throws OperationException {

        final String validInpudFormat = "[A-Z][a-z]+";

        if (paternal.matches(validInpudFormat)) {
            this.paternal = paternal;

        } else {
            throw new OperationException("paternal format is incorrect shold be" + validInpudFormat);
        }

    }

    public String getMaternal() {
        return maternal;
    }

    public void setMaternal(String maternal) throws OperationException {

        final String valisInpudFormat = "[A-Z][a-z]+";

        if (maternal.matches(valisInpudFormat)) {
            this.maternal = maternal;

        } else {
            throw new OperationException("maternal format is incorrect should be" + valisInpudFormat);
        }
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) throws OperationException {

        final String validInpudFormat = "[A-Z][a-z]+";

        if (prefix.matches(validInpudFormat)) {
            this.prefix = prefix;

        } else {
            throw new OperationException("prefix format  is incorrect should be" + validInpudFormat);
        }
    }

    @Override
    public String getPersonInfoAsString() {
        return "Name: " + firstname + " " + surname + " " + paternal + " " + maternal + " " + prefix  + "\n";
    }
}
