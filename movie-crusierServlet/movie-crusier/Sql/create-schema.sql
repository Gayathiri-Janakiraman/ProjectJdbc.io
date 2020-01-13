-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema movie_crusier
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema movie_crusier
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `movie_crusier` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `movie_crusier` ;

-- -----------------------------------------------------
-- Table `movie_crusier`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_crusier`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `movie_crusier`.`movie_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_crusier`.`movie_list` (
  `mov_id` INT(11) NOT NULL,
  `mov_title` VARCHAR(50) NULL DEFAULT NULL,
  `mov_gross` BIGINT(11) NULL DEFAULT NULL,
  `mov_active` VARCHAR(3) NULL DEFAULT NULL,
  `mov_date_of_launch` DATE NULL DEFAULT NULL,
  `mov_genre` VARCHAR(25) NULL DEFAULT NULL,
  `mov_has_teaser` VARCHAR(3) NULL DEFAULT NULL,
  PRIMARY KEY (`mov_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `movie_crusier`.`favorites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_crusier`.`favorites` (
  `fav_id` INT(11) NOT NULL AUTO_INCREMENT,
  `fav_us_id` INT(11) NULL DEFAULT NULL,
  `fav_mov_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`fav_id`),
  INDEX `fav_mc_id_idx` (`fav_mov_id` ASC),
  INDEX `fav_us_id_idx` (`fav_us_id` ASC),
  CONSTRAINT `fav_us_id`
    FOREIGN KEY (`fav_us_id`)
    REFERENCES `movie_crusier`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fav_mov_id`
    FOREIGN KEY (`fav_mov_id`)
    REFERENCES `movie_crusier`.`movie_list` (`mov_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 74
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
