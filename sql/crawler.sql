/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.43-log : Database - crawler
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crawler` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `crawler`;

/*Table structure for table `t_crawler_shell` */

DROP TABLE IF EXISTS `t_crawler_shell`;

CREATE TABLE `t_crawler_shell` (
  `shell_id` varchar(32) NOT NULL COMMENT '爬虫脚本表主键',
  `shell_service_type` varchar(100) DEFAULT NULL COMMENT '脚本业务类型',
  `shell_path` varchar(100) DEFAULT NULL COMMENT '脚本路径',
  `shell_create_time` varchar(20) DEFAULT NULL COMMENT '脚本创建时间',
  `shell_modify_time` varchar(20) DEFAULT NULL COMMENT '脚本修改时间',
  PRIMARY KEY (`shell_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `t_cron` */

DROP TABLE IF EXISTS `t_cron`;

CREATE TABLE `t_cron` (
  `cron_id` varchar(32) NOT NULL COMMENT '定时任务表主键',
  `cron_name` varchar(200) DEFAULT NULL COMMENT '定时任务名',
  `cron_service_type` varchar(100) DEFAULT NULL COMMENT '定时任务业务类型',
  `cron_rule` varchar(200) DEFAULT NULL COMMENT '定时任务规则',
  `cron_create_time` varchar(20) DEFAULT NULL COMMENT '定时任务创建时间',
  `cron_modify_time` varchar(20) DEFAULT NULL COMMENT '定时任务修改时间',
  PRIMARY KEY (`cron_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `t_exchange_rate` */

DROP TABLE IF EXISTS `t_exchange_rate`;

CREATE TABLE `t_exchange_rate` (
  `rate_id` varchar(32) NOT NULL COMMENT '汇率表主键',
  `rate_currency_name` varchar(100) DEFAULT NULL COMMENT '货币名',
  `rate_currency_buy` varchar(100) DEFAULT NULL COMMENT '现汇买入价',
  `rate_currency_sell` varchar(100) DEFAULT NULL COMMENT '现汇卖出价',
  `rate_cash_buy` varchar(100) DEFAULT NULL COMMENT '现钞买入价',
  `rate_cash_sell` varchar(100) DEFAULT NULL COMMENT '现钞卖出价',
  `rate_middle` varchar(100) DEFAULT NULL COMMENT '中行折算价',
  `rate_publish_date` varchar(20) DEFAULT NULL COMMENT '发布日期',
  `rate_publish_time` varchar(20) DEFAULT NULL COMMENT '发布时间',
  `rate_create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`rate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `t_trade_moments` */

DROP TABLE IF EXISTS `t_trade_moments`;

CREATE TABLE `t_trade_moments` (
  `moments_id` varchar(32) NOT NULL COMMENT '商圈表主键',
  `moments_type` varchar(100) DEFAULT NULL COMMENT '类型',
  `moments_image` varchar(1024) DEFAULT NULL COMMENT '图片',
  `moments_title` varchar(200) DEFAULT NULL COMMENT '标题',
  `moments_content` varchar(200) DEFAULT NULL COMMENT '内容',
  `moments_date` varchar(20) DEFAULT NULL COMMENT '发布日期',
  `moments_create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`moments_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `t_weave_price` */

DROP TABLE IF EXISTS `t_weave_price`;

CREATE TABLE `t_weave_price` (
  `price_id` varchar(32) NOT NULL COMMENT '针织价格表主键',
  `price_type` varchar(100) DEFAULT NULL COMMENT '类型',
  `price_name` varchar(200) DEFAULT NULL COMMENT '品名',
  `price_last_trade` varchar(100) DEFAULT NULL COMMENT '价格',
  `price_unit` varchar(100) DEFAULT NULL COMMENT '单位',
  `price_change` varchar(100) DEFAULT NULL COMMENT '涨跌',
  `price_date` varchar(100) DEFAULT NULL COMMENT '报价日期',
  `price_create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`price_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
