package com.chigovv.ecommerce.dao;

import com.chigovv.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//productCategory name of json entry, path - product-category2
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category2")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
