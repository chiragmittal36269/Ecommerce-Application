package com.ecommerce.EcommerceMarket.Service.impl;

import com.ecommerce.EcommerceMarket.Convertor.CustomerConvertor;
import com.ecommerce.EcommerceMarket.Model.Cart;
import com.ecommerce.EcommerceMarket.Model.Customer;
import com.ecommerce.EcommerceMarket.Repository.CustomerRepository;
import com.ecommerce.EcommerceMarket.RequestDto.CustomerRequestDto;
import com.ecommerce.EcommerceMarket.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public String addCustomer(CustomerRequestDto customerRequestDto)
    {
        Customer customer = CustomerConvertor.customerRequestDtoToCustomer(customerRequestDto);

        // allocate the cart to customer
        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        //set the cart in customer
        customer.setCart(cart);

        customerRepository.save(customer);

        return "Congrats!! Now you can shop anything :) ..";

    }

}
