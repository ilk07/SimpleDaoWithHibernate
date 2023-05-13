package com.homeworks.simpledaolayerhibernatejpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class CustomSecurityConfiguration extends GlobalMethodSecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

        authManagerBuilder.inMemoryAuthentication()
                .withUser("Eli")
                .password(encoder().encode("password"))
                .roles("READ", "WRITE", "DELETE")
                .and()
                .withUser("Anna")
                .password(encoder().encode("password"))
                .roles("READ")
                .and()
                .withUser("John")
                .password(encoder().encode("password"))
                .roles("READ", "WRITE");

        return authManagerBuilder.build();
    }
}
