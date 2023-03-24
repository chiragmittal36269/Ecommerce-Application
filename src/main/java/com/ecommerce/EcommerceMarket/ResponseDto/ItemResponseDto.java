package com.ecommerce.EcommerceMarket.ResponseDto;

import com.ecommerce.EcommerceMarket.Enum.ProductCategory;
import com.ecommerce.EcommerceMarket.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemResponseDto {

    private String productName;
    private int price;
    private ProductStatus productStatus;
    private ProductCategory productCategory;

}
