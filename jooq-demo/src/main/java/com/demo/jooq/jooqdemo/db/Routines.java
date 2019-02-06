/*
 * This file is generated by jOOQ.
 */
package com.demo.jooq.jooqdemo.db;


import com.demo.jooq.jooqdemo.db.routines.Salestax;

import java.math.BigDecimal;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.Field;


/**
 * Convenience access to all stored procedures and functions in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Routines {

    /**
     * Call <code>public.salestax</code>
     */
    public static BigDecimal salestax(Configuration configuration, BigDecimal tax) {
        Salestax f = new Salestax();
        f.setTax(tax);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.salestax</code> as a field.
     */
    public static Field<BigDecimal> salestax(BigDecimal tax) {
        Salestax f = new Salestax();
        f.setTax(tax);

        return f.asField();
    }

    /**
     * Get <code>public.salestax</code> as a field.
     */
    public static Field<BigDecimal> salestax(Field<BigDecimal> tax) {
        Salestax f = new Salestax();
        f.setTax(tax);

        return f.asField();
    }
}
