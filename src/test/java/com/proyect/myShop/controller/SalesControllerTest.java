package com.proyect.myShop.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.proyect.myShop.controllers.SalesController;
import com.proyect.myShop.dto.ProductsDTO;
import com.proyect.myShop.dto.SalesDTO;
import com.proyect.myShop.models.Sales;
import com.proyect.myShop.models.SalesProducts;
import com.proyect.myShop.service.SalesServices;
import com.proyect.myShop.utils.Utils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalesControllerTest {
	
	@Mock
	private SalesServices mockService;
	
	@Autowired
	private SalesController controller;

//	@Test
//	void givenTableWithDataWhenGetFindAllThenReturn200Response() {
//		List<SalesDTO> expectedResponse = new ArrayList<>();
//		List<ProductsDTO> listProducts = new ArrayList<ProductsDTO>();
//		listProducts.add(new ProductsDTO((long)1, "Buzo Blanco", "M, L, XL", "Masculino", "https://imagesmyshop.s3.amazonaws.com/buzoBlanco.png", (double) 120000));
//		
//		
//		expectedResponse.add(new SalesDTO((long)1, "CC", "1143127766", "ANDRES RAUL MORENO LOPEZ", null, "CALLE 44 # 1A - 16", listProducts));
//        Mockito.when(mockService.getAll()).thenReturn(expectedResponse);
//		
//        ResponseEntity<List<SalesDTO>> actualResponse = controller.getAll();
//        Assertions.assertNotNull(actualResponse);
//        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
//
//        List<SalesDTO> actualResponseBody = actualResponse.getBody();
//        Assertions.assertNotNull(actualResponseBody);
//        Assertions.assertFalse(actualResponseBody.isEmpty());
//        Assertions.assertEquals(expectedResponse, actualResponseBody);
//	}
//	
//    @Test
//    void givenTableEmptyWhenGetFindAllThenReturn200Response() {
//        Mockito.when(mockService.getAll()).thenReturn(Collections.emptyList());
//
//        ResponseEntity<List<SalesDTO>>  actualResponse = controller.getAll();
//        Assertions.assertNotNull(actualResponse);
//        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
//
//        List<SalesDTO> actualResponseBody = actualResponse.getBody();
//        Assertions.assertNotNull(actualResponseBody);
//        Assertions.assertTrue(actualResponseBody.isEmpty());
//    }
	
}
