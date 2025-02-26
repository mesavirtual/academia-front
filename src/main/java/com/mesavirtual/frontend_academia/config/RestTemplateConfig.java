package com.mesavirtual.frontend_academia.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Collections;

@Configuration
public class RestTemplateConfig {

    @Value("${api.username}") // Nome de usuário para autenticação
    private String username;

    @Value("${api.password}") // Senha para autenticação
    private String password;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        // Adiciona um interceptor para incluir o cabeçalho de autenticação
        restTemplate.setInterceptors(Collections.singletonList((ClientHttpRequestInterceptor) (request, body, execution) -> {
            // Codifica as credenciais em Base64
            String credentials = username + ":" + password;
            String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

            // Adiciona o cabeçalho de autenticação
            request.getHeaders().add(HttpHeaders.AUTHORIZATION, "Basic " + encodedCredentials);
            return execution.execute(request, body);
        }));

        return restTemplate;
    }
}
