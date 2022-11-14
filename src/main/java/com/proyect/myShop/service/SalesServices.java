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
import java.util.Map;
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

	public Sales create(Sales sales) {
		return salesRepository.save(sales);
	}

	public List<Sales> getAll(Map<String, String[]> filters) {
		List<Sales> listSales = new ArrayList<Sales>();
		
		String documentNumber = filters.get("documentNumber") == null ? null :"%"+filters.get("documentNumber")[0].toString()+"%";
		String documentType = filters.get("documentType") == null ? null : filters.get("documentType")[0].toString();
		
		if (!documentNumber.isEmpty() && !documentType.isEmpty()) {
			listSales = salesRepository.findByDocumentNumberLikeAndDocumentType(documentNumber,documentType);
		} else {
			listSales = salesRepository.findAll();
		}

		return listSales;
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

	public Sales getEntity(SalesDTO dto) {
		Sales sales = new Sales();
		sales.setDocumentType(dto.getDocumentType());
		sales.setDocumentNumber(dto.getDocumentNumber());
		sales.setPersonName(dto.getPersonName());
		sales.setDateDelivery(dto.getDateDelivery());
		sales.setAddress(dto.getAddress());
		return sales;
	}
}
