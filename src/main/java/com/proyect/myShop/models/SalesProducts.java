/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyect.myShop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author anmoreno
 */
@Getter
@Setter
@Entity
@Table(name = "sales_products")
public class SalesProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale", referencedColumnName = "id")
    private Sales sale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product", referencedColumnName = "id")
    private Products product;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "price")
    private Double price;
}
