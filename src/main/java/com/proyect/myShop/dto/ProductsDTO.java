/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyect.myShop.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author anmoreno
 */
@Getter
@Setter
public class ProductsDTO {
    private Long id;
    private String name;
    private String size;
    private String gender;
    private String image;
    private Double price;
}
