package com.ecommerce.EcommerceMarket.ResponseDto;

import com.ecommerce.EcommerceMarket.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {

    private String cardNo;
    private CardType cardType;
}
