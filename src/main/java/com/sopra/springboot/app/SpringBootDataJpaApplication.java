package com.sopra.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sopra.springboot.app.models.service.IUploadFileService;


/**
* 
* @author jlGoldaracena
* 
*/


/** si teneis clase MvcConfig podéis activar el EnableScheduling  
 * allí o en esta clase, dará lo mismo, porque ambas clases las 
 * leerá junto con todos los beans y components (service, repository,controller) 
 * para levantar la aplicación y cargarlo todo en el IOC de Spring
 * CON ESTA ANOTACION 'EnableScheduling' PODEMOS USAR LA ANOTACION 
 * 'Scheduled' DEL MODULO DE SPRING BATCH EN CLASES CON PROCESOS
 * REPETITIVOS O POR LOTES
 */
@EnableScheduling
@SpringBootApplication

	//descomentar para compilar en jar - comentar para compilar en war
	public class SpringBootDataJpaApplication implements CommandLineRunner {
	//comentar para compilar en jar - descomentar para compilar en war
//	public class SpringBootDataJpaApplication extends SpringBootServletInitializer {
	//comentar para compilar en jar - descometar para compilar en war	
//	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			return application.sources(SpringBootDataJpaApplication.class);
	}

	
	
	@Autowired
	IUploadFileService uploadFileService;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
//	COMENTAR PARA DESPLEGAR EN WAR Y DESCOMENTAR PARA DESPLEGAR EN JAR
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}

//	descomentar para compilar en jar - comentar para compilar en war
	@Override
	public void run(String... args) throws Exception {
		
        /* DESCOMENTAR ESTO SI QUEREMOS QUE NOS DESTRUYA 
		LA CARPETA UPLOADS CADA VEZ QUE ARRANQUE Y PARE */
//		uploadFileService.deleteAll();
		
		
		//EJECUTAR LA PRIMERA VEZ CON ESTA LINEA PARA QUE NOS CREE LA CARPETA UPLOADS, COMENTARLA PARA SEGUNDOS ARRANQUES
//		uploadFileService.init();
		
		
		
		/* Con este método le hemos dicho que nos de 2 claves para esa contraseña segun arranque, las 
		 * cuales usé para crear los 2 primeros usuarios del import, si quereis generar claves de forma
		 * mas limpia he creado la clase CrytoPasswords en el paquete cryptconverter y desde alli
		 * ejecutando como una java aplication podeis sacar las claves que querais para añadir más usuarios,
		 * tambien lo podeis hacer desde aqui, pero es mas incomodo, ya que lo hace al levantar el servidor
		 * y no siempre necesitamos usarlo ni tener aqui este metodo
		 */
//		String password = "12345";
//		
		/* en el i le pasaremos el número de claves que queremos para el password detallado */
//		for(int i=0; i<2; i++) {
//			String bcryptPassword = passwordEncoder.encode(password);
//			System.out.println(bcryptPassword);
//		}
	}
}
