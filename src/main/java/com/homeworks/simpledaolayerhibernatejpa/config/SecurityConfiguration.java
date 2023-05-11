package com.homeworks.simpledaolayerhibernatejpa.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password(encoder().encode("password"))
//                .authorities("read","write","sleep","eat","enjoy");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .and()
//                .authorizeRequests().antMatchers("/persons/").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/by-city").hasAuthority("read")
//                .and()
//                .authorizeRequests().antMatchers("/by-age").hasAuthority("read")
//                .and()
//                .authorizeRequests().antMatchers("/by-name-surname").hasAuthority("read")
//                .and()
//                .authorizeRequests().anyRequest().authenticated();
//    }
//}

