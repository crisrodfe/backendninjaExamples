# backendninja
Proyecto del curso Desarrollo Web con Spring Framework 4


Para su creación usé el starter que ofrece Spring desde su página.
Para el control de dependencias usé Maven, entre las utilizadas están:spring-boot-starter-web,-thymelead,-data-jpa,mysql-connector.

El proyecto incluye varios ejemplos del uso de Spring y otras tecnologías:
  - Un controlador simple que devuelve una vista con una petición Get, con uso de las etiquetas @Controller,@RequestMapping,
  @GetMapping, etc. (HelloWorldController.java, helloworld.html)
  - Controlador que recibe de varias maneras una petición get con parámetros para uso de las etiquetas
  @PathVariable y @RequestParam (ExampleController.java, example.html)
  - Controlador que filtra los datos del formulario de una vista y avisa de los errores. Se ha usado las notaciones 
  de thymeleaf para la parte de la vista(th:text,th:each, etc). (Example2Controller.java, form.html)
  - Un componente Interceptor que muestra en el Log el tiempo que ha tardado una petición
    (RequestTimeInterceptor.java,WebMvcConfiguration.java)
  - Servicio simple de ejemplo que devuelve una lista de objectos Person(clase utilizada como modelo) y ques
  es usado por un controlador para mostrar en una template una tabla simple con los datos.(ExampleService.java)
  
  - He creado una entity que representa una tabla creada en MySQL (Course.java) para trabajar la persistencia. Para poder hacer uso hay un repositorio JPA (CourseJpaRepository.java) que será el que relice las querys a la base de datos
  y que será utilizado por un servicio (CourseServiceImpl.java) para poder listar, añadir, eliminar o modificar la tabla Course de nuestra base de datos. Con el controlador CourseController.java se enviará los datos devueltos por 
el servicio y se mostrará un listado de todos los cursos en la template courses.html con las notaciones de thymeleaf.
Además en course.html hay un formulario con el que podremos añadir un registro a nuestra table Courses haciendo uso tambien
del servicio, el controlador y el repositorio.
