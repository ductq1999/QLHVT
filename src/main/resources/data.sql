create database qlhvt;
use qlhvt;
 CREATE TABLE Driver (
`id` INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
`id_number` VARCHAR(30) NOT NULL,
`name` VARCHAR(30) NOT NULL,
`license_number` VARCHAR(30) NOT NULL,
`license_type` VARCHAR(30) NOT NULL,
`address` VARCHAR(30) NOT NULL,
`date_of_birth` DATETIME,
`seniority` VARCHAR(30) NOT NULL,
`status` INT(6) NOT NULL -- 0 1
);
CREATE TABLE Coach (
`id` INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
`license_plate` VARCHAR(30) NOT NULL,
`color` VARCHAR(30) NOT NULL,
`manufacturer` VARCHAR(30) NOT NULL,
`car_type` VARCHAR(30) NOT NULL,
`model` VARCHAR(30) NOT NULL,
`chair` INT(6) NOT NULL,
`year_used` INT(6) NOT NULL,
`last_maintenance` DATETIME,
`status` INT(6) NOT NULL -- 0 1
);
CREATE TABLE  Buses (
`id` INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
`first` VARCHAR(30) NOT NULL,
`last` VARCHAR(30) NOT NULL,
`length` VARCHAR(30) NOT NULL,
`complexity` INT(6) NOT NULL, -- 1 2 3
`status` INT(6) NOT NULL -- 0 1
);

CREATE TABLE  Trip (
`id` INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
`code` VARCHAR(30) NOT NULL,
`buses_id` INT(6) UNSIGNED NOT NULL,
`guest_number` INT(6) NOT NULL,
`fare` INT(6) NOT NULL,
`date` DATETIME,
`status` INT(6) NOT NULL, -- 0 1
FOREIGN KEY (buses_id) REFERENCES Buses(id)
);

CREATE TABLE  Driver_Trip (
`id` INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
`driver_id` INT(6) UNSIGNED NOT NULL,
`trip_id` INT(6) UNSIGNED NOT NULL,
`driver_type` INT(6) NOT NULL, --  1: phu xe, 2: lai xe
FOREIGN KEY (driver_id) REFERENCES Driver(id),
FOREIGN KEY (trip_id) REFERENCES Trip(id)
);
