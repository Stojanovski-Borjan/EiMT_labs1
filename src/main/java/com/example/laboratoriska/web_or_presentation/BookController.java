package com.example.laboratoriska.web_or_presentation;

import com.example.laboratoriska.Model.Book;
import com.example.laboratoriska.Model.Category;
import com.example.laboratoriska.service_or_business.BookService;
import com.example.laboratoriska.service_or_business.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final CategoryService categoryService;
    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getBooksPage(Model model){
        List<Book> books = this.bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }

//    @GetMapping("/{id}/show")
//    public String showBookPage(Model model, @PathVariable Long id){
//        try {
//            Book book = this.bookService.findById(id);
//            List<Category> categories = this.categoryService.findAll();
//            model.addAttribute("book", book);
//            model.addAttribute("categories", categories);
//            return "show";
//        } catch (RuntimeException ex){
//            return "redirect:/books?error=" + ex.getMessage();
//        }
//    }

    @GetMapping("/add-new")
    public String addNewBook(Model model){
        List<Category> categories = this.categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("book", new Book());
        return "add-book";
    }


    @GetMapping("/{id}/edit")
    public String editProductService(Model model, @PathVariable Long id){
        try {
            Book book = this.bookService.findById(id);
            List<Category> categories = this.categoryService.findAll();
            model.addAttribute("book", book);
            model.addAttribute("categories", categories);
            return "add-book";
        } catch (RuntimeException ex){
            return "redirect:/books?error=" + ex.getMessage();
        }
    }

    @PostMapping()
    public String saveBook(@Valid Book book,
                           BindingResult bindingResult,
                           @RequestParam MultipartFile image,
                           Model model){
        if (bindingResult.hasErrors()){
            List<Category> categories = this.categoryService.findAll();
            model.addAttribute("categories", categories);
            return "add-book";
        }
        try {
            this.bookService.saveBook(book, image );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/books";
    }

    @PostMapping("/{id}/delete")
    public String deleteProductWithPost(@PathVariable Long id) {
        this.bookService.deleteById(id);
        return "redirect:/books";
    }



}
