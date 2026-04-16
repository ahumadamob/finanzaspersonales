# Finanzas Personales API

## Convención de acceso por ID en servicios

Para mantener una única regla de negocio al recuperar entidades por ID, cada servicio de módulo (por ejemplo `UsuarioService`, `CategoriaItemPresupuestoService`, `PresupuestoService`, etc.) debe seguir esta convención:

1. Exponer un método `getById(Long id)` en el servicio.
2. Resolver la entidad usando un método del repositorio acorde al modelo:
   - Con soft-delete: usar búsquedas que excluyan retirados (por ejemplo `findByIdAndRetiradoFalse`).
   - Sin soft-delete: usar la búsqueda correspondiente por ID.
3. Si no existe (o está retirado en modelos con soft-delete), lanzar `ResourceNotFoundException` con un mensaje consistente:
   - `"<Entidad> con id: <id> no encontrado o retirado."` (con soft-delete).
   - `"<Entidad> con id: <id> no encontrado."` (sin soft-delete).
4. En el resto del código, no acceder al repositorio directamente para búsquedas por ID; usar siempre `service.getById(...)`.

Esta convención centraliza validaciones y evita duplicación de reglas entre módulos.
