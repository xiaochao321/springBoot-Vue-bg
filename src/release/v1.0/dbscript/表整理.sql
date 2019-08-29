-- 客户表
CREATE TABLE `cust_info` (
  `id` int(32) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `mobile` bigint(15) DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 产品表
CREATE TABLE `product` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `name` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '产品名称',
  `describe` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '产品描述',
  `imgurl` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '产品图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 产品分类
CREATE TABLE `product_cate` (
  `id` int(32) NOT NULL COMMENT '分类id',
  `parent_id` int(32) DEFAULT '0' COMMENT '父级分类id',
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '产品分类名称',
  `code` varchar(125) CHARACTER SET utf8 DEFAULT NULL COMMENT '分类编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


