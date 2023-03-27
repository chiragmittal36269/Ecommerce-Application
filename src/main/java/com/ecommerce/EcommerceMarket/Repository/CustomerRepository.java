package com.ecommerce.EcommerceMarket.Repository;

import com.ecommerce.EcommerceMarket.Model.Customer;
import com.ecommerce.EcommerceMarket.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // inbuilt custom
    List<Customer> findByAge(int age);

    Customer findByEmail(String email);




    // custom query
    @Query(value = "Select * from Customer c where c.age>=:startAge and c.age<=:endAge", nativeQuery = true)
    List<Customer> findAllAge(int startAge, int endAge);

}
