package com.javaweb.course.resources;

import com.javaweb.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /* Recurso web que é implementado por um controlador Rest */
@RequestMapping(value = "/users") /* Nome do recurso */
public class UserResource {

    @GetMapping /* Indica que esse metodo que responde a requisicao do tipo get */
    public ResponseEntity<User> findAll(){
        /* Apenas para teste */
        User usuario = new User(1L, "Rafa", "rafateste@email.com", "9999999", "senha");
        return ResponseEntity.ok().body(usuario);
    }
}
