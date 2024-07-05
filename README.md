
<h1 align="center"> CONVERTIDOR DE DIVISAS </h1>

Este proyecto es una aplicación para la conversión de monedas, desarrollada en Java, que utiliza una API para obtener las tasas de cambio más recientes de diversas monedas a nivel mundial.

## Funcionalidades Principales

- **Conversión de Divisas:** Convierte montos entre diferentes monedas usando tasas de cambio actualizadas a través de una API.
- **Submenús Dinámicos:** Presenta tres funciones distintas en el menú principal, cada una con submenús específicos para seleccionar las monedas a operar.
- **Almacenamiento de Consultas:** Permite guardar las consultas realizadas en un archivo de texto para referencias futuras.
- **Navegación Simplificada:** El usuario puede regresar al menú principal en cualquier momento durante el uso de la aplicación.

## Requisitos del Sistema

- Java 8 o superior.
- Conexión a Internet para acceder a la API de tasas de cambio.

## Instalación y Configuración

1. Clona este repositorio en tu máquina local:
   ```sh
   git clone https://github.com/Rubensao/CoinConverter.git
   ```

## Guía de Uso

Al iniciar la aplicación, el usuario puede elegir entre tres opciones principales desde el menú principal. Cada opción lleva a un submenú donde se pueden seleccionar las monedas y realizar la consulta correspondiente.

- **Opción 1:** Consultar la tasa de cambio entre dos monedas.
- **Opción 2:** Realizar la conversión de una cantidad específica de una divisa a otra.
- **Opción 3:** Obtener el código ISO estándar internacional de una moneda.

En cada submenú, el usuario tiene la opción de guardar el historial de consultas en un archivo de texto. Al terminar, siempre se puede volver al menú principal.

## API Utilizada

Esta aplicación emplea la API `ExchangeRate` para obtener las tasas de cambio actualizadas. Asegúrate de tener una clave API válida y configurada en tu proyecto.


