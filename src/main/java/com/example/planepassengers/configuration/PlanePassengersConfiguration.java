package com.example.planepassengers.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class PlanePassengersConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return Optional::empty;
    }
}

