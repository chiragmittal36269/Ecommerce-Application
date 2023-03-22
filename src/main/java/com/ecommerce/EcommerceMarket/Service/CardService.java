package com.ecommerce.EcommerceMarket.Service;

import com.ecommerce.EcommerceMarket.Controller.CardController;
import com.ecommerce.EcommerceMarket.Convertor.CardConvertor;
import com.ecommerce.EcommerceMarket.Exception.CustomerNotFoundException;
import com.ecommerce.EcommerceMarket.Model.Card;
import com.ecommerce.EcommerceMarket.Model.Customer;
import com.ecommerce.EcommerceMarket.Repository.CardRepository;
import com.ecommerce.EcommerceMarket.Repository.CustomerRepository;
import com.ecommerce.EcommerceMarket.RequestDto.CardRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.CardDto;
import com.ecommerce.EcommerceMarket.ResponseDto.CardResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CustomerRepository customerRepository;

    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {
        Customer customer;
        try {
            customer = customerRepository.findById(cardRequestDto.getCustomerId()).get();
        } catch (Exception e) {
            throw new CustomerNotFoundException("Invalid customer id");
        }

        Card card = CardConvertor.cardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);

        // add the card to current card list of customer
        customer.getCardList().add(card);

        customerRepository.save(customer);

        // prepare response Dto
        CardResponseDto cardResponseDto = CardConvertor.cardToCardResponseDto(customer);

        return cardResponseDto;
    }
}
