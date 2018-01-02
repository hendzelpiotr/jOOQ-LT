package com.jooq.example.repository;

import com.jooq.example.dto.AuthorDTO;
import com.jooq.example.routines.UpdateAuthor;
import com.jooq.example.tables.records.AuthorRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.jooq.example.Tables.BOOK_AUTHOR;
import static com.jooq.example.tables.Author.AUTHOR;

/**
 * Created by phendzel on 5/5/2017.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class AuthorRepository {

    @Autowired
    private DSLContext dslContext;

    public AuthorRecord findAuthorById(Integer id) {
        return dslContext.selectFrom(AUTHOR)
                .where(AUTHOR.ID.eq(id))
                .fetchOne();
    }

    public List<AuthorRecord> findByFirstNameOrderByDateOfBirth(String firstName) {
        return dslContext.selectFrom(AUTHOR)
                .where(AUTHOR.FIRST_NAME.likeIgnoreCase(firstName))
                .orderBy(AUTHOR.DATE_OF_BIRTH)
                .fetchInto(AuthorRecord.class);
    }

    public List<AuthorRecord> findAll() {
        return dslContext.selectFrom(AUTHOR)
                .fetchInto(AuthorRecord.class);
    }

    public AuthorRecord insertNewAuthor(AuthorRecord author) {
        return dslContext.insertInto(AUTHOR,
                AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME, AUTHOR.ADDRESS, AUTHOR.DATE_OF_BIRTH)
                .values(author.getFirstName(), author.getLastName(), author.getAddress(), author.getDateOfBirth())
                .returning()
                .fetchOne();
    }

    public void deleteAuthor(Integer id) {
        dslContext.delete(AUTHOR)
                .where(AUTHOR.ID.eq(id))
                .execute();
    }

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

    public List<AuthorDTO> findAllAuthorsByBookId(Integer bookId) {
        List<AuthorDTO> result = new ArrayList<>();

        dslContext.select(AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
                .from(AUTHOR)
                .join(BOOK_AUTHOR)
                .on(AUTHOR.ID.eq(BOOK_AUTHOR.AUTHOR_ID).and(BOOK_AUTHOR.BOOK_ID.eq(bookId)))
                .fetchInto((RecordHandler<Record>) record -> {
                    AuthorDTO authorDTO = new AuthorDTO();
                    authorDTO.setFirstName(record.getValue(AUTHOR.FIRST_NAME));
                    authorDTO.setLastName(record.getValue(AUTHOR.LAST_NAME));

                    result.add(authorDTO);
                });

        return result;
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
