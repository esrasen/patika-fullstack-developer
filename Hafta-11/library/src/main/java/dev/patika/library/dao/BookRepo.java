package dev.patika.library.dao;

import dev.patika.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    boolean existsByCategoryList_Id(Long categoryId);
}
