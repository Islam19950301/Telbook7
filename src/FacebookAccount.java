public class FacebookAccount extends Contact {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws OperationException {

        final String validInputFormat = "[a-zA-Z0-9-_]*";

        if (username.matches(validInputFormat)) {
            this.username = username;
        } else {
            throw new OperationException("Not a valid format of username, should be " + validInputFormat);
        }
    }

    @Override
    public String getContactAsString() {
        return "www.facebook.com/people/" + username + "\n";
    }
}
