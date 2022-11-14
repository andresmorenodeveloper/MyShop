/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyect.myShop.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.proyect.myShop.dto.ProductsDTO;
import com.proyect.myShop.dto.SalesDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 *
 * @author anmoreno
 */
@Component
public class Utils {

    Gson gson1 = new GsonBuilder().setPrettyPrinting().create();

    public void printDto(List<SalesDTO> listSalesDto, String title) {

        System.out.println(title);
        System.out.println("**********************************");
        System.out.println(gson1.toJson(listSalesDto));
        System.out.println("**********************************");

    }

    public void printDto(List<ProductsDTO> listProductsDto) {

        System.out.println("INFORMACION DE LOS PRODUCTOS");
        System.out.println("**********************************");
        System.out.println(gson1.toJson(listProductsDto));
        System.out.println("**********************************");

    }

}
