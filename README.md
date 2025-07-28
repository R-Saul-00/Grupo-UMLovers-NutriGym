# Grupo-UMLovers

* Equipo:

> [Gabriel Paredes Sipe](https://github.com/gabrielps0306 "Gabriel Paredes Sipe")

> [Gustavo Montaño Cabrera](https://github.com/Gussxzz "Gustavo Montaño Cabrera")

> [Maicol Ismael Nina Zarate](https://github.com/maicolismael "Maicol Ismael Nina Zarate")

> [Rodrigo Chalco Soliz](https://github.com/RodrigoChalco "Rodrigo Chalco Soliz")

> [Rodrigo Saul Zárate Villarroel](https://github.com/R-Saul-00 "Rodrigo Saul Zárate Villarroel")

> [Oliver Saul Garcia Guzman](https://github.com/olivergarguz "Oliver Saul Garcia Guzman")

### Proyecto NutriGym

---

Este proyecto **NutriGym** simula funcionalidades clave de una aplicación de gestión de usuarios y dietas, operando como una base de datos en memoria para propósitos de demostración. Su objetivo es modelar procesos como el registro de usuarios, el inicio de sesión y la gestión básica de dietas personalizadas.

---
### Módulos Implementados:

* **Simulación de Base de Datos de Usuarios:** Maneja una lista de usuarios registrados por defecto. Permite verificar la existencia de cuentas por correo o usuario. La clase principal es `SimularBDUsuarios`.
* **Simulación de Inicio de Sesión:** Modela el proceso de un intento de sesión. Verifica la existencia del usuario o correo, luego valida la contraseña y, si es exitoso, muestra los datos del usuario simulando una vista de perfil. La clase `SimularIniciarSesion` contiene el método `main` y utiliza la clase `Usuario`.
* **Simulación de Registro de Nueva Cuenta:** Permite crear nuevas cuentas. Solicita datos como correo electrónico, contraseña y nombre de usuario, validando que no estén duplicados. Luego pide información adicional como nombre público, fecha de nacimiento, peso, altura, sexo (con validación para "hombre" o "mujer") y región/país (mostrando una lista disponible). La clase principal es `SimularRegistrarUsuario` y se apoya en las clases `ListaPais` y `ListaGenero`.
* **Simulación de Base de Datos de Alimentos:** Utiliza las clases `Alimento` para crear objetos alimento y `ListaAlimentos` para mantener una lista de estos. La clase `AlimentosPorPais` permite filtrar alimentos por región.
* **Simulación de Gestión de Dieta:** Implementa el caso de uso "gestionar dieta". Primero verifica si el usuario está registrado y luego ofrece opciones como agregar, borrar y ver alimentos en la dieta, incluyendo cálculos de calorías. Muestra la lista de alimentos filtrada por la región del usuario. La clase principal es `SimularCrearDieta`.

---

### Tecnologías Utilizadas:

* **Lenguaje de Programación:** Java JDK 23
* **Entorno de Desarrollo y Compilación:** Eclipse IDE
* **Sistema Operativo de Desarrollo:** Windows (pero diseñado para ser compatible con entornos Linux como opensuse - 12)

---

### Requisitos de Ejecución:

Para compilar y ejecutar este proyecto, solo necesitas tener instalado:
* **Java Development Kit (JDK) versión 23** o superior.

---

### Estructura del Proyecto:
.
├── .classpath

├── .gitignore

├── .project
├── README.md
└── src/
    └── nutrigym/
        └── modelo/
          ├── Alimento.java
          ├── AlimentosPorPais.java
          ├── ListaAlimentos.java
          ├── ListaGenero.java
          ├── ListaPais.java
          ├── SimulaBDUsuarios.java
          ├── SimularCrearDieta.java
          ├── SimularIniciarSesion.java
          ├── SimularRegistrarUsuario.java
          └── Usuario.java
          
---

### Pasos para la Ejecución:

El proyecto contiene **tres puntos de entrada principales** que simulan distintos casos de uso. Puedes ejecutar cada uno de ellos de forma independiente.

1.  **Obtener el Proyecto:**
    Descarga el código fuente desde el repositorio en el siguiente enlace: **(https://github.com/R-Saul-00/Grupo-UMLovers-NutriGym.git)**. Una vez descargado, descomprime el archivo si es necesario y navega a la carpeta raíz del proyecto.



2\.  \*\*Compilar el Código Fuente:\*\*

    Aunque Eclipse IDE maneja la compilación automáticamente, si necesitas compilar desde la terminal (por ejemplo, en un entorno de servidor o con otras herramientas), abre una terminal en la carpeta raíz del proyecto y ejecuta el siguiente comando:

    ```bash

    javac src/nutrigym/modelo/\*.java

    ```



3\.  \*\*Ejecutar las Aplicaciones Principales (Selecciona una):\*\*

    Una vez compilado, puedes ejecutar la simulación que desees desde la misma carpeta raíz del proyecto. Todas las interacciones se realizan por consola.



    \* \*\*Simular Registro de Nueva Cuenta:\*\*

        ```bash

        java -cp src nutrigym.modelo.SimularRegistrarUsuario

        ```

        \*(Te guiará para ingresar los datos de un nuevo usuario, validando duplicados y formatos.)\*



    \* \*\*Simular Inicio de Sesión:\*\*

        ```bash

        java -cp src nutrigym.modelo.SimularIniciarSesion

        ```

        \*(Te pedirá un correo/usuario y contraseña para verificar si existe una cuenta.)\*



    \* \*\*Simular Gestión de Dieta:\*\*

        ```bash

        java -cp src nutrigym.modelo.SimularCrearDieta

        ```

        \*(Verificará tu usuario y te permitirá gestionar una dieta, agregar alimentos y ver cálculos.)\*



4\.  \*\*Interacción por Consola:\*\*

    Una vez que inicies cualquiera de las aplicaciones, sigue las instrucciones que aparecerán en la terminal, utilizando el teclado para ingresar la información solicitada.



---



\### Repositorio:



El código fuente completo de este proyecto se encuentra alojado en:

\*\*\[ENLACE\_A\_TU\_REPOSITORIO\_GITHUB]\*\*

\*(\*\*Nota:\*\* Asegúrate de pegar aquí la URL de tu repositorio real.)\*



---



\### Limitaciones Conocidas y Funcionalidades No Implementadas:



\* Esta es una simulación en memoria; los datos no persisten una vez que la aplicación se cierra.

\* Las siguientes funcionalidades no han sido implementadas en esta versión: "gestionar rutina", "gestionar entrenamiento", "gestionar notificaciones" y "localizar gimnasio".



---

