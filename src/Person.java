public class Person {

    private ListOfPersonalInfos personalInfos = new ListOfPersonalInfos();
    private int lastFreeCellInPersonalInfos = 0;

    private ListOfContacts contacts = new ListOfContacts();
    private int lastFreeCellInContacts = 0;

    public ListOfPersonalInfos getPersonalInfos() {
        return personalInfos;
    }

    public void setPersonalInfos(ListOfPersonalInfos personalInfos) {
        this.personalInfos = personalInfos;
    }

    public ListOfContacts getContacts() {
        return contacts;
    }

    public void setContacts(ListOfContacts contacts) {
        this.contacts = contacts;
    }

    public void addPersonalInfo(PersonalInfo personalInfo) {
        personalInfos.add(personalInfo);
        lastFreeCellInPersonalInfos++;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        lastFreeCellInContacts++;
    }
}
