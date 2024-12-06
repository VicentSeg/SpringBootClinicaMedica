# API REST para Clínica Médica

Este proyecto implementa una API REST para gestionar pacientes y médicos en una clínica médica.  Utiliza Spring Boot, JPA, Flyway, y JWT para autenticación.

## Funcionalidades

* **Gestión de Médicos:**  Permite registrar, listar, actualizar y eliminar médicos.  Incluye la gestión de direcciones y especialidades.
* **Gestión de Pacientes:** Permite registrar, listar, actualizar y eliminar pacientes.  Incluye la gestión de direcciones.
* **Autenticación con JWT:**  Utiliza JSON Web Tokens (JWT) para autenticar usuarios y proteger los recursos de la API.

## Tecnologías Utilizadas

* **Spring Boot:** Framework para desarrollo de aplicaciones Java.
* **Spring Data JPA:**  Para la persistencia de datos.
* **MySQL:** Base de datos relacional.
* **Flyway:**  Para la gestión de migraciones de la base de datos.
* **Lombok:**  Para reducir la cantidad de código repetitivo.
* **Java 21:**  Versión de Java utilizada.
* **auth0-jwt:** Librería para manejo de JWT.
* **Spring Security:** Framework para seguridad.


## Estructura del Proyecto

El proyecto está organizado en paquetes que reflejan la separación de responsabilidades:

* **`med.Clinica.api.domain.*`:**  Contiene las entidades JPA (`Medico`, `Paciente`, `Usuario`, `Direccion`, `Especialidad`).
* **`med.Clinica.api.domain.*.repository`:** Contiene los repositorios JPA (`MedicoRepository`, `PacienteRepository`, `UsuarioRepository`).
* **`med.Clinica.api.domain.*.service`:** Contiene los servicios (`MedicoService`, `PacienteService`, `UsuarioService` - opcional).
* **`med.Clinica.api.Controller`:** Contiene los controladores REST (`MedicoController`, `PacienteController`, `AutenticacionController`).
* **`med.Clinica.api.infra.security`:** Contiene las clases relacionadas con la seguridad ( `SecurityConfigurations`, `AutenticacionService`, `TokenService`, `SecurityFilter`, `DatosTokenJWT`).
* **`med.Clinica.api.infra.errores`:** Contiene la clase para el manejo de errores (`TratadorDeErrores`).
* **`med.Clinica.api.domain.*.dto`:** Contiene los DTOs (Data Transfer Objects) para la transferencia de datos entre capas.


## Cómo Ejecutar el Proyecto

1. **Clonar el repositorio:**  Clona este repositorio en tu máquina local.  `git clone <https://github.com/VicentSeg/SpringBootClinicaMedica.git>`
2. **Configurar la base de datos:** Crea una base de datos MySQL y configura las variables de entorno `DB_HOST`, `MYSQL_USER`, `MYSQL_PASSWORD`, y `JWT_SECRET` con los valores apropiados.
3. **Ejecutar la aplicación:** Ejecuta la aplicación usando Maven: `mvn spring-boot:run`

## Migraciones

Las migraciones de la base de datos se gestionan con Flyway.  Los scripts de migración se encuentran en la carpeta `src/main/resources/db/migration`.

## Autenticación

La autenticación se realiza mediante JWT.  Para obtener un token, envía una solicitud POST a `/login` con el nombre de usuario y la contraseña.  El token debe incluirse en el encabezado `Authorization` de todas las solicitudes posteriores como `Bearer <token>`.

## Consideraciones

* La clave secreta JWT (`JWT_SECRET`) debe ser una cadena aleatoria y segura.  Nunca la hardcodees directamente en el código.
* El manejo de errores se realiza de forma centralizada en `TratadorDeErrores`.
* Se recomienda usar un gestor de secretos para almacenar la clave secreta JWT y las credenciales de la base de datos en un entorno de producción.


## Contribuciones

Las contribuciones son bienvenidas.  Por favor, abre un *issue* o una *pull request* si tienes alguna sugerencia o encuentras algún problema.
