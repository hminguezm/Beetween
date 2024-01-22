# Beetween "Prueba tecnica"

**Proyecto Java con Spring Boot y H2 Database**

Este proyecto tiene como objetivo proporcionar una solución efectiva a:

En la base de datos de comercio electrónico de la compañía disponemos de la tabla PRICES que refleja el precio final (pvp) 
y la tarifa que aplica a un producto de una cadena entre unas fechas determinadas. A continuación se muestra un ejemplo de 
la tabla con los campos relevantes:


| BRAND_ID | START_DATE           | END_DATE             | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE    | CURR     |
| -------- | -------------------- | -------------------- | ---------- | ---------- | -------- | -------- | -------- |
| 1        | 2020-06-14 00:00:00 | 2020-12-31 23:59:59 | 1          | 35455      | 0        | 35.50    | EUR      |
| 1        | 2020-06-14 15:00:00 | 2020-06-14 18:30:00 | 2          | 35455      | 1        | 25.45    | EUR      |
| 1        | 2020-06-15 00:00:00 | 2020-06-15 11:00:00 | 3          | 35455      | 1        | 30.50    | EUR      |
| 1        | 2020-06-15 16:00:00 | 2020-12-31 23:59:59 | 4          | 35455      | 1        | 38.95    | EUR      |

Campos:

- **BRAND_ID:** Foreign key de la cadena del grupo (1 = ZARA).
- **START_DATE, END_DATE:** Rango de fechas en el que aplica el precio tarifa indicado.
- **PRICE_LIST:** Identificador de la tarifa de precios aplicable.
- **PRODUCT_ID:** Identificador código de producto.
- **PRIORITY:** Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rango de fechas se aplica la de mayor prioridad (mayor valor numérico).
- **PRICE:** Precio final de venta.
- **CURR:** ISO de la moneda.

### Se pide:

Desarrollar una aplicación/servicio en Spring Boot con un endpoint REST que permita realizar consultas. La consulta debe aceptar los siguientes parámetros de entrada:

- Fecha de aplicación
- Identificador de producto
- Identificador de cadena

Como resultado, la aplicación debe devolver la siguiente información:

- Identificador de producto
- Identificador de cadena
- Tarifa aplicada
- Fechas de aplicación
- Precio final aplicado

Adicionalmente, la aplicación debe utilizar una base de datos en memoria (tipo H2) y se debe inicializar con datos de ejemplo. Puedes cambiar los nombres de los campos y agregar nuevos según sea necesario, seleccionando el tipo de dato apropiado.


## Desarrollar Tests para el Endpoint REST

Desarrollar unos tests al endpoint REST para validar las siguientes peticiones al servicio con los datos del ejemplo:
1. **Test 1:** Petición a las 10:00 del día 14 para el producto 35455 de la marca 1 (ZARA).
2. **Test 2:** Petición a las 16:00 del día 14 para el producto 35455 de la marca 1 (ZARA).
3. **Test 3:** Petición a las 21:00 del día 14 para el producto 35455 de la marca 1 (ZARA).
4. **Test 4:** Petición a las 10:00 del día 15 para el producto 35455 de la marca 1 (ZARA).
5. **Test 5:** Petición a las 21:00 del día 16 para el producto 35455 de la marca 1 (ZARA).


## La solución sigue una arquitectura hexagonal para asegurar una separación clara de las capas y facilitar el mantenimiento y la escalabilidad.

### Requisitos

- Java 17
- Maven
- Docker

# API Metrics
### A expressJS server application (NodeJS - Typescript) up [Docker](https://docker.com/) with Hexagonal Architecture.

# Requirement
-  [dotenv-cli](https://www.npmjs.com/package/dotenv-cli) (by local stage)
-  [Docker](https://www.docker.com/) ~>18 (Optional)
-  [Docker compose](https://docs.docker.com/compose/) ~>1.28.0 (Optional)

# Running in local stages

```shell
mvn compile
mvn package
mvn package -DskipTests (Optional)
mvn package -Dmaven.test.skip=true  (Optional)
```

# Running test in local stages
    
```shell
mvn test
  ```

# Running with Docker


### show swagger
```note
/api/v1/docs
```

## Run with environment file

```shell
docker-compose -f docker-compose.yml up -d --build
```

## Running a new container every time and then log output (default environment):

```shell
docker-compose up -d --build --force-recreate; docker-compose logs -f
```

## Running a new container every time and then log output (with environment):

```shell
docker-compose -f docker-compose.yml up -d --build --force-recreate; docker-compose -f docker-compose.yml logs -f
```

## Reference Links

+ [Spring Documentation](https://spring.io/projects/spring-boot/)
+ [Docker Documentation](https://www.docker.com/)
+ [Docker compose Documentation](https://docs.docker.com/compose/)
