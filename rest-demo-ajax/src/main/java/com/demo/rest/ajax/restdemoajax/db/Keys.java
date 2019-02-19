/*
 * This file is generated by jOOQ.
 */
package com.demo.rest.ajax.restdemoajax.db;


import com.demo.rest.ajax.restdemoajax.db.tables.Address;
import com.demo.rest.ajax.restdemoajax.db.tables.Human;
import com.demo.rest.ajax.restdemoajax.db.tables.Products;
import com.demo.rest.ajax.restdemoajax.db.tables.Student;
import com.demo.rest.ajax.restdemoajax.db.tables.records.AddressRecord;
import com.demo.rest.ajax.restdemoajax.db.tables.records.HumanRecord;
import com.demo.rest.ajax.restdemoajax.db.tables.records.ProductsRecord;
import com.demo.rest.ajax.restdemoajax.db.tables.records.StudentRecord;

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

    public static final Identity<AddressRecord, Integer> IDENTITY_ADDRESS = Identities0.IDENTITY_ADDRESS;
    public static final Identity<HumanRecord, Integer> IDENTITY_HUMAN = Identities0.IDENTITY_HUMAN;
    public static final Identity<StudentRecord, Integer> IDENTITY_STUDENT = Identities0.IDENTITY_STUDENT;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AddressRecord> ADDRESS_PKEY = UniqueKeys0.ADDRESS_PKEY;
    public static final UniqueKey<HumanRecord> HUMAN_PKEY = UniqueKeys0.HUMAN_PKEY;
    public static final UniqueKey<ProductsRecord> PRODUCTS_PKEY = UniqueKeys0.PRODUCTS_PKEY;
    public static final UniqueKey<StudentRecord> STUDENT_PKEY = UniqueKeys0.STUDENT_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<StudentRecord, AddressRecord> STUDENT__STUDENT_ADDRESS_FK_FKEY = ForeignKeys0.STUDENT__STUDENT_ADDRESS_FK_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<AddressRecord, Integer> IDENTITY_ADDRESS = Internal.createIdentity(Address.ADDRESS, Address.ADDRESS.AID);
        public static Identity<HumanRecord, Integer> IDENTITY_HUMAN = Internal.createIdentity(Human.HUMAN, Human.HUMAN.ID);
        public static Identity<StudentRecord, Integer> IDENTITY_STUDENT = Internal.createIdentity(Student.STUDENT, Student.STUDENT.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<AddressRecord> ADDRESS_PKEY = Internal.createUniqueKey(Address.ADDRESS, "address_pkey", Address.ADDRESS.AID);
        public static final UniqueKey<HumanRecord> HUMAN_PKEY = Internal.createUniqueKey(Human.HUMAN, "human_pkey", Human.HUMAN.ID);
        public static final UniqueKey<ProductsRecord> PRODUCTS_PKEY = Internal.createUniqueKey(Products.PRODUCTS, "products_pkey", Products.PRODUCTS.ID);
        public static final UniqueKey<StudentRecord> STUDENT_PKEY = Internal.createUniqueKey(Student.STUDENT, "student_pkey", Student.STUDENT.ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<StudentRecord, AddressRecord> STUDENT__STUDENT_ADDRESS_FK_FKEY = Internal.createForeignKey(com.demo.rest.ajax.restdemoajax.db.Keys.ADDRESS_PKEY, Student.STUDENT, "student__student_address_fk_fkey", Student.STUDENT.ADDRESS_FK);
    }
}
