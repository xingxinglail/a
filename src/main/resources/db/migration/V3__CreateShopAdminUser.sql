CREATE TABLE t_shop_admin_user
(
    id          int(10) UNSIGNED    NOT NULL AUTO_INCREMENT COMMENT '店铺管理员id',
    shop_id     int(10) UNSIGNED    NOT NULL COMMENT '店铺id',
    username    varchar(50)         NOT NULL COMMENT '用户登录名',
    password    varchar(32)         NOT NULL COMMENT '用户登录密码',
    nickname    varchar(50)         NOT NULL COMMENT '用户昵称',
    is_deleted  tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '删除标记（0:可用 1:已删除）',
    create_by   int(10) UNSIGNED    NOT NULL COMMENT '创建店铺用户id',
    create_time timestamp           NOT NULL DEFAULT now() COMMENT '创建时间',
    update_time timestamp           NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY `name_is_deleted` (`username`, `is_deleted`)
) COMMENT '店铺管理员表';

INSERT INTO t_shop_admin_user(id, shop_id, username, password, nickname, create_by)
values (1, 1, 'admin', 'CE0D7FF3ECAFBA95C30AC9620ABD03D5', '星星', 1);
