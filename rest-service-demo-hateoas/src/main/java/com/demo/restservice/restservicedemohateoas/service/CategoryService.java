package com.demo.restservice.restservicedemohateoas.service;

import com.demo.restservice.restservicedemohateoas.db.tables.Category;
import com.demo.restservice.restservicedemohateoas.dto.CategoryDto;
import org.jooq.DSLContext;
import org.jooq.Record3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.demo.restservice.restservicedemohateoas.db.tables.Category.CATEGORY;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private DSLContext context;

    /**
     *  ##SELECT ALL CATEGORY##
     * @return list o all categories
     */
     public List<CategoryDto> fetchAllCategory() {
         return context.select(
                 CATEGORY.CATEGORY_PK,
                 CATEGORY.NAME,
                 CATEGORY.CODE
         )
                 .from(CATEGORY)
                 .fetch()
                 .into(CategoryDto.class);
     }

     /**
      * ##SELECT CATEGORY WITH ID##
      * @param id is identity of category
      * @return an optional of category
      */
      public Optional<CategoryDto> fetchCategoryById(int id) {
          Optional<CategoryDto> dto = context.select(
                  CATEGORY.CATEGORY_PK,
                  CATEGORY.NAME,
                  CATEGORY.CODE
          )
                  .from(CATEGORY)
                  .where(CATEGORY.CATEGORY_PK.eq(id))
                  .fetchOptionalInto(CategoryDto.class);
          return dto;
      }

      /**
       *  ##DELETE A CATEGORY##
       * @param id is identity of category
       * @return numbers of affected row
       */
       public int removeCategoryById(int id) {
           return context.deleteFrom(CATEGORY)
                   .where((CATEGORY.CATEGORY_PK.eq(id)))
                   .execute();
       }
}
