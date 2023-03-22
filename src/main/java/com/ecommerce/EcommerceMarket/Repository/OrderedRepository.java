package com.ecommerce.EcommerceMarket.Repository;

import com.ecommerce.EcommerceMarket.Model.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedRepository extends JpaRepository<Ordered, Integer> {
}
