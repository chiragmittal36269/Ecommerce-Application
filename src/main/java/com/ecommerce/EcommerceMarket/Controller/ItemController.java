package com.ecommerce.EcommerceMarket.Controller;

import com.ecommerce.EcommerceMarket.RequestDto.ItemRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.ItemResponseDto;
import com.ecommerce.EcommerceMarket.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/get/{productId}")
    public ResponseEntity viewItem(@PathVariable("productId") int productId) {
        ItemResponseDto itemResponseDto;
        try {
            itemResponseDto = itemService.viewItem(productId);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(itemResponseDto, HttpStatus.ACCEPTED);
    }
}
