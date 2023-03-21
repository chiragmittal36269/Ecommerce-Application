package com.ecommerce.EcommerceMarket.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewProductByCategoryResponseDto {

    private String name;

    private int price;

    private int quantity;

    private String sellerName;
}
