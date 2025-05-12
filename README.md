# Proyecto UI Mobile

Aplicación móvil desarrollada en Android con Jetpack Compose como punto de entrada para clientes de un sistema de ventas . Provee una navegación fluida con diseño moderno e intuitivo para mostrar inicio, información institucional, catálogo de productos y acceso al panel de administrador.

---

## 🛠 Tecnologías Usadas

- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **Navigation Compose**
- **Android Studio (IDE)**

---

## ✅ Requisitos Previos

- Android Studio instalado (recomendado: Giraffe o superior)
- JDK 11 o superior
- SDK de Android (API 24 mínimo)
- Emulador configurado o dispositivo físico con Android 7.0+

---

## ⚙️ Configuración y Ejecución

1. **Clona el repositorio:**

   ```bash
   git clone https://github.com/weder5226/evidencia-android-2.git
   cd evidencia-android-2
   ```

2. **Abre el proyecto en Android Studio.**

3. **Sincroniza el proyecto** (Android Studio lo hará automáticamente o haz clic en *Sync Now*).

4. **Ejecuta la app** usando el botón ▶️ en el IDE o en un emulador/dispositivo conectado.

---

## 🧭 Navegación de la Aplicación

La app está compuesta por las siguientes secciones accesibles desde el menú lateral:

- 🏠 **Inicio** – Banner, introducción y valores de la marca.
- 🛍️ **Productos** – Lista de productos con cards, imágenes y precio.
- ℹ️ **Conócenos** – Información sobre la empresa.
- 🔐 **Administrador** – Formulario de ingreso con email y contraseña.

Además, cuenta con:

- **Encabezado superior personalizado** con acceso rápido a WhatsApp.
- **Menú lateral** accesible desde el ícono de hamburguesa.
- **Footer** adaptativo con información de contacto y descripción.

---

## 📌 Notas Finales

- Las imágenes utilizadas en banners, productos y valores son de fuente externas y fueron añadidas localmente en `res/drawable`solo para uso educativo.
- El formulario de administrador simula una autenticación mediante un *toast*, sin conexión real a backend.
- El botón flotante fue integrado al encabezado para una mejor experiencia de usuario.
