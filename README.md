# PruebaDesarrollo2020
Proyecto - Prueba de desarrollo
===============================
Autor
-----
Juan Diego Villamil Osorio
CC 1075682697

Carpetas del proyecto
---------------------------------------

El proyecto consta de 3 carpetas principales:
1. AngularCarro: En esta carpeta se encuentra el componente de angular el cual corresponde a la segunda parte de la prueba.
2. PruebaDesarrollo1: Esta carpeta contiene el proyecto en Eclipse de la primera parte de la prueba, es decir, corresponde a la aplicación de consola del vehículo a control remoto.
3. ServicioCarroPruebaDesarrollo: Esta carpeta es el proyecto de Spring boot para los servicios de la segunda parte de la actividad, esta se conecta con la parte de angular.


Instrucciones para el uso del proyecto:
---------------------------------------

Para el uso de las aplicaciones se debe contar con un IDE para la importación de los proyectos y un servidor para desplegar la página. 
El proyecto tiene dos aplicaciones:

1. De consola: Para la ejecución de esta aplicación se debe importar en el IDE de su preferencia (el proyecto se desarrollo en Eclipse) la carpeta "PruebaDesarrollo1". Una vez importado se da clic derecho en el proyecto en la opción "run-java application", realizado esto ya la aplicación se estara ejecutando, allí inicialmente pedirá el tamaño de la superficie (matriz), luego confirmar los datos y por último ingresar la cadena de comandos a ejecutar.
2. Página web: Consta de los siguientes proyectos.
	- AngularCarro: Este proyecto contiene la interfaz de la página. Los archivos que se encuentran en esta carpeta se pueden desplegar con Apache en Xampp, si se elige esta opción la carpeta se debe dejar en la carpeta donde se encuentra instalado xampp en htdocs (Ej: ..\xampp\htdocs\AngularCarro). Luego de esto se debe iniciar el Apache en xampp, iniciado el servidor se podrá acceder a la página en la url: http://localhost/AngularCarro/index.html.
	- ServicioCarroPruebaDesarrollo: Este proyecto corresponde a los servicios que consumira la aplicación de Angular, para ejecutar el proyecto primero se debe importar al IDE de su preferencia (el proyecto se desarrollo en Eclipse), ya importado se debe dar clic derecho en el proyecto en la opción "run-Spring Boot app" con ello el servicio se encontrara disponible por el puerto 9090 el cual debe estar libre para que el servicio pueda subir.
	
Uso interfaz página web
-----------------------
La página web contara con una barra de navegación la cual contiene:

1. Inicio y/o Move Car: Estas opciones redirigen a la página principal (index.html).
2. Opciones: Este botón despliega un menú el cual da acceso a las vistas existentes.
	a. Generar Superficie (index.html): Esta vista permite crear la superficie (matriz) que se usara para el desplazamiento del vehículo. Los párametros "Filas" y "Columnas" son las dimensiones que tendrá la superficie, una vez ingresados los valores se debe dar clic en el botón "Gnerar superficie" para asignar los valores.
	b. Mover (move.html): En esta vista se ingresaran los comandos a ejecutar en el atributo "Movimientos", para ejecutarlo se debe dar clic en el botón "Mover".
	c. Obtener Posicion (posicion.html): Esta vista permite obtener la posición final del carro luego de haber ejecutado la cadena de comandos en la vista "Mover". Para ejecutarlo se debe dar clic en el botón "Obtener posición".
3. Datos del autor.