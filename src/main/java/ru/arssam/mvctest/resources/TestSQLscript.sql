CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `test`.`user` (
`ID` INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`NAME` VARCHAR(25) NOT NULL,
`AGE` INT NOT NULL,
`IS_ADMIN` BIT(1) NOT NULL DEFAULT false,
`CREATED_DATE` TIMESTAMP DEFAULT CURRENT_TIMESTAMP);

INSERT INTO `test`.`user` (`NAME`, `AGE`) VALUES ('Andrey Pavlov', '36');
INSERT INTO `test`.`user` (`NAME`, `AGE`) VALUES ('Nikolay Ivanov', '24');
INSERT INTO `test`.`user` (`NAME`, `AGE`) VALUES ('Petr Dmitriev', '41');
INSERT INTO `test`.`user` (`NAME`, `AGE`) VALUES ('Dmitriy Petrov', '21');
INSERT INTO `test`.`user` (`NAME`, `AGE`) VALUES ('Ivan Nikolaev', '48');
INSERT INTO `test`.`user` (`NAME`, `AGE`) VALUES ('Pavel Andreev', '41');
