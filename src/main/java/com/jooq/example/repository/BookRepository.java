package com.jooq.example.repository;

import com.jooq.example.dto.BookDTO;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.jooq.example.Tables.BOOK_AUTHOR;
import static com.jooq.example.tables.Book.BOOK;

@Repository
@Transactional
public class BookRepository {

    @Autowired
    private DSLContext dslContext;

    public List<BookDTO> findAllBooksByAuthorId(Integer authorId) {
        List<BookDTO> result = new ArrayList<>();

        dslContext.select(BOOK.ID, BOOK.DATE_OF_PUBLICATION, BOOK.NAME, BOOK.PRICE, BOOK_AUTHOR.AUTHOR_ID)
                .from(BOOK)
                .join(BOOK_AUTHOR)
                .on(BOOK.ID.eq(BOOK_AUTHOR.BOOK_ID).and(BOOK_AUTHOR.AUTHOR_ID.eq(authorId)))
                .fetchInto((RecordHandler<Record>) record -> {
                    BookDTO bookDTO = new BookDTO();
                    bookDTO.setId(record.getValue(BOOK.ID));
                    bookDTO.setDateOfPublication(record.getValue(BOOK.DATE_OF_PUBLICATION));
                    bookDTO.setName(record.getValue(BOOK.NAME));
                    bookDTO.setPrice(record.getValue(BOOK.PRICE));
                    bookDTO.setAuthorId(record.getValue(BOOK_AUTHOR.AUTHOR_ID));
                    result.add(bookDTO);
                });

        return result;
    }

}
