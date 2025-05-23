package com.javaweb.course.services;

import com.javaweb.course.entities.Product;
import com.javaweb.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service /* Registra a classe para ser realizada a injeção de dependencia do framework */
public class ProductService {

    @Autowired
    private ProductRepository ProductRepository;

    public List<Product> findAll(){
        return ProductRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = ProductRepository.findById(id);
        return obj.get();
    }
}
