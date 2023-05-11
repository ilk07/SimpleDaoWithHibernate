package com.homeworks.simpledaolayerhibernatejpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CustomSecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/persons/").permitAll()
                .and()
                .authorizeRequests().antMatchers("/by-city").hasAuthority("read")
                .and()
                .authorizeRequests().antMatchers("/by-age").hasAuthority("read")
                .and()
                .authorizeRequests().antMatchers("/by-name-surname").hasAuthority("read")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();

        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authManagerBuilder.inMemoryAuthentication()
                .withUser("user")
                .password(encoder().encode("password"))
                .authorities("read","write","sleep","eat","enjoy");

        return authManagerBuilder.build();
    }
}
