package com.pgs.soft.controller;

import com.pgs.soft.dto.AuthorDTO;
import com.pgs.soft.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.ok(authorService.findAuthorById(id));
    }

}
