package com.ecommerce.EcommerceMarket.Controller;

import com.ecommerce.EcommerceMarket.RequestDto.CreateProductRequestDto;
import com.ecommerce.EcommerceMarket.RequestDto.ViewProductByCategoryRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.CreateProductResponseDto;
import com.ecommerce.EcommerceMarket.ResponseDto.ViewProductByCategoryResponseDto;
import com.ecommerce.EcommerceMarket.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public CreateProductResponseDto addProduct(@RequestBody CreateProductRequestDto createProductRequestDto)
    {
        return productService.addProduct(createProductRequestDto);
    }

    @GetMapping("/getProductByCategory")
    public List<ViewProductByCategoryResponseDto> getProductByCategory(@RequestBody ViewProductByCategoryRequestDto viewProductByCategoryRequestDto)
    {
        return productService.getProductByCategory(viewProductByCategoryRequestDto);
    }
}
