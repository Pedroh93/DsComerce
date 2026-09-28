package com.DevSuperior.DSComerce1.Service;

import com.DevSuperior.DSComerce1.DTO.ProductDTO;
import com.DevSuperior.DSComerce1.Entites.Product;
import com.DevSuperior.DSComerce1.Repositores.ProdutsReporitory;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProdutsReporitory reporitory;
    @Transactional(readOnly=true)
    public ProductDTO findByid(Long id){
        Product product=reporitory.findById(id).get();
        return new ProductDTO(product);



    }
}
