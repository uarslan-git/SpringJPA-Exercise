package com.umut.jpaexercise;

import com.umut.jpaexercise.Customer.Customer;
import com.umut.jpaexercise.Repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaExerciseApplication.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(JpaExerciseApplication.class);

    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepository) {
        return (args) -> {
            customerRepository.save(new Customer("Jack", "Bauer"));
            customerRepository.save(new Customer("John", "Smith"));
            customerRepository.save(new Customer("Jane", "Doe"));
            customerRepository.save(new Customer("Bob", "Smith"));
            customerRepository.save(new Customer("Jack", "Smith"));
            customerRepository.save(new Customer("Jane", "Smith"));
            customerRepository.save(new Customer("Jack", "Smith"));

            log.info("Customers found with findAll():");
            log.info("--------------------------------");
            customerRepository.findAll().forEach(customer -> {
                log.info(customer.toString());
            });
            log.info("Customers found with findById(1)");
            log.info("--------------------------------");
            log.info(customerRepository.findById(2).toString());
            log.info("Customers found with lastName(Doe)");
            log.info("--------------------------------");
            log.info(customerRepository.findByLastName("Doe").toString());
        };
    }
}
