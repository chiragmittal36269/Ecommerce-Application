package com.ecommerce.EcommerceMarket.Controller;

import com.ecommerce.EcommerceMarket.RequestDto.SellerRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.SellerResponseDto;
import com.ecommerce.EcommerceMarket.Service.impl.SellerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerServiceImpl sellerService;

    @PostMapping("/add")
    public String addSeller(@RequestBody SellerRequestDto sellerRequestDto) {
        return sellerService.addSeller(sellerRequestDto);
    }

    @GetMapping("/getAllSellers")
    public List<SellerResponseDto> viewAllSeller() {
        return sellerService.viewAllSeller();
    }


    @GetMapping("/get/{pancard")
    public SellerResponseDto getSeller(@PathVariable("pancard") String panCard) {
        return sellerService.getSeller(panCard);
    }


    @GetMapping("/get")
    public List<SellerResponseDto> getAllSeller(@RequestParam int startAge, @RequestParam int endAge) {
        return sellerService.getAllSeller(startAge, endAge);
    }


    @DeleteMapping("/delete/{sellerId}")
    public String deleteSeller(@PathVariable("sellerId") int sellerId) {
        return sellerService.deleteSeller(sellerId);
    }


    @DeleteMapping("/deleteAll")
    public String deleteAllSeller()
    {
        return sellerService.deleteAllSeller();
    }
}
