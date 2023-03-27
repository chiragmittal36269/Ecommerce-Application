package com.ecommerce.EcommerceMarket.Service;

import com.ecommerce.EcommerceMarket.RequestDto.OrderRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.OrderResponseDto;

import java.util.List;

public interface CartService {

    String addToCart(OrderRequestDto orderRequestDto) throws Exception;

    List<OrderResponseDto> checkoutCart(int customerId) throws Exception;



}
