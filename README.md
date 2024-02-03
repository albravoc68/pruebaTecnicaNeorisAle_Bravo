<!-- PROJECT LOGO -->
<br />
<p align="center">

  <h3 align="center">Prueba Técnica Neoris</h3>

  <!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Contenido</summary>
  <ol>
    <li><a href="#DESCRIPCIÓN">Descripción</a></li>
    <li>
      <a href="#CONFIGURACIÓN">Configuración</a>
      <ul>
        <li><a href="#Configuración DB">Base de datos</a></li>
      </ul>
      <ul>
        <li><a href="#Configuración application.properties">application.properties</a></li>
      </ul>
      <ul>
        <li><a href="# Configuración Postman">Postman</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Imágenes</a>
      <ul>
        <li><a href="#installation">Diagrama</a></li>
      </ul>
      <ul>
        <li><a href="#installation">Resultado Postman</a></li>
      </ul>
    </li>
  </ol>
</details>

<!-- DESCRIPCIÓN-->
## DESCRIPCIÓN

Conforme el desafío de construir una api que permita crear usuarios utilizando UUID para sus ID, y JWT como herramienta de seguridad se han creado 3 endpoints (Cada uno con bodys y header de prueba en archivo postman):

<b>/pruebaTecnica/users/create</b>: Este endpoint existe para solventar el desafio de la prueba técnica, funciona cómo registro y autenticación de usuario, 
por lo que retorna un token que permite acceder a una funcionalidad exclusiva de usuarios autenticados.

<b>/pruebaTecnica/users/login</b>: Esta funcionalidad de login requiere un campo email y password, retorna un token de autenticación que permite acceder a una funcionalidad exclusiva de usuarios autenticados.

<b>/pruebaTecnica/users/registeredEmails</b>: Este endpoint retorna una lista de todos los emails registrados, exclusiva de usuarios autenticados, 
sólo se puede usar con el header <b>Authorization</b> con el valor del token dado en cualquiera de los otros endpoints.

## CONFIGURACIÓN
<!-- Configuración DB-->
## Configuración DB
Para configurar la base de datos es necesario ejecutar el comando de H2:
<code>RUNSCRIPT FROM 'NEORIS_PRUEBA_TECNICA_DB'</code>
utilizando el archivo NEORIS_PRUEBA_TECNICA_DB de este repositorio.

<!-- Configuración application.properties-->
## Configuración application.properties
Es necesario configurar el application.properties del proyecto con la configuración de la DB de H2:

<b>spring.datasource.url</b>=Path de conexión

<b>spring.datasource.username</b>=Usuario de la Base de datos.

<b>spring.datasource.password</b>=Contraseña del usuario de la Base de datos.

<!-- Configuración Postman-->
## Configuración Postman
Para obtener los endpoints con sus ejemplos de body y header es necesario importar el archivo <b>requests_prueba_tecnica.postman_collection</b> a POSTMAN.


## IMÁGENES
<!-- DIAGRAMA-->
## DIAGRAMA

<!-- RESULTADOS POSTMAN-->
## RESULTADOS POSTMAN


</p>
