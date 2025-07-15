
package com.example.springbootfirst.config;

import com.example.springbootfirst.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SpringConfiguration {
    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;
    // // to convert to pop-up
    @Bean
    public PasswordEncoder passwordEncoder(){          //BCryptPasswordEncoder hashes passwords for secure storage.//passwordencoder is a interface consist methosd like encoder,matches
        return new BCryptPasswordEncoder();
    }




    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

//    //ROLE BASED AUTHENTICATion
//    //to create/built a users->need to build username,passworrd and role
//    @Bean
//    InMemoryUserDetailsManager userDetails(){//  https://chatgpt.com/share/686de9f4-40c0-8002-afac-b550a3f2f37d    store in RAM
//        UserDetails admin= User.builder()//user1
//                .username("admin")
//                .password(passwordEncoder().encode("admin"))//passord must be include with noop/encode
//                .roles("ADMIN")//this roles was provided inside app.prop
//                .build();
//
//        UserDetails Rhythan= User.builder()//user2
//                .username("Rhythan")
//                .password(passwordEncoder().encode("Rhythan"))//encoding the password using above  passwordEncoder()
//                .roles("USER")
//                .build();
//        //return admin;
//        return new InMemoryUserDetailsManager(admin,Rhythan);
//
//    }

}