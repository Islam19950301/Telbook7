public class ContactNode {

    private ContactNode next;
    private ContactNode previous;
    private Contact content;

    public ContactNode(ContactNode next, ContactNode previous, Contact content) {
        this.next = next;
        this.previous = previous;
        this.content = content;
    }

    public ContactNode getNext() {
        return next;
    }

    public void setNext(ContactNode next) {
        this.next = next;
    }

    public ContactNode getPrevious() {
        return previous;
    }

    public void setPrevious(ContactNode previous) {
        this.previous = previous;
    }

    public Contact getContent() {
        return content;
    }

    public void setContent(Contact content) {
        this.content = content;
    }
}
