package com.ecommerce.EcommerceMarket.Service;

import com.ecommerce.EcommerceMarket.Exception.CustomerNotFoundException;
import com.ecommerce.EcommerceMarket.Exception.ProductNotFoundException;
import com.ecommerce.EcommerceMarket.Model.*;
import com.ecommerce.EcommerceMarket.Repository.CustomerRepository;
import com.ecommerce.EcommerceMarket.Repository.ProductRepository;
import com.ecommerce.EcommerceMarket.RequestDto.ItemRequestDto;
import com.ecommerce.EcommerceMarket.RequestDto.OrderRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.ItemResponseDto;
import com.ecommerce.EcommerceMarket.ResponseDto.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.InsufficientResourcesException;

@Service
public class OrderService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ItemService itemService;

    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws CustomerNotFoundException, ProductNotFoundException, InsufficientResourcesException {

        //check customer is available
        Customer customer;
        try {
            customer = customerRepository.findById(orderRequestDto.getCustomerId()).get();
        } catch (Exception e) {
            throw new CustomerNotFoundException("Invalid customer id");
        }

        //check product is available
        Product product;
        try {
            product = productRepository.findById(orderRequestDto.getProductId()).get();
        } catch (Exception e) {
            throw new ProductNotFoundException("Invalid product id");
        }

        //check the quantity of product
        if (product.getQuantity() < orderRequestDto.getRequiredQuantity()) {
            throw new InsufficientResourcesException("Insufficient quantity sorry...");
        }

        //view item
        ItemResponseDto itemResponseDto = itemService.viewItem(orderRequestDto.getProductId());
        //get item using product
        Item item = product.getItem();


        // prepare the ordered
        int totalCost = orderRequestDto.getRequiredQuantity() * product.getPrice(); // calculate the total cost
        int deliveryCharge = 0;
        if(totalCost < 500)
        {
            deliveryCharge = 50;
            totalCost += deliveryCharge;
        }
        Ordered ordered = Ordered.builder()
                .totalCost(totalCost)
                .deliveryCharge(deliveryCharge)
                .customer(customer)
                .build();

        ordered.getItemList().add(item);

        //prepare the card String
        Card card = customer.getCardList().get(0);
        
        String cardUsed = "";
        for(int i=0; i<=card.getCardNo()-4; i++)
        {
            cardUsed
        }
    }

}
