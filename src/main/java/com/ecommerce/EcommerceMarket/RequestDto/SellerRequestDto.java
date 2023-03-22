package com.ecommerce.EcommerceMarket.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerRequestDto {

    private String name;
    private String email;
    private String mobile;
    private String panCard;

}
