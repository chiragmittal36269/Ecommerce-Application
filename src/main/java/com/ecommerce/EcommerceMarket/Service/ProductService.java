package com.ecommerce.EcommerceMarket.Service;

import com.ecommerce.EcommerceMarket.Enum.ProductCategory;
import com.ecommerce.EcommerceMarket.RequestDto.ProductRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws Exception;

    List<ProductResponseDto> getProductByCategory(ProductCategory productCategory);

}
