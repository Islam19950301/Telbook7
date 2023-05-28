public class InstagramAccount extends Contact {

    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) throws OperationException {

        final String validInputFormat = "[a-zA-Z0-9-_]*";

        if (account.matches(validInputFormat)) {
            this.account = account;
        } else {
            throw new OperationException("Not a valid format of account, should be " + validInputFormat);
        }
    }

    @Override
    public String getContactAsString() {
        return "www.instagram.com/" + account + "\n";
    }
}
