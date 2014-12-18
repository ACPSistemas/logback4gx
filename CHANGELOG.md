Changelog
---------

**v1.2 - 2014/12/19**

* Se agrega la posibilidad de leer cualquier propiedad del client.cfg a través del PropertyReader GxPropertyReader.
* Se prueba y asegura compatibilidad con Gx Ev3.
* Se mejora la documentación del proyecto en general y se limpian archivos innecesarios.
* Se cambia la licencia a GPLv2. Siempre es bueno hacer que los proyectos abiertos se mantengan abiertos.
* Se agregan los métodos para hacer las operaciones de login para 3 y 4 parámetros. Ej. &log.debugFormat4("Esto posee 4 reemplazos: {} {} {} {}",1,2,3,4)
* Se actualizan las bibliotecas base. Logback a su versión 1.0.11 y slf4j v1.7.9. Si bien se podría haber utilizado una versión más nueva de logback, la v1.0.11 es la última que mantiene compatibilidad de groovy conf con el SiftAppender, por lo que se mantiene esta versión hasta que se resuelva este [pedido](http://jira.qos.ch/browse/LOGBACK-957).

**v1.1 - 2013/10/10**

* Se arregla un error de importación en el xpz de la versión full.
* Se agrega un objeto File a la exportación con un ejemplo de configuración de LogBack.

**v1.0 - 2012/10/17**

* Primera versión pública.