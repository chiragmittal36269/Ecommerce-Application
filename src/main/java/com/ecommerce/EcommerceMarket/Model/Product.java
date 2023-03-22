package com.ecommerce.EcommerceMarket.Model;

import com.ecommerce.EcommerceMarket.Enum.ProductCategory;
import com.ecommerce.EcommerceMarket.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Name;

    private int price;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;


    @Enumerated(EnumType.STRING)
    ProductCategory productCategory;

    @ManyToOne
    @JoinColumn
    Seller seller;


    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    Item item;

}
