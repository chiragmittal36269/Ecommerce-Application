package com.ecommerce.EcommerceMarket.Convertor;

import com.ecommerce.EcommerceMarket.Model.Seller;
import com.ecommerce.EcommerceMarket.RequestDto.SellerRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.SellerResponseDto;

import java.util.ArrayList;
import java.util.List;

public class SellerConvertor {

    public static Seller sellerRequestDtoToSeller(SellerRequestDto sellerRequestDto)
    {
        Seller seller = Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .mobile(sellerRequestDto.getMobile())
                .panCard(sellerRequestDto.getPanCard())
                .age(sellerRequestDto.getAge())
                .build();

        return seller;
    }


    public static SellerResponseDto sellerToSellerResponseDto(Seller seller)
    {
        SellerResponseDto sellerResponseDto = SellerResponseDto.builder()
                .name(seller.getName())
                .email(seller.getEmail())
                .mobile(seller.getMobile())
                .panCard(seller.getPanCard())
                .age(seller.getAge())
                .build();

        return sellerResponseDto;
    }

}
