package com.example.laboratoriska.service_or_business;

import com.example.laboratoriska.Model.Book;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    Book saveBook(String bookName, Long bookQuantity, String bookDescription, Long categoryId);
    Book saveBook(Book book, MultipartFile image) throws IOException;
    void deleteById(Long id);

}
