package com.DevSuperior.DSComerce1.Service;

import com.DevSuperior.DSComerce1.DTO.ProductDTO;
import com.DevSuperior.DSComerce1.Entites.Product;
import com.DevSuperior.DSComerce1.Repositores.ProdutsReporitory;
import com.DevSuperior.DSComerce1.Service.Exception.DataBaseException;
import com.DevSuperior.DSComerce1.Service.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.EmptyStackException;

@Service
public class ProductService {

    @Autowired
    private ProdutsReporitory reporitory;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
                Product product = reporitory.findById(id).orElseThrow(
                        ()-> new ResourceNotFoundException("Recurso não encontrado"));
            return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> result = reporitory.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
   Product entity= new Product();
        copyDtoEntity(dto , entity);
        entity = reporitory.save(entity);
   return new ProductDTO(entity);
    }
    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        Product entity= reporitory.getReferenceById(id);
        copyDtoEntity(dto , entity);
        entity = reporitory.save(entity);
        return new ProductDTO(entity);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!reporitory.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            reporitory.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
    }

}