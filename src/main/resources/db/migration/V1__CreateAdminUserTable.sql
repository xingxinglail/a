CREATE TABLE t_admin_user
(
    id          int(10) UNSIGNED    NOT NULL AUTO_INCREMENT COMMENT '用户id',
    username    varchar(50)         NOT NULL COMMENT '用户登录名',
    password    varchar(32)        NOT NULL COMMENT '用户登录密码',
    nickname    varchar(50)         NOT NULL COMMENT '用户昵称',
    is_deleted  tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '删除标记（0:可用 1:已删除）',
    create_time timestamp           NOT NULL DEFAULT now() COMMENT '创建时间',
    update_time timestamp           NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY `username_is_deleted` (`username`, `is_deleted`)
) COMMENT '管理员用户表';

INSERT INTO t_admin_user(id, username, password, nickname)
values (1, 'admin', 'CE0D7FF3ECAFBA95C30AC9620ABD03D5', '管理员');