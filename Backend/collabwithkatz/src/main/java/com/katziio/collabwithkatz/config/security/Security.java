package com.katziio.collabwithkatz.config.security;

//@Configuration
//public class Security {
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails admin = User.builder().username("katz").password("{noop}1234").roles("ADMIN").build();
//        UserDetails editor = User.builder().username("editor").password("{noop}1234").roles("EDITOR").build();
//        return new InMemoryUserDetailsManager(admin, editor);
//
//    }
//
//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .antMatchers("/public/**").permitAll() // Publicly accessible URLs
//                                .antMatchers("/admin/**").hasRole("ADMIN") // Requires ADMIN role
//                                .antMatchers("/user/**").hasRole("USER") // Requires USER role
//                                .anyRequest().authenticated() // All other URLs require authentication
//                )
//                .formLogin(withDefaults()); // Use default form login
//
//        return http.build();
//    }
//
//
//}


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
//                .csrf()
//                .disable()
                .authorizeRequests(configurer ->
                        configurer
                                /*.requestMatchers("/").permitAll()
                                .requestMatchers("/posts/create/post").hasAnyAuthority(Constants.ADMIN, Constants.AUTHOR)
                                .requestMatchers("/posts/filter").permitAll()
                                .requestMatchers("/posts/update/**").hasAnyAuthority(Constants.ADMIN, Constants.AUTHOR)
                                .requestMatchers("/posts/delete/**").hasAnyAuthority(Constants.ADMIN, Constants.AUTHOR)
                                .requestMatchers("/posts/drafts/**").hasAnyAuthority(Constants.ADMIN, Constants.AUTHOR)
                                .requestMatchers("/drafts/read/**").hasAnyAuthority(Constants.ADMIN, Constants.AUTHOR)
                                .requestMatchers("/comment/create").permitAll()
                                .requestMatchers("/comment/delete/**").hasAnyAuthority(Constants.ADMIN, Constants.AUTHOR)
                                .requestMatchers("/comment/update/**").hasAnyAuthority(Constants.ADMIN, Constants.AUTHOR)
                                .requestMatchers("/error").permitAll()*/
                                .requestMatchers("/public/**").permitAll() // Publicly accessible URLs
                                .requestMatchers("/admin/**").hasRole("ADMIN") // Requires ADMIN role
                                .requestMatchers("/user/**").hasRole("USER") // Requires USER role
                                //.requestMatchers("").authenticated() // All other URLs require authentication
                )
                .formLogin(Customizer.withDefaults())
                .logout(LogoutConfigurer::permitAll)
                .build();
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
