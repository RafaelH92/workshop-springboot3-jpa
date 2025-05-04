package com.javaweb.course.resources;

import com.javaweb.course.entities.User;
import com.javaweb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController /* Recurso web que é implementado por um controlador Rest */
@RequestMapping(value = "/users") /* Nome do recurso */
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping /* Indica que esse metodo que responde a requisicao do tipo get */
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") /* Indica que o endpoint tera um parametro */
    public ResponseEntity<User> findById(@PathVariable Long id){ /* Passa o parametro definido no endpoint para metodo */
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){ /* Desserializa o json passado para objeto */
        obj = service.insert(obj);
        /* Para retorno de reposta 201 (criação) deve ser retornar um obj do tipo URI com o caminho do recurso que foi criado */
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
