UPDATE usuarios
SET retirado = false
WHERE retirado IS NULL;

ALTER TABLE usuarios
    ALTER COLUMN retirado SET DEFAULT false,
    ALTER COLUMN retirado SET NOT NULL;

UPDATE cuentas
SET retirado = false
WHERE retirado IS NULL;

ALTER TABLE cuentas
    ALTER COLUMN retirado SET DEFAULT false,
    ALTER COLUMN retirado SET NOT NULL;

UPDATE categorias_item_presupuesto
SET retirado = false
WHERE retirado IS NULL;

ALTER TABLE categorias_item_presupuesto
    ALTER COLUMN retirado SET DEFAULT false,
    ALTER COLUMN retirado SET NOT NULL;
