-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema AlbumDeMusicas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema AlbumDeMusicas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `AlbumDeMusicas` DEFAULT CHARACTER SET utf8 ;
USE `AlbumDeMusicas` ;

-- -----------------------------------------------------
-- Table `AlbumDeMusicas`.`Time`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `AlbumDeMusicas`.`Time` ;

CREATE TABLE IF NOT EXISTS `AlbumDeMusicas`.`Time` (
  `cod_album` INT NOT NULL,
  `nm_time` VARCHAR(45) NULL,
  `data` DATE NULL,
  PRIMARY KEY (`cod_album`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlbumDeMusicas`.`Jogador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `AlbumDeMusicas`.`Jogador` ;

CREATE TABLE IF NOT EXISTS `AlbumDeMusicas`.`Jogador` (
  `cod_jogador` INT NOT NULL,
  `nm_jogador` VARCHAR(45) NULL,
  `vl_preco` DOUBLE NULL,
  `cod_time` INT NOT NULL,
  PRIMARY KEY (`cod_jogador`),
  INDEX `fk_Musica_Album1_idx` (`cod_time` ASC),
  CONSTRAINT `fk_Musica_Album1`
    FOREIGN KEY (`cod_time`)
    REFERENCES `AlbumDeMusicas`.`Time` (`cod_album`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlbumDeMusicas`.`Posicao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `AlbumDeMusicas`.`Posicao` ;

CREATE TABLE IF NOT EXISTS `AlbumDeMusicas`.`Posicao` (
  `cod_posicao` INT NOT NULL,
  `nm_posicao` VARCHAR(45) NULL,
  PRIMARY KEY (`cod_posicao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlbumDeMusicas`.`JogadorPosicao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `AlbumDeMusicas`.`JogadorPosicao` ;

CREATE TABLE IF NOT EXISTS `AlbumDeMusicas`.`JogadorPosicao` (
  `cod_jogador` INT NOT NULL,
  `cod_posicao` INT NOT NULL,
  PRIMARY KEY (`cod_jogador`, `cod_posicao`),
  INDEX `fk_Musica_has_Artista_Artista1_idx` (`cod_posicao` ASC),
  INDEX `fk_Musica_has_Artista_Musica_idx` (`cod_jogador` ASC),
  CONSTRAINT `fk_Musica_has_Artista_Musica`
    FOREIGN KEY (`cod_jogador`)
    REFERENCES `AlbumDeMusicas`.`Jogador` (`cod_jogador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Musica_has_Artista_Artista1`
    FOREIGN KEY (`cod_posicao`)
    REFERENCES `AlbumDeMusicas`.`Posicao` (`cod_posicao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
