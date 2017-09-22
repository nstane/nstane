create database contactdb;
use contactdb;

CREATE  TABLE `contact` (

  `contact_id` INT NOT NULL ,

  `name` VARCHAR(45) NOT NULL ,

  `email` VARCHAR(45) NOT NULL ,

  `address` VARCHAR(45) NOT NULL ,

  `telephone` VARCHAR(45) NOT NULL ,

  PRIMARY KEY (`contact_id`) )

DEFAULT CHARACTER SET = utf8

COLLATE = utf8_general_ci;