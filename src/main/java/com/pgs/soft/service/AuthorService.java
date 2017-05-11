package com.pgs.soft.service;

import com.pgs.soft.dto.AuthorDTO;

import java.util.List;

/**
 * Created by phendzel on 5/5/2017.
 */
public interface AuthorService {

    AuthorDTO findAuthorById(Integer id);
    List<AuthorDTO> findAuthorsByFirstNameOrderByDateOfBirth(String firstName);
    List<AuthorDTO> findAll();
    AuthorDTO updateAuthor(Integer id, AuthorDTO authorDTO);
    AuthorDTO createAuthor(AuthorDTO authorDTO);
    void deleteById(Integer id);
}
