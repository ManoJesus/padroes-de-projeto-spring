package com.github.manojesus.padroesdeprojetospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PadroesDeProjetoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PadroesDeProjetoSpringApplication.class, args);
    }

}
