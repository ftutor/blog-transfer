- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT ,
  `user_name` VARCHAR(45) NULL ,
  `user_password` VARCHAR(45) NULL ,
  `email_address` VARCHAR(45) NULL ,
  `registed_date` DATETIME NULL ,
  `last_login` DATETIME NULL ,
  PRIMARY KEY (`user_id`) )
ENGINE = InnoDB;

CREATE UNIQUE INDEX `user_name_UNIQUE` ON `mydb`.`user` (`user_name` ASC) ;


-- -----------------------------------------------------
-- Table `mydb`.`user_blog`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`user_blog` (
  `blog_id` INT NOT NULL AUTO_INCREMENT ,
  `title` VARCHAR(45) NULL ,
  `article` TEXT NULL ,
  `create_time` DATETIME NULL ,
  `last_edit` DATETIME NULL ,
  `user_id` INT NOT NULL ,
  PRIMARY KEY (`blog_id`, `user_id`) ,
  CONSTRAINT `fk_user_blog_user`
    FOREIGN KEY (`user_id` )
    REFERENCES `mydb`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_user_blog_user_idx` ON `mydb`.`user_blog` (`user_id` ASC) ;