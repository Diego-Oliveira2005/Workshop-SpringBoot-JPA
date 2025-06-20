package com.DiegoOliveira2005.study.config;

import com.DiegoOliveira2005.study.entities.Category;
import com.DiegoOliveira2005.study.entities.Order;
import com.DiegoOliveira2005.study.entities.User;
import com.DiegoOliveira2005.study.entities.enums.OrderStatus;
import com.DiegoOliveira2005.study.repositories.CategoryRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category("Electronics");
        Category category2 = new Category("Books");
        Category category3 = new Category("Computers");

        User user1 = new User("Manus Thrax", "manus@email.com", "987654321", "123456" );
        User user2 = new User("Diego Carvalho", "diego@gmail.com", "987654323", "123456" );

        Order order1 = new Order(Instant.parse("2000-08-19T20:10:18Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(Instant.parse("2001-12-14T21:10:19Z"), OrderStatus.CANCELED, user1);
        Order order3 = new Order(Instant.parse("2005-10-15T08:05:05Z"), OrderStatus.SHIPPED, user2);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
    }
}
