CREATE TABLE t_shop_category_goods
(
    id          int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
    category_id int(10) UNSIGNED NOT NULL COMMENT '分类id',
    goods_id    int(10) UNSIGNED NOT NULL COMMENT '商品id',
    create_time timestamp        NOT NULL DEFAULT now() COMMENT '创建时间',
    update_time timestamp        NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
    PRIMARY KEY (id)
) COMMENT '商品分类关联表';

INSERT INTO t_shop_category_goods(id, category_id, goods_id)
values (1, 1, 1),
       (2, 2, 2),
       (3, 4, 3),
       (4, 5, 4);

