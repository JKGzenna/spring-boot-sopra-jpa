# spring-boot-sopra-jpa
Proyecto terminado con Spring Boot, MVC, Security, JPA, Hibernate,  Thymeleaf, BootStrap, js para autocompletados, 
Spring Rest, internacionalización i18n, Spring Loaded y Exportación a Pdf, Json, XML, XLS, CSV, Fichero Plano.  

Recordar estos 2 comandos si se quieren saltar los test de Maven desde el CMD: 
'mvn clean install -Dmaven.test.skip=true' 
y 
'mvn clean install -DskipTests'.  

El proyecto necesita IDE Eclipse Oxygen o superior + plugin STS (Spring Tool Suite) descargado 
desde el marketplace, JDK8 y Maven (vale usar el embebido de Eclipse, pero si se desea usar 
desde CMD debemos descomprimirlo en c:\ y apuntarlo en una variable de entorno M2_HOME, la 
cual debe ser registrada en la variable de sistema path.  

Viene en el 'application.properties' descomentado y configurado para el datasource MySQL, 
pero podemos usarlo con H2, la cual también ha quedado preparada en el 'application.properties' 
y comentada, por tanto, con tener simplemente el Eclipse con el plugin ya podriamos clonar y 
ejecutar el proyecto sin necesidad de instalar MySQL ni Maven, ya que con el embebido y la 
base de datos H2 unido al tomcat embebido que lleva en el Boot Dashboard hacen que sólo necesitemos 
nuestro eclipse con el plugin y el jdk 8 instalados.  

Para crear nuevos usuarios encriptados consultar usar la clase 'CryptoPasswords' del paquete 
¡com.sopra.springboot.app.cryptconverter' y consultar los comentarios de dicha clase que explican 
como crearlos e insertarlos en base de datos ya sea desde el workbench de mysql conectado a la 
instancia o a través del archivo 'import.sql'.  

Recordar poner correctamente las configuraciones del datasource en el 'application.properties' 
detallando correctamente el nombre de vuestro esquema, el user y el pass de la base de datos y 
si vais a usar un import hacer 'create-drop' y levantar, despues 'create' y levantar y una vez 
ingresados los datos del 'import.sql' dejar en 'update'.  

Si no se desea hacer una migración de datos con un 'import.sql' y se desea usar el producto de 
cero dejar directamente en 'update' despues de hacer un 'create' para que al menos levante las 
tablas vacias en bbdd.  

Recordar el banner y su propiedad y la ventaja de usar DevTools en el desarrollo frente a Spring Loaded.
