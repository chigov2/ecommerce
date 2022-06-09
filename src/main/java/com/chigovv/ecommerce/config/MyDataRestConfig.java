package com.chigovv.ecommerce.config;

import com.chigovv.ecommerce.entity.Product;
import com.chigovv.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        //disable methods for Product - PUY POST DELETE
        HttpMethod[] unSupportedMethods = {HttpMethod.PUT, HttpMethod.POST,HttpMethod.DELETE};

        //will be applied for product repository
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unSupportedMethods))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unSupportedMethods));

        //will be applied for product category repository
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unSupportedMethods))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unSupportedMethods));

    }
}
