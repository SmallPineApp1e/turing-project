package com.turing.turing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.turing.turing.dao")
public class TuringProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TuringProjectApplication.class, args);
    }

}
