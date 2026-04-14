RENAME TABLE plazos_fijo TO plazos_fijos;
RENAME TABLE importes_monetario TO importes_monetarios;

ALTER TABLE plazos_fijos
    RENAME COLUMN capital_inicial TO capital_inicial_id;
