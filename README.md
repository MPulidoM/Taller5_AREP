# Taller 5: TALLER DE DE MODULARIZACIÓN CON VIRTUALIZACIÓN E INTRODUCCIÓN A DOCKER

Este laboratorio se centra en la creación de una aplicación web utilizando el micro-framework Spark Java (http://sparkjava.com/). La aplicación proporciona servicios REST para realizar operaciones matemáticas y determinar propiedades de cadenas. Además, se implementa la capacidad de llamar a estos servicios de manera asíncrona mediante formularios en el cliente.

**Funcionalidades del Laboratorio**

El laboratorio ofrece los siguientes servicios REST:

- Sin y Cos: Calcula el seno y coseno de un valor dado.
- Palíndromo: Determina si una cadena ingresada es un palíndromo.
- Magnitud de Vector: Calcula la magnitud de un vector real de dos dimensiones.

**Despliegue con Docker**

El laboratorio incluye la creación de un contenedor Docker para facilitar el despliegue de la aplicación. Los pasos para construir la imagen Docker y desplegarla en una máquina local están detallados en la documentación.

**Publicación en DockerHub**

Para facilitar la distribución y acceso a la aplicación, la imagen Docker se publica en DockerHub. Esto permite a otros usuarios obtener la imagen y desplegar la aplicación en sus entornos.

**Cliente Asíncrono**

La interfaz de usuario del cliente ha sido mejorada para permitir la llamada asíncrona de los servicios REST. Se han implementado formularios para cada función, lo que facilita la interacción del usuario con las operaciones matemáticas y la verificación de propiedades de cadenas de manera rápida y eficiente.

Este laboratorio busca proporcionar una experiencia completa, desde el desarrollo local hasta el despliegue en Docker, con el objetivo de ofrecer una solución versátil y fácilmente accesible para operaciones matemáticas y manipulación de cadenas.

## Empezando

El proyecto contiene:

--> En la carpeta [co.edu.escuelaing.sparkdockerdemolive](https://github.com/MPulidoM/Taller5_AREP/tree/main/src/main/java/co/edu/escuelaing/sparkdockerdemolive).

- La clase [ApplicationUtilService](https://github.com/MPulidoM/Taller5_AREP/blob/main/src/main/java/co/edu/escuelaing/sparkdockerdemolive/ApplicationUtilService.java).  proporciona métodos estáticos para realizar operaciones matemáticas como calcular el seno (getSin), el coseno (getCos), determinar si una cadena es un palíndromo (isPalindrome), y calcular la magnitud de un vector bidimensional (getMagnitude). 
  
- La clase  [SparkWebServer](https://github.com/MPulidoM/Taller5_AREP/blob/main/src/main/java/co/edu/escuelaing/sparkdockerdemolive/SparkWebServer.java).  representa la implementación del servidor web utilizando Spark Java. La clase define las rutas para un formulario (/formulario) y el manejo de las operaciones matemáticas (/calcular) basándose en los parámetros proporcionados por el usuario. 

--> Archivos :

- [DockerFile](https://github.com/MPulidoM/Taller5_AREP/blob/main/Dockerfile). : Este archivo Docker define un entorno para ejecutar la aplicación Spark Java, estableciendo el directorio de trabajo, configurando el puerto de escucha, y copiando los archivos compilados y dependencias necesarios para ejecutar la clase principal SparkWebServer
- [docker-compose.yml](https://github.com/MPulidoM/Taller5_AREP/blob/main/docker-compose.yml). : Este archivo de configuración Docker Compose define dos servicios: uno para la aplicación web (web) y otro para una base de datos MongoDB (db). El servicio web se construye utilizando el Dockerfile especificado y se nombra "web", mapeando el puerto 8087 del host al puerto 46000 del contenedor.



## Requisitos previos

[Docker](https://www.docker.com/): Proporciona un entorno de contenedorización que garantiza la consistencia y portabilidad de la aplicación.

[Maven](https://maven.apache.org/) : Con esta herramienta se creo la estructura del proyecto y se manejan las dependencias que se necesitan

[Git](https://git-scm.com/) : Se basa en un sistema de control de versiones distribuido, donde cada desarrollador tiene una copia completa del historial del proyecto.

Para asegurar una correcta instalación de Maven, es crucial confirmar que la versión del JDK de Java sea compatible. Si el JDK no está actualizado, la instalación de las versiones actuales de Maven podría fallar, generando problemas durante el uso de la herramienta.
```
java -version 
```
## Arquitectura

1. SparkWebServer (Clase Java):

- Propósito: Esta clase define un servidor web utilizando Spark Java, con dos rutas principales (/formulario y /calcular). La ruta /formulario genera un formulario HTML para que el usuario ingrese datos y seleccione la operación deseada, mientras que la ruta /calcular procesa estos datos y utiliza la clase ApplicationUtilService para realizar cálculos matemáticos o verificar si una cadena es un palíndromo.
  
--> Funciones Principales:

- Generar formulario HTML.
- Procesar solicitudes y llamar a funciones de ApplicationUtilService.

2. ApplicationUtilService (Clase Java):

- Propósito: Ofrece funciones utilitarias para realizar operaciones matemáticas (seno, coseno, magnitud de vector) y verificar si una cadena es un palíndromo.
  
--> Funciones Principales:

- getCos: Calcula el coseno de un número.
- getSin: Calcula el seno de un número.
- isPalindrome: Verifica si una cadena es un palíndromo.
- getMagnitude: Calcula la magnitud de un vector bidimensional.
  
3. Dockerfile:

- Propósito: Define la configuración para construir la imagen Docker de la aplicación Spark Java.
  
--> Acciones Principales:

- Establece el directorio de trabajo y el puerto de escucha.
- Copia los archivos compilados y las dependencias necesarias.
- Define el comando para ejecutar la aplicación.
  
4. docker-compose.yml:

- Propósito: Configura y coordina los servicios necesarios para ejecutar la aplicación en un entorno Docker.
  
--> Acciones Principales:

- Define dos servicios: "web" para la aplicación Spark Java y "db" para una instancia de MongoDB.
- Especifica la construcción de la imagen usando el Dockerfile.
- Mapea los puertos entre el host y los contenedores.
- Establece volúmenes para almacenar datos y configuraciones de MongoDB.

**Funcionamiento General**:

- El usuario accede a la aplicación a través de la ruta /formulario para proporcionar datos y seleccionar una operación.
- Al enviar el formulario, la aplicación procesa la solicitud en la ruta /calcular utilizando la lógica definida en SparkWebServer y llama a funciones en ApplicationUtilService para realizar cálculos o verificar propiedades de cadenas.
- La aplicación y la base de datos MongoDB se ejecutan en contenedores Docker, coordinados por el archivo docker-compose.yml.
- La arquitectura busca ofrecer una solución completa, desde la interfaz web hasta el despliegue en contenedores Docker, permitiendo la ejecución consistente y escalable de la aplicación en diferentes entornos.

La arquitectura del laboratorio se basa en una aplicación web desarrollada con Spark Java, un micro-framework, que ofrece servicios REST para realizar operaciones matemáticas y verificar propiedades de cadenas. La lógica del servidor está encapsulada en la clase SparkWebServer, la cual gestiona las rutas, solicitudes y respuestas. Las operaciones matemáticas son llevadas a cabo por la clase ApplicationUtilService, que proporciona funciones utilitarias. La implementación se empaqueta en un contenedor Docker mediante el Dockerfile, facilitando la consistencia y portabilidad. La coordinación de servicios, incluyendo la aplicación y una base de datos MongoDB, se logra con Docker Compose. Esta arquitectura brinda una solución completa, desde la interfaz web hasta el despliegue en contenedores, promoviendo la escalabilidad y distribución eficiente del laboratorio.

## Funcionamiento-Laboratorio

Para poder ver el funcionamiento  se debe hacer lo siguiente:

Clonar el repositorio en su maquina local. Para esto utilice el siguiente comando y ejecutelo.

```
git clone https://github.com/MPulidoM/Taller5_AREP.git
```

Por consiguiente se debe ingresar al directorio del proyecto 

```
cd Taller5_AREP
```
Ya teniendo lo anterior es momento de compilar con Maven , se debe ejecutar el siguiente el comando
```
mvn clean install
```

Ya por último debemos ejecutar la clase que nos permitira ver el funcionamiento de la aplicación ( ; Windows , : Linux)
```
java -cp "target/classes;target/dependency/*" co.edu.escuelaing.sparkdockerdemolive.SparkWebServer
```

## Pruebas

Entramos con el link
```
http://localhost:4567/formulario
```


![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/ec1d47f3-9edf-422f-a2d8-8161ebf65ad7)

Para realizar cada calculo se debe dar en el boton calcular despues de poner los parametros como se indica :

- Coseno
![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/8d2a9404-1cbf-461e-8e99-0fa4c77b1b47)
![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/d1318ed1-2f6d-42bf-a50f-1dd8289f0aba)

- Seno
![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/60972a21-62ca-408e-9012-04b68c67438a)
![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/0bfe70cb-e636-418c-a303-60c83ac16974)

- Palíndromo
  
--> No es Palíndromo:
  
![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/8a35b928-8d45-46f7-adc1-0c44874fd527)
![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/3f852c55-322c-458a-a4c6-9a23d44de47c)

--> Es Palíndromo:

![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/657840f3-b7c8-4679-aa7b-1023320a016a)
![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/54a880d2-daa2-482b-8e97-0d031bb1343b)

- Magnitud

![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/63e69d8d-cbc6-402f-9d4a-c021a35b0411)
![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/771e22df-c90c-4f97-b4f3-037b70ab8f19)

## Funcionamiento - Laboratorio con Docker

- Repositorio Docker Hub : [mariana360/firstsprkwebapprepo](https://hub.docker.com/repository/docker/mariana360/firstsprkwebapprepo/general)  

Primero se debe abrir la hermmaienta de Docker Desktop en el computador y ver que este corriendo
![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/043fff76-0843-4007-9372-845721915725)

Nos dirigimos a consola y hacemos lo siguiente:

```
docker pull mariana360/firstsprkwebapprepo:latest
```
Despues seguimos con los siguientes comandos

```
docker run -d -p 34000:46000 --name funciona mariana360/firstsprkwebapprepo:latest
```
```
docker run -d -p 34001:46000 --name funciona1 mariana360/firstsprkwebapprepo:latest
```
```
docker run -d -p 34002:46000 --name funciona2 mariana360/firstsprkwebapprepo:latest
```

## Pruebas Docker

Entramos con el link correspondiente al puerto que deseamos ver :
```
http://localhost:34000/formulario
```
```
http://localhost:34001/formulario
```
```
http://localhost:34002/formulario
```

- **PUERTO 34000**
  ![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/6748dea6-d4c5-4ecc-b087-0215c6da049e)

- **PUERTO 34001**
  ![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/fb95e568-aa73-402a-8156-10a59e1f742c)

- **PUERTO 34002**
  ![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/821ca24b-31b9-4149-8177-ed8b5660c3b2)


Para la funcionalidad de la calculadora se haran las pruebas con el puerto 34000 para cada operación se debe dar click al boton Calcular :

- Coseno
![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/35f39c18-e1ef-4e9b-b7f5-226e2c215ebc)
![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/e4e83188-0a57-4c01-939b-617fb0f4eb5a)


- Seno

![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/72b63ec5-7997-40fa-b0a5-bf22c634994f)

![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/93475d84-2031-4695-a8fc-df3ce42dfcd4)


- Palíndromo
  
--> No es Palíndromo:

![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/f93b6311-a7be-46f6-a4cc-6f1ec3ca7d0b)

![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/1627921a-a0e7-4184-9659-4690d802ec5c)


--> Es Palíndromo:

![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/3dfe3895-0f8d-4fa9-908b-1d725371168e)

![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/681b44e7-3ff7-4919-9083-ef7f5432df88)


- Magnitud

![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/3c0d4014-6849-4094-8883-c9666d902c1a)

![image](https://github.com/MPulidoM/Taller5_AREP/assets/118181543/a2265487-d4f5-420a-9f15-60cebb71df11)



## Autores

* **Mariana Pulido Moreno** - *Arep 101* - [MPulidoM](https://github.com/MPulidoM)


## Construido con

* [Maven](https://maven.apache.org/) - Gestión de dependencias
* [Java](https://www.java.com/es/) - Lenguaje Utilizado
* [GitHub](https://git-scm.com/) - Control de Versiones
* [Docker](https://www.docker.com/) - Contenedor 
