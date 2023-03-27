package com.ecommerce.EcommerceMarket.Service.impl;

import com.ecommerce.EcommerceMarket.Convertor.SellerConvertor;
import com.ecommerce.EcommerceMarket.Model.Seller;
import com.ecommerce.EcommerceMarket.Repository.SellerRepository;
import com.ecommerce.EcommerceMarket.RequestDto.SellerRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.SellerResponseDto;
import com.ecommerce.EcommerceMarket.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

//    // without using convertor and builder
//    public CreateSellerResponseDto addSeller(CreateSellerRequestDto createSellerRequestDto) {
//
//        // create the seller and add the details into it from requestDTO
//        Seller seller = new Seller();
//        seller.setName(createSellerRequestDto.getName());
//        seller.setMobile(createSellerRequestDto.getMobile());
//        seller.setEmail(createSellerRequestDto.getEmail());
//        seller.setPanCard(createSellerRequestDto.getPanCard());
//
//        // save the seller data into database.
//        Seller updatedSeller = sellerRepository.save(seller);
//
//        // make the response DTO
//        CreateSellerResponseDto createSellerResponseDto = new CreateSellerResponseDto();
//        createSellerResponseDto.setId(updatedSeller.getId());
//        createSellerResponseDto.setName(updatedSeller.getName());
//        createSellerResponseDto.setEmail(updatedSeller.getEmail());
//        createSellerResponseDto.setMobile(updatedSeller.getMobile());
//        createSellerResponseDto.setPanCard(updatedSeller.getPanCard());
//
//        // return the response DTO
//        return createSellerResponseDto;
//    }
//
//    // without using convertor and builder
//    public List<ViewAllSellerResponseDto> viewAllSeller() {
//
//        List<Seller> sellers = sellerRepository.findAll();
//
//        List<ViewAllSellerResponseDto> viewAllSellerResponseDtos = new ArrayList<>();
//        for(Seller s : sellers)
//        {
//            ViewAllSellerResponseDto viewAllSellerResponseDto = new ViewAllSellerResponseDto();
//            viewAllSellerResponseDto.setName(s.getName());
//            viewAllSellerResponseDto.setEmail(s.getEmail());
//            viewAllSellerResponseDto.setMobile(s.getMobile());
//            viewAllSellerResponseDto.setPanCard(s.getPanCard());
//
//            viewAllSellerResponseDtos.add(viewAllSellerResponseDto);
//        }
//
//        return viewAllSellerResponseDtos;
//    }

    // with the help of builder
    @Override
    public String addSeller(SellerRequestDto sellerRequestDto) {

        // convert requestDto to Seller with the help of convertor
        Seller seller = SellerConvertor.sellerRequestDtoToSeller(sellerRequestDto);

        sellerRepository.save(seller);

        return "Congrats!! Now you can sell on our site :)..";
    }

    @Override
    public List<SellerResponseDto> viewAllSeller() {

        List<Seller> sellers = sellerRepository.findAll();

        List<SellerResponseDto> sellerResponseDtos = new ArrayList<>();
        for (Seller s : sellers) {
            SellerResponseDto sellerResponseDto = SellerConvertor.sellerToSellerResponseDto(s);

            sellerResponseDtos.add(sellerResponseDto);
        }

        return sellerResponseDtos;
    }

    @Override
    public SellerResponseDto getSeller(String panCard) {
        Seller seller = sellerRepository.findByPanCard(panCard);

        SellerResponseDto sellerResponseDto = SellerConvertor.sellerToSellerResponseDto(seller);

        return sellerResponseDto;
    }

    @Override
    public List<SellerResponseDto> getAllSeller(int startAge, int endAge) {
        List<Seller> sellerList = sellerRepository.findAllAge(startAge, endAge);

        List<SellerResponseDto> sellerResponseDtos = new ArrayList<>();

        for (Seller seller : sellerList) {
            SellerResponseDto sellerResponseDto = SellerConvertor.sellerToSellerResponseDto(seller);

            sellerResponseDtos.add(sellerResponseDto);
        }

        return sellerResponseDtos;
    }

    @Override
    public String deleteSeller(int sellerId) {
        sellerRepository.deleteById(sellerId);

        return "Seller has been deleted Successfully.";
    }

    @Override
    public String deleteAllSeller() {
        sellerRepository.deleteAll();
        return "All Sellers data have been deleted";
    }

    @Override
    public List<SellerResponseDto> getByAge(int age) {
        List<Seller> sellerList = sellerRepository.findByAge(age);

        List<SellerResponseDto> sellerResponseDtos = new ArrayList<>();
        for (Seller seller : sellerList) {
            SellerResponseDto sellerResponseDto = SellerConvertor.sellerToSellerResponseDto(seller);

            sellerResponseDtos.add(sellerResponseDto);
        }
        return sellerResponseDtos;
    }
}
