/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyect.myShop.service;

import com.proyect.myShop.dto.ProductsDTO;
import com.proyect.myShop.dto.SalesDTO;
import com.proyect.myShop.models.Products;
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
	
	@Autowired
	ProductsService productsService;

	public Sales create(Sales sales) {
		return salesRepository.save(sales);
	}

	public List<SalesDTO> getAll(Map<String, String[]> filters) {
		List<Sales> listSales = new ArrayList<Sales>();
		List<SalesDTO> listSalesDto = new ArrayList<SalesDTO>();
		
		String documentNumber = filters.get("documentNumber") == null ? null : "%" + filters.get("documentNumber")[0].toString() + "%";
		String documentType = filters.get("documentType") == null ? null : filters.get("documentType")[0].toString();

		if (documentNumber != null && documentType != null) {
			listSales = salesRepository.findByDocumentNumberLikeAndDocumentType(documentNumber, documentType);
		} else {
			listSales = salesRepository.findAll();
		}
		
        listSales.forEach((entity) -> {
            listSalesDto.add(getDto(entity));
        });

		return listSalesDto;
	}

	public SalesDTO getDto(Sales entity) {
		SalesDTO salesDto = new SalesDTO();
		salesDto.setId(entity.getId());
		salesDto.setPersonName(entity.getPersonName());
		salesDto.setDocumentType(entity.getDocumentType());
		salesDto.setDocumentNumber(entity.getDocumentNumber());
		salesDto.setDateDelivery(entity.getDateDelivery());
		salesDto.setAddress(entity.getAddress());

		List<ProductsDTO> listProductsDto = new ArrayList<ProductsDTO>();
		if (entity.getListSalesProducts() != null) {
			
			entity.getListSalesProducts().forEach((salesProducts) -> {
                listProductsDto.add(productsService.getDto(salesProducts.getProduct()));
            });
		}
		salesDto.setListProducts(listProductsDto);
		return salesDto;
	}

	public Sales getEntity(SalesDTO dto) {
		Sales sales = new Sales();
		sales.setDocumentType(dto.getDocumentType());
		sales.setDocumentNumber(dto.getDocumentNumber());
		sales.setPersonName(dto.getPersonName());
		sales.setDateDelivery(dto.getDateDelivery());
		sales.setAddress(dto.getAddress());
		
		List<SalesProducts> listSalesProducts = new ArrayList<SalesProducts>();
		if(dto.getListProducts() != null) {
			for(ProductsDTO productDto : dto.getListProducts()) {
				Products product = productsService.getProductById(productDto.getId());
				
				SalesProducts salesProducts = new SalesProducts();
				salesProducts.setProduct(product);
				salesProducts.setSale(sales);
				salesProducts.setQuantity((long) 1);
				salesProducts.setPrice(product.getPrice());
				
				listSalesProducts.add(salesProducts);
			}
		}
		sales.setListSalesProducts(listSalesProducts);
		return sales;
	}
}
