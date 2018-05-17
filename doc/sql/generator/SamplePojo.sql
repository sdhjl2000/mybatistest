-- auto Generated on 2018-05-17 14:34:50 
-- DROP TABLE IF EXISTS `sample_pojo`; 
CREATE TABLE sample_pojo(
    `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'name',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'sample_pojo';
