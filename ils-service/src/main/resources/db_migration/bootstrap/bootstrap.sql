-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ilsexample
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ilsexample` ;

-- -----------------------------------------------------
-- Schema ilsexample
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ilsexample` DEFAULT CHARACTER SET latin1 ;
USE `ilsexample` ;

-- -----------------------------------------------------
-- Table `ilsexample`.`device`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilsexample`.`device` ;

CREATE TABLE IF NOT EXISTS `ilsexample`.`device` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL COMMENT '设备名',
  `brand` VARCHAR(45) NULL DEFAULT NULL COMMENT '品牌',
  `model` VARCHAR(45) NULL DEFAULT NULL COMMENT '模型',
  `enabled` TINYINT(4) NULL DEFAULT NULL COMMENT '激活',
  `weight` DOUBLE NULL DEFAULT NULL COMMENT '重量\n',
  `length` INT(11) NULL DEFAULT NULL COMMENT '长度 cm',
  `height` INT(11) NULL DEFAULT NULL COMMENT '高度 cm',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ilsexample`.`measurement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilsexample`.`measurement` ;

CREATE TABLE IF NOT EXISTS `ilsexample`.`measurement` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL COMMENT '监控参数标准名-英文',
  `unit` VARCHAR(45) NULL DEFAULT NULL COMMENT '单位',
  `alias` VARCHAR(45) NULL DEFAULT NULL COMMENT '其他名字',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
