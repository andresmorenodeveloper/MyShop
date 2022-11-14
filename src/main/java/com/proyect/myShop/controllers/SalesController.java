/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyect.myShop.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.proyect.myShop.dto.SalesDTO;
import com.proyect.myShop.models.Sales;
import com.proyect.myShop.service.SalesServices;
import com.proyect.myShop.utils.Response;
import com.proyect.myShop.utils.Utils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @Autowired
    Utils utils;

    @GetMapping
    @ApiOperation(value = "Listar registros", notes = "Servicio para listar todos los registros")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Registros encontrados"),
        @ApiResponse(code = 204, message = "Registros no encontrados")})
    private ResponseEntity<Response> getAl(HttpServletRequest request) {

        Map<String, String[]> filters = utils.getSearchParameters(request);

        Response<List<SalesDTO>> response = new Response<List<SalesDTO>>();
        List<SalesDTO> listSalesDto = new ArrayList<SalesDTO>();

        List<Sales> listSales = salesServices.getAll(filters);
        if (!listSales.isEmpty()) {
            listSales.forEach((entity) -> {
                listSalesDto.add(salesServices.getDto(entity));
            });
            utils.printDto(listSalesDto,"INFORMACION DE LAS VENTAS");
            response.setData(listSalesDto);
            response.setMessage("Consulta realizada correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setData(null);
            response.setMessage("No se encontro informacion");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ApiOperation(value = "Crear registro", notes = "Servicio para crear un nuevo registro")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Registro creado correctamente"),
        @ApiResponse(code = 400, message = "Solicitud no valida")})
    public ResponseEntity<Response> create(HttpServletRequest request, @RequestBody @Validated SalesDTO dto) {
        Response response = new Response();

        Sales entity = salesServices.create(salesServices.getEntity(dto));
        if (entity != null) {
            response.setData(salesServices.getDto(entity));
            response.setMessage("Registro creado correctamente");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.setData(null);
            response.setMessage("Solicitud no valida");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }
    
}
