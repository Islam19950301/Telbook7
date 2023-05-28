public class ListOfPages {

    private PageNode firstNode;
    private PageNode lastNode;
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

    public Page get(int index) {

        PageNode node = getNode(index);

        if (node != null) {
            return node.getContent();
        }

        return null;
    }

    private PageNode getNode(int index) {

        PageNode iteratorNode = firstNode;

        for (int i = 0; i < size; i++) {

            if (i == index) {
                return iteratorNode;
            }

            iteratorNode = iteratorNode.getNext();
        }

        return null;
    }

    public void set(int index, Page content) {

        PageNode node = getNode(index);

        if (node != null) {
            node.setContent(content);
        }

    }

    public void remove(int index) {

        PageNode node = getNode(index);

        if (node != null) {

            PageNode prevNode = node.getPrevious();
            PageNode nextNode = node.getNext();

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

    public void add(Page content) {

        if (size != 0) {
            PageNode node = new PageNode(null, lastNode, content);
            lastNode.setNext(node);
            lastNode = node;
        } else {
            PageNode node = new PageNode(null, null, content);
            firstNode = node;
            lastNode = node;
        }

        size++;

    }

}
