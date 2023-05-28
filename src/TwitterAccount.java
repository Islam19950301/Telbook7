public class TwitterAccount extends Contact {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws OperationException {

        final String validInpudtFormar = "[A-Z][a-z]+\\s[A-Z][a-z]+";
        if (username.matches(validInpudtFormar)) {
            this.username = username;
        } else {
            throw new OperationException("twitter user name  format is incorrect should be" + validInpudtFormar);
        }

    }

    @Override
    public String getContactAsString() {
        return "www.twitter.com/" + username + "\n";
    }
}
