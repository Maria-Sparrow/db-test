CREATE SCHEMA IF NOT EXISTS `third_lab_db` DEFAULT CHARACTER SET utf8 ;
USE `third_lab_db` ;

DROP TABLE IF EXISTS medicine_categories;
DROP TABLE IF EXISTS medicine_storage;
DROP TABLE IF EXISTS using_in_life;
DROP TABLE IF EXISTS type_of_packing_has_medicine;
DROP TABLE IF EXISTS producer_has_medicine;
DROP TABLE IF EXISTS medicine;
DROP TABLE IF EXISTS type_of_packing;
DROP TABLE IF EXISTS producer;

CREATE TABLE type_of_packing (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(45) NOT NULL)
ENGINE = InnoDB;

CREATE TABLE medicine_categories (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  categories VARCHAR(45) NOT NULL)
ENGINE = InnoDB;

CREATE TABLE producer (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name_producer VARCHAR(45) NOT NULL)
ENGINE = InnoDB;

CREATE TABLE medicine_storage (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  storage VARCHAR(50) NOT NULL
  )
ENGINE = InnoDB;

CREATE TABLE using_in_life (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
 using_in VARCHAR(50) NOT NULL)
  ENGINE = InnoDB;

CREATE TABLE medicine (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  price VARCHAR(45) NOT NULL,
  medicine_storage_id INT NOT NULL,
  medicine_categories_id INT NOT NULL,
  using_in_life_id INT NOT NULL)
  ENGINE = InnoDB;
  CREATE INDEX medicine1 ON medicine (medicine_storage_id,medicine_categories_id,using_in_life_id );

CREATE TABLE type_of_packing_has_medicine (
  type_of_packing_id BIGINT NOT NULL,
  medicine_id BIGINT NOT NULL,
  PRIMARY KEY (type_of_packing_id, medicine_id))
  ENGINE = InnoDB;
  CREATE INDEX packing1 ON type_of_packing_has_medicine (type_of_packing_id,medicine_id);
ALTER TABLE type_of_packing_has_medicine
ADD CONSTRAINT FK_type_of_packing_has_medicine_medicine
FOREIGN KEY (medicine_id)
REFERENCES medicine (id),
ADD CONSTRAINT FK_type_of_packing_has_medicine_type_of_packing
FOREIGN KEY (type_of_packing_id)
REFERENCES type_of_packing (id);

CREATE TABLE producer_has_medicine (
  producer_id BIGINT NOT NULL,
  medicine_id BIGINT NOT NULL,
  PRIMARY KEY (producer_id, medicine_id))
ENGINE = InnoDB;
CREATE INDEX producer1 ON producer_has_medicine (producer_id,medicine_id);

ALTER TABLE producer_has_medicine
ADD CONSTRAINT FK_producer_has_medicine_medicine1
FOREIGN KEY (medicine_id)
REFERENCES medicine (id),
ADD CONSTRAINT FK_producer_has_medicine_producer1
FOREIGN KEY (producer_id)
REFERENCES producer (id);
INSERT INTO type_of_packing (id, type) VALUES
(1, 'tablets'),
(2, 'capsules'),
(3, 'ampoules'),
(4, 'jars');

INSERT INTO medicine_categories (id, categories) VALUES
(1, 'analgetics'),
(2, 'antispasmodics'),
(3, 'sedatives'),
(4, 'desensitizing'),
(5, 'mucolytics'),
(6, 'corticosteroids');

INSERT INTO producer (id, name_producer) VALUES
(1, 'Germany'),
(2, 'England'),
(3, 'Ukraine'),
(4, 'India'),
(5, 'China');

INSERT INTO medicine_storage (id, storage) VALUES
(1, 'metamizol_natrium'),
(2, 'drotavirinum'),
(3, 'streptocide'),
(4, 'thermopsis'),
(5, 'bifidobacteria'),
(6, 'chloropyramide'),
(7, 'magnesium'),
(8, 'natrium');

INSERT INTO using_in_life (id, using_in) VALUES
(1, 'analgetics'),
(2, 'from_a_sore_throat,from_a_cough'),
(3, 'from_alergies'),
(4, 'from_poisoning'),
(5, 'for_digestion'),
(6, 'hormones');

INSERT INTO medicine (id, name, price, medicine_storage_id, medicine_categories_id, using_in_life_id) VALUES
(1, 'Analgin', 43, 1, 3, 2),
(2, 'Noshpa', 56, 2, 1, 3 ),
(3, 'Papairine', 98, 3, 2, 5),
(4, 'Mezum', 46, 5, 6, 5),
(5, 'Ocsutozin', 104, 4, 2, 4);


INSERT INTO type_of_packing_has_medicine (type_of_packing_id, medicine_id) VALUES
(1, 3), (1, 2), (2, 4), (3, 1), (4, 3) ;


INSERT INTO producer_has_medicine (producer_id, medicine_id) VALUES
(1, 2), (1, 4), (2, 3), (3, 5), (4, 2), (5, 1);

