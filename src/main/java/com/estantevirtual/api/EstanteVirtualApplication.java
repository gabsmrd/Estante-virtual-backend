package com.estantevirtual.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class  EstanteVirtualApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstanteVirtualApplication.class, args);
    }

    // Este é o filtro supremo de CORS. Ele libera acesso total para o seu Frontend!
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(false); // Tem que ser false quando usamos "*"
        config.addAllowedOrigin("*");      // Libera qualquer IP/Porta (como o seu 127.0.0.1:5500)
        config.addAllowedHeader("*");      // Libera qualquer tipo de cabeçalho
        config.addAllowedMethod("*");      // Libera GET, POST, PUT, DELETE, OPTIONS
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}