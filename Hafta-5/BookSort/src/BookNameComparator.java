import java.util.Comparator;
public class BookNameComparator implements Comparator<Book>{        //Book sınıfını isme göre sıralamak için
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
