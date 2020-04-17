package com.example.laboratoriska.Model;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Book {
    private Long id;

    @NotBlank(message = "You must enter Book Name")
    private String bookName;

    @NotNull
    @Min(value = 0, message = "Quantity must be bigger than 0")
    private Long bookQuantity;

    @NotBlank(message = "You must enter Book Description")
    private String bookDescription;
    private Category category;

    //IMAGE
    private MultipartFile image;

    private String imageBase64;

    public Book(){}

    public Book(Long id, String bookName, Long bookQuantity, String bookDescription, Category category) {
        this.id = id;
        this.bookName = bookName;
        this.bookQuantity = bookQuantity;
        this.bookDescription = bookDescription;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Long getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Long bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
}
