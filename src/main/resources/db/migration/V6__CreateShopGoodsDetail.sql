CREATE TABLE t_shop_goods_detail
(
    id          int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品详情id',
    goods_id    int(10) UNSIGNED NOT NULL COMMENT '商品id',
    content     text COMMENT '商品详情',
    create_time timestamp        NOT NULL DEFAULT now() COMMENT '创建时间',
    update_time timestamp        NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
    PRIMARY KEY (id)
) COMMENT '商品详情表';

INSERT INTO t_shop_goods_detail(id, goods_id, content)
values (1, 1,
        '商品名称：小米（MI）Redmi Note 10 Pro商品编号：10032970801010店铺： 凯旋通二手手机专营店商品毛重：0.51kg三防标准：IP68屏幕分辨率：HD+成色：95新后摄主像素：6400万像素屏幕尺寸：6.6-6.79英寸'),
       (2, 2, '品牌： ThinkPad
商品名称：ThinkPadThinkBook 16p商品编号：100056969359商品毛重：4.05kg商品产地：中国大陆屏幕色域：100% DCI-P3类型：高性能轻薄笔记本系统：Windows 11 带Office厚度：18.1-20.0mm特性：背光键盘，指纹识别内存容量：32GB系列：ThinkBook-16P支持IPv6：支持IPv6颜色：灰色处理器：intel i9屏幕刷新率：165Hz屏幕尺寸：16.0-16.9英寸显卡芯片供应商：NVIDIA显卡型号：RTX 4060屏幕比例：16:10固态硬盘（SSD）：1TB机械硬盘：无机械硬盘'),
       (3, 3,
        '商品名称：海澜之家短袖T恤HNTBJ2U015A商品编号：100029992444商品毛重：240.00g商品产地：江苏货号：HNTBJ2U015A材质：棉77%版型：标准型适用季节：夏季上市时间：2022年夏季领型：圆领适用人群：青年流行元素：印花厚度：常规图案：字母袖长：短袖风格：休闲风休闲风：简约风'),
       (4, 4,
        '商品名称：无印良品（MUJI）女式 棉桑蚕丝 短袖连衣裙 裙子 衬衫裙 polo连衣裙 BC05CC3S 白色条纹 S-M（160/84A）商品编号：10072766023914店铺： 无印良品MUJI官方旗舰店商品毛重：300.00g货号：BC05CC3S材质：棉71%廓形：H型腰型：自然腰上市时间：2023年夏季领型：翻领裙型：其他袖型：常规袖袖长：短袖裙长：中长裙衣门襟：单排扣风格：休闲风休闲风：简约风');
