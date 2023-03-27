package com.ecommerce.EcommerceMarket.Service;

import com.ecommerce.EcommerceMarket.ResponseDto.ItemResponseDto;

public interface ItemService {

    ItemResponseDto viewItem(int productId) throws Exception;

}
