package com.ecommerce.EcommerceMarket.Repository;

import com.ecommerce.EcommerceMarket.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
}