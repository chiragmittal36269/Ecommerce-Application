package com.ecommerce.EcommerceMarket.Service;

import com.ecommerce.EcommerceMarket.Enum.Category;
import com.ecommerce.EcommerceMarket.Model.Product;
import com.ecommerce.EcommerceMarket.Model.Seller;
import com.ecommerce.EcommerceMarket.Repository.ProductRepository;
import com.ecommerce.EcommerceMarket.Repository.SellerRepository;
import com.ecommerce.EcommerceMarket.RequestDto.CreateProductRequestDto;
import com.ecommerce.EcommerceMarket.RequestDto.ViewProductByCategoryRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.CreateProductResponseDto;
import com.ecommerce.EcommerceMarket.ResponseDto.ViewProductByCategoryResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    public CreateProductResponseDto addProduct(CreateProductRequestDto createProductRequestDto) {

        // create the product from request Dto
        Product product = new Product();
        product.setName(createProductRequestDto.getName());
        product.setPrice(createProductRequestDto.getPrice());
        product.setQuantity(createProductRequestDto.getQuantity());
        product.setCategory(createProductRequestDto.getCategory());

        // need to add the seller of particular product
        Seller seller = sellerRepository.findById(createProductRequestDto.getSellerID()).get();

        product.setSeller(seller);

        // save the product into repository
        Product updatedProduct = productRepository.save(product);

        // make the response Dto
        CreateProductResponseDto createProductResponseDto = new CreateProductResponseDto();
        createProductResponseDto.setId(updatedProduct.getId());
        createProductResponseDto.setName(updatedProduct.getName());
        createProductResponseDto.setPrice(updatedProduct.getPrice());
        createProductResponseDto.setQuantity(updatedProduct.getQuantity());

        // return the response Dto
        return createProductResponseDto;
    }

    public List<ViewProductByCategoryResponseDto> getProductByCategory(ViewProductByCategoryRequestDto viewProductByCategoryRequestDto) {
        String category = viewProductByCategoryRequestDto.getCategory();
        List<Product> productList = productRepository.getListOfProductsViaCategory(category);

        List<ViewProductByCategoryResponseDto> viewProductByCategoryResponseDtoList = new ArrayList<>();
        for(Product p : productList)
        {
            ViewProductByCategoryResponseDto viewProductByCategoryResponseDto = new ViewProductByCategoryResponseDto();

            viewProductByCategoryResponseDto.setName(p.getName());
            viewProductByCategoryResponseDto.setPrice(p.getPrice());
            viewProductByCategoryResponseDto.setQuantity(p.getQuantity());
            viewProductByCategoryResponseDto.setSellerName(p.getSeller().getName());

            viewProductByCategoryResponseDtoList.add(viewProductByCategoryResponseDto);
        }

        return viewProductByCategoryResponseDtoList;
    }
}
