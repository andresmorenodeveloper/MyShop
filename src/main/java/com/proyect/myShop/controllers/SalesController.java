/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyect.myShop.controllers;

import com.proyect.myShop.dto.ProductsDTO;
import com.proyect.myShop.dto.SalesDTO;
import com.proyect.myShop.models.Products;
import com.proyect.myShop.models.Sales;
import com.proyect.myShop.service.SalesServices;
import com.proyect.myShop.utils.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anmoreno
 */
@RestController
@RequestMapping("/api/v1/sales")
@CrossOrigin
public class SalesController {
    
    @Autowired
    SalesServices salesServices;

    @GetMapping
    @ApiOperation(value = "Listar registros", notes = "Servicio para listar todos los registros")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Registros encontrados"),
        @ApiResponse(code = 204, message = "Registros no encontrados")})
    private ResponseEntity<Response> getAl() {
        Response<List<SalesDTO>> response = new Response<List<SalesDTO>>();
        List<SalesDTO> listProductsDto = new ArrayList<SalesDTO>();

        List<Sales> listSales = salesServices.getAll();
        if (!listSales.isEmpty()) {
            listSales.forEach((entity) -> {
                listProductsDto.add(salesServices.getDto(entity));
            });

            response.setData(listProductsDto);
            response.setMessage("Consulta realizada correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setData(null);
            response.setMessage("No se encontro informacion");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

}
