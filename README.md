# pruebaEventos_SoniaTejeroRecio 

Este proyecto consiste en **cuatro aplicaciones independientes** desarrolladas en **Kotlin** utilizando **Android Studio**, cada una con funcionalidades específicas que se complementan para formar un ecosistema móvil robusto.

---

## 📱 Aplicaciones en el Proyecto

---

### 1. **App Eventos**

#### Descripción:
La aplicación de eventos permite a los usuarios gestionar una lista de eventos con detalles clave como nombre, descripción, precio, dirección y fecha. Esta app utiliza bases de datos locales para almacenar los datos de forma persistente.

#### Clases:

- **`EventosActivity`**:
  - **Responsabilidad**: Actúa como la actividad principal y punto de entrada.
  - **Funciones**:
    - Configuración del `RecyclerView` para listar eventos.
    - Navegación hacia la pantalla de detalle o creación de eventos.

- **`EventoDetailFragment`**:
  - **Responsabilidad**: Muestra los detalles de un evento seleccionado.
  - **Funciones**:
    - Recibe los datos del evento mediante un `Bundle`.
    - Renderiza los detalles del evento en la interfaz.
    - Permite la edición o eliminación del evento.

- **`EventoListFragment`**:
  - **Responsabilidad**: Maneja la lista de eventos almacenados.
  - **Funciones**:
    - Usa `LiveData` para observar los cambios en la base de datos.
    - Actualiza automáticamente la lista al añadir, editar o eliminar eventos.

- **`EventoDao`**:
  - **Responsabilidad**: Define las consultas SQL para operar con la base de datos Room.
  - **Funciones**:
    - Inserción, actualización, eliminación y consulta de eventos.

- **`EventoEntity`**:
  - **Responsabilidad**: Representa un modelo de datos para la tabla `eventos` en Room.
  - **Funciones**:
    - Define los atributos de un evento como `id`, `nombre`, `descripcion`, `precio`, etc.

---

### 2. **App Farmacia**

#### Descripción:
La App Farmacia permite a los usuarios explorar una lista de farmacias y su ubicación en un mapa interactivo. Usa Firebase Firestore para almacenar los datos y Google Maps para visualizarlos.

#### Clases:

- **`FarmaciaListFragment`**:
  - **Responsabilidad**: Muestra la lista de farmacias almacenadas en Firestore.
  - **Funciones**:
    - Renderiza el nombre, dirección y teléfono de cada farmacia.
    - Permite seleccionar una farmacia para ver más detalles.

- **`FarmaciaMapFragment`**:
  - **Responsabilidad**: Integra Google Maps y muestra la ubicación de las farmacias.
  - **Funciones**:
    - Carga las coordenadas desde Firestore.
    - Añade marcadores en el mapa para cada farmacia.
    - Implementa clics en los marcadores para mostrar información adicional.

- **`FarmaciaDataManager`**:
  - **Responsabilidad**: Maneja la carga y sincronización de datos desde Firestore.
  - **Funciones**:
    - Lee datos JSON locales y los sube a Firestore.
    - Implementa la funcionalidad de consulta y actualización en Firestore.

- **`FarmaciaEntity`**:
  - **Responsabilidad**: Modelo de datos para las farmacias.
  - **Funciones**:
    - Define atributos como `nombre`, `direccion`, `telefono`, `coordenadas`, etc.

- **`FirestoreManager`**:
  - **Responsabilidad**: Clase de utilidad para gestionar operaciones con Firebase Firestore.
  - **Funciones**:
    - Configuración de la base de datos.
    - Métodos para realizar consultas, añadir y eliminar farmacias.

---

### 3. **App Horario**

#### Descripción:
La aplicación Horario permite a los usuarios planificar sus actividades diarias con horarios detallados, organizados por días de la semana. Incluye notificaciones para recordar próximas actividades.

#### Clases:

- **`HorarioActivity`**:
  - **Responsabilidad**: Actividad principal y punto de entrada.
  - **Funciones**:
    - Configura la interfaz principal con tabs para cada día de la semana.
    - Navega hacia la pantalla de creación de actividades.

- **`HorarioListFragment`**:
  - **Responsabilidad**: Muestra la lista de actividades para un día específico.
  - **Funciones**:
    - Observa y actualiza la lista usando `LiveData`.
    - Permite marcar actividades como completadas o eliminarlas.

- **`NotificacionManager`**:
  - **Responsabilidad**: Gestiona notificaciones para recordar actividades.
  - **Funciones**:
    - Usa `WorkManager` para programar recordatorios.
    - Genera notificaciones personalizadas con detalles de la actividad.

- **`HorarioDao`**:
  - **Responsabilidad**: Define las operaciones SQL para la base de datos Room.
  - **Funciones**:
    - Inserción, actualización y eliminación de actividades.
    - Consultas filtradas por día de la semana.

- **`HorarioEntity`**:
  - **Responsabilidad**: Modelo de datos para las actividades.
  - **Funciones**:
    - Atributos como `id`, `nombre`, `hora`, `dia`, etc.

---

### 4. **Main App**

#### Descripción:
La Main App actúa como la aplicación principal que conecta todas las aplicaciones individuales. Incluye un saludo dinámico y navegación fluida hacia cada app.

#### Clases:

- **`MainActivity`**:
  - **Responsabilidad**: Actividad principal para navegar entre aplicaciones.
  - **Funciones**:
    - Contiene botones para abrir cada aplicación (Eventos, Farmacia y Horario).

---
## Corrección 🖇️

**Repositorio de GitHub:** [Repositorio](https://github.com/SoniaTejeroRecio/pruebaEventos_Sonia.git)

