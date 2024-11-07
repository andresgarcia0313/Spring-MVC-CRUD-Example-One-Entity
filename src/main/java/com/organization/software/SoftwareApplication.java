package com.organization.software;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que arranca la aplicación Spring Boot.
 * Esta clase contiene el método `main` que es el punto de entrada para iniciar la aplicación.
 * La anotación @SpringBootApplication habilita la configuración automática, el escaneo de componentes y la configuración de la aplicación.
 */
@SpringBootApplication
public class SoftwareApplication {

    /**
     * Método principal que arranca la aplicación Spring Boot.
     * 
     * @param args Argumentos de la línea de comandos pasados a la aplicación.
     * @see SpringApplication#run(Class, String...)
     */
    public static void main(String[] args) {
        // Inicia la aplicación Spring Boot. Este método configura el contexto de la aplicación y arranca el servidor embebido.
        SpringApplication.run(SoftwareApplication.class, args);
    }

}
