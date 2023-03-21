package com.ecommerce.EcommerceMarket.RequestDto;

import com.ecommerce.EcommerceMarket.Enum.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequestDto {

    private String name;

    private int price;

    private int quantity;

    private Category category;

    private int sellerID;

}
