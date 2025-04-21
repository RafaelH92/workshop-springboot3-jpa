package com.javaweb.course.config;

import com.javaweb.course.entities.User;
import com.javaweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test") /* Anotação de configuração do perfil test */
public class TestConfig implements CommandLineRunner { /* Implements para executar quando a aplicação for iniciada */

    @Autowired /* Resolve dependencia do repository */
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2)); /* Salva objeto no banco de dados */
    }
}
