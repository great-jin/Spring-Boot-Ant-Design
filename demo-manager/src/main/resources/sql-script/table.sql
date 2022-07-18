-- test_db.login_user definition
CREATE TABLE `login_user`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT,
    `account_code` varchar(10) NOT NULL,
    `username`     varchar(52) DEFAULT NULL,
    `password`     varchar(30) DEFAULT NULL,
    `is_delete`    int(11) DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;