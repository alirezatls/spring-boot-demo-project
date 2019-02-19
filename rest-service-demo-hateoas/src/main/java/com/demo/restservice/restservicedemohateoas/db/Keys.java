/*
 * This file is generated by jOOQ.
 */
package com.demo.restservice.restservicedemohateoas.db;


import com.demo.restservice.restservicedemohateoas.db.tables.Category;
import com.demo.restservice.restservicedemohateoas.db.tables.Product;
import com.demo.restservice.restservicedemohateoas.db.tables.records.CategoryRecord;
import com.demo.restservice.restservicedemohateoas.db.tables.records.ProductRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<CategoryRecord, Integer> IDENTITY_CATEGORY = Identities0.IDENTITY_CATEGORY;
    public static final Identity<ProductRecord, Integer> IDENTITY_PRODUCT = Identities0.IDENTITY_PRODUCT;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CategoryRecord> CATEGORY_PKEY = UniqueKeys0.CATEGORY_PKEY;
    public static final UniqueKey<ProductRecord> PRODUCT_PKEY = UniqueKeys0.PRODUCT_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ProductRecord, CategoryRecord> PRODUCT__PRODUCT_CATEGORY_ID_FKEY = ForeignKeys0.PRODUCT__PRODUCT_CATEGORY_ID_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<CategoryRecord, Integer> IDENTITY_CATEGORY = Internal.createIdentity(Category.CATEGORY, Category.CATEGORY.CATEGORY_PK);
        public static Identity<ProductRecord, Integer> IDENTITY_PRODUCT = Internal.createIdentity(Product.PRODUCT, Product.PRODUCT.PRODUCT_ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<CategoryRecord> CATEGORY_PKEY = Internal.createUniqueKey(Category.CATEGORY, "category_pkey", Category.CATEGORY.CATEGORY_PK);
        public static final UniqueKey<ProductRecord> PRODUCT_PKEY = Internal.createUniqueKey(Product.PRODUCT, "product_pkey", Product.PRODUCT.PRODUCT_ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<ProductRecord, CategoryRecord> PRODUCT__PRODUCT_CATEGORY_ID_FKEY = Internal.createForeignKey(com.demo.restservice.restservicedemohateoas.db.Keys.CATEGORY_PKEY, Product.PRODUCT, "product__product_category_id_fkey", Product.PRODUCT.CATEGORY_ID);
    }
}
