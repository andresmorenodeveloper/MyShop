/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyect.myShop.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.proyect.myShop.dto.ProductsDTO;
import com.proyect.myShop.models.Products;
import com.proyect.myShop.service.ProductsService;
import com.proyect.myShop.utils.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;

import com.proyect.myShop.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jdesquivia
 */
@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    Utils utils;

    @GetMapping
    @ApiOperation(value = "Listar registros", notes = "Servicio para listar todos los registros")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Registros encontrados"),
        @ApiResponse(code = 204, message = "Registros no encontrados")})
    private ResponseEntity<Response> getAll() {
        Response<List<ProductsDTO>> response = new Response<List<ProductsDTO>>();
        List<ProductsDTO> listProductsDto = new ArrayList<ProductsDTO>();

        List<Products> listProducts = productsService.getAll();
        if (!listProducts.isEmpty()) {
            listProducts.forEach((entity) -> {
                listProductsDto.add(productsService.getDto(entity));
            });
            utils.printDto(listProductsDto);
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
