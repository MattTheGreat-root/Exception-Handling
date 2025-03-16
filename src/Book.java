public class Book {
    private String title;
    private int pageCount;

    public Book(String title, int pageCount) {
        setTitle(title);
        setPageCount(pageCount);
    }

    public String getTitle() {
        return title;
    }
    public int getPageCount() {
        return pageCount;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        else this.title = title;
    }

    public void setPageCount(int pageCount) {
        if (pageCount <= 0) {
            throw new IllegalArgumentException("Page count must be positive");
        }
        else this.pageCount = pageCount;
    }

    @Override
    public String toString() {
         return title + "(" + pageCount + " pages" + ")";
    }
}
