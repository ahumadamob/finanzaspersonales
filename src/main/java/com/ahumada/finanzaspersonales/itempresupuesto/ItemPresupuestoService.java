package com.ahumada.finanzaspersonales.itempresupuesto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumada.finanzaspersonales.categoriaitempresupuesto.CategoriaItemPresupuesto;
import com.ahumada.finanzaspersonales.categoriaitempresupuesto.CategoriaItemPresupuestoService;
import com.ahumada.finanzaspersonales.common.ImporteMonetario;
import com.ahumada.finanzaspersonales.common.ImporteMonetarioService;
import com.ahumada.finanzaspersonales.common.exception.ResourceNotFoundException;

@Service
public class ItemPresupuestoService {

    @Autowired
    private ItemPresupuestoRepository repo;

    @Autowired
    private CategoriaItemPresupuestoService categoriaItemPresupuestoService;

    @Autowired
    private ImporteMonetarioService importeMonetarioService;

    public List<ItemPresupuesto> getAll() {
        return repo.findAllByOrderByFechaVencimientoAscIdAsc();
    }

    public ItemPresupuesto getById(Long id) {
        return repo.findByIdItemPresupuesto(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "ItemPresupuesto con id: " + id + " no encontrado."));
    }

    public ItemPresupuesto save(ItemPresupuesto item) {
        return repo.save(item);
    }

    public ItemPresupuesto save(ItemPresupuestoRequestDto dto) {
        ItemPresupuestoMapper mapper = new ItemPresupuestoMapper();
        CategoriaItemPresupuesto categoria = categoriaItemPresupuestoService.getById(dto.getCategoriaId());
        ImporteMonetario importeMonetario = importeMonetarioService.getById(dto.getImporteMonetarioId());
        ItemPresupuesto entity = mapper.toEntity(dto, categoria, importeMonetario);
        return repo.save(entity);
    }

    public ItemPresupuesto update(ItemPresupuesto item) {
        return repo.save(item);
    }

    public void deleteById(Long id) {
        ItemPresupuesto item = this.getById(id);
        repo.delete(item);
    }
}
