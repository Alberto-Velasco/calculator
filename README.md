## Microservicio de Calculadora

Este proyecto es un microservicio de calculadora que permite realizar operaciones de suma y resta con números decimales. A continuación, se proporciona información sobre la estructura del proyecto, las dependencias utilizadas, las funcionalidades implementadas, los procedimientos de compilación y ejecución, así como ejemplos de llamadas de la API.

## Estructura del Proyecto

El proyecto sigue la siguiente estructura de directorios:

```
src/
|-- main/
| |-- java/
| | |-- com/
| | | |-- example/
| | | | |-- calculator/
| | | | | |-- config/
| | | | | | |-- SwaggerConfig.java
| | | | | |-- controller/
| | | | | | |-- CalculatorController.java
| | | | | |-- exceptions/
| | | | | | |-- CustomExceptionHandler.java
| | | | | |-- request/
| | | | | | |-- CalculatorRequest.java
| | | | | |-- service/
| | | | | | |-- CalculatorService.java
| | | | | | |-- impl/
| | | | | | | | |-- CalculatorServiceImpl.java
| |-- resources/
| | |-- application.properties
|-- test/
| |-- java/
| | |-- com/
| | | |-- example/
| | | | |-- calculator/
| | | | | |-- controller/
| | | | | | |-- CalculatorControllerTest.java
| | | | | |-- service/
| | | | | | | | |-- impl/
| | | | | | |-- CalculatorServiceTest.java
```


## Dependencias Utilizadas

Este proyecto utiliza las siguientes dependencias:

- Spring Boot: Para el desarrollo de la aplicación web y la configuración de Spring.
- Spring Web: Para la creación de la API RESTful.
- OpenAPI (Swagger): Para definir y documentar la API.
- JUnit5: Para escribir pruebas unitarias.
- Mockito: Para simular objetos y comportamientos en las pruebas.

## Funcionalidades Implementadas y Alcance del Servicio

Este microservicio de calculadora actualmente implementa las siguientes funcionalidades:

- Suma de dos números decimales.
- Resta de dos números decimales.

El servicio está diseñado para recibir solicitudes HTTP y devolver respuestas JSON con los resultados de las operaciones.

## Procedimientos de Compilación y Ejecución

Para compilar y ejecutar el proyecto, sigue estos pasos:

1. Clona el repositorio desde GitHub:
   git clone https://github.com/Alberto-Velasco/calculator

2. Navega al directorio del proyecto:
      cd calculator
3. Compila el proyecto utilizando Maven:
     mvn clean install
4. Ejecuta la aplicación Spring Boot:
     java -jar target/calculator-1.0.jar
   
La aplicación estará disponible en http://localhost:8090

Ejemplos de Llamadas de la API

Suma

POST /api/calculator/calculate
Content-Type: application/json

{
    "operand1": 5.5,
    "operand2": 3.2,
    "operationType": 1
}
Respuesta:
{
    "result": 8.7
}

Resta

POST /api/calculator/calculate
Content-Type: application/json

{
    "operand1": 8.7,
    "operand2": 3.5,
    "operationType": 2
}
Respuesta:
{
    "result": 5.2
}
