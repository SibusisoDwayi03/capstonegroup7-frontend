package com.example.application.security;


//import com.example.application.views.main.LoginView;
//import com.vaadin.flow.spring.security.VaadinWebSecurity;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends VaadinWebSecurity {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        setLoginView(http, LoginView.class);
//    }
//    @Bean
//    public BCryptPasswordEncoder encoder(){
//        //Encodes our secirity passwords
//        return new BCryptPasswordEncoder();
//    }
//
//
//   @Bean
//    UserDetailsManager userDetailsManager(BCryptPasswordEncoder bCryptPasswordEncoder){
//        //Creating roles for the system
//       InMemoryUserDetailsManager man = new InMemoryUserDetailsManager();
//       man.createUser(User.withUsername("admin-user")
//               .password(bCryptPasswordEncoder.encode("aaaa5555"))
//               .roles("ADMIN")
//               .build()
//       );
//       man.createUser(User.withUsername("client-user")
//               .password(bCryptPasswordEncoder.encode("aaaa5555"))
//               .roles("USER")
//               .build()
//       );
//       //return man;
//
//        return new InMemoryUserDetailsManager(
//                User.withUsername("Adm")
//                        .password("Dwayi")
//                        .roles("ADMIN").build()
//        );
//    }
//}