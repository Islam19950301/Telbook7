public class Email extends Contact {

    private String username; //maxim.semenov
    private String mailProvider; //gmail.com

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws OperationException {

        final String validInpudFormat =  "[a-z]+[_]*[.]*[a-z]*";

        if (username.matches(validInpudFormat)){
            this.username = username;
        } else {
            throw new OperationException("mail User name format is incorrect should be" + validInpudFormat);
        }
    }

    public String getMailProvider() {
        return mailProvider;
    }

    public void setMailProvider(String mailProvider) throws OperationException {

        final String validInputFormat = "[a-zA-Z0-9-_]*";

        if (mailProvider.matches(validInputFormat)) {
            this.mailProvider = mailProvider;
        } else {
            throw new OperationException("mailProvider format is incorrect should be "+validInputFormat);
        }

    }

    @Override
    public String getContactAsString() {
        return"Email: " + username + "@" + mailProvider + "\n";
    }
}
