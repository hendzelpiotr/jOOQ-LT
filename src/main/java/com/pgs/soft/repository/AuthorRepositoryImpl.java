package com.pgs.soft.repository;

import com.pgs.soft.routines.UpdateAuthor;
import com.pgs.soft.tables.records.AuthorRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<AuthorRecord> findByFirstNameOrderByDateOfBirth(String firstName) {
        return dslContext.selectFrom(AUTHOR)
                .where(AUTHOR.FIRST_NAME.likeIgnoreCase(firstName))
                .orderBy(AUTHOR.DATE_OF_BIRTH)
                .fetchInto(AuthorRecord.class);
    }

    @Override
    public List<AuthorRecord> findAll() {
        return dslContext.selectFrom(AUTHOR)
                .fetchInto(AuthorRecord.class);
    }

    @Override
    public AuthorRecord insertNewAuthor(AuthorRecord author) {
        return dslContext.insertInto(AUTHOR,
                AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME, AUTHOR.ADDRESS, AUTHOR.DATE_OF_BIRTH)
                .values(author.getFirstName(), author.getLastName(), author.getAddress(), author.getDateOfBirth())
                .returning()
                .fetchOne();
    }

    @Override
    public void deleteAuthor(Integer id) {
        dslContext.delete(AUTHOR)
                .where(AUTHOR.ID.eq(id))
                .execute();
    }

    @Override
    public AuthorRecord updateAuthor(Integer id, AuthorRecord author) {
        return dslContext.update(AUTHOR)
                .set(AUTHOR.FIRST_NAME, author.getFirstName())
                .set(AUTHOR.LAST_NAME, author.getLastName())
                .set(AUTHOR.ADDRESS, author.getAddress())
                .set(AUTHOR.DATE_OF_BIRTH, author.getDateOfBirth())
                .where(AUTHOR.ID.eq(id))
                .returning()
                .fetchOne();
    }

    private Boolean updateAuthorByDatabaseFunction(AuthorRecord author) {
        UpdateAuthor updateAuthor = new UpdateAuthor();
        updateAuthor.setFirstName(author.getFirstName());
        updateAuthor.setLastName(author.getLastName());
        updateAuthor.setAddress(author.getAddress());
        updateAuthor.setDateOfBirth(author.getDateOfBirth());
        return updateAuthor.getReturnValue();
    }

}
