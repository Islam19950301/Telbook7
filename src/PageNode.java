public class PageNode {

    private PageNode next;
    private PageNode previous;
    private Page content;

    public PageNode(PageNode next, PageNode previous, Page content) {
        this.next = next;
        this.previous = previous;
        this.content = content;
    }

    public PageNode getNext() {
        return next;
    }

    public void setNext(PageNode next) {
        this.next = next;
    }

    public PageNode getPrevious() {
        return previous;
    }

    public void setPrevious(PageNode previous) {
        this.previous = previous;
    }

    public Page getContent() {
        return content;
    }

    public void setContent(Page content) {
        this.content = content;
    }
}
