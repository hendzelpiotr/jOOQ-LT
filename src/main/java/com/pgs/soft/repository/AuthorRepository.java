package com.pgs.soft.repository;

import com.pgs.soft.tables.records.AuthorRecord;

/**
 * Created by phendzel on 5/5/2017.
 */
public interface AuthorRepository {

    AuthorRecord findAuthorById(Integer id);
    AuthorRecord insertNewAuthor(AuthorRecord newAuthor);
    void deleteAuthor(Integer id);
    AuthorRecord updateAuthor(Integer id, AuthorRecord author);

}
