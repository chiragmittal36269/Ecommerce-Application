package com.ecommerce.EcommerceMarket.Service.impl;

import com.ecommerce.EcommerceMarket.Convertor.CardConvertor;
import com.ecommerce.EcommerceMarket.Exception.CustomerNotFoundException;
import com.ecommerce.EcommerceMarket.Model.Card;
import com.ecommerce.EcommerceMarket.Model.Customer;
import com.ecommerce.EcommerceMarket.Repository.CardRepository;
import com.ecommerce.EcommerceMarket.Repository.CustomerRepository;
import com.ecommerce.EcommerceMarket.RequestDto.CardRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.CardResponseDto;
import com.ecommerce.EcommerceMarket.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
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

    @Override
    public String deleteCard(int id) {
        cardRepository.deleteById(id);

        return "Card is successfully deleted";
    }

    @Override
    public String deleteCard(String cardNo) {
        Card card = cardRepository.findByCardNo(cardNo);

        cardRepository.delete(card);

        return "Card has been deleted successfully";
    }

    @Override
    public String deleteByCustomerId(int id) {
        Customer customer = customerRepository.findById(id).get();

        for (Card card : customer.getCardList()) {
            cardRepository.delete(card);
        }

        return "All the card has been deleted";
    }
}
