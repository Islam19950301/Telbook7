public class ListOfContacts {

    private ContactNode firstNode;
    private ContactNode lastNode;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {

        if (size == 0) {
            return false;
        }

        return true;
    }

    public void clear() {

        firstNode = null;
        lastNode = null;
        size = 0;

    }

    public Contact get(int index) {

        ContactNode node = getNode(index);

        if (node != null) {
            return node.getContent();
        }

        return null;
    }

    private ContactNode getNode(int index) {

        ContactNode iteratorNode = firstNode;

        for (int i = 0; i < size; i++) {

            if (i == index) {
                return iteratorNode;
            }

            iteratorNode = iteratorNode.getNext();
        }

        return null;
    }

    public void set(int index, Contact content) {

        ContactNode node = getNode(index);

        if (node != null) {
            node.setContent(content);
        }

    }

    public void remove(int index) {

        ContactNode node = getNode(index);

        if (node != null) {

            ContactNode prevNode = node.getPrevious();
            ContactNode nextNode = node.getNext();

            if (firstNode == lastNode) {
                firstNode = null;
                lastNode = null;
            } else if (node == firstNode) {
                firstNode = nextNode;
                firstNode.setPrevious(null);
            } else if (node == lastNode) {
                lastNode = prevNode;
                lastNode.setNext(null);
            } else {
                prevNode.setNext(nextNode);
                nextNode.setPrevious(prevNode);
            }

            size--;
        }

    }

    public void add(Contact content) {

        if (size != 0) {
            ContactNode node = new ContactNode(null, lastNode, content);
            lastNode.setNext(node);
            lastNode = node;
        } else {
            ContactNode node = new ContactNode(null, null, content);
            firstNode = node;
            lastNode = node;
        }

        size++;

    }

}
