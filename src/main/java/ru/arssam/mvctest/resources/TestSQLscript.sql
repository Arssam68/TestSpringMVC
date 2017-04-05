CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `test`.`user` (
`ID` INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`NAME` VARCHAR(25) NOT NULL,
`AGE` INT NOT NULL,
`IS_ADMIN` BIT(1) NOT NULL DEFAULT false,
`CREATED_DATE` TIMESTAMP DEFAULT CURRENT_TIMESTAMP);

INSERT INTO `test`.`user` (`NAME`, `AGE`, `IS_ADMIN`) VALUES ('Andrey Pavlov', '36', FALSE );
INSERT INTO `test`.`user` (`NAME`, `AGE`, `IS_ADMIN`) VALUES ('Nikolay Ivanov', '24', TRUE );
INSERT INTO `test`.`user` (`NAME`, `AGE`, `IS_ADMIN`) VALUES ('Petr Dmitriev', '41', FALSE );
INSERT INTO `test`.`user` (`NAME`, `AGE`, `IS_ADMIN`) VALUES ('Dmitriy Petrov', '21', FALSE );
INSERT INTO `test`.`user` (`NAME`, `AGE`, `IS_ADMIN`) VALUES ('Ivan Nikolaev', '48',TRUE );
INSERT INTO `test`.`user` (`NAME`, `AGE`, `IS_ADMIN`) VALUES ('Pavel Andreev', '41', FALSE );
