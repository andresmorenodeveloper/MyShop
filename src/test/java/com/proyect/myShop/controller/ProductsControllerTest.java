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
			List<ProductsDTO> expectedResponse = new ArrayList<>();
			
			expectedResponse.add(new ProductsDTO((long)1, "Buzo Blanco", "M, L, XL", "Masculino", "https://imagesmyshop.s3.amazonaws.com/buzoBlanco.png", (double) 120000));
			expectedResponse.add(new ProductsDTO((long)3, "Gorra Negra", "M, L, XL", "Masculino", "https://imagesmyshop.s3.amazonaws.com/gorraNegra.jpg", (double) 50000));
			expectedResponse.add(new ProductsDTO((long)7, "Sueter Negro", "M, L, XL", "Masculino", "https://imagesmyshop.s3.amazonaws.com/sueterNegro.jpg", (double) 155000));
			expectedResponse.add(new ProductsDTO((long)8, "Sueter Rojo", "M, L, XL", "Masculino", "https://imagesmyshop.s3.amazonaws.com/sueterRojo.png", (double) 220000));
			expectedResponse.add(new ProductsDTO((long)9, "Zapatos", "39, 40, 41", "Masculino", "https://imagesmyshop.s3.amazonaws.com/zapatos2.jpg", (double) 130000));
			expectedResponse.add(new ProductsDTO((long)10, "Zapatos", "36, 37, 38", "Femenino", "https://imagesmyshop.s3.amazonaws.com/zapatos.jpg", (double) 130000));
	        Mockito.when(mockService.getAll()).thenReturn(expectedResponse);
			
	        ResponseEntity<List<ProductsDTO>> actualResponse = controller.getAll();
	        Assertions.assertNotNull(actualResponse);
	        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());

	        List<ProductsDTO> actualResponseBody = actualResponse.getBody();
	        Assertions.assertNotNull(actualResponseBody);
	        Assertions.assertFalse(actualResponseBody.isEmpty());
	        Assertions.assertEquals(expectedResponse, actualResponseBody);
	}
	
    @Test
    void givenTableEmptyWhenGetFindAllThenReturn200Response() {
        Mockito.when(mockService.getAll()).thenReturn(Collections.emptyList());

        ResponseEntity<List<ProductsDTO>>  actualResponse = controller.getAll();
        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());

        List<ProductsDTO> actualResponseBody = actualResponse.getBody();
        Assertions.assertNotNull(actualResponseBody);
        Assertions.assertFalse(actualResponseBody.isEmpty());
    }

}
