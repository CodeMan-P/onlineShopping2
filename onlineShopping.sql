/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.19 : Database - shop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shop` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `shop`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `adressId` int(8) NOT NULL AUTO_INCREMENT,
  `uid` int(8) NOT NULL,
  `address` text CHARACTER SET utf8 NOT NULL,
  `def` tinyint(1) DEFAULT '0',
  `aphone` decimal(16,0) NOT NULL,
  `aname` varchar(20) CHARACTER SET utf8 NOT NULL,
  `province` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  `city` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`adressId`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

/*Data for the table `address` */

insert  into `address`(`adressId`,`uid`,`address`,`def`,`aphone`,`aname`,`province`,`city`) values (27,1,'陕西省西安市西二环259号',1,'18932324298','小明','7','17'),(2,1,'西安市长里村',0,'1667711999','小明他妈','4','9'),(43,312,'sdfs',0,'14124124421','asdf','',''),(42,12,'qwewewq',1,'23213123333','qwew','',''),(44,1,'西安外包学院',0,'13899464689','小明','4','2');

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `gid` int(8) NOT NULL AUTO_INCREMENT,
  `gname` varchar(30) CHARACTER SET utf8 NOT NULL,
  `tid` int(8) DEFAULT NULL,
  `price` double(9,2) NOT NULL,
  `descption` text CHARACTER SET utf8,
  `imgPath` text CHARACTER SET utf8,
  `filePath` text CHARACTER SET utf8,
  `stock` int(8) DEFAULT '9999',
  PRIMARY KEY (`gid`)
) ENGINE=MyISAM AUTO_INCREMENT=116 DEFAULT CHARSET=latin1;

/*Data for the table `goods` */

insert  into `goods`(`gid`,`gname`,`tid`,`price`,`descption`,`imgPath`,`filePath`,`stock`) values (2,'小米6',2,1000.00,'[ {\r\n  \"网络类型\" : \"4G全网通\",\r\n  \"机身颜色\" : \"钻雕金,钻雕蓝,草木绿,曜石黑,玫瑰金\",\r\n  \"套餐类型\" : \"官方标配,套餐一,套餐二,套餐三,套餐四,套餐五\",\r\n  \"存储容量\" : \"64GB,128GB\",\r\n  \"购买方式\" : \"裸机\",\r\n  \"版本\" : \"小米6\"\r\n} ]','goods/xiaomi_6/6.jpg','goods/xiaomi_6/img/',9983),(3,'小米Max 2',2,2000.00,'[ {\r\n  \"网络类型\" : \"4G全网通\",\r\n  \"机身颜色\" : \"钻雕金,钻雕蓝,草木绿,曜石黑,玫瑰金\",\r\n  \"套餐类型\" : \"官方标配,套餐一,套餐二,套餐三,套餐四,套餐五\",\r\n  \"存储容量\" : \"64GB,128GB\",\r\n  \"购买方式\" : \"裸机\",\r\n  \"版本\" : \"Mate 10,Mate 10 62G+128G,麦芒6,P10,畅享7\"\r\n} ]','goods/xiaomi_6/6.jpg','goods/xiaomi_6/img/',9999),(4,'红米4X',2,2912.00,'[ {\r\n  \"网络类型\" : \"4G全网通\",\r\n  \"机身颜色\" : \"钻雕金,钻雕蓝,草木绿,曜石黑,玫瑰金\",\r\n  \"套餐类型\" : \"官方标配,套餐一,套餐二,套餐三,套餐四,套餐五\",\r\n  \"存储容量\" : \"64GB,128GB\",\r\n  \"购买方式\" : \"裸机\",\r\n  \"版本\" : \"Mate 10,Mate 10 62G+128G,麦芒6,P10,畅享7\"\r\n} ]','goods/xiaomi_6/6.jpg','goods/xiaomi_6/img/',9994),(5,'红米Note 4X',2,2200.00,'[ {\r\n  \"网络类型\" : \"4G全网通\",\r\n  \"机身颜色\" : \"钻雕金,钻雕蓝,草木绿,曜石黑,玫瑰金\",\r\n  \"套餐类型\" : \"官方标配,套餐一,套餐二,套餐三,套餐四,套餐五\",\r\n  \"存储容量\" : \"64GB,128GB\",\r\n  \"购买方式\" : \"裸机\",\r\n  \"版本\" : \"Mate 10,Mate 10 62G+128G,麦芒6,P10,畅享7\"\r\n} ]','goods/xiaomi_6/6.jpg','goods/xiaomi_6/img/',9992),(1,'Huawei/华为 P10全网通手机',2,3488.00,'[ {\r\n  \"网络类型\" : \"4G全网通\",\r\n  \"机身颜色\" : \"钻雕金,钻雕蓝,草木绿,曜石黑,玫瑰金\",\r\n  \"套餐类型\" : \"官方标配,套餐一,套餐二,套餐三,套餐四,套餐五\",\r\n  \"存储容量\" : \"64GB,128GB\",\r\n  \"购买方式\" : \"裸机\",\r\n  \"版本\" : \"Mate 10,Mate 10 62G+128G,麦芒6,P10,畅享7\"\r\n} ]','goods/huawei_1/P10.jpg','goods/huawei_1/img/',9603);

/*Table structure for table `goodsand` */

DROP TABLE IF EXISTS `goodsand`;

CREATE TABLE `goodsand` (
  `goodsId` int(8) DEFAULT NULL,
  `text` varchar(400) CHARACTER SET utf8 DEFAULT NULL,
  `imageUrl` text CHARACTER SET utf8,
  `spanSize` int(11) DEFAULT NULL,
  `banners` text CHARACTER SET utf8,
  `descption` text CHARACTER SET utf8
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `goodsand` */

insert  into `goodsand`(`goodsId`,`text`,`imageUrl`,`spanSize`,`banners`,`descption`) values (0,NULL,NULL,4,'[\"https://i8.mifile.cn/v1/a1/251f0880-423e-fa2d-3c18-1d3ec23f9912.webp\",\r\n \"https://i8.mifile.cn/v1/a1/49dfd019-9504-abb5-34bb-26f425b67e45.webp\",\r\n \"https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/b9540da01aef9a00a5c640b1c98b955a.jpg\"\r\n]',NULL),(1,'明星单品','https://i8.mifile.cn/v1/a1/1d338200-1be1-f868-9695-9d5ae0d6c2c6.webp',4,NULL,NULL),(2,'小米5c  64GB 移动版','https://i8.mifile.cn/v1/a1/04629084-7810-d1fb-6f4a-a0c52433ca29.webp?width=360&height=360',2,NULL,NULL),(3,'米家智能摄像机','https://i8.mifile.cn/v1/a1/375bd3a4-aab9-f77b-f6a1-5dbf01087495.webp?width=360&height=360',2,NULL,NULL),(4,NULL,'https://i8.mifile.cn/v1/a1/656a5863-6af1-6302-4e36-a33bd49e45cb.webp?width=360&height=360',2,NULL,NULL),(5,NULL,'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/cbcdb6c054d45c1afc955c87329e96f1.jpg?width=360&height=360',2,NULL,NULL),(6,NULL,'https://i8.mifile.cn/v1/a1/f093e0a8-e3d8-4fc8-deb7-af25ea3d8663.webp?width=360&height=360',2,NULL,NULL),(7,NULL,'https://i8.mifile.cn/v1/a1/b6c55f3b-d4ac-b2be-8d7c-3c818a79030a.webp?width=360&height=360',2,NULL,NULL),(5,'智能生活，从这里开始',NULL,4,NULL,NULL),(5,'测试描述5','https://i8.mifile.cn/v1/a1/6cc739d8-ae51-779a-3707-2f1d20a558bf.webp?width=720&heihgt=440',4,NULL,NULL),(6,'测试描述6','http://imgsrc.baidu.com/baike/pic/item/0b55b319ebc4b745a58395aecffc1e178a821576.jpg',4,NULL,NULL),(5,'我又是野广告',NULL,4,NULL,NULL);

/*Table structure for table `goodstype` */

DROP TABLE IF EXISTS `goodstype`;

CREATE TABLE `goodstype` (
  `tid` int(8) NOT NULL AUTO_INCREMENT,
  `tname` varchar(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `goodstype` */

insert  into `goodstype`(`tid`,`tname`) values (1,'新品'),(2,'手机'),(3,'电视'),(4,'电脑'),(5,'家电'),(6,'路由'),(7,'智能'),(8,'电源'),(9,'耳机'),(10,'音箱'),(11,'礼品'),(12,'生活'),(13,'零售');

/*Table structure for table `orderform` */

DROP TABLE IF EXISTS `orderform`;

CREATE TABLE `orderform` (
  `oid` decimal(14,0) NOT NULL,
  `gid` int(8) NOT NULL,
  `gnum` int(8) NOT NULL,
  `SubTotal` double(9,2) NOT NULL,
  `descption` text NOT NULL,
  `uid` int(8) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `orderform` */

insert  into `orderform`(`oid`,`gid`,`gnum`,`SubTotal`,`descption`,`uid`) values ('20171126180009',1,1,3488.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('20171126180109',1,2,6976.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('20171126180109',2,2,2000.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('123123',1,1,123.00,'asdasdas',1),('20171126180444',1,4,13952.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('20171125231209',2,2,2000.00,'[{\"网络类型\" : \"4G全网通\",\"机身颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\",\"存储容量\" : \"128GB\",\"购买方式\" : \"裸机\",\"版本\" : \"小米6\"}]',1),('20171114000839',1,1,3488.00,'[{\"网络类型\" : \"4G全网通\",\"机身颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\",\"存储容量\" : \"128GB\",\"购买方式\" : \"裸机\",\"版本\" : \"小米6\"}]',1),('20171114150342',1,1,3488.00,'[{\"网络类型\" : \"4G全网通\",\"机身颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\",\"存储容量\" : \"128GB\",\"购买方式\" : \"裸机\",\"版本\" : \"小米6\"}]',1),('20171115115255',1,1,3488.00,'[{\"网络类型\" : \"4G全网通\",\"机身颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\",\"存储容量\" : \"128GB\",\"购买方式\" : \"裸机\",\"版本\" : \"小米6\"}]',1),('20171115115316',1,1,3488.00,'[{\"网络类型\" : \"4G全网通\",\"机身颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\",\"存储容量\" : \"128GB\",\"购买方式\" : \"裸机\",\"版本\" : \"小米6\"}]',1),('20171120142528',1,1,3488.00,'[{\"网络类型\" : \"4G全网通\",\"机身颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\",\"存储容量\" : \"128GB\",\"购买方式\" : \"裸机\",\"版本\" : \"小米6\"}]',1),('20171125185207',1,5,17440.00,'[{\"网络类型\" : \"4G全网通\",\"机身颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\",\"存储容量\" : \"128GB\",\"购买方式\" : \"裸机\",\"版本\" : \"小米6\"}]',1),('20171125214247',1,4,13952.00,'[{\"网络类型\" : \"4G全网通\",\"机身颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\",\"存储容量\" : \"128GB\",\"购买方式\" : \"裸机\",\"版本\" : \"小米6\"}]',1),('20171125222523',1,2,6976.00,'[{\"网络类型\" : \"4G全网通\",\"机身颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\",\"存储容量\" : \"128GB\",\"购买方式\" : \"裸机\",\"版本\" : \"小米6\"}]',1),('20171125223010',1,3,10464.00,'[{\"网络类型\" : \"4G全网通\",\"机身颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\",\"存储容量\" : \"128GB\",\"购买方式\" : \"裸机\",\"版本\" : \"小米6\"}]',1),('20171114000359',2,1,1000.00,'[{\"网络类型\" : \"4G全网通\",\"机身颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\",\"存储容量\" : \"128GB\",\"购买方式\" : \"裸机\",\"版本\" : \"小米6\"}]',1),('20171114000359',1,1,3488.00,'[{\"网络类型\" : \"4G全网通\",\"机身颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\",\"存储容量\" : \"128GB\",\"购买方式\" : \"裸机\",\"版本\" : \"小米6\"}]',1),('20171125223156',1,2,6976.00,'[{\"网络类型\" : \"4G全网通\",\"机身颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\",\"存储容量\" : \"128GB\",\"购买方式\" : \"裸机\",\"版本\" : \"小米6\"}]',1),('20171125223010',2,3,3000.00,'[{\"网络类型\" : \"4G全网通\",\"机身颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\",\"存储容量\" : \"128GB\",\"购买方式\" : \"裸机\",\"版本\" : \"小米6\"}]',1),('20171126180444',2,4,4000.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('20171127090311',5,2,4400.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('20171127150050',5,5,11000.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('20171127192619',1,3,10464.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('20171127192651',1,1,3488.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('20171127192651',2,1,1000.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('20171130103944',1,1,3488.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('20171130105352',1,1,3488.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('20171130105352',4,5,14560.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('20171201154830',1,5,17440.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('20171201160824',2,2,2000.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('20171201160824',1,5,17440.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('20171201162427',1,3,10464.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1),('20171201163020',1,303,1056864.00,'[{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}]',1);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `oid` decimal(14,0) NOT NULL,
  `uid` int(8) NOT NULL,
  `state` varchar(10) NOT NULL DEFAULT '待付款',
  `address` text NOT NULL,
  `sum` double(10,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `orders` */

insert  into `orders`(`oid`,`uid`,`state`,`address`,`sum`) values ('20171201160824',1,'已付款','陕西省西安市西二环259号',19440.00),('20171201154830',1,'已付款','陕西省西安市西二环259号',17440.00),('20171130105352',1,'已付款','西安外包学院',18048.00),('20171130103944',1,'已付款','sdf',3488.00),('20171127192651',1,'已付款','西安外包学院',4488.00),('20171127192619',1,'已付款','西安外包学院',10464.00),('20171127150050',1,'已付款','西安市外包学院',11000.00),('20171127090311',1,'已付款','西安市外包学院',4400.00),('20171126180444',1,'已付款','西安市长里村',17952.00),('20171126180331',1,'待付款','西安市外包学院',0.00),('20171126180109',1,'待付款','西安市外包学院',8976.00),('20171126180009',1,'已付款','西安市外包学院',3488.00),('20171125231209',1,'已付款','西安市外包学院',2000.00),('20171125223156',1,'待付款','西安市外包学院',6976.00),('20171125223010',1,'待付款','西安市外包学院',13464.00),('20171114000359',1,'已付款','西安市外包学院',4488.00),('20171125222523',1,'待付款','西安市外包学院',6976.00),('20171125214247',1,'待付款','西安市外包学院',13952.00),('20171114000839',1,'待付款','西安市外包学院',3488.00),('20171114150342',1,'已付款','西安市外包学院',3488.00),('20171115115255',1,'已付款','西安市长里村',3488.00),('20171115115316',1,'已付款','西安市外包学院',3488.00),('20171120142528',1,'已付款','西安市外包学院',3488.00),('20171125185207',1,'待付款','西安市外包学院',17440.00),('20171201162427',1,'已付款','陕西省西安市西二环259号',10464.00),('20171201163020',1,'已付款','西安市长里村',1056864.00);

/*Table structure for table `qrcheck` */

DROP TABLE IF EXISTS `qrcheck`;

CREATE TABLE `qrcheck` (
  `uuid` text CHARACTER SET utf8 NOT NULL,
  `status` int(2) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `pwd` varchar(20) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `qrcheck` */

insert  into `qrcheck`(`uuid`,`status`,`name`,`pwd`) values ('2017112121142442C03E893E3156484CBF7ED01853FDF8A4',0,NULL,NULL),('2017112121142084342BBB19FFB7D4833B14C31F2816DDCB5',0,NULL,NULL),('2017112121141785180901A8855D4468EAF9A4BE637790C2F',0,NULL,NULL),('2017112121141178123433DD26A364B2E9C0B225203C67144',0,NULL,NULL),('201711212113535306AF8FA44A39A4BFDB1F074AF6024728B',2,NULL,NULL),('201711212112562513F838EA7A6CC433BAE42BA8FD40211C5',2,NULL,NULL),('20171121211224429AC6C18F4EF9847C6BE7312924901D40C',2,NULL,NULL),('2017112121115516618D644D9FA5C4A08B41AFA7223F95D2B',2,NULL,NULL),('2017112121103818349487943CF064A53A8AD42640E5724D5',2,NULL,NULL),('20171121210842378E9F2426A0BB549588A828DC297E1D678',2,NULL,NULL),('201711212107571131BF5C2678BEB4D658647654BEAF0B1F9',0,NULL,NULL),('20171121210746265E9C7A8A8775345F9971C6BC686689DE1',0,NULL,NULL),('201711212105293355CF235AB738148179396144D86881886',0,NULL,NULL),('201711212107384403F21897A2BC744FF9618DFC78248CA69',0,NULL,NULL),('20171121210500871C2C3365613D749539658CFF72B5A1047',0,NULL,NULL),('20171121210456941D57E86D67483482993C76E5858126E5D',0,NULL,NULL),('201711212104225219B96B2BE87E045FFB950AA2636AEC652',0,NULL,NULL),('20171121210421581A75C4613FC874B5D8FF07D2C282BB399',0,NULL,NULL),('20171121210412992087D6CCFC4B1483BB65AA0A029CA6617',0,NULL,NULL),('20171121210348664E0D0D471989A484F86A31681669B95D2',0,NULL,NULL),('2017112121034430669EF69250615415B8F00B9BA06DCE7FA',0,NULL,NULL),('20171121210244104B743A5314707497D9A573110632882B7',0,NULL,NULL),('2017112121021138073A71ACFB2AB455DB89444D83702B554',0,NULL,NULL),('20171121210157354753827BDA07244798AD03683F8E33089',0,NULL,NULL),('20171121210053863471568FF25244036BE6DDB61FF9E2001',2,NULL,NULL),('201711212100252768C113FAF40B2476B83A5D5BF084D2313',0,NULL,NULL),('20171121210020889A0B9EBA0A4C642F5930FE2E1D7096F9A',0,NULL,NULL),('2017112120593931CCC6A911FA564B93A597338469C0A367',0,NULL,NULL),('20171121205855384D43029A310E14F32960C23939D3F02EF',0,NULL,NULL),('20171121205651129BA6756191B694C33951A0DDC2F580270',0,NULL,NULL),('2017112120541162053115E6DF3B646A3BE2C05A85C952A6C',2,NULL,NULL),('20171121205405484FCD5406BF1934E55970A89898EDE4299',0,NULL,NULL),('20171121205338417F96D65DD991E4CA483E7AE4C5D89D6C7',0,NULL,NULL),('20171121205318558E3C4E105B7B24BDCA26C4C46A960FE71',0,NULL,NULL),('2017112120513412A9D65EBEB2044CCBA408EF630587009D',0,NULL,NULL),('20171121205008697BDE994F324EF4A70AF4DC446674B5B56',0,NULL,NULL),('201711211834474F4D3838AA9BD47478479D9EC2A5606F3',0,NULL,NULL),('201711211834462488ED68279726A4071A5EA8A7BF34AB431',0,NULL,NULL),('20171121183445516424F71A81F5A42D3ADCDF638ADBFBA70',0,NULL,NULL),('2017112118344460024DAEFC2EB2449A79F5E13ADDAB5EC26',0,NULL,NULL),('201711211834406802B3AF17EBCD455DBC696CFF535A0E0C',0,NULL,NULL),('201711212114277838F61A11D42134D4BB934A8C0F77C0E5E',0,NULL,NULL),('20171121211438150EE4B65827BC64C7C845C4F01BAE44971',0,NULL,NULL),('20171121211518995521F0107C5004B939C5D167EE4AE5C90',0,NULL,NULL),('2017112121152339B5090722D3114E03AD257687E5697F0D',0,NULL,NULL),('201711212115258956D98017647804E05987D8AEFD2C9F10C',0,NULL,NULL),('20171121211529279D7BFC9F9A46740F9B31EF793EE869B83',0,NULL,NULL),('20171121211534387FFADF93E8B894301B2AA5F6E696F52EB',0,NULL,NULL),('2017112121153866327E303F3BACD4B019E4C6BF0B04D3E66',0,NULL,NULL),('201711212115403158DB4A96BCD874A41B1219BB915D71572',0,NULL,NULL),('20171121211541261401DBF0DE984AFAB873F91D3F92CEA0',0,NULL,NULL),('20171121211541730E7EC45E8314E418A80259B2DF5F210D4',0,NULL,NULL),('20171121211542436704776F602884622A26F3B6DCAB6CAD2',0,NULL,NULL),('201711212115437243F9F74846A614906A1B616A031132BD8',0,NULL,NULL),('201711212115466801C01F946CA2E4D5CB7431E96586732FB',0,NULL,NULL),('20171121211547334C36691B9DA984D73858E5C623E88D397',0,NULL,NULL),('20171121211547924BA464D5A8BFE40A28B8B06AF1E537C9A',0,NULL,NULL),('2017112209040756142C3DADE4F814CC1B229D4E188EFE600',0,NULL,NULL),('20171122090405727C2444704658548AD8481A10F7675340B',0,NULL,NULL),('201711220904084657DBC17C2E4534494A65B34536EF83B83',0,NULL,NULL),('20171122090409241DD075F70ADFE463FA75A7229D389676B',0,NULL,NULL),('20171122090410143E0810DE041C64E3DAE8BA4F4ED53B752',0,NULL,NULL),('20171122090410833B450B49D100B458BB309539B9D6EA0AF',0,NULL,NULL),('2017112209041319777277F6F805546FFA000CA4129D2459E',0,NULL,NULL),('20171122090414771C87D77AFBB5C41CE96762757D90ED217',0,NULL,NULL),('201711220904162391825D77777FC48D69D64615EF0A84E53',0,NULL,NULL),('201711220904202590E11479843EB4A3595EB164681FCB3A0',0,NULL,NULL),('2017112209042352334AE60789EE442BC9B50BA2D05FDF860',0,NULL,NULL),('20171122090858253A2ABD7A12E9A4234965211724D58A462',0,NULL,NULL),('20171125231300835FBD5672C200C48E09957279917314235',2,NULL,NULL),('20171127130015394CBE82A08F71C4CE9A4EA5FB6075730FA',0,NULL,NULL),('20171201155117294623486FA5DFF43D68AA4AFADA1FD69C3',0,NULL,NULL),('201712011551332550E4B16F5C9B34AD0924C94E7FEE2F642',0,NULL,NULL),('201712011552477020D8FC724119E448F96A1EE96FA042128',0,NULL,NULL),('201712011552486902FE31FE59952433FB68DA1AAC7232AD9',0,NULL,NULL),('201712011552502328947AD59957A44A8BFE1D6D30F5CD4D6',0,NULL,NULL);

/*Table structure for table `r_user` */

DROP TABLE IF EXISTS `r_user`;

CREATE TABLE `r_user` (
  `userid` int(20) NOT NULL AUTO_INCREMENT,
  `username` tinytext,
  `roleid` int(50) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `NewIndex1` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `r_user` */

insert  into `r_user`(`userid`,`username`,`roleid`) values (1,'昆明',1),(2,'文山',1),(3,'普洱',1),(4,'西双版纳',1),(5,'西宁',2),(6,'海东',2),(7,'济南',3),(8,'泰安',3),(9,'石家庄',4),(10,'保定',4),(11,'兰州',5),(12,'白银',5),(13,'太原',6),(14,'晋中',6),(15,'大同',6),(16,'介休',6),(17,'西安',7),(18,'渭南',7),(19,'安康',7),(20,'渝中',8),(21,'渝北',8),(22,'广州',9),(23,'佛山',9),(24,'云浮',9),(25,'肇庆',9),(26,'南宁',10),(27,'百色',10),(28,'柳州',10);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleid` int(20) NOT NULL AUTO_INCREMENT,
  `rolename` tinytext,
  PRIMARY KEY (`roleid`),
  KEY `NewIndex1` (`roleid`),
  CONSTRAINT `FK_role` FOREIGN KEY (`roleid`) REFERENCES `r_user` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`roleid`,`rolename`) values (1,'云南'),(2,'青海'),(3,'山东'),(4,'河北'),(5,'甘肃'),(6,'山西'),(7,'陕西'),(8,'重庆'),(9,'广东'),(10,'广西');

/*Table structure for table `shoppingcar` */

DROP TABLE IF EXISTS `shoppingcar`;

CREATE TABLE `shoppingcar` (
  `cid` int(8) NOT NULL AUTO_INCREMENT,
  `addGoodsTime` datetime NOT NULL,
  `uid` int(8) NOT NULL,
  `gid` int(8) NOT NULL,
  `gnum` int(8) NOT NULL,
  `descption` text CHARACTER SET utf8,
  PRIMARY KEY (`cid`)
) ENGINE=MyISAM AUTO_INCREMENT=115 DEFAULT CHARSET=latin1;

/*Data for the table `shoppingcar` */

insert  into `shoppingcar`(`cid`,`addGoodsTime`,`uid`,`gid`,`gnum`,`descption`) values (111,'2017-12-14 11:09:08',1,1,1,'{\"颜色\" : \"钻雕金\",\"套餐类型\" : \"官方标配\"}');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `uid` int(8) NOT NULL AUTO_INCREMENT,
  `uname` varchar(16) CHARACTER SET utf8 NOT NULL,
  `upwd` varchar(16) CHARACTER SET utf8 NOT NULL,
  `phone` decimal(16,0) DEFAULT NULL,
  `city` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `regDate` date DEFAULT NULL,
  `idCard` varchar(13) CHARACTER SET utf8 DEFAULT NULL,
  `realName` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `sex` varchar(8) CHARACTER SET utf8 DEFAULT NULL,
  `avatar` text CHARACTER SET utf8,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `uk_users_uname` (`uname`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `users` */

insert  into `users`(`uid`,`uname`,`upwd`,`phone`,`city`,`regDate`,`idCard`,`realName`,`age`,`email`,`sex`,`avatar`) values (3,'xiaoming','123','18899119292','西安','2017-11-11',NULL,'小明',22,'qwe@qeq.asd','男','avatar/getAvatar_date_2017111014553791.jpg'),(1,'xiaoli','123','12312312213','西安','2017-11-10','12312312',NULL,22,'qwewq@qw.ca','男','avatar/getAvatar_date_2017111014553791.jpg');

/*Table structure for table `view_car_goods` */

DROP TABLE IF EXISTS `view_car_goods`;

/*!50001 DROP VIEW IF EXISTS `view_car_goods` */;
/*!50001 DROP TABLE IF EXISTS `view_car_goods` */;

/*!50001 CREATE TABLE  `view_car_goods`(
 `cid` int(8) NOT NULL  default '0' ,
 `addGoodsTime` datetime NOT NULL ,
 `uid` int(8) NOT NULL ,
 `gid` int(8) NOT NULL ,
 `gnum` int(8) NOT NULL ,
 `gname` varchar(30) NOT NULL ,
 `descption` text NULL ,
 `imgPath` text NULL ,
 `price` double(9,2) NOT NULL ,
 `stock` int(8) NULL  default '9999' 
)*/;

/*Table structure for table `view_order_goods` */

DROP TABLE IF EXISTS `view_order_goods`;

/*!50001 DROP VIEW IF EXISTS `view_order_goods` */;
/*!50001 DROP TABLE IF EXISTS `view_order_goods` */;

/*!50001 CREATE TABLE  `view_order_goods`(
 `oid` decimal(14,0) NOT NULL ,
 `uid` int(8) NOT NULL ,
 `gid` int(8) NOT NULL  default '0' ,
 `gname` varchar(30) NOT NULL ,
 `gnum` int(8) NOT NULL ,
 `price` double(9,2) NOT NULL ,
 `SubTotal` double(9,2) NOT NULL ,
 `sum` double(10,2) NOT NULL ,
 `tid` int(8) NULL ,
 `descption` text NOT NULL ,
 `imgPath` text NULL ,
 `stock` int(8) NULL  default '9999' ,
 `state` varchar(10) NOT NULL  default '待付款' ,
 `address` text NOT NULL 
)*/;

/*Table structure for table `view_user_address` */

DROP TABLE IF EXISTS `view_user_address`;

/*!50001 DROP VIEW IF EXISTS `view_user_address` */;
/*!50001 DROP TABLE IF EXISTS `view_user_address` */;

/*!50001 CREATE TABLE  `view_user_address`(
 `uname` varchar(16) NOT NULL ,
 `phone` decimal(16,0) NULL ,
 `realName` varchar(16) NULL ,
 `adressId` int(8) NOT NULL  default '0' ,
 `uid` int(8) NOT NULL ,
 `address` text NOT NULL ,
 `def` tinyint(1) NULL  default '0' ,
 `aphone` decimal(16,0) NOT NULL ,
 `aname` varchar(20) NOT NULL 
)*/;

/*View structure for view view_car_goods */

/*!50001 DROP TABLE IF EXISTS `view_car_goods` */;
/*!50001 DROP VIEW IF EXISTS `view_car_goods` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_car_goods` AS (select `o`.`cid` AS `cid`,`o`.`addGoodsTime` AS `addGoodsTime`,`o`.`uid` AS `uid`,`o`.`gid` AS `gid`,`o`.`gnum` AS `gnum`,`g`.`gname` AS `gname`,`o`.`descption` AS `descption`,`g`.`imgPath` AS `imgPath`,`g`.`price` AS `price`,`g`.`stock` AS `stock` from (`shoppingcar` `o` join `goods` `g`) where (`o`.`gid` = `g`.`gid`)) */;

/*View structure for view view_order_goods */

/*!50001 DROP TABLE IF EXISTS `view_order_goods` */;
/*!50001 DROP VIEW IF EXISTS `view_order_goods` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_order_goods` AS (select `o`.`oid` AS `oid`,`os`.`uid` AS `uid`,`g`.`gid` AS `gid`,`g`.`gname` AS `gname`,`o`.`gnum` AS `gnum`,`g`.`price` AS `price`,`o`.`SubTotal` AS `SubTotal`,`os`.`sum` AS `sum`,`g`.`tid` AS `tid`,`o`.`descption` AS `descption`,`g`.`imgPath` AS `imgPath`,`g`.`stock` AS `stock`,`os`.`state` AS `state`,`os`.`address` AS `address` from ((`orderform` `o` join `goods` `g`) join `orders` `os`) where ((`o`.`gid` = `g`.`gid`) and (`o`.`oid` = `os`.`oid`))) */;

/*View structure for view view_user_address */

/*!50001 DROP TABLE IF EXISTS `view_user_address` */;
/*!50001 DROP VIEW IF EXISTS `view_user_address` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_user_address` AS (select `u`.`uname` AS `uname`,`u`.`phone` AS `phone`,`u`.`realName` AS `realName`,`a`.`adressId` AS `adressId`,`a`.`uid` AS `uid`,`a`.`address` AS `address`,`a`.`def` AS `def`,`a`.`aphone` AS `aphone`,`a`.`aname` AS `aname` from (`users` `u` join `address` `a`) where (`u`.`uid` = `a`.`uid`)) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
