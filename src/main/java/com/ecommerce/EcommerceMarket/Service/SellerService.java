package com.ecommerce.EcommerceMarket.Service;

import com.ecommerce.EcommerceMarket.Model.Seller;
import com.ecommerce.EcommerceMarket.Repository.SellerRepository;
import com.ecommerce.EcommerceMarket.RequestDto.CreateSellerRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.CreateSellerResponseDto;
import com.ecommerce.EcommerceMarket.ResponseDto.ViewAllSellerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;


    public CreateSellerResponseDto addSeller(CreateSellerRequestDto createSellerRequestDto) {

        // create the seller and add the details into it from requestDTO
        Seller seller = new Seller();
        seller.setName(createSellerRequestDto.getName());
        seller.setMobile(createSellerRequestDto.getMobile());
        seller.setEmail(createSellerRequestDto.getEmail());
        seller.setPanCard(createSellerRequestDto.getPanCard());

        // save the seller data into database.
        Seller updatedSeller = sellerRepository.save(seller);

        // make the response DTO
        CreateSellerResponseDto createSellerResponseDto = new CreateSellerResponseDto();
        createSellerResponseDto.setId(updatedSeller.getId());
        createSellerResponseDto.setName(updatedSeller.getName());
        createSellerResponseDto.setEmail(updatedSeller.getEmail());
        createSellerResponseDto.setMobile(updatedSeller.getMobile());
        createSellerResponseDto.setPanCard(updatedSeller.getPanCard());

        // return the response DTO
        return createSellerResponseDto;
    }

    public List<ViewAllSellerResponseDto> viewAllSeller() {

        List<Seller> sellers = sellerRepository.findAll();

        List<ViewAllSellerResponseDto> viewAllSellerResponseDtos = new ArrayList<>();
        for(Seller s : sellers)
        {
            ViewAllSellerResponseDto viewAllSellerResponseDto = new ViewAllSellerResponseDto();
            viewAllSellerResponseDto.setName(s.getName());
            viewAllSellerResponseDto.setEmail(s.getEmail());
            viewAllSellerResponseDto.setMobile(s.getMobile());
            viewAllSellerResponseDto.setPanCard(s.getPanCard());

            viewAllSellerResponseDtos.add(viewAllSellerResponseDto);
        }

        return viewAllSellerResponseDtos;
    }
}
