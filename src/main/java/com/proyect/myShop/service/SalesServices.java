/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyect.myShop.service;

import com.proyect.myShop.dto.SalesDTO;
import com.proyect.myShop.models.Sales;
import com.proyect.myShop.models.SalesProducts;
import com.proyect.myShop.repository.SalesRepository;
import com.proyect.myShop.validates.SalesValidate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anmoreno
 */

@Service
public class SalesServices {
    
    @Autowired
    SalesRepository salesRepository;
    
    @Autowired
    SalesValidate salesValidate;
    
    public void createSale(){
        
        salesValidate.validate();
        
        Sales sales = new Sales();
        
        
        List<SalesProducts> listSalesProducts = new ArrayList<SalesProducts>();
        
        
        sales.setListSalesProducts(listSalesProducts);
        
        salesRepository.save(sales);
    }
    
        public List<Sales> getAll() {
        return salesRepository.findAll();
    }

    public SalesDTO getDto(Sales entity) {
        SalesDTO salesDto = new SalesDTO();
        salesDto.setId(entity.getId());
        salesDto.setPersonName(entity.getPersonName());
        salesDto.setDocumentType(entity.getDocumentType());
        salesDto.setDocumentNumber(entity.getDocumentNumber());
        salesDto.setDateDelivery(entity.getDateDelivery());
        salesDto.setAddress(entity.getAddress());
        
        return salesDto;
    }
}
