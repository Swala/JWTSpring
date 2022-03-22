package com.example.jwtauth;

import com.example.jwtauth.model.EFlag;
import com.example.jwtauth.model.Flag;
import com.example.jwtauth.repository.FlagRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JwtAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthApplication.class, args);
    }

    /* Alreaddy entered flags
    @Bean
    public CommandLineRunner demoData(FlagRepo flagRepo) {

        flagRepo.deleteAll();

        //Creates values for DB in Flags table
        return args -> {
            List<EFlag> flags = List.of(EFlag.UNASSIGNED, EFlag.ASSIGNED, EFlag.IN_PROGRESS, EFlag.REVIEW, EFlag.COMPLETED);
            flags.forEach(flag -> flagRepo.save(new Flag(flag)));

        };
    }*/

}
