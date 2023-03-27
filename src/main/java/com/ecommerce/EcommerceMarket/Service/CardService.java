package com.ecommerce.EcommerceMarket.Service;

import com.ecommerce.EcommerceMarket.RequestDto.CardRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.CardResponseDto;

public interface CardService {

    CardResponseDto addCard(CardRequestDto cardRequestDto) throws Exception;

    String deleteCard(int id);

    String deleteCard(String cardNo);

    String deleteByCustomerId(int id);
}
