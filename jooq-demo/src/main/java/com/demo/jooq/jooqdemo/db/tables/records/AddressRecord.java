/*
 * This file is generated by jOOQ.
 */
package com.demo.jooq.jooqdemo.db.tables.records;


import com.demo.jooq.jooqdemo.db.tables.Address;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AddressRecord extends UpdatableRecordImpl<AddressRecord> implements Record4<Integer, String, String, String> {

    private static final long serialVersionUID = 96548359;

    /**
     * Setter for <code>public.address.aid</code>.
     */
    public void setAid(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.address.aid</code>.
     */
    public Integer getAid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.address.city</code>.
     */
    public void setCity(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.address.city</code>.
     */
    public String getCity() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.address.street</code>.
     */
    public void setStreet(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.address.street</code>.
     */
    public String getStreet() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.address.zipcode</code>.
     */
    public void setZipcode(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.address.zipcode</code>.
     */
    public String getZipcode() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Address.ADDRESS.AID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Address.ADDRESS.CITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Address.ADDRESS.STREET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Address.ADDRESS.ZIPCODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getAid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getCity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getStreet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getZipcode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getAid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getCity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getStreet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getZipcode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value1(Integer value) {
        setAid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value2(String value) {
        setCity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value3(String value) {
        setStreet(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value4(String value) {
        setZipcode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord values(Integer value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AddressRecord
     */
    public AddressRecord() {
        super(Address.ADDRESS);
    }

    /**
     * Create a detached, initialised AddressRecord
     */
    public AddressRecord(Integer aid, String city, String street, String zipcode) {
        super(Address.ADDRESS);

        set(0, aid);
        set(1, city);
        set(2, street);
        set(3, zipcode);
    }
}
