package com.ecommerce.EcommerceMarket.Service.impl;

import com.ecommerce.EcommerceMarket.Convertor.ProductConvertor;
import com.ecommerce.EcommerceMarket.Enum.ProductCategory;
import com.ecommerce.EcommerceMarket.Exception.SellerNotPresentException;
import com.ecommerce.EcommerceMarket.Model.Product;
import com.ecommerce.EcommerceMarket.Model.Seller;
import com.ecommerce.EcommerceMarket.Repository.ProductRepository;
import com.ecommerce.EcommerceMarket.Repository.SellerRepository;
import com.ecommerce.EcommerceMarket.RequestDto.ProductRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.ProductResponseDto;
import com.ecommerce.EcommerceMarket.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;


//    // without using convertor and builder
//    public CreateProductResponseDto addProduct(CreateProductRequestDto createProductRequestDto) {
//
//        // create the product from request Dto
//        Product product = new Product();
//        product.setName(createProductRequestDto.getName());
//        product.setPrice(createProductRequestDto.getPrice());
//        product.setQuantity(createProductRequestDto.getQuantity());
//        product.setCategory(createProductRequestDto.getCategory());
//
//        // need to add the seller of particular product
//        Seller seller = sellerRepository.findById(createProductRequestDto.getSellerID()).get();
//
//        product.setSeller(seller);
//
//        // save the product into repository
//        Product updatedProduct = productRepository.save(product);
//
//        // make the response Dto
//        CreateProductResponseDto createProductResponseDto = new CreateProductResponseDto();
//        createProductResponseDto.setId(updatedProduct.getId());
//        createProductResponseDto.setName(updatedProduct.getName());
//        createProductResponseDto.setPrice(updatedProduct.getPrice());
//        createProductResponseDto.setQuantity(updatedProduct.getQuantity());
//
//        // return the response Dto
//        return createProductResponseDto;
//    }
//
//
//    // without using convertor and builder
//    public List<ViewProductByCategoryResponseDto> getProductByCategory(ViewProductByCategoryRequestDto viewProductByCategoryRequestDto) {
//        String category = viewProductByCategoryRequestDto.getCategory();
//        List<Product> productList = productRepository.getListOfProductsViaCategory(category);
//
//        List<ViewProductByCategoryResponseDto> viewProductByCategoryResponseDtoList = new ArrayList<>();
//        for(Product p : productList)
//        {
//            ViewProductByCategoryResponseDto viewProductByCategoryResponseDto = new ViewProductByCategoryResponseDto();
//
//            viewProductByCategoryResponseDto.setName(p.getName());
//            viewProductByCategoryResponseDto.setPrice(p.getPrice());
//            viewProductByCategoryResponseDto.setQuantity(p.getQuantity());
//            viewProductByCategoryResponseDto.setSellerName(p.getSeller().getName());
//
//            viewProductByCategoryResponseDtoList.add(viewProductByCategoryResponseDto);
//        }
//
//        return viewProductByCategoryResponseDtoList;
//    }


    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotPresentException {

        Seller seller;
        try
        {
            seller = sellerRepository.findById(productRequestDto.getSellerID()).get();
        }
        catch (Exception e)
        {
            throw new SellerNotPresentException("Invaild seller id");
        }

        // make the Product object using builder and convertor
        Product product = ProductConvertor.productRequestDtoToProduct(productRequestDto);

        // set seller in product
        product.setSeller(seller);

        //add product in seller
        seller.getProductList().add(product);

        // parent can save the child also because or cascade
        sellerRepository.save(seller);

        // convert the seller to responseDto
        ProductResponseDto productResponseDto = ProductConvertor.ProductToProductResponseDto(product);

        return productResponseDto;
    }


    @Override
    public List<ProductResponseDto> getProductByCategory(ProductCategory productCategory)
    {
        List<Product> products = productRepository.findAllByProductCategory(productCategory);

        // prepare the list of responseDto
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product p : products)
        {
            ProductResponseDto productResponseDto = ProductConvertor.ProductToProductResponseDto(p);

            productResponseDtos.add(productResponseDto);
        }

        return productResponseDtos;
    }
}