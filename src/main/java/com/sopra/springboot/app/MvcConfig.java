package com.sopra.springboot.app;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.sopra.springboot.app.batch.RequestTimeInterceptor;

/** Para Spring 5 y SpringBoot 2 o superiores implementamos
la interface 'WebMvcConfigurer' en lugar de extender la clase
'WebMvcConfigurerAdapter' (deprecada a partir de estas versiones citadas) */

/** si teneis clase MvcConfig podéis activar el EnableScheduling  
 * allí o en esta clase, dará lo mismo, porque ambas clases las 
 * leerá junto con todos los beans y components (service, repository,controller) 
 * para levantar la aplicación y cargarlo todo en el IOC de Spring
 * CON ESTA ANOTACION 'EnableScheduling' PODEMOS USAR LA ANOTACION 
 * 'Scheduled' DEL MODULO DE SPRING BATCH EN CLASES CON PROCESOS
 * REPETITIVOS O POR LOTES
 */
/** @EnableScheduling */
@Configuration
/** descomentar este método para versiones superiores de SpringBoot 2 o Spring Framework 5 */
public class MvcConfig implements WebMvcConfigurer {
/** descomentar este método para versiones inferiores de SpringBoot 2 o Spring Framework 5 */
//public class MvcConfig extends WebMvcConfigurerAdapter {
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/error_403").setViewName("error_403");
	}

	
	/** A continuación 2 beans para la internacionalización e 
	implementación del InterceptorRegistry */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("es", "ES"));
		return localeResolver;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
		localeInterceptor.setParamName("lang");
		return localeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
		
		/** REGISTRO EN EL INTERCEPTOR DEL REQUEST TIME DECLARADO AL FINAL Y EN EL PAQUETE BATCH */
		registry.addInterceptor(requestTimeInterceptor);
	}
	
	/** Bean para el paso la exportación a xml */
	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller =  new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(new Class[] {com.sopra.springboot.app.view.xml.ClienteList.class});
		return marshaller;
	}
	
	/** CONFIGURACION DEL EVENTO 'RequestTimeInterceptor' */
	@Autowired
	@Qualifier("requestTimeInterceptor")
	private RequestTimeInterceptor requestTimeInterceptor;

    /* YA HEMOS IMPLEMENTADO EL METODO addInterceptors ARRIBA PARA LA
	INTERNACIONALIZACIÓN, ASÍ QUE SIMPLEMENTE AÑADIMOS UN REGISTRO MÁS A ESE METODO */
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(requestTimeInterceptor);
//	}
}
