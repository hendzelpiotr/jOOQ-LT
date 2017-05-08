package com.pgs.soft.converter;

import org.jooq.Converter;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * Created by phendzel on 5/8/2017.
 */
public class LocalDateConverter implements Converter<Timestamp, LocalDate> {

    @Override
    public LocalDate from(Timestamp t) {
        return t == null ? null : t.toLocalDateTime().toLocalDate();
    }

    @Override
    public Timestamp to(LocalDate u) {
        return u == null ? null : Timestamp.valueOf(u.toString());
    }

    @Override
    public Class<Timestamp> fromType() {
        return Timestamp.class;
    }

    @Override
    public Class<LocalDate> toType() {
        return LocalDate.class;
    }

}
