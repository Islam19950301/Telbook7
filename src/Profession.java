public class Profession extends PersonalInfo {

    private String professionGroup; //medical
    private String professionName; //dentist

    public String getProfessionGroup() {
        return professionGroup;
    }

    public void setProfessionGroup(String professionGroup) throws OperationException {

        final String validFormat = "[a-zA-Z- ]*";

        if (professionGroup.matches(validFormat)) {
            this.professionGroup = professionGroup;
        } else {
            throw new OperationException("Not a valid profession group format, should be " + validFormat);
        }
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) throws OperationException {

        final String validFormat = "[a-zA-Z0-9- ]*";

        if (professionName.matches(validFormat)) {
            this.professionName = professionName;
        } else {
            throw new OperationException("Incorrect format of input data, should be " + validFormat);
        }
    }

    @Override
    public String getPersonInfoAsString() {
        return "Profession: " + professionName + " " + professionGroup + " " + "\n";
    }
}
