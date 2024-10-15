package com.example.elasticsearch.controller;

import com.example.elasticsearch.document.Book;
import com.example.elasticsearch.dto.BookPaginationRequest;
import com.example.elasticsearch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void saveBook(@RequestBody Book book) {
        bookService.save(book);
    }

    @PostMapping("/find")
    public List<Book> findBooks(@RequestBody BookPaginationRequest r) {
        String author = r.getAuthor();
        Integer number = r.getNumber();
        Integer size = r.getSize();
        return bookService.searchByAuthor(author, number, size).getContent();
    }
}
