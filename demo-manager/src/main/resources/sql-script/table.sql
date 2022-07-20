-- test_db.sys_user definition
CREATE TABLE `sys_user`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `username`  varchar(52) DEFAULT NULL,
    `password`  varchar(30) DEFAULT NULL,
    `gender`    varchar(10) DEFAULT NULL,
    `birthday`  date        DEFAULT NULL,
    `is_delete` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;