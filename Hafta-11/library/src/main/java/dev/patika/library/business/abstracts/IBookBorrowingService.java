package dev.patika.library.business.abstracts;

import dev.patika.library.entities.Author;
import dev.patika.library.entities.BookBorrowing;
import org.springframework.data.domain.Page;

public interface IBookBorrowingService {

    BookBorrowing save(BookBorrowing bookBorrowing);
    BookBorrowing get(Long id);
    Page<BookBorrowing> cursor(int page, int pageSize);
    BookBorrowing update(BookBorrowing bookBorrowing);
    boolean delete(Long id);
}
