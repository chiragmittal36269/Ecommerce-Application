package com.ecommerce.EcommerceMarket.Convertor;

import com.ecommerce.EcommerceMarket.Model.Seller;
import com.ecommerce.EcommerceMarket.RequestDto.SellerRequestDto;

public class SellerConvertor {

    public static Seller sellerRequestDtoToSeller(SellerRequestDto sellerRequestDto)
    {
        Seller seller = Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .mobile(sellerRequestDto.getMobile())
                .panCard(sellerRequestDto.getPanCard())
                .build();

        return seller;
    }

}
