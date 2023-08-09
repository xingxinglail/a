CREATE TABLE t_shop
(
    id          int(10) UNSIGNED    NOT NULL AUTO_INCREMENT COMMENT '店铺id',
    name        varchar(50)         NOT NULL COMMENT '店铺名',
    `desc`      varchar(255)        NOT NULL COMMENT '店铺描述',
    logo_url    varchar(255)        NOT NULL COMMENT '店铺logo地址',
    status      tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态（1:开店 0:闭店）',
    is_deleted  tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '删除标记（0:可用 1:已删除）',
    create_by   int(10) UNSIGNED    NOT NULL COMMENT '创建店铺用户id',
    create_time timestamp           NOT NULL DEFAULT now() COMMENT '创建时间',
    update_time timestamp           NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY `name_is_deleted` (`name`, `is_deleted`)
) COMMENT '店铺表';
