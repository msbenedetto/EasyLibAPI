package com.ioc.easylibapi.config;

import com.ioc.easylibapi.security.jwt.JwtSecurityConfig;
import com.ioc.easylibapi.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Class SecurityConfig
 * meant to define the security beans, such as PasswordEncoder, AuthenticationManager, paths access to the api to make the calls
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    JwtTokenProvider provider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth/login",
                        "/auth/register",
                        "/v2/api-docs",
                        "/swagger-ui.html").permitAll()
                .antMatchers(HttpMethod.GET, "/public/**").permitAll()
                //.antMatchers(HttpMethod.DELETE, "/admin/**").hasRole("ROLE_ADMIN")
                .anyRequest().authenticated()
                .and()
                .apply(new JwtSecurityConfig(provider));
        //@formatter:on

    }
}
