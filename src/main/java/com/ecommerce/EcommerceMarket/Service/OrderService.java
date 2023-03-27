package com.ecommerce.EcommerceMarket.Service;

import com.ecommerce.EcommerceMarket.RequestDto.OrderRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.OrderResponseDto;

public interface OrderService {

    OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws Exception;



}
