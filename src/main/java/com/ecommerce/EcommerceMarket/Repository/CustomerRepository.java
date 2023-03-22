package com.ecommerce.EcommerceMarket.Repository;

import com.ecommerce.EcommerceMarket.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
