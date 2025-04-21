package com.javaweb.course.resources;

import com.javaweb.course.entities.Order;
import com.javaweb.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController /* Recurso web que é implementado por um controlador Rest */
@RequestMapping(value = "/orders") /* Nome do recurso */
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping /* Indica que esse metodo que responde a requisicao do tipo get */
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") /* Indica que o endpoint tera um parametro */
    public ResponseEntity<Order> findById(@PathVariable Long id){ /* Passa o parametro definido no endpoint para metodo */
        Order Order = service.findById(id);
        return ResponseEntity.ok().body(Order);
    }
}
