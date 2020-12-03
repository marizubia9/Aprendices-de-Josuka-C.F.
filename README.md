# Aprendices de Josuka C.F.

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
"mvn clean" elimina la carpeta destino
"mvn compile" compila el proyecto
"ant -f build.xml server" ejecuta el servidor en el localhost

### Step 3 - Cliente de Aprendices de Josuka C.F

Para lanzar las ventanas, y poder ejecutar el proyecto con normalidad.
"ant -f build.xml admin" ejecuta el cliente, conectándose al servidor anterior

### Step 4 - Testing

Mediante "mvn test" se ejecutarán todos los test unitarios realizados en el proyecto. Además, debido a que se han integrado JaCoCo y Contiperf, se generarán los reports correspondientes. 
