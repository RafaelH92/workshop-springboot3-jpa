package com.javaweb.course.services;

import com.javaweb.course.entities.User;
import com.javaweb.course.repositories.UserRepository;
import com.javaweb.course.services.exceptions.DatabaseException;
import com.javaweb.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service /* Registra a classe para ser realizada a injeção de dependencia do framework */
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(()-> new ResourceNotFoundException(id)); /* Tenta realizar o get no objeto, se não conseguir lança a exceção */
    }

    public User insert(User obj){
        return userRepository.save(obj); /* Retorna a entidade salva */
    }

    public void delete(Long id){
        try {
            if (userRepository.existsById(id)) { /* utilizando existsById pois o deleteById não gera mais exceção caso não encontrar o registro para deleção */
                userRepository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        } catch (DataIntegrityViolationException e) { /* Erro de integridade do bd */
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        try {
            User entity = userRepository.getReferenceById(id); /* Instancia o usuário (não busca no banco de dados), deixa apenas o objeto monitorado pelo JPA */
            updateData(entity, obj);
            return userRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
