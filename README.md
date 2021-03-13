# Proceso-Digital-de-Imagenes
Programa elaborado para la clase de Proceso digital de imagenes que se enfoca en la manipulación de imagenes a través de diferentes filtros.

## Requisitos técnicos para echar a andar el contenido del repo
* jdk1.8 o superior
* maven 3.6.3

1. Clonar el repositorio
```console
foo@bar:~$ git clone https://github.com/charlanjazz/Proceso-Digital-de-Imagenes.git
```
2. Descomprimir (en caso de haber bajado un zip). En caso contrario entrar en la carpeta del proyecto (Filtros).

3. Una vez dentro de la carpeta del proyecto ejecutar:
```console
foo@bar:~$ mvn clean install
```
4. Después de construir el proyecto ejecutaremos un plugin de maven que ejecuta un servidor tomcat7 en el puerto 8080
```console
foo@bar:~$ mvn tomcat7:run
```
5. Cuando se haya terminado de levanter el servidor veremos al final en la consola
```console
INFORMACIÓN: Starting ProtocolHandler ["http-bio-8080"]
```
6. El proyecto está corriendo en la siguiente dirección:
 ```console
http://localhost:8080/Filtros
```
7. pegar esta dirección en el navegador y ya se debería de poder visualizar el proyecto.
