# veterinariaBack
Backend de un proyecto de veterinaria en springBoot, en el cual se pueden crear usuarios de mascotas y agregarle sus mascotas y gestionar el tema de vacunación.

### [Visita el Front-end](https://github.com/AlzateLeon/veterinariaFront)

**Funcionalidades**
* Se puede usar con la base de datos temporal H2 para temas de practica o si no se tiene una BD definida
* Script inicial para tener datos desde que se inicia la aplicacion y asi tener un usuario de prueba y un "administrador" del sistema (cuando se usa H2 para no tener que repetir procesos)
* Implementación de validacion de cuenta a traves de correo electronico
* Implementación de carga de imagenes tanto de mascotas como de los usuarios almacenandose en un campo @Lob de la tabla de la BD

### Usar la base de datos MySQL
1. Se debe descargar docker
2. Instalamos la ultima version de MySQL -> docker pull mysql:latest
3. Creamos el contenedor de MySQL -> docker run -p  3306:3306 --name mysql-container -e MYSQL_ROOT_PASSWORD=password mysql:latest
    * cambiar "password" por la contraseña de la BD
    * cambiar "mysql-container" por el nombre del contenedor
4. Redespliega la aplicación

### Ver la base de datos temporal H2, (cuando esta desplegado) 
* http://localhost:8080/veterinaria/h2-console

### Ver documentacion de controladores,(cuando esta desplegado) 
* http://localhost:8080/veterinaria/swagger-ui/index.html

### Pendientes
- [X] Implementar modulo de vacunación
- [X] Implementar módulo de administrador
- [ ] Implementar una base de datos diferente a la de H2

### Pendientes cliente
- [ ] Implementar que las citas se pongan solo cada media hora
- [ ] Poder agendar citas desde el panel de administración
- [ ] Mostrar la hora en la lista de citas (panel administración)
- [ ] implementar unidades disponibles por cada vacuna
- [ ] Mostrar la información de cada usuario y sus mascotas (panel administración)

