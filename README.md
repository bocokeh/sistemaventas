# Sistema de Ventas con Simulación de Concurrencia

## Descripción

Sistema de punto de venta desarrollado en Java que simula múltiples usuarios realizando operaciones comerciales de forma concurrente. El sistema incluye gestión completa de inventarios, clientes, proveedores y ventas, implementando control de concurrencia para operaciones simultáneas y manejo thread-safe de la base de datos.

## Características Principales

- **Simulación Multi-usuario**: Múltiples hilos representando usuarios reales o simulados
- **Inventario Compartido**: Control de concurrencia para evitar sobreventas
- **Pagos Concurrentes**: Procesamiento paralelo de transacciones
- **Tiempo Real**: Actualizaciones instantáneas del inventario y bloqueos
- **Interfaz Gráfica**: Mínimo 3 ventanas para diferentes funcionalidades

## Funcionalidades

### 1. Sistema de Autenticación (Login)
- Ventana de login segura con validación de credenciales
- Control de acceso basado en roles de usuario
- Sesión de usuario con timeout automático
- Integración con base de datos para autenticación

### 2. Gestión de Productos
- CRUD completo de productos (Crear, Leer, Actualizar, Eliminar)
- Control de inventario en tiempo real
- Categorización y búsqueda avanzada de productos
- Actualización automática de stock con operaciones concurrentes

### 3. Administración de Clientes y Proveedores
- Gestión completa de información de clientes
- Registro y mantenimiento de proveedores
- Historial de transacciones por cliente/proveedor
- Reportes de actividad comercial

### 4. Procesamiento de Ventas Concurrente
- Múltiples cajeros pueden procesar ventas simultáneamente
- Control de stock thread-safe para evitar sobreventas
- Generación automática de detalles de venta
- Cálculo en tiempo real de totales e impuestos

### 5. Reportes y Gráficos
- Reportes de ventas por período
- Gráficos estadísticos de rendimiento
- Análisis de productos más vendidos
- Exportación de datos para análisis externo

## Arquitectura Técnica

### Control de Concurrencia
- **Synchronized blocks/methods**: Para operaciones críticas sobre inventario
- **ReentrantLock**: Control fino de acceso a recursos compartidos
- **Atomic variables**: Para contadores y operaciones atómicas
- **Thread-safe collections**: Para manejo seguro de datos compartidos

### Manejo de Hilos
- **Thread pool**: Para gestión eficiente de usuarios concurrentes
- **ExecutorService**: Coordinación de tareas paralelas
- **CompletableFuture**: Para operaciones asíncronas
- **Sincronización**: Barreras y semáforos según necesidad

### Gestión de Inventario
- **Stock tracking**: Control preciso de cantidades disponibles
- **Reservation system**: Reserva temporal durante proceso de compra
- **Rollback mechanism**: Liberación de stock en caso de fallo de pago
- **Real-time updates**: Notificación inmediata de cambios

## Instalación y Ejecución

### Prerrequisitos
- Java JDK 11 o superior
- IDE compatible (IntelliJ IDEA, Eclipse, NetBeans)
- Git para clonación del repositorio

### Pasos de Instalación
```bash

\# Clonar el repositorio

git clone \[URL\_DEL\_REPOSITORIO]

cd sistemaventaa



\# Compilar el proyecto (si usas línea de comandos)

javac -d build -cp "librerias/\*" src/\*\*/\*.java



\# Ejecutar la aplicación

java -cp "build:librerias/\*" sistemaventa.SistemaVenta

```

### Configuración de Base de Datos
1. Crear base de datos MySQL/PostgreSQL
2. Ejecutar el script `venta.sql` incluido en el proyecto
3. Configurar conexión en `src/Modelo/Conexion.java`:
   ```java
   // Actualizar con tus credenciales
   String url = "jdbc:mysql://localhost:3306/venta";
   String user = "tu_usuario";
   String password = "tu_password";
   ```

### Ejecución desde IDE
1. Abrir el proyecto en IntelliJ IDEA o NetBeans
2. Configurar las librerías externas desde la carpeta `librerias/`
3. Ejecutar `sistemaventa.SistemaVenta.main()`
4. Usar credenciales por defecto o las configuradas en la BD

## Estructura del Proyecto

```

sistemaventaa/

├── .idea/                        # Configuración de IntelliJ IDEA

├── build/                        # Archivos compilados

├── librerias/                    # Librerías externas

├── nbproject/                    # Configuración NetBeans

├── out/                         # Salida de compilación

├── src/

│   ├── Img/                     # Recursos de imágenes

│   ├── Modelo/                  # Modelos de datos

│   │   ├── Cliente.java         # Modelo del cliente

│   │   ├── ClienteDao.java      # DAO para cliente

│   │   ├── Combo.java           # Modelo combo/dropdown

│   │   ├── Conexion.java        # Conexión a base de datos

│   │   ├── Config.java          # Configuración del sistema

│   │   ├── Detalle.java         # Detalle de venta

│   │   ├── Eventos.java         # Manejo de eventos

│   │   ├── login.java           # Modelo de login

│   │   ├── LoginDAO.java        # DAO para autenticación

│   │   ├── Productos.java       # Modelo de productos

│   │   ├── ProductosDao.java    # DAO para productos

│   │   ├── Proveedor.java       # Modelo de proveedor

│   │   ├── ProveedorDao.java    # DAO para proveedor

│   │   ├── Venta.java           # Modelo de venta

│   │   └── VentaDao.java        # DAO para ventas

│   ├── Reportes/                # Reportes del sistema

│   │   └── Grafico.java         # Gráficos y reportes

│   ├── sistemaventa/            # Clase principal

│   │   └── SistemaVenta.java    # Punto de entrada

│   └── Vista/                   # Interfaces gráficas

│       ├── Login.java           # Ventana de login

│       ├── Login.form           # Diseño de login

│       ├── Sistema.java         # Ventana principal

│       └── Sistema.form         # Diseño del sistema

├── build.xml                    # Script de construcción

├── manifest.mf                  # Manifiesto de la aplicación

├── sistemaventaa.iml           # Archivo de módulo IntelliJ

└── venta.sql                   # Script de base de datos

```

## Componentes Principales

### Modelos de Datos (Modelo/)
- **Cliente.java**: Entidad cliente con información personal y comercial
- **Productos.java**: Modelo de productos con control de inventario
- **Proveedor.java**: Información de proveedores y sus productos
- **Venta.java**: Registro de transacciones de venta
- **Detalle.java**: Detalles específicos de cada venta
- **login.java**: Modelo para autenticación de usuarios

### Acceso a Datos (DAO Pattern)
- **ClienteDao.java**: Operaciones CRUD para clientes
- **ProductosDao.java**: Gestión de productos con control concurrente
- **ProveedorDao.java**: Administración de proveedores
- **VentaDao.java**: Procesamiento de ventas thread-safe
- **LoginDAO.java**: Autenticación y control de sesiones

### Interfaces Gráficas (Vista/)
- **Login.java/.form**: Ventana de autenticación
- **Sistema.java/.form**: Interfaz principal del sistema
- Formularios diseñados con NetBeans GUI Builder

### Utilidades del Sistema
- **Conexion.java**: Pool de conexiones thread-safe a la base de datos
- **Config.java**: Configuración global del sistema
- **Eventos.java**: Manejo de eventos del sistema
- **Grafico.java**: Generación de reportes visuales

## Tecnologías de Concurrencia Utilizadas

### Sincronización
- `synchronized` para métodos críticos
- `ReentrantLock` para control avanzado
- `Semaphore` para limitar recursos
- `CountDownLatch` para coordinación

### Colecciones Thread-Safe
- `ConcurrentHashMap` para inventario
- `BlockingQueue` para procesamiento de pedidos
- `CopyOnWriteArrayList` para listas de usuarios

### Atomic Operations
- `AtomicInteger` para contadores
- `AtomicReference` para referencias compartidas
- `AtomicBoolean` para flags de estado

## Características de la Simulación

### Usuarios Simulados
- Comportamiento aleatorio de compra
- Diferentes velocidades de navegación
- Patrones de compra realistas

### Métricas Monitoreadas
- Número de usuarios concurrentes
- Transacciones por segundo
- Tiempo promedio de respuesta
- Conflictos de concurrencia detectados

### Logging y Monitoreo
- Registro detallado de todas las operaciones
- Timestamps precisos para análisis de concurrencia
- Alertas de conflictos o deadlocks
- Estadísticas de rendimiento

## Video Demostrativo

El video incluido muestra:
- Operaciones simultáneas de múltiples usuarios
- Efectos en tiempo real sobre el stock
- Manejo de situaciones de concurrencia
- Explicación del uso de mecanismos de sincronización
- Demostración de ReentrantLock y colas concurrentes

## Contribución

1. Fork del repositorio
2. Crear branch para nueva feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit de cambios (`git commit -am 'Agregar nueva funcionalidad'`)
4. Push al branch (`git push origin feature/nueva-funcionalidad`)
5. Crear Pull Request

## Licencia

Este proyecto está bajo
