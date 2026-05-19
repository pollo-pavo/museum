nombre proyecto: Museo
Asignatura DSY1103 Desarrollo Fullstack
integantes: Estean Orellana
            Miguel Gonzalez

Descripcion del Proyecto:

Sistema de backend diseñado para un museo, cuya arquitectura esta formada por
distintos microservicios que ayudan a cumplir con las necesidades del sistema.

Este proyecto implementa microservicios que crean, guardan, actualizan, eliminan y ejecutan informacion de distintos
objetos como pinturas, esculturas, historias, etc. Utilizando pruebas de integración mediante POSTMAN, ademas de compartir
esta misma información entre algunos microservicios mediante Feign Client, con un rastro de versiones por parte Flyway Migrations.

Microservicios implementados:
1. ms-empleado
2. ms-cargo
3. ms-escultura
4. ms-pintura
5. ms-autor
6. ms-biblioteca
7. ms-prestamo
8. ms-histariaEx(Historia Extranjera)
9. ms-historiaNa(Historia Nacional)
10. ms-historiaInt(Historia Interactiva)

Pasos para ejecutar:

Tenga instalado Laragon MySQL y Postman.
Encienda la base de datos en Laragon, unicamente habilitando MySQL en configuraciones.
Inicie todos los microservicios (desde el archivo java Ms[nombre]Application) haciendo uso de su IDE de confianza.
Dentro del respectivo Controller de cada microservicio ubique @RequestMapping, copie su url y peguela en 'Enter request URL' de Postman.
Para cada accion o prueba que quiera realizar mediante Postman, utilice ya sea por ejemplo PUT, GET, DELETE, y escribiendo su respectiva URL del método.


