package com.example.elasticsearch.service;

import com.example.elasticsearch.document.Book;
import com.example.elasticsearch.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Page<Book> searchByAuthor(String author, Integer number, Integer size) {
        PageRequest pageRequest = PageRequest.of(number, size);
        return bookRepository.findByAuthor(author, pageRequest);
    }

    public void save(Book book) {
        bookRepository.save(book);
    }
}
