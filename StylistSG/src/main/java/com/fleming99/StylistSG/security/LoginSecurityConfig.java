package com.fleming99.StylistSG.security;

import com.fleming99.StylistSG.core.entities.StylistEmployee;
import com.fleming99.StylistSG.core.usecases.UserService;
import com.fleming99.StylistSG.core.validation.CustomerDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity, AuthenticationSuccessHandler authenticationSuccessHandler) throws Exception{

        httpSecurity.authorizeHttpRequests(configurer -> configurer
                .requestMatchers("/authenticateTheUser", "/login-page", "/login", "/login-directory", "/static/**", "/css/**", "/images/**", "/index")
                .permitAll()
                .requestMatchers("/", "/home", "/templates/**", "/customers/**", "/create-customer", "/customers-list", "/update-customer", "/jobs/**", "/jobs-list", "/create-new-job", "/update-job").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
        ).formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/authenticateTheUser")
                .successHandler(authenticationSuccessHandler)
                .permitAll()
                .defaultSuccessUrl("/home")
        ).logout(logout->logout
                .permitAll().logoutSuccessUrl("/login")
        ).exceptionHandling(configurer->configurer
                .accessDeniedPage("/access-denied")
        );

        return httpSecurity.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public DaoAuthenticationProvider authenticationProvider (UserService<StylistEmployee> userService){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
}
