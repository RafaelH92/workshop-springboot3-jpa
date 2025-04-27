package com.javaweb.course.resources;

import com.javaweb.course.entities.Product;
import com.javaweb.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController /* Recurso web que é implementado por um controlador Rest */
@RequestMapping(value = "/products") /* Nome do recurso */
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping /* Indica que esse metodo que responde a requisicao do tipo get */
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") /* Indica que o endpoint tera um parametro */
    public ResponseEntity<Product> findById(@PathVariable Long id){ /* Passa o parametro definido no endpoint para metodo */
        Product product = service.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
