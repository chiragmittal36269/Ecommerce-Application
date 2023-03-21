package com.ecommerce.EcommerceMarket.RequestDto;

import com.ecommerce.EcommerceMarket.Enum.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewProductByCategoryRequestDto {

    private String category;

}
