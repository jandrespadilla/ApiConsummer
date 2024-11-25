# ApiConsummer

ApiConsummer es un proyecto que permite consumir APIs de manera eficiente y sencilla. Este proyecto está desarrollado en Java con SprintBooot y proporciona herramientas para gestionar las solicitudes HTTP y manejar las respuestas de las APIs.

## Características

- **Fácil de usar**: Interfaz simple y amigable para realizar solicitudes a las APIs.
- **Configuración flexible**: Permite configurar encabezados, parámetros y cuerpo de las solicitudes.
- **Manejo de respuestas**: Incluye utilidades para manejar diferentes tipos de respuestas, como JSON, XML, etc.
- **Registro de errores**: Sistema de registro para capturar y manejar errores de las solicitudes.

## Instalación

Para instalar y configurar el proyecto, sigue estos pasos:

1. Clona el repositorio:
    ```bash
    git clone https://github.com/jandrespadilla/ApiConsummer.git
    ```

2. Navega al directorio del proyecto:
    ```bash
    cd ApiConsummer
    ```


## Uso

### Endpoints de ejemplo

- **Obtener todos los productos**:
    - **URL**: `http://localhost:8981/product/`
    - **Método**: `GET`
    - **Respuesta**:
      ```json
      [
          {
              "id": 1,
              "nombre": "Curso de Java",
              "descripcion": "Curso de java para la creacion de API",
              "stock": 27,
              "precio": 120000.0
          },
          {
              "id": 2,
              "nombre": "Curso de PHP",
              "descripcion": "Curso de PHP con laravel para la creacion de API",
              "stock": 40,
              "precio": 150000.0
          },
          {
              "id": 3,
              "nombre": "Curso de Python",
              "descripcion": "Curso de Python con Dianjo para la creacion de API",
              "stock": 40,
              "precio": 130000.0
          },
          {
              "id": 4,
              "nombre": "Curso de HTML",
              "descripcion": "Curso de HTML con CSS usando Bootstrap",
              "stock": 36,
              "precio": 100000.0
          },
          {
              "id": 5,
              "nombre": "Curso de JavaScript",
              "descripcion": "Curso de JavaScript con JQuery",
              "stock": 39,
              "precio": 90000.0
          }
      ]
      ```

### Información adicional

- **Base URL del API**: `http://localhost:8981/product/`
- **Servidor de Product API**: `http://localhost:8981/`
- **Modificación del puerto**: Si deseas modificar el puerto en el que corre el servidor, puedes hacerlo en el archivo `application.properties`.

```properties
# application.properties
server.port=8981
