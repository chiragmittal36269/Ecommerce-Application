package com.ecommerce.EcommerceMarket.Convertor;

import com.ecommerce.EcommerceMarket.Model.Card;
import com.ecommerce.EcommerceMarket.Model.Customer;
import com.ecommerce.EcommerceMarket.RequestDto.CardRequestDto;
import com.ecommerce.EcommerceMarket.ResponseDto.CardDto;
import com.ecommerce.EcommerceMarket.ResponseDto.CardResponseDto;

import java.util.ArrayList;
import java.util.List;

public class CardConvertor {

    public static Card cardRequestDtoToCard(CardRequestDto cardRequestDto)
    {
        Card card = Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cvv(cardRequestDto.getCvv())
                .cardType(cardRequestDto.getCardType())
                .build();

        return card;
    }

    public static CardResponseDto cardToCardResponseDto(Customer customer)
    {
        CardResponseDto cardResponseDto = new CardResponseDto();
        // set the customer name.
        cardResponseDto.setCustomerName(customer.getName());
        // convert every card to List<CardDto>
        List<CardDto> cardDtoList = new ArrayList<>();
        for(Card card1 : customer.getCardList())
        {
            CardDto cardDto = new CardDto();
            cardDto.setCardNo(card1.getCardNo());
            cardDto.setCardType(card1.getCardType());

            cardDtoList.add(cardDto);
        }
        // set the list of card.
        cardResponseDto.setCardDtoList(cardDtoList);

        return cardResponseDto;
    }
}
