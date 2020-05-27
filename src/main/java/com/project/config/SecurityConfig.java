package com.project.config;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class SecurityConfig {
 // dziêki adnotacji @Bean Spring uruchomi metodê i zarejestruje w kontenerze obiekt przez ni¹
 @Bean // zwrócony, natomiast adnotacja @Autowired u¿yta w innej klasie spowoduje jego wstrzykniêcie
 RestTemplate customRestTemplate(RestTemplateBuilder restTemplateBuilder) {
 return restTemplateBuilder.basicAuthentication("admin", "admin").build();
 }
 // login i has³o mo¿na przechowywaæ w pliku np. application.properties, ale has³o powinno byæ
} // w postaci zaszyfrowanej, poniewa¿ do plików aplikacji lokalnej ma dostêp ka¿dy u¿ytkownik komputera