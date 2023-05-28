public class TelBook {

    private String owner;
    private ListOfPages pages = new ListOfPages();
    private int lastEmptyPageIndex = 0;

    public void add(Page page) throws OperationException {

        if (page == null) {
            throw new OperationException("page can not be null");
        } else if (page.getPerson() == null) {
            throw new OperationException("page person can not be null");
        }

        page.setPageNumber(lastEmptyPageIndex);
        pages.add(page);
        lastEmptyPageIndex++;

    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getLastEmptyPageIndex() {
        return lastEmptyPageIndex;
    }

    public void setLastEmptyPageIndex(int lastEmptyPageIndex) {
        this.lastEmptyPageIndex = lastEmptyPageIndex;
    }

    public void update(Page page, int pageIndex) {

        int listIndex = getListIndex(pageIndex);
        if (listIndex >= 0) {
            pages.set(listIndex, page);
        }

    }

    private int getListIndex(int pageIndex) {

        for (int i = 0; i < pages.size(); i++) {

            Page foundPage = pages.get(i);

            if (foundPage.getPerson() != null) {
                if (foundPage.getPageNumber() == pageIndex) {
                    return i; //Attention: i.e. listIndex!=pageIndex
                }
            }

        }

        return -1;
    }

    public void delete(int pageIndex) {

        int listIndex = getListIndex(pageIndex); //Attention: listIndex!=pageIndex

        if (listIndex >= 0) {
            pages.remove(listIndex);
        }

    }

    public ListOfPages search(String keyWord) {

        ListOfPages searchResults = new ListOfPages();

        for (int i = 0; i < pages.size(); i++) {

            Page foundPage = pages.get(i);

            if (foundPage.getPerson() != null) {

                ListOfPersonalInfos personalInfos = foundPage.getPerson().getPersonalInfos();

                for (int j=0; j<personalInfos.size(); j++) {

                    if (personalInfos.get(j).getPersonInfoAsString().contains(keyWord)) {
                        searchResults.add(foundPage);
                    }

                }

                ListOfContacts contacts = foundPage.getPerson().getContacts();

                for (int j=0; j<contacts.size(); j++) {

                    if (contacts.get(j).getContactAsString().contains(keyWord)) {
                        searchResults.add(foundPage);
                    }

                }

            }

        }

        return searchResults;
    }

    public Page get(int pageIndex) {

        int listIndex = getListIndex(pageIndex); //Attention: listIndex!=pageIndex

        if (listIndex >= 0) {
            return pages.get(listIndex);
        }

        return null;
    }

    public ListOfPages getPages() {
        return pages;
    }

}
