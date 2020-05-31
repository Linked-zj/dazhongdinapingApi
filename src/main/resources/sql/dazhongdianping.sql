/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : dazhongdianping

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2020-05-30 11:09:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES ('1', '休闲零食');
INSERT INTO `tb_category` VALUES ('2', '饮料饮品');
INSERT INTO `tb_category` VALUES ('3', '日用百货');
INSERT INTO `tb_category` VALUES ('4', '新鲜果蔬');

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_avatar_img` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `shop_commented_id` int(11) DEFAULT NULL COMMENT '被评论商店id',
  `product_commented_id` int(11) DEFAULT NULL COMMENT '被评论商品id',
  `if_comment` int(11) DEFAULT NULL COMMENT '是否为精选评论 1:是 0:不是',
  `comment_info` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `comment_img1` varchar(255) DEFAULT NULL COMMENT '评论图片',
  `comment_img2` varchar(255) DEFAULT NULL,
  `comment_img3` varchar(255) DEFAULT NULL,
  `comment_img4` varchar(255) DEFAULT NULL,
  `comment_img5` varchar(255) DEFAULT NULL,
  `comment_img6` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES ('1', '1', '就一吃货', '/image/touxiang1.png', '1', null, '1', '肥肠好吃，酥肉好吃，大刀腰片好吃，盆栽豆苗好吃，鲜鸭血好吃，巴沙鱼好吃，竹荪好吃，好吃的东西太多了，人少的话一次吃不完很多菜品的，盆栽豆苗非常嫩，价格也不贵，工作日的晚上排队等了一小时，7点20分左右才吃上，冬季到了，火锅果然还是最受欢迎的食物，自助吧也比以前丰富了，凉拌笋丝特别好吃，很嫩，西瓜品质很好，多汁又甜，巴沙鱼一定要点一份吃，比鲶鱼片好吃多了', '/image/comment/comment1.jpg', null, null, null, null, null, null);
INSERT INTO `tb_comment` VALUES ('2', '2', '我在等你啊', '/image/touxiang2.png', '1', null, '1', '[菜品]新品番茄木瓜美蛙锅值得拥有，一边是软糯的木瓜番茄汤，一边是鲜嫩香辣的牛蛙锅，一次获得两种满足。小郡肝和鲜虾串也是必点款，食材新鲜。店家还贴心的退出各种拼盘，点了牛羊汇和火锅组合，对于两个小胃口女生来说，这个实在太友好。', '/image/comment/comment2.jpg', null, null, null, null, null, null);
INSERT INTO `tb_comment` VALUES ('3', '3', '等烟雨', '/image/touxiang3.png', '1', null, '1', '新搬来上海点小伙伴想吃火锅随便按距离选了一下，网上拿号之后按照预估等待时间前往…虽然知道是常年排队，还是小看了这家的火爆程度…等了差不多两个小时，隔壁刚来等位的超有经验，一定要八点后来，第一次，不知道，应该也没有下一次了……等俩钟头，不停提供吃喝，不用进去火锅也能试吃饱了呢……', '/image/comment/comment3.jpg', null, null, null, null, null, null);
INSERT INTO `tb_comment` VALUES ('4', '4', '钢铁侠', '/image/touxiang4.jpg', '1', null, '1', '快过年了，在世纪公园遛弯找到了这家，意大利菜在很隐蔽的角落里，低调。由于来得早，位子还很多。在服务生的介绍下点了几个必吃，味道确实不错。生蚝大而肥美，要是以后可以2粒，4粒就好，半打和一打对于人少有点多。后切牛舌口感Q滑，海鲜拼盘量足，M9牛排稍微逊色了点，配生蚝的白葡萄酒好好喝，实在是不胜酒力就没点红酒。饭后甜点提拉米苏也很好吃。除了贵其他都好，算是快到新年了给自己的奖励吧。', '/image/comment/comment4.jpg', null, null, null, null, null, null);
INSERT INTO `tb_comment` VALUES ('5', '5', '蜘蛛侠', '/image/touxiang5.jpg', '1', null, '1', '好好好好哦好好爱护哦啊哦吼吼吼奥哈红红', '/image/comment/comment5.jpg', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for tb_flash_sale
-- ----------------------------
DROP TABLE IF EXISTS `tb_flash_sale`;
CREATE TABLE `tb_flash_sale` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL COMMENT '现价',
  `origin_price` decimal(10,2) DEFAULT NULL COMMENT '原价',
  `spec` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_flash_sale
-- ----------------------------
INSERT INTO `tb_flash_sale` VALUES ('18', '爱森五花肉 500g', '\\image\\flash\\wuhuarou.jpg', '41.80', '46.90', '爱森五花肉 500g', '20', '0', '1');
INSERT INTO `tb_flash_sale` VALUES ('19', '四季宝柔滑花生酱 340g/瓶', '\\image\\flash\\huashengjiang.jpg', '13.90', '16.90', '四季宝柔滑花生酱 340g/瓶', '20', '0', '1');
INSERT INTO `tb_flash_sale` VALUES ('20', '粮全其美葱香味手抓饼 900g/袋', '\\image\\flash\\shouzhuabing.jpg', '15.80', '18.80', '粮全其美葱香味手抓饼 900g/袋', '20', '0', '1');
INSERT INTO `tb_flash_sale` VALUES ('21', '松花菜半颗 约500g', '\\image\\flash\\songhua.jpg', '9.80', '12.80', '松花菜半颗 约500g', '20', '0', '1');
INSERT INTO `tb_flash_sale` VALUES ('22', '芸豆 300g', '\\image\\flash\\yundou.jpg', '5.90', '9.90', '芸豆 300g', '20', '0', '1');
INSERT INTO `tb_flash_sale` VALUES ('23', '美国车厘子 250g', '\\image\\flash\\chelizi.jpg', '32.90', '52.90', '美国车厘子 250g', '20', '0', '1');

-- ----------------------------
-- Table structure for tb_head_line
-- ----------------------------
DROP TABLE IF EXISTS `tb_head_line`;
CREATE TABLE `tb_head_line` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_head_line
-- ----------------------------
INSERT INTO `tb_head_line` VALUES ('1', null, '双12年终榜单-上海江苏-老版轮播-1209', '/image/pingtuanri.jpg');
INSERT INTO `tb_head_line` VALUES ('2', null, '西鲜记羊肉专题老banner12.9-12.15', '/image/guodanian.jpg');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `order_status` int(1) DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单''',
  `total_amount` double(10,2) DEFAULT NULL,
  `receive_name` varchar(255) DEFAULT NULL,
  `receive_phone` varchar(255) DEFAULT NULL,
  `receive_address` varchar(255) DEFAULT NULL,
  `confirm_status` int(1) DEFAULT NULL COMMENT '0:未确认 1:已确认',
  `receive_time` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_order
-- ----------------------------

-- ----------------------------
-- Table structure for tb_order_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_product`;
CREATE TABLE `tb_order_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_order_product
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(1) NOT NULL COMMENT '商品类别',
  `name` varchar(255) DEFAULT NULL,
  `origin_price` decimal(10,1) DEFAULT NULL,
  `price` decimal(10,1) DEFAULT NULL,
  `spec` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `is_flash` int(1) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_product
-- ----------------------------
INSERT INTO `tb_product` VALUES ('10', '1', 'ZEK海苔（原味） 15g/包', '12.8', '12.8', 'ZEK海苔（原味） 15g/包', '\\image\\product\\haitai.png', '0', '100', '1', '2');
INSERT INTO `tb_product` VALUES ('11', '1', '蜀道香麻辣牛肉 100g/袋', '12.9', '12.9', '蜀道香麻辣牛肉 100g/袋', '\\image\\product\\shudaoxiang.png', '0', '100', '1', '1');
INSERT INTO `tb_product` VALUES ('12', '1', '乐事无限嗞嗞烤肉味 104g/罐', '8.2', '8.2', '乐事无限嗞嗞烤肉味 104g/罐', '\\image\\product\\shupian.png', '0', '100', '1', '0');
INSERT INTO `tb_product` VALUES ('13', '2', '可口可乐 330ml*6罐', '13.9', '13.9', '可口可乐 330ml*6罐', '\\image\\product\\kele.png', '0', '100', '1', '0');
INSERT INTO `tb_product` VALUES ('14', '2', '百威啤酒 500ml*3罐', '20.9', '20.9', '百威啤酒 500ml*3罐', '\\image\\product\\baiwei.png', '0', '100', '1', '0');
INSERT INTO `tb_product` VALUES ('15', '2', '维他柠檬茶 250ml*6/盒', '16.0', '16.0', '维他柠檬茶 250ml*6/盒', '\\image\\product\\weita.png', '0', '100', '1', '0');
INSERT INTO `tb_product` VALUES ('16', '3', '维达超韧系列纸面巾家庭装 130抽*6/袋', '22.8', '22.8', '维达超韧系列纸面巾家庭装 130抽*6/袋', '\\image\\product\\weida.png', '0', '100', '1', '0');
INSERT INTO `tb_product` VALUES ('17', '4', '农皇帝蕉 300g', '9.9', '9.9', '小巧精致就是我 香甜软萌就是我', '\\image\\product\\xiangjiao.png', '0', '100', '1', '100');
INSERT INTO `tb_product` VALUES ('18', '5', '爱森五花肉 500g', '46.9', '41.8', '爱森五花肉 500g', '\\image\\flash\\wuhuarou.jpg', '1', '100', '1', '100');
INSERT INTO `tb_product` VALUES ('19', '5', '四季宝柔滑花生酱 340g/瓶', '16.9', '13.9', '四季宝柔滑花生酱 340g/瓶', '\\image\\flash\\huashengjiang.jpg', '1', '20', '1', '0');
INSERT INTO `tb_product` VALUES ('20', '5', '粮全其美葱香味手抓饼 900g/袋', '18.8', '15.8', '粮全其美葱香味手抓饼 900g/袋', '\\image\\flash\\shouzhuabing.jpg', '1', '20', '1', '0');
INSERT INTO `tb_product` VALUES ('21', '5', '松花菜半颗 约500g', '12.8', '9.8', '松花菜半颗 约500g', '\\image\\flash\\songhua.jpg', '1', '20', '1', '0');
INSERT INTO `tb_product` VALUES ('22', '5', '芸豆 300g', '9.9', '5.9', '芸豆 300g', '\\image\\flash\\yundou.jpg', '1', '20', '1', '0');
INSERT INTO `tb_product` VALUES ('23', '5', '美国车厘子 250g', '52.9', '32.9', '美国车厘子 250g', '\\image\\flash\\chelizi.jpg', '1', '20', '1', '0');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '用户');
INSERT INTO `tb_role` VALUES ('2', '商家');
INSERT INTO `tb_role` VALUES ('3', '管理员');

-- ----------------------------
-- Table structure for tb_shop
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop`;
CREATE TABLE `tb_shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(255) DEFAULT NULL COMMENT '商店名称',
  `shop_category_id` int(11) DEFAULT NULL COMMENT '商品类别',
  `shop_area_id` varchar(255) DEFAULT NULL COMMENT '商店区域',
  `pritory` int(11) DEFAULT NULL COMMENT '权重',
  `shop_desc` varchar(255) DEFAULT NULL COMMENT '商店描述',
  `shop_avg_price` int(11) DEFAULT NULL COMMENT '人均',
  `shop_phone` varchar(255) DEFAULT NULL COMMENT '商店联系方式',
  `shop_address` varchar(255) DEFAULT NULL COMMENT '商店地址',
  `shop_rate` float(2,1) DEFAULT NULL COMMENT '评分',
  `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` varchar(255) DEFAULT NULL COMMENT '最后编辑时间',
  `shop_longitude` varchar(255) DEFAULT NULL COMMENT '商店经度',
  `shop_latitude` varchar(255) DEFAULT NULL COMMENT '商店纬度',
  `shop_image1` varchar(255) DEFAULT NULL,
  `shop_image2` varchar(255) DEFAULT NULL,
  `shop_image3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_shop
-- ----------------------------
INSERT INTO `tb_shop` VALUES ('1', '東發道·朱雀打边炉', '1', null, null, '锅底涮嫩牛肉和鹅肠非常美味', '98', null, '上海市杨浦区国定路233号', '4.0', null, null, null, null, '/image/shop/zhuque.png', null, null);
INSERT INTO `tb_shop` VALUES ('2', '重庆高老九火锅', '1', null, null, '在众多火锅店中里性价比很高的了', '78', null, '浦东新区周浦镇年家浜路329号（近康沈路）', '4.5', null, null, null, null, '/image/shop/gaolaojiu.png', null, null);
INSERT INTO `tb_shop` VALUES ('3', 'MOSSO音乐酒吧•live house', '3', null, null, 'MOSSO音乐酒吧•live house', '163', '17602135092', ' 静安区凤阳路545号魔贸580商场101店（南京西路580号）', '4.8', null, null, null, null, '/image/shop/mosso.jpg', null, null);
INSERT INTO `tb_shop` VALUES ('4', '网鱼网咖（南京东路店）', '3', null, null, '网鱼网咖', '40', '021-63600042', ' 黄浦区南京东路588号丝绸商厦5楼（世纪广场正对面）', '4.6', null, null, null, null, '/image/shop/wangyu.jpg', null, null);
INSERT INTO `tb_shop` VALUES ('5', '如家商旅酒店(上海南站店)', '4', null, null, '2018年装修 2018年开业', '180', '021-54113151', '徐汇区石龙路987号', '4.7', null, null, null, null, '/image/shop/rujiashanglv.jpg', null, null);
INSERT INTO `tb_shop` VALUES ('6', '全季酒店(上海周浦万达广场店)', '4', null, null, '浦东新区周浦镇年家浜路329号（近康沈路） ', '190', '021-20966555', '浦东新区周浦镇年家浜路329号（近康沈路） ', '4.5', null, null, null, null, '/image/shop/quanji.jpg', null, null);
INSERT INTO `tb_shop` VALUES ('7', '万达影城（金山万达广场店）', '5', null, null, '金山区龙皓路1088号万达广场四楼（蒙山北路）', '45', '021-31022888', '金山区龙皓路1088号万达广场四楼（蒙山北路）', '4.8', null, null, null, null, '/image/shop/wangda.jpg', null, null);
INSERT INTO `tb_shop` VALUES ('8', 'V-STAR威斯达', '6', null, null, '静安区愚园路168号环球世界大厦A座31楼', '120', '021-61620323', '静安区愚园路168号环球世界大厦A座31楼（静安寺，久光百货）', '4.6', null, null, null, null, '/image/shop/weisida.jpg', null, null);
INSERT INTO `tb_shop` VALUES ('9', 'NRG fitness健身工作室（大柏树店', '7', null, null, ' 虹口区广纪路800号（集装箱创意园内）', '88', '17701808900', ' 虹口区广纪路800号（集装箱创意园内）', '4.9', null, null, null, null, '/image/shop/dabaishu.jpg', null, null);
INSERT INTO `tb_shop` VALUES ('10', '星马教育·雅思托福SAT（杨浦校区）', '10', null, null, '杨浦区国宾路18号万达广场A座6层', '1500', '400820820', '杨浦区国宾路18号万达广场A座6层', '2.5', null, null, null, null, '/image/shop/xingma.jpg', null, null);

-- ----------------------------
-- Table structure for tb_shop_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop_category`;
CREATE TABLE `tb_shop_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_shop_category
-- ----------------------------
INSERT INTO `tb_shop_category` VALUES ('1', '美食');
INSERT INTO `tb_shop_category` VALUES ('2', '美团外卖');
INSERT INTO `tb_shop_category` VALUES ('3', '休闲娱乐');
INSERT INTO `tb_shop_category` VALUES ('4', '酒店');
INSERT INTO `tb_shop_category` VALUES ('5', '电影/演出');
INSERT INTO `tb_shop_category` VALUES ('6', '丽人');
INSERT INTO `tb_shop_category` VALUES ('7', '运动健身');
INSERT INTO `tb_shop_category` VALUES ('8', '景点/门票');
INSERT INTO `tb_shop_category` VALUES ('9', 'ktv');
INSERT INTO `tb_shop_category` VALUES ('10', '培训教育');

-- ----------------------------
-- Table structure for tb_shop_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop_product`;
CREATE TABLE `tb_shop_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_desc` varchar(255) DEFAULT NULL,
  `origin_price` decimal(10,0) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_shop_product
-- ----------------------------
INSERT INTO `tb_shop_product` VALUES ('1', '1', '精选必吃四人餐', '仅售294元！最高价值431.7元的精选必吃4人套餐', '294', '470', '\\image\\shopproduct\\wa.jpg');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `gender` int(1) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `role` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('15', null, '18635987526', '111111', null, null, null, null);
INSERT INTO `tb_user` VALUES ('16', null, '17869853697', '96e79218965eb72c92a549dd5a330112', null, null, null, null);
INSERT INTO `tb_user` VALUES ('17', null, '18569874526', '9db06bcff9248837f86d1a6bcf41c9e7', null, null, '2020-05-05 16:09:24', '1');
INSERT INTO `tb_user` VALUES ('18', null, '17596324859', '92a35d8b542d4b11a6430f4db05c7e8d', null, null, '2020-05-05 16:44:34', '1');
INSERT INTO `tb_user` VALUES ('19', null, '15893486021', '9db06bcff9248837f86d1a6bcf41c9e7', null, null, '2020-05-05 16:47:53', '1');
INSERT INTO `tb_user` VALUES ('20', null, '14786593268', '9db06bcff9248837f86d1a6bcf41c9e7', null, null, '2020-05-05 16:51:20', '1');
INSERT INTO `tb_user` VALUES ('21', null, '15476986012', '9db06bcff9248837f86d1a6bcf41c9e7', null, null, '2020-05-05 17:18:29', '1');
INSERT INTO `tb_user` VALUES ('22', null, '14789652369', '9db06bcff9248837f86d1a6bcf41c9e7', null, null, '2020-05-05 17:19:42', '1');
INSERT INTO `tb_user` VALUES ('23', '上应点评', '18321291760', '9db06bcff9248837f86d1a6bcf41c9e7', null, null, '2020-05-05 21:04:01', '1');
INSERT INTO `tb_user` VALUES ('24', null, '15863597862', '9db06bcff9248837f86d1a6bcf41c9e7', null, null, '2020-05-23 17:08:13', '1');
INSERT INTO `tb_user` VALUES ('25', null, '18326598642', 'd0521106f6ba7f9ac0a7370fb28d0ec6', null, null, '2020-05-23 17:08:42', '1');
INSERT INTO `tb_user` VALUES ('26', null, '18654597654', 'd593db4e52fa9ddca35ad15f2e5ed1bc', null, null, '2020-05-24 11:28:31', '1');
