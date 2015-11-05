CREATE TABLE if not exists `entidadbancaria` (
	`idEntidadBancaria` INT(11) NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NULL DEFAULT NULL,
	`codigoEntidad` INT(11) NULL DEFAULT NULL,
	`fechaCreacion` DATE NULL DEFAULT NULL,
	`direccion` VARCHAR(50) NULL DEFAULT NULL,
	`CIF` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`idEntidadBancaria`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=49
;
INSERT INTO `entidadbancaria` (`idEntidadBancaria`, `nombre`, `codigoEntidad`, `fechaCreacion`, `direccion`, `CIF`) VALUES
	(48, 'EL REIMON', 123, '2015-02-10', 'NO ME BORRES', 'NO ME BORRES');
