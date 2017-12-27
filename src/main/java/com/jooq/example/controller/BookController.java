package com.jooq.example.controller;

import com.jooq.example.dto.BookDTO;
import com.jooq.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "authors/{authorId}")
    public ResponseEntity<List<BookDTO>> getAllBooksForSpecificAuthor(@PathVariable("authorId") Integer authorId) {
        List<BookDTO> books = bookRepository.findAllBooksByAuthorId(authorId);
        return ResponseEntity.ok(books);
    }

}
