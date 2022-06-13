# BackEnd_SpringBoot_Proyect

Proyecto realizado con **Spring Boot** java desde: https://start.spring.io

--------------------------Configuración en Spring initialzr-----------------------
* Language: Java
* Proyect: Gradle Proyect
* Spring Boot: 2.7.0
* Packaging: Jar
* Java: 17

------------------Dependencias para el proyecto en Spring initialzr---------------
1. **Web**
- **(Spring Web)**  -> Cree aplicaciones web, incluidas RESTful, utilizando Spring MVC. Utiliza Apache Tomcat como contenedor incrustado predeterminado.
- **(Jersey)** -> Marco para desarrollar servicios web RESTful en Java que brinda soporte para las API JAX-RS.
- **(Rest Repositories)** -> Exponer repositorios de Spring Data sobre REST a través de Spring Data REST.
- **(Rest Repositories HAL Explorer)** -> Navegar por los repositorios REST de Spring Data en su navegador.
2. **SQL**
- **(Spring Data JPA)** -> Persista los datos en almacenes SQL con la API de persistencia de Java usando Spring Data e Hibernate.
- **(H2 Database)** -> Proporciona una base de datos en memoria rápida que admite la API de JDBC y el acceso R2DBC, con una huella pequeña (2 mb). Admite los modos integrado y de servidor, así como una aplicación de consola basada en navegador.
- **(MySQL Driver)** -> Controlador MySQL JDBC y R2DBC.
- **(PostgreSQL Driver)** -> Un controlador JDBC y R2DBC que permite que los programas Java se conecten a una base de datos PostgreSQL utilizando código Java estándar e independiente de la base de datos.

--------------------Configuración para trabajar con H2 Database------------------
1. Dirigirse a la ruta: src/main/resources
2. Crear el archivo application.yml
3. Ingresar el siguiente script:

&nbsp;&nbsp;&nbsp;spring:<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;datasource:<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;url: jdbc:h2:mem:testdb<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;username: test<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;password: test<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;driverClassName: org.h2.Driver<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;jpa:<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;spring.jpa.database-platform: org.hibernate.dialect.H2Dialect

4. Guardar el archivo application.yml
5. En la misma ruta: src/main/resources
6. Abrir el archivo application.properties
7. Ingresar el siguiente script:

spring.datasource.url=jdbc:h2:mem:testdb<br>
spring.datasource.driverClassName=org.h2.Driver<br>
spring.datasource.username=test<br>
spring.datasource.password=test<br>
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
