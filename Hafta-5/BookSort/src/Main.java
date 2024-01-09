
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<Book> books = new TreeSet<>(new BookNameComparator());  //BookNameComparator sınıfı ile kitapları isimlerine göre sıraladım.

        books.add(new Book("HTML", "Alice", 360, "19.07.2002"));
        books.add(new Book("REACT", "Charlie", 455, "19.07.2019"));
        books.add(new Book("CSS", "Bob", 200, "19.07.2023"));
        books.add(new Book("JAVA", "Dania", 525, "03.11.2019"));

        for (Book book : books) {                                //TreeSet içerisindeki kitapları yazdırdım.
            System.out.println("Book Name: " + book.getName());
        }

        System.out.println("====================================");

        TreeSet<Book> books2 = new TreeSet<>(new BookPageComparator()); //BookPageComparator sınıfı ile kitapları sayfa sayılarına göre sıraladım.

        books2.add(new Book("HTML", "Alice", 360, "19.07.2002"));
        books2.add(new Book("CSS", "Bob", 200, "19.07.2023"));
        books2.add(new Book("JAVA", "Dania", 525, "03.11.2019"));
        books2.add(new Book("REACT", "Charlie", 455, "19.07.2019"));


        for (Book book : books2) {
            System.out.println(" Page: " + book.getPage());
        }


    }
}