package com.javaweb.course.resources;

import com.javaweb.course.entities.Category;
import com.javaweb.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController /* Recurso web que é implementado por um controlador Rest */
@RequestMapping(value = "/categories") /* Nome do recurso */
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping /* Indica que esse metodo que responde a requisicao do tipo get */
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") /* Indica que o endpoint tera um parametro */
    public ResponseEntity<Category> findById(@PathVariable Long id){ /* Passa o parametro definido no endpoint para metodo */
        Category category = service.findById(id);
        return ResponseEntity.ok().body(category);
    }
}
