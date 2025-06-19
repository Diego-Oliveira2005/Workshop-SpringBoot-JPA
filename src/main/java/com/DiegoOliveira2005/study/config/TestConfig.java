package com.DiegoOliveira2005.study.config;

import com.DiegoOliveira2005.study.entities.User;
import com.DiegoOliveira2005.study.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("Manus Thrax", "manus@email.com", "987654321", "123456" );
        User user2 = new User("Diego Carvalho", "diego@gmail.com", "987654323", "123456" );

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
