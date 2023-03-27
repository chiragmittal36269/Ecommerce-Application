package com.ecommerce.EcommerceMarket.Controller;

import com.ecommerce.EcommerceMarket.RequestDto.CustomerRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.CustomerResponseDto;
import com.ecommerce.EcommerceMarket.Service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @PostMapping("/add")
    public String addCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        return customerService.addCustomer(customerRequestDto);
    }


    @GetMapping("/get")
    public CustomerResponseDto getById(@RequestParam("id") int customerId) {
        return customerService.getById(customerId);
    }
}
