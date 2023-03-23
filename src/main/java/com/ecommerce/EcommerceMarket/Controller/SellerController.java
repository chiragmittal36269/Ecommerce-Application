package com.ecommerce.EcommerceMarket.Controller;

import com.ecommerce.EcommerceMarket.RequestDto.SellerRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.SellerResponseDto;
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
    public String addSeller(@RequestBody SellerRequestDto sellerRequestDto)
    {
        return sellerService.addSeller(sellerRequestDto);
    }

    @GetMapping("/getAllSellers")
    public List<SellerResponseDto> viewAllSeller()
    {

        return sellerService.viewAllSeller();
    }


}
