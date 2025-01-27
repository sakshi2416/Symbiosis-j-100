package com.example.sakshi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // Marks this class as a configuration class in Spring. This tells Spring that the class contains bean definitions.
public class supplierconfig {
    
    @Bean  // Indicates that the method returns a bean definition that should be managed by the Spring container.
    public WebMvcConfigurer corsConfigurer() {
        // This method creates and returns a WebMvcConfigurer bean that configures CORS mappings for the web application.
        return new WebMvcConfigurer() {
            // The WebMvcConfigurer interface allows us to customize Spring MVC configurations without overriding the entire configuration.
            
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // The addCorsMappings method allows us to add CORS (Cross-Origin Resource Sharing) settings to the application.
                
                registry.addMapping("/**")  // Adds CORS mappings for all paths in the application. (/** means all paths)
                        .allowedOrigins("http://localhost:4200")  // Specifies the allowed origin for cross-origin requests. Here, it's set to Angular app running at http://localhost:4200.
                        .allowedMethods("GET", "POST", "PUT", "DELETE");  // Specifies the HTTP methods allowed for cross-origin requests: GET, POST, PUT, DELETE.
            }
        };
    }
}
