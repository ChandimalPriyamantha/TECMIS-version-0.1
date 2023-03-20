-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tecmis_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tecmis_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tecmis_db` DEFAULT CHARACTER SET utf8 ;
USE `tecmis_db` ;

-- -----------------------------------------------------
-- Table `tecmis_db`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecmis_db`.`admin` (
  `id` VARCHAR(20) NOT NULL,
  `nic` VARCHAR(45) NULL DEFAULT NULL,
  `fname` VARCHAR(45) NULL DEFAULT NULL,
  `mname` VARCHAR(45) NULL DEFAULT NULL,
  `lname` VARCHAR(45) NULL DEFAULT NULL,
  `birth_date` DATETIME NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `sex` VARCHAR(10) NULL DEFAULT NULL,
  `phone_no` INT(11) NULL DEFAULT NULL,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `image_path` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tecmis_db`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecmis_db`.`department` (
  `department_id` VARCHAR(20) NOT NULL,
  `d_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`department_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tecmis_db`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecmis_db`.`student` (
  `id` VARCHAR(20) NOT NULL,
  `nic` VARCHAR(45) NULL DEFAULT NULL,
  `fname` VARCHAR(45) NULL DEFAULT NULL,
  `mname` VARCHAR(45) NULL DEFAULT NULL,
  `lname` VARCHAR(45) NULL DEFAULT NULL,
  `birth_date` DATETIME NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `sex` VARCHAR(10) NULL DEFAULT NULL,
  `phone_no` INT(11) NULL DEFAULT NULL,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `image_path` VARCHAR(1000) NULL DEFAULT NULL,
  `level` VARCHAR(45) NULL DEFAULT NULL,
  `department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`, `department_id`),
  INDEX `fk_student_department_idx` (`department_id` ASC) VISIBLE,
  CONSTRAINT `fk_student_department`
    FOREIGN KEY (`department_id`)
    REFERENCES `tecmis_db`.`department` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tecmis_db`.`attendence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecmis_db`.`attendence` (
  `attendence_id` INT(11) NOT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  `state` VARCHAR(45) NULL DEFAULT NULL,
  `date` DATE NULL DEFAULT NULL,
  `course_id` VARCHAR(20) NULL DEFAULT NULL,
  `lecturer_id` VARCHAR(20) NULL DEFAULT NULL,
  `hour` INT(11) NULL DEFAULT NULL,
  `student_id` VARCHAR(20) NOT NULL,
  `student_department_department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`attendence_id`, `student_id`, `student_department_department_id`),
  INDEX `fk_attendence_student1_idx` (`student_id` ASC, `student_department_department_id` ASC) VISIBLE,
  CONSTRAINT `fk_attendence_student1`
    FOREIGN KEY (`student_id` , `student_department_department_id`)
    REFERENCES `tecmis_db`.`student` (`id` , `department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tecmis_db`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecmis_db`.`course` (
  `course_id` VARCHAR(20) NOT NULL,
  `level` INT(11) NULL DEFAULT NULL,
  `credit` INT(11) NULL DEFAULT NULL,
  `course_name` VARCHAR(45) NULL DEFAULT NULL,
  `course_type` VARCHAR(45) NULL DEFAULT NULL,
  `department_department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`course_id`, `department_department_id`),
  INDEX `fk_course_department1_idx` (`department_department_id` ASC) VISIBLE,
  CONSTRAINT `fk_course_department1`
    FOREIGN KEY (`department_department_id`)
    REFERENCES `tecmis_db`.`department` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tecmis_db`.`course_has_department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecmis_db`.`course_has_department` (
  `course_course_id` VARCHAR(20) NOT NULL,
  `course_department_department_id` VARCHAR(20) NOT NULL,
  `department_department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`course_course_id`, `course_department_department_id`, `department_department_id`),
  INDEX `fk_course_has_department_department1_idx` (`department_department_id` ASC) VISIBLE,
  INDEX `fk_course_has_department_course1_idx` (`course_course_id` ASC, `course_department_department_id` ASC) VISIBLE,
  CONSTRAINT `fk_course_has_department_course1`
    FOREIGN KEY (`course_course_id` , `course_department_department_id`)
    REFERENCES `tecmis_db`.`course` (`course_id` , `department_department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_has_department_department1`
    FOREIGN KEY (`department_department_id`)
    REFERENCES `tecmis_db`.`department` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tecmis_db`.`gpa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecmis_db`.`gpa` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Student_ID` VARCHAR(45) NULL DEFAULT NULL,
  `GPA_Value` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tecmis_db`.`lecture_matireal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecmis_db`.`lecture_matireal` (
  `lecture_matireal_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `file_path` VARCHAR(1000) NULL DEFAULT NULL,
  `course_id` VARCHAR(20) NOT NULL,
  `course_department_department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`lecture_matireal_id`, `course_id`, `course_department_department_id`),
  INDEX `fk_lecture_matireal_course1_idx` (`course_id` ASC, `course_department_department_id` ASC) VISIBLE,
  CONSTRAINT `fk_lecture_matireal_course1`
    FOREIGN KEY (`course_id` , `course_department_department_id`)
    REFERENCES `tecmis_db`.`course` (`course_id` , `department_department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tecmis_db`.`lecturer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecmis_db`.`lecturer` (
  `id` VARCHAR(20) NOT NULL,
  `nic` VARCHAR(45) NULL DEFAULT NULL,
  `fname` VARCHAR(45) NULL DEFAULT NULL,
  `mname` VARCHAR(45) NULL DEFAULT NULL,
  `lname` VARCHAR(45) NULL DEFAULT NULL,
  `birth_date` DATETIME NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `sex` VARCHAR(10) NULL DEFAULT NULL,
  `phone_no` INT(11) NULL DEFAULT NULL,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `image_path` VARCHAR(1000) NULL DEFAULT NULL,
  `department_department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`, `department_department_id`),
  INDEX `fk_lecturer_department1_idx` (`department_department_id` ASC) VISIBLE,
  CONSTRAINT `fk_lecturer_department1`
    FOREIGN KEY (`department_department_id`)
    REFERENCES `tecmis_db`.`department` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tecmis_db`.`mark`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecmis_db`.`mark` (
  `mark_id` INT(11) NOT NULL,
  `grade` VARCHAR(45) NULL DEFAULT NULL,
  `level` VARCHAR(45) NULL DEFAULT NULL,
  `assesment` INT(11) NULL DEFAULT NULL,
  `quiz` INT(11) NULL DEFAULT NULL,
  `course_id` INT(11) NULL DEFAULT NULL,
  `sgpa` DECIMAL(3,2) NULL DEFAULT NULL,
  `cgpa` DECIMAL(3,2) NULL DEFAULT NULL,
  `mid_term` INT(11) NULL DEFAULT NULL,
  `final_theory` INT(11) NULL DEFAULT NULL,
  `final_practicle` INT(11) NULL DEFAULT NULL,
  `student_id` VARCHAR(20) NOT NULL,
  `student_department_department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`mark_id`, `student_id`, `student_department_department_id`),
  INDEX `fk_mark_student1_idx` (`student_id` ASC, `student_department_department_id` ASC) VISIBLE,
  CONSTRAINT `fk_mark_student1`
    FOREIGN KEY (`student_id` , `student_department_department_id`)
    REFERENCES `tecmis_db`.`student` (`id` , `department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tecmis_db`.`medical`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecmis_db`.`medical` (
  `medical_id` VARCHAR(255) NOT NULL,
  `date` DATETIME NULL DEFAULT NULL,
  `state` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(250) NULL DEFAULT NULL,
  `department_id` VARCHAR(20) NULL DEFAULT NULL,
  `subject_code` VARCHAR(20) NULL DEFAULT NULL,
  `student_id` VARCHAR(20) NOT NULL,
  `file_path` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`medical_id`, `student_id`),
  INDEX `fk_medical_student1_idx` (`student_id` ASC) VISIBLE,
  CONSTRAINT `fk_medical_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `tecmis_db`.`student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tecmis_db`.`notice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecmis_db`.`notice` (
  `notice_id` INT(11) NOT NULL AUTO_INCREMENT,
  `file_path` VARCHAR(1000) NULL DEFAULT NULL,
  `title` VARCHAR(45) NULL DEFAULT NULL,
  `date_and_time` DATETIME NULL DEFAULT NULL,
  `discripsion` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`notice_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tecmis_db`.`technical_officer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecmis_db`.`technical_officer` (
  `id` VARCHAR(20) NOT NULL,
  `nic` VARCHAR(45) NULL DEFAULT NULL,
  `fname` VARCHAR(45) NULL DEFAULT NULL,
  `mname` VARCHAR(45) NULL DEFAULT NULL,
  `lname` VARCHAR(45) NULL DEFAULT NULL,
  `birth_date` DATETIME NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `sex` VARCHAR(10) NULL DEFAULT NULL,
  `phone_no` INT(11) NULL DEFAULT NULL,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `image_path` VARCHAR(1000) NULL DEFAULT NULL,
  `department_department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`, `department_department_id`),
  INDEX `fk_technical_officer_department1_idx` (`department_department_id` ASC) VISIBLE,
  CONSTRAINT `fk_technical_officer_department1`
    FOREIGN KEY (`department_department_id`)
    REFERENCES `tecmis_db`.`department` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
