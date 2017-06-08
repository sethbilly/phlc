/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.1.21-MariaDB : Database - phlc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`phlc` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `phlc`;

/*Table structure for table `consignment` */

DROP TABLE IF EXISTS `consignment`;

CREATE TABLE `consignment` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `cargo_location` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `eta_date` date DEFAULT NULL,
  `hbl` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `job_no` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `mbl_no` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pol_pod` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  `vessel_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vessel_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `weight_vol` double DEFAULT NULL,
  `client` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_consignment_client` (`client`),
  CONSTRAINT `FK_consignment_client` FOREIGN KEY (`client`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `consignment` */

insert  into `consignment`(`id`,`cargo_location`,`created_date`,`deleted`,`description`,`eta_date`,`hbl`,`job_no`,`last_modified_by`,`last_modified_date`,`mbl_no`,`pol_pod`,`updated`,`vessel_name`,`vessel_number`,`weight_vol`,`client`) values ('762697bea0d74317972ddf4ef6efad92','Hamburg','2017-05-25 08:17:40',0,NULL,'2017-06-15','','PHC001117',NULL,'2017-05-25 08:18:15','',NULL,0,'Cosco','AS343244',0,'5e6a99be2e1243259f983e3172920c4a');

/*Table structure for table `consignment_invoice` */

DROP TABLE IF EXISTS `consignment_invoice`;

CREATE TABLE `consignment_invoice` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `invoice_date` date DEFAULT NULL,
  `invoice_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `month_code` int(11) DEFAULT NULL,
  `processed` tinyint(1) DEFAULT '0',
  `remaining_balance` double DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  `value_date` date DEFAULT NULL,
  `value_month` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value_quarter` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value_week` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value_year` int(11) DEFAULT NULL,
  `week_code` int(11) DEFAULT NULL,
  `consignment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_consignment_invoice_consignment` (`consignment`),
  CONSTRAINT `FK_consignment_invoice_consignment` FOREIGN KEY (`consignment`) REFERENCES `consignment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `consignment_invoice` */

insert  into `consignment_invoice`(`id`,`created_date`,`deleted`,`invoice_date`,`invoice_number`,`last_modified_by`,`last_modified_date`,`month_code`,`processed`,`remaining_balance`,`total_amount`,`updated`,`value_date`,`value_month`,`value_quarter`,`value_week`,`value_year`,`week_code`,`consignment`) values ('bacfe36e9b094dc68039bada0cf58ec4','2017-05-25 08:31:33',0,'2017-05-25',NULL,NULL,'2017-05-25 08:37:07',NULL,0,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,'762697bea0d74317972ddf4ef6efad92');

/*Table structure for table `consignment_invoice_items` */

DROP TABLE IF EXISTS `consignment_invoice_items`;

CREATE TABLE `consignment_invoice_items` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `amount` double DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `ex_rate` double DEFAULT NULL,
  `invoice_item_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `item_description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  `invoice` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_consignment_invoice_items_invoice` (`invoice`),
  CONSTRAINT `FK_consignment_invoice_items_invoice` FOREIGN KEY (`invoice`) REFERENCES `consignment_invoice` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `consignment_invoice_items` */

insert  into `consignment_invoice_items`(`id`,`amount`,`created_date`,`deleted`,`ex_rate`,`invoice_item_type`,`item_description`,`last_modified_by`,`last_modified_date`,`rate`,`updated`,`invoice`) values ('939275ea89ea44debe621d0fb5265502',0,'2017-05-25 08:41:57',1,0,NULL,NULL,NULL,'2017-05-25 08:42:21',0,0,'bacfe36e9b094dc68039bada0cf58ec4'),('fe1f1e81012a414bbbc13e7885019a63',50,'2017-05-25 08:41:55',0,0,'CHARGE','',NULL,'2017-05-25 08:47:34',0,0,'bacfe36e9b094dc68039bada0cf58ec4');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `full_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `mobile_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telephone_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `customer` */

insert  into `customer`(`id`,`address`,`created_date`,`deleted`,`email`,`full_name`,`last_modified_by`,`last_modified_date`,`mobile_number`,`telephone_number`,`updated`) values ('5e6a99be2e1243259f983e3172920c4a','','2017-05-25 08:17:30',0,'','Isaac Nartey',NULL,'2017-05-25 08:17:37','0266000475','',0);

/*Table structure for table `invoice_payment` */

DROP TABLE IF EXISTS `invoice_payment`;

CREATE TABLE `invoice_payment` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `amount_paying` double DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `last_modified_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `month_code` int(11) DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `payment_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  `value_date` date DEFAULT NULL,
  `value_month` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value_quarter` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value_week` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `value_year` int(11) DEFAULT NULL,
  `week_code` int(11) DEFAULT NULL,
  `invoice` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `payment_number` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_invoice_payment_invoice` (`invoice`),
  CONSTRAINT `FK_invoice_payment_invoice` FOREIGN KEY (`invoice`) REFERENCES `consignment_invoice` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `invoice_payment` */

insert  into `invoice_payment`(`id`,`amount_paying`,`created_date`,`deleted`,`last_modified_by`,`last_modified_date`,`month_code`,`payment_date`,`payment_type`,`updated`,`value_date`,`value_month`,`value_quarter`,`value_week`,`value_year`,`week_code`,`invoice`,`payment_number`) values ('7e9d88b1ac934ad5be613b9ae181683e',100,'2017-05-27 21:19:12',1,NULL,'2017-05-27 21:27:28',NULL,'2017-05-27','CHEQUE',0,NULL,NULL,NULL,NULL,NULL,NULL,'bacfe36e9b094dc68039bada0cf58ec4','');

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `full_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `mobile_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telephone_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `staff` */

/*Table structure for table `user_account` */

DROP TABLE IF EXISTS `user_account`;

CREATE TABLE `user_account` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `last_logged_in` date DEFAULT NULL,
  `last_logged_out` date DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telephone_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `staff` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_account_staff` (`staff`),
  CONSTRAINT `FK_user_account_staff` FOREIGN KEY (`staff`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_account` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
