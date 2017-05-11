package com.pgs.soft.repository;

import com.pgs.soft.tables.records.AuthorRecord;

import java.util.List;

/**
 * Created by phendzel on 5/5/2017.
 */
public interface AuthorRepository {

    AuthorRecord findAuthorById(Integer id);
    List<AuthorRecord> findByFirstNameOrderByDateOfBirth(String firstName);
    List<AuthorRecord> findAll();
    AuthorRecord insertNewAuthor(AuthorRecord author);
    void deleteAuthor(Integer id);
    AuthorRecord updateAuthor(Integer id, AuthorRecord author);

}
