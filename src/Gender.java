import java.io.FileOutputStream;
import java.io.IOException;

public class Gender extends PersonalInfo {

    private String type; //w, m

    private final String MALE = "m";
    private final String FEMALE = "f";

    public String getType() {
        return type;
    }

    public void setType(String type) throws OperationException {

        if (type.equalsIgnoreCase(MALE) || type.equalsIgnoreCase(FEMALE)) {
            this.type = type;

        } else {
            throw new OperationException("Incorrect input, should be either " + MALE + " or " + FEMALE);
        }

    }

    @Override
    public String getPersonInfoAsString() {
        return "Gender: " + type + "\n";
    }
}
