package com.DevSuperior.DSComerce1.Controllers;

import com.DevSuperior.DSComerce1.DTO.ProductDTO;
import com.DevSuperior.DSComerce1.Entites.Product;
import com.DevSuperior.DSComerce1.Repositores.ProdutsReporitory;
import com.DevSuperior.DSComerce1.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value ="/products")
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id){
       return service.findByid(id);

    }

}
