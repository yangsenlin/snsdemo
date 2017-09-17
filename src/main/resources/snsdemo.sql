
CREATE DATABASE /*!32312 IF NOT EXISTS*/ `snsdemo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `snsdemo`;

DROP TABLE IF EXISTS `tb_theme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_theme` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `publisherId` bigint(20) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `publishtime` datetime DEFAULT NULL,
  `isdelete` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
