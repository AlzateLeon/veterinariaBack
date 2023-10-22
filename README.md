# veterinariaBack
Backend de un proyecto de veterinaria en springBoot, en el cual se pueden crear usuarios de mascotas y agregarle sus mascotas y gestionar el tema de vacunación.

### [Visita el Front-end](https://github.com/AlzateLeon/veterinariaFront)

**Funcionalidades**
* Se puede usar con la base de datos temporal H2 para temas de practica o si no se tiene una BD definida
* Script inicial para tener datos desde que se inicia la aplicacion y asi tener un usuario de prueba y un "administrador" del sistema (cuando se usa H2 para no tener que repetir procesos)
* Implementación de validacion de cuenta a traves de correo electronico
* Implementación de carga de imagenes tanto de mascotas como de los usuarios almacenandose en un campo @Lob de la tabla de la BD

### Ver la base de datos temporal H2, (cuando esta desplegado) 
* http://localhost:8080/veterinaria/h2-console

### Ver documentacion de controladores,(cuando esta desplegado) 
* http://localhost:8080/veterinaria/swagger-ui/index.html

### Pendientes
- [ ] Implementar modulo de vacunación
- [ ] Implementar módulo de administrador
- [ ] Implementar una base de datos diferente a la de H2

