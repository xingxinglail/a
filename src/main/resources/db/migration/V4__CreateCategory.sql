CREATE TABLE t_category
(
    id          int(10) UNSIGNED    NOT NULL AUTO_INCREMENT COMMENT '分类id',
    name        varchar(20)         NOT NULL COMMENT '分类名称',
    is_deleted  tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '删除标记（0:可用 1:已删除）',
    create_by   int(10) UNSIGNED    NOT NULL COMMENT '创建用户id',
    create_time timestamp           NOT NULL DEFAULT now() COMMENT '创建时间',
    update_time timestamp           NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY `name_is_deleted` (`name`, `is_deleted`)
) COMMENT '商品分类表';

INSERT INTO t_category(id, name, create_by)
values (1, '手机', 1),
       (2, '电脑', 1),
       (3, '家具', 1),
       (4, '男装', 1),
       (5, '女装', 1);
