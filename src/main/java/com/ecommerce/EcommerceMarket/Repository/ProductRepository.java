package com.ecommerce.EcommerceMarket.Repository;

import com.ecommerce.EcommerceMarket.Enum.Category;
import com.ecommerce.EcommerceMarket.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


    @Query(value = "select * from product p where p.category=:category", nativeQuery = true)
    List<Product> getListOfProductsViaCategory(String category);
}
