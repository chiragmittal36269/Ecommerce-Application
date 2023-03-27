package com.ecommerce.EcommerceMarket.Service;

import com.ecommerce.EcommerceMarket.RequestDto.SellerRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.SellerResponseDto;

import java.util.List;

public interface SellerService {

    String addSeller(SellerRequestDto sellerRequestDto);

    List<SellerResponseDto> viewAllSeller();

}
