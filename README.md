# Arquitectura y diseno

Para este proyecto decidi utilizar una arquitectura hexagonal, basado en features y el patron MVVM
donde las capas de adentro hacia afuera son:

- `data`: Abarca todo lo relacionado al dominio del negocio.
- `api`: Se encuentran las implementaciones de los `datasources` que se encuentran en la capa de
  dominio.
- `components`, `activities` y `view models`: Aca se encuentran todos los componentes de vista y del
  framework de Android como tal.

La interaccion de las capas es descendente y unidireccional, es decir, las capas superiores tienen
unicamente acceso a las capas inferiores lo que permite mantener los contextos de cada capa lo mas
limpios posibles y con un mayor enfonque al __para si__.

## `components`

Contienen los elementos unicamente de vistas, ya que al utilizar `Jetpack Compose` se saca un mayor
provecho para incrementar la cohesion y reducir el acoplamiento (uno de los grandes problemas de
Android en el pasado).

Ademas, el diseno utilizado es `Atomic Design`, el cual permite una mayor flexibilidad ayudando a la
reutilizacion de cada componente.

# Patrones de diseno relevantes

- MVVM.
- Repository.
- Strategy.
- Atomic Design.

# Alcance futuro

Bien, si pensamos en una aplicacion del mundo real, esta app tendria que tener un backend claramente
estructurado y que empodere a la app.

En cuanto al feed de recetas, para un mejor logro y uso, traer el listado paginado y no
todos. De momento en el mock de backend que esta, se encuentra aproximadamente 10 recetas; sin
embargo, estos podrian ser miles lo cual, a pesar de que los `RecyclerView`s o los `LazyColumn` en
el caso de Compose estan bien optimizados para mantener una buena cantidad de datos esto podria
generar un mal desempeno en equipos de gama baja, generando una mala experiencia de usuario. De
igual manera, de momento la busqueda de recetas se encuentra en de este lado, y aunque no esta mal,
si pensamos en los datos paginados, lo mejor seria realizar esta busqueda con los datos en cache (
con la intencion de mostrar algo rapido al usuario) y en un servicio dedicado.

De igual manera, aunque mencionado levemente, implementar un cache de datos para brindar una mejor
experiencia al usuario.

Mejor manejo de excepciones al igual que un incremento en las pruebas, aunque estas no garanticen
que la app vaya a estar complemente fuera de problemas, si los reducen significativamente.

Implementacion de analitica.

Implementacion de ambientes de desarrollo.

Implementacion de sugerencias y reportes por parte del usuario en cuanto a la app. Suelo ser
partidario de empoderar al usuario en cuanto a lo que usa y quiere mejorar.

# Anexos

## Los __porquees__

- `minSdk` en `24` es debido a la cobertura a usuarios, lo que significa que hay alrededor de un 94%
  de usuarios cubiertos.
- Falta de implementacion de la tercera vista: `Maps`; se debio a que no pude sacar mas tiempo para
  realizarlo.
- Escacez de pruebas unitarias: Nuevamente, el tiempo me fue un factor en contra, sin embargo,
  intente que el objetivo de implementar pruebas fuera claro.
- No utilice una libreria de inyeccion de dependencias porque no me parecio relevante y de gran
  provecho para lo corto que es el proyecto. Sin embargo, se encuentra una leve implementacion hecha
  por mi.
- A pesar de que para el alcance de la app, considero que en la implementacion actual hubo un
  sobreesfuerzo de ingenieria. Pudo haber sido mas sencillo, pero hey! La idea es mostrar y fue esto
  ultimo lo que me consumio mas tiempo y por lo que no pude implementar mas pruebas ni completar la
  pantalla del map.
