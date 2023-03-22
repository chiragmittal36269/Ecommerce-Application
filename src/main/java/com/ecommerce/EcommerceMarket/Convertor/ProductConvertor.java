package com.ecommerce.EcommerceMarket.Convertor;

import com.ecommerce.EcommerceMarket.Enum.ProductStatus;
import com.ecommerce.EcommerceMarket.Model.Product;
import com.ecommerce.EcommerceMarket.RequestDto.ProductRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.ProductResponseDto;

public class ProductConvertor {

    public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto)
    {
        Product product = Product.builder()
                .Name(productRequestDto.getName())
                .productCategory(productRequestDto.getProductCategory())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .productStatus(ProductStatus.AVAILABLE)
                .build();

        return product;
    }

    public static ProductResponseDto ProductToProductResponseDto(Product product)
    {
        ProductResponseDto productResponseDto = ProductResponseDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .productStatus(product.getProductStatus())
                .build();

        return productResponseDto;
    }


}
