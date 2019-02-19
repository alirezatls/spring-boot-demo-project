/*
 * This file is generated by jOOQ.
 */
package com.demo.restservice.restservicedemohateoas.db;


import com.demo.restservice.restservicedemohateoas.db.tables.Category;
import com.demo.restservice.restservicedemohateoas.db.tables.Product;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index CATEGORY_PKEY = Indexes0.CATEGORY_PKEY;
    public static final Index PRODUCT_PKEY = Indexes0.PRODUCT_PKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index CATEGORY_PKEY = Internal.createIndex("category_pkey", Category.CATEGORY, new OrderField[] { Category.CATEGORY.CATEGORY_PK }, true);
        public static Index PRODUCT_PKEY = Internal.createIndex("product_pkey", Product.PRODUCT, new OrderField[] { Product.PRODUCT.PRODUCT_ID }, true);
    }
}
