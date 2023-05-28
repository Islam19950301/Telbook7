public class PersonalInfoNode {

    private PersonalInfoNode next;
    private PersonalInfoNode previous;
    private PersonalInfo content;

    public PersonalInfoNode(PersonalInfoNode next, PersonalInfoNode previous, PersonalInfo content) {
        this.next = next;
        this.previous = previous;
        this.content = content;
    }

    public PersonalInfoNode getNext() {
        return next;
    }

    public void setNext(PersonalInfoNode next) {
        this.next = next;
    }

    public PersonalInfoNode getPrevious() {
        return previous;
    }

    public void setPrevious(PersonalInfoNode previous) {
        this.previous = previous;
    }

    public PersonalInfo getContent() {
        return content;
    }

    public void setContent(PersonalInfo content) {
        this.content = content;
    }
}
