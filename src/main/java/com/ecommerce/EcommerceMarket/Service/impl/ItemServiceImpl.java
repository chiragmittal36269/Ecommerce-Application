package com.ecommerce.EcommerceMarket.Service.impl;

import com.ecommerce.EcommerceMarket.Exception.ProductNotFoundException;
import com.ecommerce.EcommerceMarket.Model.Item;
import com.ecommerce.EcommerceMarket.Model.Product;
import com.ecommerce.EcommerceMarket.Repository.ItemRepository;
import com.ecommerce.EcommerceMarket.Repository.ProductRepository;
import com.ecommerce.EcommerceMarket.ResponseDto.ItemResponseDto;
import com.ecommerce.EcommerceMarket.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ProductRepository productRepository;

    public ItemResponseDto viewItem(int productId) throws ProductNotFoundException {
        Product product;
        try {
            product = productRepository.findById(productId).get();
        } catch (Exception e) {
            throw new ProductNotFoundException("Invalid product id");
        }

        Item item = Item.builder()
                .requiredQuantity(0)
                .product(product)
                .build();

        // set the item in product
        product.setItem(item);

        //saving both item and product
        productRepository.save(product);

        //make the responseDto
        ItemResponseDto itemResponseDto = ItemResponseDto.builder()
                .productName(product.getName())
                .price(product.getPrice())
                .productCategory(product.getProductCategory())
                .productStatus(product.getProductStatus())
                .build();

        return itemResponseDto;
    }

}
