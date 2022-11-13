/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyect.myShop.dto;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author anmoreno
 */
@Getter
@Setter
public class SalesDTO {
    
    private Long id;
    private String documentType;
    private String documentNumber;
    private String personName;
    private Timestamp dateDelivery;
    private String address;
}
