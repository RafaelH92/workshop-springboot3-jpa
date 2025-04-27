package com.javaweb.course.services;

import com.javaweb.course.entities.Category;
import com.javaweb.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service /* Registra a classe para ser realizada a injeção de dependencia do framework */
public class CategoryService {

    @Autowired
    private CategoryRepository CategoryRepository;

    public List<Category> findAll(){
        return CategoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = CategoryRepository.findById(id);
        return obj.get();
    }
}
