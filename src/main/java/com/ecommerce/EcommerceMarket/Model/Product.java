package com.ecommerce.EcommerceMarket.Model;

import com.ecommerce.EcommerceMarket.Enum.Category;
import com.ecommerce.EcommerceMarket.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
    Category category;

    @ManyToOne
    @JoinColumn
    Seller seller;


    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    Item item;

}
