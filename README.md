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

Aquí se muestra un ejemplo básico de cómo usar ApiConsummer:

```python
import apiconsummer

# Crear una instancia de ApiConsummer
api = apiconsummer.ApiConsummer(base_url='https://api.ejemplo.com')

# Realizar una solicitud GET
respuesta = api.get('/ruta')
print(respuesta.json())

# Realizar una solicitud POST
datos = {'clave': 'valor'}
respuesta = api.post('/ruta', json=datos)
print(respuesta.json())
