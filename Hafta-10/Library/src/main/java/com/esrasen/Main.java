package com.esrasen;

import com.esrasen.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        //Category
        Category biography = new Category("Biography");
        Category mystery = new Category("Mystery");
        Category fantasy = new Category("Fantasy");

        entityManager.persist(biography);
        entityManager.persist(mystery);
        entityManager.persist(fantasy);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(biography);
        categoryList.add(mystery);
        categoryList.add(fantasy);


        //Author
        Author author = new Author();
        author.setName("Lev Tolstoy");
        author.setBirthDate(LocalDate.of(1828, 9, 9));
        author.setCountry("Russia");

        entityManager.persist(author);

        // Publisher
        Publisher publisher = new Publisher();
        publisher.setName("Atlas Yayınevi");
        publisher.setEstablishmentYear(2008);
        publisher.setAddress("İstanbul, Turkey");

        entityManager.persist(publisher);

        // Book
        Book book = new Book();
        book.setName("Anna Karenina");
        book.setPublicationYear(1878);
        book.setStock(100);
        book.setPublisher(publisher);
        book.setAuthor(author);
        book.setCategoryList(categoryList);

        entityManager.persist(book);

        //BookBorrowing
        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowerName("Esra");
        bookBorrowing.setBorrowingDate(LocalDate.of(2024, 01, 10));
        bookBorrowing.setReturnDate(LocalDate.of(2024, 02, 10));
        bookBorrowing.setBook(book);

        entityManager.persist(bookBorrowing);

        transaction.commit();

    }
}