package com.javaweb.course.services;

import com.javaweb.course.entities.Order;
import com.javaweb.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service /* Registra a classe para ser realizada a injeção de dependencia do framework */
public class OrderService {

    @Autowired
    private OrderRepository OrderRepository;

    public List<Order> findAll(){
        return OrderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = OrderRepository.findById(id);
        return obj.get();
    }
}
