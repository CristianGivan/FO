package com.app.FO.config;

import com.app.FO.service.security.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class JwtSecurityConfig {

    private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**"
            // other public endpoints of your API may be appended to this array
    };
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public JwtSecurityConfig(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/tags/**").permitAll()
                .antMatchers("/users/getLogInUser").permitAll()
                .antMatchers("/users/findAll").permitAll()
                .antMatchers(HttpMethod.POST, "/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/notes/**").hasRole("ADMIN")
                .antMatchers(AUTH_WHITELIST).permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

//
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        return http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/authenticate").permitAll()
//                .antMatchers("/register").permitAll()
//                .antMatchers("/users/**").permitAll()
//                .antMatchers("/tags/**").permitAll()
//                .antMatchers("/notes/**").permitAll()
//                .antMatchers("/reminder/**").permitAll()
//                .antMatchers("/users/getLogInUser").permitAll()
//                .antMatchers("/users/findAll").permitAll()
////                .antMatchers(HttpMethod.POST, "/users/**").hasRole("ADMIN")
////                .antMatchers(HttpMethod.GET, "/notes/**").hasRole("ADMIN")
//                .antMatchers(AUTH_WHITELIST).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }
}
