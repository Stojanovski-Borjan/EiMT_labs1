package com.example.laboratoriska.persistence_or_repository.Impl;

import com.example.laboratoriska.Model.Book;
import com.example.laboratoriska.persistence_or_repository.BookRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private HashMap<Long, Book> books;
    private AtomicLong counter;

    @PostConstruct
    public void init(){
        books = new HashMap<>();
        counter = new AtomicLong(0);

        Long id = counter.getAndIncrement();
        this.books.put(id, new Book(id, "Девојката со бисерна обетка", 3L, "Девојката со бисерна обетка е убедлив историски роман; а како студија на човековата природа, зачинета со зрела анализа, блеска.", null));
        id = counter.getAndIncrement();
        this.books.put(id, new Book(id, "Мементо за Истанбул", 5L, "Возбудлива приказна со која патуваме низ времето, од најраните денови на Бизант до денешниот, милионски Истанбул.", null));
        id = counter.getAndIncrement();
        this.books.put(id, new Book(id, "Судење", 5L, "Од својата баба, Алекс Крос ја слуша приказната за дедо му и за неговата борба за преживување во времето на Кју-клукс-кланот. ", null));
    }


    @Override
    public List<Book> findAll() {
        return new ArrayList<>(this.books.values());
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(this.books.get(id));
    }

    @Override
    public Book saveBook(Book book) {
        if(book.getId() == null) {
            book.setId(this.counter.getAndIncrement());
        }
        this.books.put(book.getId(), book);
        return book;
    }

    @Override
    public void deleteById(Long id) {
        this.books.remove(id);
    }
}
