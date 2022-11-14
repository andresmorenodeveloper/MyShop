/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyect.myShop.repository;

import com.proyect.myShop.models.Sales;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author anmoreno
 */
public interface SalesRepository extends JpaRepository<Sales, Long>{
	
	public List<Sales> findByDocumentNumberLikeAndDocumentType(String documentNumber,String documentType);
}
