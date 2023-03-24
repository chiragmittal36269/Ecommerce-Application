package com.ecommerce.EcommerceMarket.Service;

import com.ecommerce.EcommerceMarket.Exception.ProductNotFoundException;
import com.ecommerce.EcommerceMarket.Model.Item;
import com.ecommerce.EcommerceMarket.Model.Product;
import com.ecommerce.EcommerceMarket.Repository.ItemRepository;
import com.ecommerce.EcommerceMarket.Repository.ProductRepository;
import com.ecommerce.EcommerceMarket.RequestDto.ItemRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.ItemResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ProductRepository productRepository;

    public ItemResponseDto viewItem(ItemRequestDto itemRequestDto) throws ProductNotFoundException {
        Product product;
        try {
            product = productRepository.findById(itemRequestDto.getProductId()).get();
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

        ItemResponseDto itemResponseDto = ItemResponseDto.builder()
                .productName(product.getName())
                .price(product.getPrice())
                .productCategory(product.getProductCategory())
                .productStatus(product.getProductStatus())
                .build();

        return itemResponseDto;
    }

}