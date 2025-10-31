create table prendas(
    marca varchar(20) primary key,
    tipoPrenda enum('Camiseta', 'Pantalon')
);

create table ejemplares(
    prenda varchar(20),
    color enum('blanco', 'negro'),
    talla enum('S','M','L','XL'),
    stock tinyint,
    primary key(prenda, color, talla),
    foreign key (prenda) references prendas(marca)
);

-- Prendas
INSERT INTO prendas (marca, tipoPrenda) VALUES
('RunMax', 'Camiseta'),
('AthletIQ', 'Camiseta'),
('UrbanStride', 'Pantalon'),
('PeakZone', 'Pantalon'),
('FlowGear', 'Camiseta'),
('CoreMotion', 'Camiseta'),
('SprintEdge', 'Pantalon'),
('VitalForm', 'Pantalon'),
('AeroFit', 'Camiseta'),
('NordFlex', 'Pantalon');

-- Ejemplares (entre 10 y 30 por marca)
INSERT INTO ejemplares (prenda, color, talla, stock) VALUES
-- RunMax
('RunMax','blanco','S',12),
('RunMax','blanco','M',18),
('RunMax','blanco','L',10),
('RunMax','negro','S',20),
('RunMax','negro','M',15),
('RunMax','negro','L',9),
('RunMax','negro','XL',8),

-- AthletIQ
('AthletIQ','blanco','S',10),
('AthletIQ','blanco','M',14),
('AthletIQ','blanco','L',12),
('AthletIQ','blanco','XL',7),
('AthletIQ','negro','S',16),
('AthletIQ','negro','M',18),
('AthletIQ','negro','L',15),
('AthletIQ','negro','XL',10),

-- UrbanStride
('UrbanStride','negro','S',11),
('UrbanStride','negro','M',15),
('UrbanStride','negro','L',9),
('UrbanStride','negro','XL',6),
('UrbanStride','blanco','S',7),
('UrbanStride','blanco','M',10),
('UrbanStride','blanco','L',8),

-- PeakZone
('PeakZone','negro','S',18),
('PeakZone','negro','M',22),
('PeakZone','negro','L',16),
('PeakZone','negro','XL',14),
('PeakZone','blanco','S',9),
('PeakZone','blanco','M',12),
('PeakZone','blanco','L',8),
('PeakZone','blanco','XL',7),

-- FlowGear
('FlowGear','blanco','S',20),
('FlowGear','blanco','M',18),
('FlowGear','blanco','L',15),
('FlowGear','blanco','XL',12),
('FlowGear','negro','S',17),
('FlowGear','negro','M',13),
('FlowGear','negro','L',9),
('FlowGear','negro','XL',8),

-- CoreMotion
('CoreMotion','blanco','S',9),
('CoreMotion','blanco','M',11),
('CoreMotion','blanco','L',8),
('CoreMotion','negro','S',14),
('CoreMotion','negro','M',16),
('CoreMotion','negro','L',12),
('CoreMotion','negro','XL',10),

-- SprintEdge
('SprintEdge','negro','S',20),
('SprintEdge','negro','M',22),
('SprintEdge','negro','L',18),
('SprintEdge','negro','XL',16),
('SprintEdge','blanco','S',11),
('SprintEdge','blanco','M',13),
('SprintEdge','blanco','L',9),
('SprintEdge','blanco','XL',7),

-- VitalForm
('VitalForm','blanco','S',10),
('VitalForm','blanco','M',9),
('VitalForm','blanco','L',8),
('VitalForm','negro','S',14),
('VitalForm','negro','M',15),
('VitalForm','negro','L',13),
('VitalForm','negro','XL',10),

-- AeroFit
('AeroFit','blanco','S',16),
('AeroFit','blanco','M',15),
('AeroFit','blanco','L',12),
('AeroFit','blanco','XL',10),
('AeroFit','negro','S',20),
('AeroFit','negro','M',18),
('AeroFit','negro','L',15),

-- NordFlex
('NordFlex','blanco','S',12),
('NordFlex','blanco','M',11),
('NordFlex','blanco','L',9),
('NordFlex','blanco','XL',6),
('NordFlex','negro','S',14),
('NordFlex','negro','M',17),
('NordFlex','negro','L',15),
('NordFlex','negro','XL',10);
