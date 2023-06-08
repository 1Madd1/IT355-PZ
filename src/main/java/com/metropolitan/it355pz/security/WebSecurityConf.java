package com.metropolitan.it355pz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;


@Configuration
@EnableWebMvc
public class WebSecurityConf{

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST)
                .permitAll()
                .antMatchers("/component")
                .hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        return http.build();
    }


//    @Override
//    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .cors()
//                .configurationSource(corsConfigurationSource())
//                .and()
//                .authorizeRequests()
//                .antMatchers(AUTH_WHITELIST)
//                .permitAll()
//                .antMatchers(HttpMethod.DELETE).hasAnyRole("ADMIN", "USER")
//                .antMatchers(HttpMethod.PUT).hasAnyRole("ADMIN", "USER")
//                .antMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "USER")
//                .antMatchers(HttpMethod.GET).hasAnyRole("ADMIN", "USER")
//                .antMatchers("/")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//        return http.build();
//                .formLogin()
//                .defaultSuccessUrl("/")
//                .and()
//                .rememberMe()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/");
//    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:8080"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    private static final String[] AUTH_WHITELIST = {
            "/login_register/**", "/computer/**", "/computer", "/component/**", "/component", "/creditCard", "/creditCard/**"
    };

    private static final String[] USER_WHITELIST = {
            "/computer/**", "/computer", "/component/**", "/component"
    };

}