package com.ecommerce.EcommerceMarket.Service;

import com.ecommerce.EcommerceMarket.RequestDto.CustomerRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.CustomerResponseDto;

public interface CustomerService {

    String addCustomer(CustomerRequestDto customerRequestDto);

    CustomerResponseDto getById(int customerId);

}
