public class ListOfPersonalInfos {

    private PersonalInfoNode firstNode;
    private PersonalInfoNode lastNode;
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

    public PersonalInfo get(int index) {

        PersonalInfoNode node = getNode(index);

        if (node != null) {
            return node.getContent();
        }

        return null;
    }

    private PersonalInfoNode getNode(int index) {

        PersonalInfoNode iteratorNode = firstNode;

        for (int i = 0; i < size; i++) {

            if (i == index) {
                return iteratorNode;
            }

            iteratorNode = iteratorNode.getNext();
        }

        return null;
    }

    public void set(int index, PersonalInfo content) {

        PersonalInfoNode node = getNode(index);

        if (node != null) {
            node.setContent(content);
        }

    }

    public void remove(int index) {

        PersonalInfoNode node = getNode(index);

        if (node != null) {

            PersonalInfoNode prevNode = node.getPrevious();
            PersonalInfoNode nextNode = node.getNext();

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

    public void add(PersonalInfo content) {

        if (size != 0) {
            PersonalInfoNode node = new PersonalInfoNode(null, lastNode, content);
            lastNode.setNext(node);
            lastNode = node;
        } else {
            PersonalInfoNode node = new PersonalInfoNode(null, null, content);
            firstNode = node;
            lastNode = node;
        }

        size++;

    }

}
