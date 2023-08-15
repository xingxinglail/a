CREATE TABLE t_shop_goods
(
    id          int(10) UNSIGNED    NOT NULL AUTO_INCREMENT COMMENT '商品id',
    shop_id     int(10) UNSIGNED    NOT NULL COMMENT '店铺id',
    name        varchar(50)         NOT NULL COMMENT '商品名称',
    stock       int(10) UNSIGNED    NOT NULL DEFAULT 0 COMMENT '库存',
    price       int(10) UNSIGNED    NOT NULL DEFAULT 0 COMMENT '单价，单位分',
    image_url   varchar(255)        NOT NULL COMMENT '封面图片地址',
    sell_status tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '售卖状态（0:下架 1:上架）',
    is_deleted  tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '删除标记（0:可用 1:已删除）',
    create_by   int(10) UNSIGNED    NOT NULL COMMENT '创建用户id',
    create_time timestamp           NOT NULL DEFAULT now() COMMENT '创建时间',
    update_time timestamp           NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
    PRIMARY KEY (id)
) COMMENT '商品表';

INSERT INTO t_shop_goods(id, shop_id, name, stock, price, image_url, sell_status, create_by)
values (1, 1, 'RedMi Note10 Pro', 10, 124900,
        'https://img11.360buyimg.com/n7/jfs/t1/166276/29/34960/53447/64c0ed8cF490e2a5f/f0f522b5a5bb5484.jpg', 1, 1),
       (2, 1, '联想ThinkBook 16p 英特尔酷睿i9 16英寸', 10, 1099900,
        'https://img14.360buyimg.com/n7/jfs/t1/157397/24/39713/91882/64d87a25Fc1ee1ca1/c8e0797f2bb94028.jpg', 1, 1),
       (3, 1, 'HLA海澜之家短袖T恤男夏新疆棉微弹圆', 10, 7290,
        'https://img14.360buyimg.com/n7/jfs/t1/108749/8/37807/22125/643e308aF1dc77bf0/87468ff53b0f3ed5.jpg', 1, 1),
       (4, 1, '无印良品（MUJI）女式 棉桑蚕丝 短袖连', 10, 33800,
        'https://img14.360buyimg.com/n7/jfs/t1/92705/37/29839/73724/64d7dd7aF86126051/0388bce3d7b8b49a.jpg', 1, 1);
