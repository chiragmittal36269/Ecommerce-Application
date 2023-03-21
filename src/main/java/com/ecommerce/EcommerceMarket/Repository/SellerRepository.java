package com.ecommerce.EcommerceMarket.Repository;

import com.ecommerce.EcommerceMarket.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
}
