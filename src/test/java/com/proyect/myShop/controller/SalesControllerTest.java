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
import com.proyect.myShop.service.SalesServices;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalesControllerTest {
	
	@Mock
	private SalesServices mockService;
	
	@Autowired
	private SalesController controller;
	
    private HttpServletRequest request;

	@Test
	void givenTableWithDataWhenGetFindAllThenReturn200Response() {
		List<SalesDTO> expectedResponse = new ArrayList<>();
		
		SalesDTO s = new SalesDTO((long)1, "CC", "1143127766", "ANDRES RAUL MORENO LOPEZ", null, "CALLE 44 # 1A - 16", null);
		
		expectedResponse.add(new SalesDTO((long)1, "CC", "1143127766", "ANDRES RAUL MORENO LOPEZ", null, "CALLE 44 # 1A - 16", null));
		expectedResponse.add(new SalesDTO((long)2, "CC", "1143145124", "THIAGO ANDRES MORENO DE LA HOZ", null, "CALLE 44 # 1A - 16", null));
        Mockito.when(mockService.getAll(null)).thenReturn(expectedResponse);
		
        ResponseEntity<List<SalesDTO>> actualResponse = controller.getAll(request);
        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());

        List<SalesDTO> actualResponseBody = actualResponse.getBody();
        Assertions.assertNotNull(actualResponseBody);
        Assertions.assertFalse(actualResponseBody.isEmpty());
        Assertions.assertEquals(expectedResponse, actualResponseBody);
	}
	
    @Test
    void givenTableEmptyWhenGetFindAllThenReturn200Response() {
        Mockito.when(mockService.getAll(null)).thenReturn(Collections.emptyList());

        ResponseEntity<List<SalesDTO>>  actualResponse = controller.getAll(request);
        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());

        List<SalesDTO> actualResponseBody = actualResponse.getBody();
        Assertions.assertNotNull(actualResponseBody);
        Assertions.assertTrue(actualResponseBody.isEmpty());
    }
	
}
