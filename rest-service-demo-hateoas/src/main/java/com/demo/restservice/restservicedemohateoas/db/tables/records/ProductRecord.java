/*
 * This file is generated by jOOQ.
 */
package com.demo.restservice.restservicedemohateoas.db.tables.records;


import com.demo.restservice.restservicedemohateoas.db.tables.Product;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
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
public class ProductRecord extends UpdatableRecordImpl<ProductRecord> implements Record6<Integer, String, String, Integer, Boolean, Integer> {

    private static final long serialVersionUID = -994552227;

    /**
     * Setter for <code>public.product.product_id</code>.
     */
    public void setProductId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.product.product_id</code>.
     */
    public Integer getProductId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.product.product_name</code>.
     */
    public void setProductName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.product.product_name</code>.
     */
    public String getProductName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.product.product_code</code>.
     */
    public void setProductCode(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.product.product_code</code>.
     */
    public String getProductCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.product.product_price</code>.
     */
    public void setProductPrice(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.product.product_price</code>.
     */
    public Integer getProductPrice() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.product.product_state</code>.
     */
    public void setProductState(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.product.product_state</code>.
     */
    public Boolean getProductState() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>public.product.category_id</code>.
     */
    public void setCategoryId(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.product.category_id</code>.
     */
    public Integer getCategoryId() {
        return (Integer) get(5);
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
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, String, String, Integer, Boolean, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, String, String, Integer, Boolean, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Product.PRODUCT.PRODUCT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Product.PRODUCT.PRODUCT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Product.PRODUCT.PRODUCT_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Product.PRODUCT.PRODUCT_PRICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field5() {
        return Product.PRODUCT.PRODUCT_STATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return Product.PRODUCT.CATEGORY_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getProductId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getProductName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getProductCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getProductPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component5() {
        return getProductState();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getCategoryId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getProductId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getProductName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getProductCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getProductPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value5() {
        return getProductState();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getCategoryId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord value1(Integer value) {
        setProductId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord value2(String value) {
        setProductName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord value3(String value) {
        setProductCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord value4(Integer value) {
        setProductPrice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord value5(Boolean value) {
        setProductState(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord value6(Integer value) {
        setCategoryId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord values(Integer value1, String value2, String value3, Integer value4, Boolean value5, Integer value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProductRecord
     */
    public ProductRecord() {
        super(Product.PRODUCT);
    }

    /**
     * Create a detached, initialised ProductRecord
     */
    public ProductRecord(Integer productId, String productName, String productCode, Integer productPrice, Boolean productState, Integer categoryId) {
        super(Product.PRODUCT);

        set(0, productId);
        set(1, productName);
        set(2, productCode);
        set(3, productPrice);
        set(4, productState);
        set(5, categoryId);
    }
}