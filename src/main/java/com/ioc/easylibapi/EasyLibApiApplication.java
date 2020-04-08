package com.ioc.easylibapi;
/**
 * @author Eric Rubio, Hassan Zerouali, Mathilde Benedetto
 * copyright 2020
 */

import com.ioc.easylibapi.config.SwaggerConfiguration;
import com.ioc.easylibapi.models.user.User;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Optional;

/**
 * Class EasyLibApiApplication
 * Starting point of the application
 */
@Configuration
@EnableEncryptableProperties
//@PropertySource(name="EncryptedProperties", value = "classpath:encrypted.properties")
@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class EasyLibApiApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(EasyLibApiApplication.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

    }

    @Configuration
    @EnableJpaAuditing
    class DataJpaConfig {
        @Bean
        public AuditorAware<User> auditor() {
            return () -> Optional.ofNullable(SecurityContextHolder.getContext())
                    .map(SecurityContext::getAuthentication)
                    .filter(Authentication::isAuthenticated)
                    .map(Authentication::getPrincipal)
                    .map(User.class::cast);
        }
    }
}