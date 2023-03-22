package com.ecommerce.EcommerceMarket.Repository;

import com.ecommerce.EcommerceMarket.Enum.ProductCategory;
import com.ecommerce.EcommerceMarket.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // custom query
//    @Query(value = "select * from product p where p.category=:category", nativeQuery = true)
//    List<Product> getListOfProductsViaCategory(String category);

    //using findAllByProductCategory
    //ORM is written the whole code for us.
    List<Product> findAllByProductCategory(ProductCategory productCategory);
}
