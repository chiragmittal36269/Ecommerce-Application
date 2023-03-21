package com.ecommerce.EcommerceMarket.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewAllSellerResponseDto {

    private String name;

    private String email;

    private String mobile;

    private String panCard;

}
