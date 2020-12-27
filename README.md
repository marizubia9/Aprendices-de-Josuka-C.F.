# Aprendices de Josuka C.F.

Proyecto realizado por cuatro estudiantes de la Universidad de Deusto en Proceso de Software y Calidad

### Step 1 - Servicio Externo

El proyecto cuenta con un servicio externo, de la cual se consiguen los partidos jugados y las sanciones puestas a los jugadores en cada partido. Por ello, es necesario ejecutar el siguiente comando **ANTES** de cualquier ejecución.

``` python launch_AprendicesDeJosuka_partidos.py --host 127.0.0.1 --port 5000 ```

Para poder ejecutar correctamente este microservicio, requiere:
* python3
* flask
* flask_restful
* json
* bson
* pymongo
* jsonpickle

### Step 2 - Servidor de Aprendices de Josuka C.F

Al ser una arquitectura cliente-servidor, será necesario ejecutar el servidor y que el cliente se conecte a él. Conexión que se realizará mediante RMI.
Para ello:  
`mvn clean` elimina la carpeta destino  
`mvn compile` compila el proyecto  
`ant -f build.xml server` ejecuta el servidor en el localhost  

### Step 3 - Administrador de Aprendices de Josuka C.F

Para lanzar las ventanas, y poder ejecutar la parte del Administrador.  
`ant -f build.xml admin` ejecuta el cliente, conectándose al servidor anterior.
Aquí, se podrá:
- Añadir Equipos
- Ver partidos (según categoría)
- Ver Entrenadores, jugadores y equipos
- Editar entrenadores, jugadores y equipos
- Clasificación

### Step 4 - Cliente de Aprendices de Josuka C.F

Esta parte es la referente a los jugadores y los entrenadores del club. 
`ant -f build.xml jugador` ejecuta el cliente, conectándose al servidor anterior.
Aquí, se podrá:
- Ver estadísticas
- Ver partidos (según categoría)
- Ver ficha y equipos
- Editar datos personales
- Clasificación

### Step 5 - Testing

Mediante `mvn test` se ejecutarán todos los test unitarios realizados en el proyecto. Además, debido a que se han integrado JaCoCo y Contiperf, se generarán los reports correspondientes. 
