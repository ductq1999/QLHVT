create database qlhvt;
use qlhvt;
 CREATE TABLE Driver (
`id` INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(30) NOT NULL,
`license_number` VARCHAR(30) NOT NULL,
`license_type` VARCHAR(30) NOT NULL,
`address` VARCHAR(30) NOT NULL,
`date_of_birth` DATETIME,
`seniority` VARCHAR(30) NOT NULL
);
-- CREATE TABLE Coach (
-- `id` INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
-- `licensePlate` VARCHAR(30) NOT NULL,
-- `color` VARCHAR(30) NOT NULL,
-- `manufacturer` VARCHAR(30) NOT NULL,
-- `car_type` VARCHAR(30) NOT NULL,
-- `chair` VARCHAR(30) NOT NULL,
-- `year` VARCHAR(30) NOT NULL,
-- `last_maintenance` TIMESTAMP
-- );
-- CREATE TABLE  Buses (
-- `id` INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
-- `first` VARCHAR(30) NOT NULL,
-- `last` VARCHAR(30) NOT NULL,
-- `length` VARCHAR(30) NOT NULL,
-- `complexity` INT(6) NOT NULL -- 1 2 3
-- );

-- CREATE TABLE  Trip (
-- `id` INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
-- `code` VARCHAR(30) NOT NULL,
-- `buses_id` INT(6) UNSIGNED,
-- `driver_primary` INT(6) UNSIGNED,
-- `driver_foreign` INT(6) UNSIGNED,
-- `guest_number` VARCHAR(30) NOT NULL,
-- `fare` VARCHAR(30) NOT NULL,
-- FOREIGN KEY (buses_id) REFERENCES Buses(id),
-- FOREIGN KEY (driver_primary) REFERENCES Driver(id),
-- FOREIGN KEY (driver_foreign) REFERENCES Driver(id)
-- );
-- drop database qlhvt;