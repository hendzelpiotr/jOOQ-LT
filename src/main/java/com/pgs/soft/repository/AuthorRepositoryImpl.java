package com.pgs.soft.repository;

import com.pgs.soft.tables.records.AuthorRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static com.pgs.soft.tables.Author.AUTHOR;

/**
 * Created by phendzel on 5/5/2017.
 */
@Repository
@Transactional
public class AuthorRepositoryImpl implements AuthorRepository {

    @Autowired
    private DSLContext dslContext;

    @Override
    public AuthorRecord findAuthorById(Integer id) {
        return dslContext.selectFrom(AUTHOR)
                .where(AUTHOR.ID.eq(id))
                .fetchOne();
    }

    @Override
    public AuthorRecord insertNewAuthor(AuthorRecord newAuthor) {
        return null;
    }

    @Override
    public void deleteAuthor(Integer id) {

    }

    @Override
    public AuthorRecord updateAuthor(Integer id, AuthorRecord author) {
        return null;
    }

}
