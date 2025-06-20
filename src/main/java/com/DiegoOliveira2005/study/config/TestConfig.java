package com.DiegoOliveira2005.study.config;

import com.DiegoOliveira2005.study.entities.Order;
import com.DiegoOliveira2005.study.entities.User;
import com.DiegoOliveira2005.study.repositories.OrderRepository;
import com.DiegoOliveira2005.study.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("Manus Thrax", "manus@email.com", "987654321", "123456" );
        User user2 = new User("Diego Carvalho", "diego@gmail.com", "987654323", "123456" );

        Order order1 = new Order(Instant.parse("2000-08-19T20:10:18Z"), user1);
        Order order2 = new Order(Instant.parse("2001-12-14T21:10:19Z"), user1);
        Order order3 = new Order(Instant.parse("2005-10-15T08:05:05Z"), user2);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
