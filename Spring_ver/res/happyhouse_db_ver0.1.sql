-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema happyhouse
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema happyhouse
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `happyhouse` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `happyhouse` ;

-- -----------------------------------------------------
-- Table `happyhouse`.`sidocode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`sidocode` (
  `sidoCode` VARCHAR(10) NOT NULL,
  `sidoName` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`sidoCode`),
  UNIQUE INDEX `sidoName` (`sidoName` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`dongcode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`dongcode` (
  `dongCode` VARCHAR(10) NOT NULL,
  `sidoName` VARCHAR(30) NULL DEFAULT NULL,
  `gugunName` VARCHAR(30) NULL DEFAULT NULL,
  `dongName` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`dongCode`),
  INDEX `sidoName` (`sidoName` ASC) VISIBLE,
  CONSTRAINT `dongcode_ibfk_1`
    FOREIGN KEY (`sidoName`)
    REFERENCES `happyhouse`.`sidocode` (`sidoName`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`baseaddress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`baseaddress` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `sidoName` VARCHAR(30) NULL DEFAULT NULL,
  `gugunName` VARCHAR(30) NULL DEFAULT NULL,
  `dongName` VARCHAR(30) NULL DEFAULT NULL,
  `dongCode` VARCHAR(10) NULL DEFAULT NULL,
  `lat` VARCHAR(20) NULL DEFAULT NULL,
  `lng` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `dongCode` (`dongCode` ASC) VISIBLE,
  CONSTRAINT `baseaddress_ibfk_1`
    FOREIGN KEY (`dongCode`)
    REFERENCES `happyhouse`.`dongcode` (`dongCode`))
ENGINE = InnoDB
AUTO_INCREMENT = 3597
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`guguncode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`guguncode` (
  `gugunCode` VARCHAR(10) NOT NULL,
  `gugunName` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`gugunCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`houseinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`houseinfo` (
  `aptCode` INT NOT NULL,
  `aptName` VARCHAR(50) NULL DEFAULT NULL,
  `dongCode` VARCHAR(10) NULL DEFAULT NULL,
  `dongName` VARCHAR(30) NULL DEFAULT NULL,
  `buildYear` INT NULL DEFAULT NULL,
  `jibun` VARCHAR(30) NULL DEFAULT NULL,
  `lat` VARCHAR(30) NULL DEFAULT NULL,
  `lng` VARCHAR(30) NULL DEFAULT NULL,
  `img` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`aptCode`),
  INDEX `dongCode` (`dongCode` ASC) VISIBLE,
  CONSTRAINT `houseinfo_ibfk_1`
    FOREIGN KEY (`dongCode`)
    REFERENCES `happyhouse`.`dongcode` (`dongCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`housedeal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`housedeal` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `aptCode` INT NULL DEFAULT NULL,
  `dealAmount` VARCHAR(20) NULL DEFAULT NULL,
  `dealYear` INT NULL DEFAULT NULL,
  `dealMonth` INT NULL DEFAULT NULL,
  `dealDay` INT NULL DEFAULT NULL,
  `area` VARCHAR(30) NULL DEFAULT NULL,
  `floor` VARCHAR(30) NULL DEFAULT NULL,
  `type` VARCHAR(30) NULL DEFAULT NULL,
  `rentMoney` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `aptCode` (`aptCode` ASC) VISIBLE,
  CONSTRAINT `housedeal_ibfk_1`
    FOREIGN KEY (`aptCode`)
    REFERENCES `happyhouse`.`houseinfo` (`aptCode`))
ENGINE = InnoDB
AUTO_INCREMENT = 68865
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`member` (
  `memId` VARCHAR(10) NOT NULL,
  `memPw` VARCHAR(15) NOT NULL,
  `memName` VARCHAR(45) NOT NULL,
  `memEmail` VARCHAR(45) NOT NULL,
  `memTel` VARCHAR(45) NOT NULL,
  `signupDate` DATETIME NULL,
  PRIMARY KEY (`memId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `happyhouse`.`memBoard`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`memBoard` (
  `no` INT NOT NULL,
  `memId` VARCHAR(10) NOT NULL,
  `title` VARCHAR(45) NULL,
  `content` LONGTEXT NULL,
  `date` DATETIME NULL,
  INDEX `fk_memBoard_memeber1_idx` (`memId` ASC) VISIBLE,
  PRIMARY KEY (`no`),
  CONSTRAINT `fk_memBoard_memeber1`
    FOREIGN KEY (`memId`)
    REFERENCES `happyhouse`.`member` (`memId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `happyhouse`.`watchList`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`watchList` (
  `no` INT NOT NULL,
  `memId` VARCHAR(10) NOT NULL,
  `dongCode` VARCHAR(10) NOT NULL,
  `addDate` DATETIME NULL,
  PRIMARY KEY (`no`),
  INDEX `fk_watchList_memeber1_idx` (`memId` ASC) VISIBLE,
  INDEX `fk_watchList_dongcode1_idx` (`dongCode` ASC) VISIBLE,
  CONSTRAINT `fk_watchList_memeber1`
    FOREIGN KEY (`memId`)
    REFERENCES `happyhouse`.`member` (`memId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_watchList_dongcode1`
    FOREIGN KEY (`dongCode`)
    REFERENCES `happyhouse`.`dongcode` (`dongCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `happyhouse`.`houseLike`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`houseLike` (
  `no` INT NOT NULL,
  `memId` VARCHAR(10) NOT NULL,
  `aptCode` INT NOT NULL,
  `addDate` DATETIME NULL,
  PRIMARY KEY (`no`),
  INDEX `fk_houseLike_memeber1_idx` (`memId` ASC) VISIBLE,
  INDEX `fk_houseLike_houseinfo1_idx` (`aptCode` ASC) VISIBLE,
  CONSTRAINT `fk_houseLike_memeber1`
    FOREIGN KEY (`memId`)
    REFERENCES `happyhouse`.`member` (`memId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_houseLike_houseinfo1`
    FOREIGN KEY (`aptCode`)
    REFERENCES `happyhouse`.`houseinfo` (`aptCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `happyhouse`.`storeInfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`storeInfo` (
  `storeCode` VARCHAR(20) NOT NULL,
  `storeName` VARCHAR(45) NULL,
  `addrCode` VARCHAR(45) NULL,
  `lat` VARCHAR(30) NULL,
  `lng` VARCHAR(30) NULL,
  `storeType` VARCHAR(45) NULL,
  PRIMARY KEY (`storeCode`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `happyhouse`.`noticeBoard`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`noticeBoard` (
  `no` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `content` LONGTEXT NULL,
  `date` DATETIME NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
