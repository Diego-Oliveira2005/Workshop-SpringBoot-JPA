package com.DiegoOliveira2005.study.config;

import com.DiegoOliveira2005.study.entities.*;
import com.DiegoOliveira2005.study.entities.enums.OrderStatus;
import com.DiegoOliveira2005.study.repositories.*;
import com.DiegoOliveira2005.study.services.CategoryService;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category("Electronics");
        Category category2 = new Category("Books");
        Category category3 = new Category("Computers");

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

        Product product1 = new Product("TV", "Make image???",  2000.00, "");
        Product product2 = new Product("Java Deitel", "it's a book",  95.00, "");
        Product product3 = new Product("Compiutär", "Computes",  4000.00, "");
        Product product4 = new Product("Lenovo or Dell", "i need one!",  1000.00, "");

        product1.getCategories().add(category1);
        product2.getCategories().add(category2);
        product3.getCategories().add(category3);
        product4.getCategories().add(category3);
        product4.getCategories().add(category1);

        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4));

        User user1 = new User("Manus Thrax", "manus@email.com", "987654321", "123456" );
        User user2 = new User("Diego Carvalho", "diego@gmail.com", "987654323", "123456" );

        Order order1 = new Order(Instant.parse("2000-08-19T20:10:18Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(Instant.parse("2001-12-14T21:10:19Z"), OrderStatus.CANCELED, user1);
        Order order3 = new Order(Instant.parse("2005-10-15T08:05:05Z"), OrderStatus.SHIPPED, user2);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        OrderItem orderItem1 = new OrderItem(order1, product1, 1, product1.getPrice());
        OrderItem orderItem2 = new OrderItem(order2, product2, 3, product2.getPrice());
        OrderItem orderItem3 = new OrderItem(order1, product3, 2, product3.getPrice());
        OrderItem orderItem4 = new OrderItem(order3, product4, 5, product4.getPrice());

        orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));
    }
}
