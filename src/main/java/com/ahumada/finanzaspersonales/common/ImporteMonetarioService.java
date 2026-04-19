package com.ahumada.finanzaspersonales.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumada.finanzaspersonales.common.exception.ResourceNotFoundException;

@Service
public class ImporteMonetarioService {

    @Autowired
    private ImporteMonetarioRepository repo;

    @Autowired
    private MonedaService monedaService;

    public List<ImporteMonetario> getAll() {
        return repo.findAllByOrderByMontoAsc();
    }

    public ImporteMonetario getById(Long id) {
        return repo.findByIdImporteMonetario(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "ImporteMonetario con id: " + id + " no encontrado."));
    }

    public ImporteMonetario save(ImporteMonetario importeMonetario) {
        return repo.save(importeMonetario);
    }

    public ImporteMonetario save(ImporteMonetarioRequestDto dto) {
        ImporteMonetarioMapper mapper = new ImporteMonetarioMapper();
        Moneda moneda = monedaService.getById(dto.getMonedaId());
        ImporteMonetario entity = mapper.toEntity(dto, moneda);
        return repo.save(entity);
    }

    public ImporteMonetario update(ImporteMonetario importeMonetario) {
        return repo.save(importeMonetario);
    }

    public ImporteMonetario update(Long id, ImporteMonetarioRequestDto dto) {
        ImporteMonetario importeMonetario = this.getById(id);
        importeMonetario.setMoneda(monedaService.getById(dto.getMonedaId()));
        importeMonetario.setMonto(dto.getMonto());
        return repo.save(importeMonetario);
    }

    public void deleteById(Long id) {
        ImporteMonetario importeMonetario = this.getById(id);
        repo.delete(importeMonetario);
    }
}
