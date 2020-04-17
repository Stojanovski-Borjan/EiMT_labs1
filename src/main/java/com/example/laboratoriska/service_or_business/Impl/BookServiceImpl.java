package com.example.laboratoriska.service_or_business.Impl;

import com.example.laboratoriska.Model.Book;
import com.example.laboratoriska.Model.Category;
import com.example.laboratoriska.Model.exception.BookNotFoundException;
import com.example.laboratoriska.persistence_or_repository.BookRepository;
import com.example.laboratoriska.service_or_business.BookService;
import com.example.laboratoriska.service_or_business.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository,
                           CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElseThrow(()
                -> new BookNotFoundException(id));
    }

    @Override
    public Book saveBook(String bookName, Long bookQuantity, String bookDescription, Long categortId) {
        Category category = this.categoryService.findById(categortId);
        Book book = new Book(null, bookName, bookQuantity, bookDescription, category);
        return this.bookRepository.saveBook(book);
    }

    @Override
    public Book saveBook(Book book, MultipartFile image) throws IOException {
        Category category = this.categoryService.findById(book.getCategory().getId());
        book.setCategory(category);
        if (image != null && !image.getName().isEmpty()){
            byte[] bytes = image.getBytes();
            String base64image = String.format("data:%s;base64,%s",
                    image.getContentType(),
                    Base64.getEncoder().encodeToString(bytes));
            book.setImage(image);
            book.setImageBase64(base64image);
        }

        return this.bookRepository.saveBook(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
