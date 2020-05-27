package com.project.config;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class SecurityConfig {
 // dzi�ki adnotacji @Bean Spring uruchomi metod� i zarejestruje w kontenerze obiekt przez ni�
 @Bean // zwr�cony, natomiast adnotacja @Autowired u�yta w innej klasie spowoduje jego wstrzykni�cie
 RestTemplate customRestTemplate(RestTemplateBuilder restTemplateBuilder) {
 return restTemplateBuilder.basicAuthentication("admin", "admin").build();
 }
 // login i has�o mo�na przechowywa� w pliku np. application.properties, ale has�o powinno by�
} // w postaci zaszyfrowanej, poniewa� do plik�w aplikacji lokalnej ma dost�p ka�dy u�ytkownik komputera