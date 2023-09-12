package com.katziio.collabwithkatz.config.security;
//
////@Configuration
////public class Security {
////    @Bean
////    public InMemoryUserDetailsManager userDetailsManager() {
////        UserDetails admin = User.builder().username("katz").password("{noop}1234").roles("ADMIN").build();
////        UserDetails editor = User.builder().username("editor").password("{noop}1234").roles("EDITOR").build();
////        return new InMemoryUserDetailsManager(admin, editor);
////
////    }
////
////    @Bean
////    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests(authorizeRequests ->
////                        authorizeRequests
////                                .antMatchers("/public/**").permitAll() // Publicly accessible URLs
////                                .antMatchers("/admin/**").hasRole("ADMIN") // Requires ADMIN role
////                                .antMatchers("/user/**").hasRole("USER") // Requires USER role
////                                .anyRequest().authenticated() // All other URLs require authentication
////                )
////                .formLogin(withDefaults()); // Use default form login
////
////        return http.build();
////    }
////
////
////}
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
////@Configuration
////@EnableWebSecurity
////public class Security{
////
////    @Bean
////    public LogoutConfigurer<HttpSecurity> filterChain(HttpSecurity http) throws Exception {
////        return http
//////                .authorizeHttpRequests()
////                .authorizeHttpRequests()
////                .antMatchers("/allEditors").hasAnyAuthority() // Configure the required authority for this endpoint
////                .anyRequest().authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/login") // Configure your custom login page if needed
////                .permitAll()
////                .and()
////                .logout()
////                .permitAll();
////    }
////                /* .authorizeRequests(configurer ->
////                        configurer
////                                *//*.requestMatchers("/").permitAll()
////                                .requestMatchers("/posts/create/post").hasAnyAuthority(Constants.ADMIN, Constants.AUTHOR)
////                                .requestMatchers("/posts/filter").permitAll()
////                                .requestMatchers("/posts/update/**").hasAnyAuthority(Constants.ADMIN, Constants.AUTHOR)
////                                .requestMatchers("/posts/delete/**").hasAnyAuthority(Constants.ADMIN, Constants.AUTHOR)
////                                .requestMatchers("/posts/drafts/**").hasAnyAuthority(Constants.ADMIN, Constants.AUTHOR)
////                                .requestMatchers("/drafts/read/**").hasAnyAuthority(Constants.ADMIN, Constants.AUTHOR)
////                                .requestMatchers("/comment/create").permitAll()
////                                .requestMatchers("/comment/delete/**").hasAnyAuthority(Constants.ADMIN, Constants.AUTHOR)
////                                .requestMatchers("/comment/update/**").hasAnyAuthority(Constants.ADMIN, Constants.AUTHOR)
////                                .requestMatchers("/error").permitAll()*//*
////                                //.requestMatchers("/public/**").permitAll() // Publicly accessible URLs
//////                                .requestMatchers("/admin/**").hasRole("ADMIN") // Requires ADMIN role
//////                                .requestMatchers("/user/**").hasRole("USER") // Requires USER role
////                                .requestMatchers("/allEditors").permitAll()
////                                .requestMatchers(RequestMatcher()"/editorById").hasRole("ADMIN")
////                        //.requestMatchers("").authenticated() // All other URLs require authentication
////                )
////                .formLogin(Customizer.withDefaults())
////                .logout(LogoutConfigurer::permitAll)
////                .build();*/
//////    }
////    @Bean
////    public PasswordEncoder getPasswordEncoder(){
////        return NoOpPasswordEncoder.getInstance();
////    }
////
////}
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//@EnableWebSecurity
//public class Security extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails admin = User.builder()
//                .username("katz")
//                .password("{noop}1234")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails editor = User.builder()
//                .username("editor")
//                .password("{noop}1234")
//                .roles("EDITOR")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, editor);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/allEditors").hasAnyAuthority("ADMIN") // Configure the required authority for this endpoint
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login") // Configure your custom login page if needed
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//
//        // Add any additional security configurations you may need
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**"); // Specify resources to be ignored by security
//    }
//}


//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class Security extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("password")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("password")
//                .roles("ADMIN");
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class Security{

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails admin = User.builder().username("katz").password("{noop}1234").roles("ADMIN").build();
        UserDetails editor = User.builder().username("editor").password("{noop}1234").roles("EDITOR").build();
        return new InMemoryUserDetailsManager(admin, editor);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.requestMatchers(mvc.pattern("/allEditors")).permitAll()
                        .requestMatchers(mvc.pattern("/editorById")).authenticated()
                )
                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.loginPage("/secured_login"))

                .logout(LogoutConfigurer::permitAll)
                .build();
    }

    @Scope("prototype")
    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}