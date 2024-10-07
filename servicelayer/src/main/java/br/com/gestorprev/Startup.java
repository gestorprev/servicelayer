package br.com.gestorprev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Startup {

	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
	}
	
	//CORS
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        //.allowedOrigins("http://www.gestorprev.com.br","http://localhost:8080") // Permitir múltiplas origens
                        .allowedOrigins("*")  // Permite qualquer origem
                		//.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Métodos HTTP permitidos
                		.allowedMethods("*")  // Métodos HTTP permitidos
                		.allowedHeaders("Authorization", "Content-Type")  // Cabeçalhos permitidos
                		.allowCredentials(false);  // Permite cookies/sessões
            }
        };
    }
}


