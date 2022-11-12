/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyect.myShop.repository;

import com.proyect.myShop.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jdesquivia
 */
public interface ProductsRepository extends JpaRepository<Products, Long> {

}
