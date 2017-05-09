package com.pgs.soft.controller;

import com.pgs.soft.dto.AuthorDTO;
import com.pgs.soft.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by phendzel on 5/5/2017.
 */
@RestController
@RequestMapping("api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("{id}")
    public ResponseEntity<AuthorDTO> getOneById(@PathVariable("id") Integer id) {
        AuthorDTO foundAuthor = authorService.findAuthorById(id);
        return ResponseEntity.ok(foundAuthor);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createNew(@RequestBody AuthorDTO authorDTO) {
        AuthorDTO createdAuthor = authorService.createAuthor(authorDTO);
        return ResponseEntity.status(201).body(createdAuthor);
    }

    @PutMapping("{id}")
    public ResponseEntity<AuthorDTO> update(@PathVariable("id") Integer id, @RequestBody AuthorDTO authorDTO) {
        AuthorDTO updatedAuthor = authorService.updateAuthor(id, authorDTO);
        return ResponseEntity.ok(updatedAuthor);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAll() {
        List<AuthorDTO> authorDTOs = authorService.findAll();
        return ResponseEntity.ok(authorDTOs);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        authorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
