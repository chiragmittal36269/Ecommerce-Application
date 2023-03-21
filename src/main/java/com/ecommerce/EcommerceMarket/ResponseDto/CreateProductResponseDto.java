package com.ecommerce.EcommerceMarket.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductResponseDto {

    private int id;

    private String Name;

    private int price;

    private int quantity;

}
