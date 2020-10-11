package com.sopra.springboot.app.cryptconverter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CrytoPasswords {
	
	/** 
	 * CLASE PARA CREAR NUESTRAS CLAVES CIFRADAS A 128-256 BITS. INTRODUCIMOS LA 
	 * CLAVE QUE DESEAMOS ENCRIPTAR Y HACEMOS UN 'RUN AS JAVA APPLICATION, IREMOS 
	 * A LA CONSOLA DESPUES DE LA EJECUCION PARA VER Y COPIAR ESA CLAVE YA ENCRIPTADA
 	 * A CONTINUACION NOS VAMOS A BASE DE DATOS Y HACEMOS 2 INSERT, EL PRIMERO EN 
 	 * LA TABLA 'users' y EL SEGUNDO EN LA TABLA 'authorities'
 	 * 
	 * INSERT INTO `users` (username, password, enabled) VALUES ('tuusuario','AQUI TU CLAVE ENCRIPTADA',1);
	 * 
	 * INSERT INTO `authorities` (user_id, authority) VALUES (5,'ROLE_ADMIN');
	 * INSERT INTO `authorities` (user_id, authority) VALUES (5,'ROLE_USER');
	 * 
	 * @author jlGoldaracena
	 * 
	 */
	public static void main(String[] args) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
				//AQUI EL PASSWORD QUE QUEREMOS CIFRAR 
				System.out.println(pe.encode("AQUI LA CLAVE A ENCRIPTAR"));

	}

}
