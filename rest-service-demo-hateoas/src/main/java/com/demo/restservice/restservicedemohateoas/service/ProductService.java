package com.demo.restservice.restservicedemohateoas.service;

import com.demo.restservice.restservicedemohateoas.db.tables.records.ProductRecord;
import com.demo.restservice.restservicedemohateoas.dto.ProductDto;
import org.jooq.DSLContext;
import org.jooq.InsertResultStep;
import org.jooq.Record6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.demo.restservice.restservicedemohateoas.db.tables.Category.CATEGORY;
import static com.demo.restservice.restservicedemohateoas.db.tables.Product.PRODUCT;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private DSLContext context;

    /**
     *  ##SELECT ALL PRODUCT IN ALL CATEGORIES##
     * @return list of product
     */
    public List<ProductDto> getAllProduct() {
        List<ProductDto> products = context.select(
                PRODUCT.PRODUCT_ID,
                PRODUCT.PRODUCT_NAME,
                PRODUCT.PRODUCT_CODE,
                PRODUCT.PRODUCT_PRICE,
                PRODUCT.PRODUCT_STATE,
                PRODUCT.CATEGORY_FK
        )
                .from(PRODUCT)
                .fetch()
                .into(ProductDto.class);
        return products;
    }

    /**
     *  ##SELECT ALL PRODUCT OF SPECIAL CATEGORY##
     * @param id is identity of product
     * @return List
     */
    public Optional<List<ProductDto>>  fetchAllProductByCategoryId(int id) {
        List<ProductDto> list = context.select(
                PRODUCT.PRODUCT_ID,
                PRODUCT.PRODUCT_NAME,
                PRODUCT.PRODUCT_CODE,
                PRODUCT.PRODUCT_PRICE,
                PRODUCT.PRODUCT_STATE,
                PRODUCT.CATEGORY_FK
        )
                .from(PRODUCT)
                .where(PRODUCT.CATEGORY_FK.eq(id))
                .fetch()
                .into(ProductDto.class);
        Optional<List<ProductDto>> opt = Optional.of(list);
        return opt;

    }

    /**
     *  ##SELECT ONE PRODUCT IN SPECIAL CATEGORY##
     * @param productId is identity of product
     * @return an Optional with type product
     */
    public Optional<ProductDto> fechProductByIdAndCategoryId(int productId) {
        Optional<ProductDto> product = context.select(
                PRODUCT.PRODUCT_ID,
                PRODUCT.PRODUCT_NAME,
                PRODUCT.PRODUCT_CODE,
                PRODUCT.PRODUCT_PRICE,
                PRODUCT.PRODUCT_STATE,
                PRODUCT.CATEGORY_FK
        )
                .from(PRODUCT)
                .where(PRODUCT.PRODUCT_ID.eq(productId))
                .fetchOptionalInto(ProductDto.class);
        return product;
    }

    /**
     *  ##INSERT PRODUCT TO CATEGORY##
     * @param productDto is object that you want to insert
     * @return numbers of rows that affected
     */
    public ProductDto insertProduct(ProductDto productDto) {
        InsertResultStep<ProductRecord> returning = context.insertInto(PRODUCT)
                .set(PRODUCT.PRODUCT_NAME, productDto.getProductName())
                .set(PRODUCT.PRODUCT_CODE, productDto.getProductCode())
                .set(PRODUCT.PRODUCT_PRICE, productDto.getProductPrice())
                .set(PRODUCT.PRODUCT_STATE, productDto.isProductState())
                .set(PRODUCT.CATEGORY_FK,productDto.getCategoryFk())
                .returning();
        return returning.fetchOne().into(ProductDto.class);
    }

    /**
     *  ##DELETE PRODUCT FROM SPECIAL CATEGORY##
     * @param productId is identity of product
     * @return numbers of rows that affected
     */
    public int deleteProduct(int productId) {
        return context.deleteFrom(PRODUCT)
                .where(PRODUCT.PRODUCT_ID.eq(productId))
                .execute();
    }

    /**
     *  ##UPDATE A PRODUCT IN SPECIAL CATEGORY##
     * @param productId is identity of product
     * @return numbers of rows that affected
     */
    public int updateProductInCategory(int productId, ProductDto productDto) {
        return context.update(PRODUCT)
                .set(PRODUCT.PRODUCT_NAME, productDto.getProductName())
                .set(PRODUCT.PRODUCT_CODE, productDto.getProductCode())
                .set(PRODUCT.PRODUCT_PRICE, productDto.getProductPrice())
                .set(PRODUCT.PRODUCT_STATE, productDto.isProductState())
                .set(PRODUCT.CATEGORY_FK, productDto.getCategoryFk())
                .where(PRODUCT.PRODUCT_ID.eq(productId))
                .execute();
    }


}
