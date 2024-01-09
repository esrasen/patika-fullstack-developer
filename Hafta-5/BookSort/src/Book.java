public class Book implements Comparable<Book> {
    private String name;
    private String author;
    private int page;
    private String publicationDate;

    public Book(String name, String author, int page, String publicationDate) {
        this.name = name;
        this.author = author;
        this.page = page;
        this.publicationDate = publicationDate;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAuthor() {return author;}

    public void setAuthor(String author) {this.author = author;}

    public int getPage() {return page;}

    public void setPage(int page) {this.page = page;}

    public String getPublicationDate() {return publicationDate;}

    public void setPublicationDate(String publicationDate) {this.publicationDate = publicationDate;}

    @Override
    public int compareTo(Book o) {
        return 0;
    }

}
