/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyect.myShop.service;

import com.proyect.myShop.dto.ProductsDTO;
import com.proyect.myShop.models.Products;
import com.proyect.myShop.repository.ProductsRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anmoreno
 */
@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;
    
    public ProductsDTO getDto(Products entity){
        ProductsDTO productDto = new  ProductsDTO();
        productDto.setId(entity.getId());
        productDto.setImage(entity.getImage());
        productDto.setName(entity.getName());
        productDto.setPrice(entity.getPrice());
        productDto.setSize(entity.getSize());
        productDto.setGender(entity.getGender());
        return productDto;
        
    }

    public List<ProductsDTO> getAll() {
    	List<ProductsDTO> listProductsDto = new ArrayList<ProductsDTO>();
    	
    	productsRepository.findAll().forEach((entity) -> {
            listProductsDto.add(getDto(entity));
        });
    	
        return listProductsDto;
    }
    
    public Products getProductById(Long productId) {
    	return productsRepository.getById(productId);
    }

}
