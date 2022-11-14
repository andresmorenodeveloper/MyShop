package com.proyect.myShop.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

import com.proyect.myShop.controllers.ProductsController;
import com.proyect.myShop.dto.ProductsDTO;
import com.proyect.myShop.service.ProductsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsControllerTest {

	@Mock
	private ProductsService mockService;

	@Autowired
	private ProductsController controller;

	@Test
	void givenTableWithDataWhenGetFindAllThenReturn200Response() {
		try {
			List<ProductsDTO> expectedResponse = new ArrayList<>();
			
			expectedResponse.add(new ProductsDTO((long)1, "Ramera Negra", "M, L, XL", "Masculino", "https://imagesmyshop.s3.amazonaws.com/ropa.png", (double) 120000));
			expectedResponse.add(new ProductsDTO((long)2, "Jean Azul", "M, L", "Femenino", "", (double) 200000));
	        Mockito.when(mockService.getAll()).thenReturn(expectedResponse);
			
	        ResponseEntity<List<ProductsDTO>> actualResponse = controller.getAll();
	        Assertions.assertNotNull(actualResponse);
	        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());

	        List<ProductsDTO> actualResponseBody = actualResponse.getBody();
	        Assertions.assertNotNull(actualResponseBody);
	        Assertions.assertFalse(actualResponseBody.isEmpty());
	        Assertions.assertEquals(expectedResponse, actualResponseBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
    @Test
    void givenTableEmptyWhenGetFindAllThenReturn200Response() {
        Mockito.when(mockService.getAll()).thenReturn(Collections.emptyList());

        ResponseEntity<List<ProductsDTO>>  actualResponse = controller.getAll();
        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());

        List<ProductsDTO> actualResponseBody = actualResponse.getBody();
        Assertions.assertNotNull(actualResponseBody);
        Assertions.assertTrue(actualResponseBody.isEmpty());
    }

}
