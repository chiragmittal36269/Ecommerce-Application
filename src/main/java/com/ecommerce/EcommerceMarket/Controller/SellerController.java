package com.ecommerce.EcommerceMarket.Controller;

import com.ecommerce.EcommerceMarket.RequestDto.CreateSellerRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.CreateSellerResponseDto;
import com.ecommerce.EcommerceMarket.ResponseDto.ViewAllSellerResponseDto;
import com.ecommerce.EcommerceMarket.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/add")
    public CreateSellerResponseDto addSeller(@RequestBody CreateSellerRequestDto createSellerRequestDto)
    {
        return sellerService.addSeller(createSellerRequestDto);
    }

    @GetMapping("/getAllSellers")
    public List<ViewAllSellerResponseDto> viewAllSeller()
    {
        return sellerService.viewAllSeller();
    }
}
