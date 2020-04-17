package com.example.laboratoriska.persistence_or_repository;

import com.example.laboratoriska.Model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book saveBook(Book book);
//    Book findById(Long id);
    void deleteById(Long id);
}
