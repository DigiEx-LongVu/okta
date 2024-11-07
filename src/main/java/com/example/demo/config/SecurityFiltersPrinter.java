package com.example.demo.config;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityFiltersPrinter implements CommandLineRunner {

    @Autowired
    SecurityFilterChain configure;

    @Override
    public void run(String... args) throws Exception {
        List<Filter> filters = configure.getFilters();
        filters.forEach(filter -> System.out.println(filter.getClass().getSimpleName()));
    }

}
