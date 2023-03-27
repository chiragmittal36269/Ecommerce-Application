package com.ecommerce.EcommerceMarket.Controller;

import com.ecommerce.EcommerceMarket.Exception.CustomerNotFoundException;
import com.ecommerce.EcommerceMarket.RequestDto.CardRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.CardResponseDto;
import com.ecommerce.EcommerceMarket.Service.CardService;
import com.ecommerce.EcommerceMarket.Service.impl.CardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardServiceImpl cardService;

    @PostMapping("/add")
    public ResponseEntity addCard(@RequestBody CardRequestDto cardRequestDto) throws CustomerNotFoundException {
        CardResponseDto cardResponseDto;
        try {
            cardResponseDto = cardService.addCard(cardRequestDto);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(cardResponseDto, HttpStatus.CREATED);
    }
}
