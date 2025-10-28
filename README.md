# VetES - Sistema de Gestión Veterinaria

Sistema moderno de gestión de inventario y ventas para clínicas veterinarias, desarrollado con Android Jetpack Compose.

## 🎯 Características

### 📦 Gestión de Inventario
- ✅ Registrar productos con información completa (nombre, categoría, precio, stock, proveedor)
- ✅ Visualizar todos los productos en una interfaz moderna y organizada
- ✅ Editar productos existentes
- ✅ Eliminar productos
- ✅ Alertas de stock bajo (configuración de stock mínimo)
- ✅ Estadísticas rápidas: total de productos y alertas de stock bajo

### 💰 Sistema de Ventas
- ✅ Registrar ventas rápidas
- ✅ Selección de productos del inventario
- ✅ Cálculo automático de totales
- ✅ Múltiples métodos de pago (Efectivo, Tarjeta, Transferencia)
- ✅ Registro de cliente (opcional)
- ✅ Actualización automática de stock al realizar una venta
- ✅ Historial completo de ventas
- ✅ Visualización de ingresos totales

## 🏗️ Arquitectura

La aplicación sigue las mejores prácticas de Android con:

- **MVVM (Model-View-ViewModel)**: Separación clara de responsabilidades
- **Room Database**: Persistencia de datos local
- **Jetpack Compose**: UI moderna y declarativa
- **Navigation Compose**: Navegación fluida entre pantallas
- **Material Design 3**: Diseño moderno y atractivo
- **Coroutines**: Manejo asíncrono de datos
- **Flows**: Observación reactiva de datos

## 📋 Estructura del Proyecto

```
app/src/main/java/com/proyecto/vetes/
├── data/                    # Modelos de datos y base de datos
│   ├── Product.kt          # Entidad de producto
│   ├── Sale.kt             # Entidad de venta
│   ├── VetDatabase.kt      # Configuración de Room
│   └── dao/                # Data Access Objects
├── repository/             # Repositorios para acceso a datos
│   ├── ProductRepository.kt
│   └── SaleRepository.kt
├── viewmodel/              # ViewModels con lógica de negocio
│   ├── ProductViewModel.kt
│   ├── SaleViewModel.kt
│   └── ViewModelFactory.kt
├── ui/                     # Interfaz de usuario
│   ├── home/               # Pantalla principal
│   ├── inventory/          # Pantallas de inventario
│   └── sales/              # Pantallas de ventas
├── util/                   # Utilidades
│   └── Screen.kt          # Configuración de navegación
├── VetApplication.kt       # Application custom
└── MainActivity.kt         # Actividad principal
```

## 🚀 Cómo Usar

### Compilar y Ejecutar

1. Abre el proyecto en Android Studio
2. Sincroniza las dependencias Gradle
3. Conecta un dispositivo Android o inicia un emulador
4. Ejecuta la aplicación

### Gestión de Inventario

1. Desde la pantalla principal, selecciona "📦 Inventario"
2. Presiona el botón flotante "+" para agregar un nuevo producto
3. Completa los campos:
   - Nombre del producto
   - Descripción
   - Categoría (Medicamento, Alimento, Accesorio, Otro)
   - Precio
   - Stock inicial
   - Stock mínimo (para alertas)
   - Proveedor (opcional)
4. Guarda el producto
5. Para editar: toca un producto en la lista
6. Para eliminar: toca el icono de eliminar en un producto

### Registrar Ventas

1. Desde la pantalla principal, selecciona "💰 Ventas"
2. Presiona el botón flotante "+" para nueva venta
3. Selecciona el producto deseado
4. Ingresa la cantidad
5. Selecciona el método de pago
6. Opcionalmente, ingresa el nombre del cliente
7. Revisa el total y confirma la venta
8. El stock se actualizará automáticamente

## 🎨 Características de Diseño

- **Material Design 3**: Colores y componentes modernos
- **Interfaz intuitiva**: Navegación clara y fácil de usar
- **Responsive**: Se adapta a diferentes tamaños de pantalla
- **Accesible**: Elementos grandes y texto legible
- **Animaciones**: Transiciones suaves entre pantallas
- **Dark Mode**: Soporte completo para tema oscuro

## 📦 Dependencias Principales

- **Jetpack Compose**: UI moderna
- **Room**: Base de datos local
- **Navigation Compose**: Navegación
- **ViewModel**: Gestión de estado
- **Coroutines**: Programación asíncrona
- **Material 3**: Componentes UI

## 📱 Requisitos del Sistema

- **Android SDK**: 31 (Android 12+) o superior
- **Target SDK**: 35
- **Kotlin**: 2.0.21

## 🔮 Funcionalidades Futuras

- [ ] Exportación de reportes (PDF, Excel)
- [ ] Búsqueda avanzada de productos
- [ ] Gestión de clientes
- [ ] Historial de inventario
- [ ] Notificaciones push para stock bajo
- [ ] Sincronización en la nube
- [ ] Multi-usuario con roles
- [ ] Códigos de barras/QR
- [ ] Estadísticas y gráficos avanzados
- [ ] Modo offline completo

## 📄 Licencia

Este proyecto es de uso privado para la gestión de clínicas veterinarias.

---

Desarrollado con ❤️ para profesionales veterinarios

