# ************************************************************
# Antares - SQL Client
# Version 0.7.14
# 
# https://antares-sql.app/
# https://github.com/antares-sql/antares
# 
# Host: 127.0.0.1 (Ubuntu 24.10 11.4.5)
# Database: shine_admin_db
# Generation time: 2025-08-23T17:31:02+01:00
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table adresse
# ------------------------------------------------------------

DROP TABLE IF EXISTS `adresse`;

CREATE TABLE `adresse` (
  `af_id` int(11) NOT NULL,
  `af_type` smallint(6) NOT NULL COMMENT 'adresse de livraison ou adresse de facturation',
  `af_rue` varchar(255) DEFAULT NULL,
  `af_ville` varchar(255) DEFAULT NULL,
  `af_pays` varchar(255) DEFAULT NULL,
  `af_code_postal` varchar(255) DEFAULT NULL,
  `tiers` int(11) DEFAULT NULL,
  PRIMARY KEY (`af_id`),
  KEY `adresse_tiers_IDX` (`tiers`) USING BTREE,
  CONSTRAINT `FKintpvc8pn9237jodlu57m7vd2` FOREIGN KEY (`tiers`) REFERENCES `tiers` (`cl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;





# Dump of table currency
# ------------------------------------------------------------

DROP TABLE IF EXISTS `currency`;

CREATE TABLE `currency` (
  `currency_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `symbol_left` varchar(255) NOT NULL,
  `symbol_right` varchar(255) NOT NULL,
  `decimal_place` char(1) NOT NULL,
  `value` decimal(25,4) NOT NULL DEFAULT 1.0000,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`currency_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;





# Dump of table currency_to_site
# ------------------------------------------------------------

DROP TABLE IF EXISTS `currency_to_site`;

CREATE TABLE `currency_to_site` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `currency_id` int(11) NOT NULL,
  `site_id` int(11) NOT NULL DEFAULT 1,
  `status` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`c_id`),
  KEY `currency_id` (`currency_id`),
  KEY `INDEX_YD12` (`site_id`),
  CONSTRAINT `FK_PNW6` FOREIGN KEY (`site_id`) REFERENCES `site` (`pv_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_QLDJ` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`currency_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;





# Dump of table emplacement
# ------------------------------------------------------------

DROP TABLE IF EXISTS `emplacement`;

CREATE TABLE `emplacement` (
  `em_id` int(11) NOT NULL AUTO_INCREMENT,
  `em_nom` varchar(255) NOT NULL,
  `em_code` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci NOT NULL,
  `site` int(11) NOT NULL,
  PRIMARY KEY (`em_id`),
  UNIQUE KEY `INDEX_H1RK` (`em_code`),
  KEY `em_site` (`site`),
  CONSTRAINT `emplacement_ibfk_1` FOREIGN KEY (`site`) REFERENCES `site` (`pv_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;





# Dump of table groups
# ------------------------------------------------------------

DROP TABLE IF EXISTS `groups`;

CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `is_active` int(11) DEFAULT NULL,
  `societe` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `INDEX_7B4N` (`societe`),
  CONSTRAINT `FK_ODR1` FOREIGN KEY (`societe`) REFERENCES `societe` (`s_id`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;





# Dump of table groups_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `groups_role`;

CREATE TABLE `groups_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acces` int(11) NOT NULL,
  `idgroup` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `INDEX_B7AL` (`acces`),
  KEY `INDEX_KN3B` (`idgroup`),
  CONSTRAINT `FK_KMGM` FOREIGN KEY (`acces`) REFERENCES `roles` (`id_action`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_SVE2` FOREIGN KEY (`idgroup`) REFERENCES `groups` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;





# Dump of table items_condition_paiement
# ------------------------------------------------------------

DROP TABLE IF EXISTS `items_condition_paiement`;

CREATE TABLE `items_condition_paiement` (
  `icp_id` int(11) NOT NULL AUTO_INCREMENT,
  `icp_type_echeance` int(11) NOT NULL COMMENT '0 pour sans esconte(totalité de la facture) et 1 pour pourcentage et -1 pour solde',
  `cpi_valeur` int(11) NOT NULL COMMENT 'en pourcentage 100% pour la totalité',
  `icp_delais` int(11) NOT NULL COMMENT 'en jour pour  réglé la facture du fournisseur exemple(30jrs fin de mois)',
  `condition_paiement` int(11) NOT NULL,
  PRIMARY KEY (`icp_id`),
  KEY `cpi_condition_paiement` (`condition_paiement`),
  CONSTRAINT `items_condition_paiement_ibfk_1` FOREIGN KEY (`condition_paiement`) REFERENCES `ligne_condition_paiement` (`lcp_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;





# Dump of table languages
# ------------------------------------------------------------

DROP TABLE IF EXISTS `languages`;

CREATE TABLE `languages` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `slug` varchar(50) NOT NULL,
  `code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

LOCK TABLES `languages` WRITE;
/*!40000 ALTER TABLE `languages` DISABLE KEYS */;

INSERT INTO `languages` (`id`, `name`, `slug`, `code`) VALUES
	(1, "FRANCAIS", "FR", "FR001"),
	(2, "ANGLAIS", "EN", "EN002");

/*!40000 ALTER TABLE `languages` ENABLE KEYS */;
UNLOCK TABLES;



# Dump of table language_translations
# ------------------------------------------------------------

DROP TABLE IF EXISTS `language_translations`;

CREATE TABLE `language_translations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lang_id` int(11) NOT NULL,
  `lang_key` varchar(100) NOT NULL,
  `lang_value` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;





# Dump of table ligne_condition_paiement
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ligne_condition_paiement`;

CREATE TABLE `ligne_condition_paiement` (
  `lcp_id` int(11) NOT NULL AUTO_INCREMENT,
  `lcp_nom` varchar(255) NOT NULL,
  `lcp_description` varchar(255) DEFAULT NULL,
  `societe` int(11) NOT NULL,
  PRIMARY KEY (`lcp_id`),
  KEY `cop_societe` (`societe`),
  CONSTRAINT `ligne_condition_paiement_ibfk_1` FOREIGN KEY (`societe`) REFERENCES `societe` (`s_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;





# Dump of table login_logs
# ------------------------------------------------------------

DROP TABLE IF EXISTS `login_logs`;

CREATE TABLE `login_logs` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;





# Dump of table modepaiement_to_site
# ------------------------------------------------------------

DROP TABLE IF EXISTS `modepaiement_to_site`;

CREATE TABLE `modepaiement_to_site` (
  `mps_id` int(11) NOT NULL AUTO_INCREMENT,
  `modepaiement_id` int(11) NOT NULL,
  `site_id` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`mps_id`),
  KEY `INDEX_VLC4` (`modepaiement_id`),
  KEY `INDEX_E3YD` (`site_id`),
  CONSTRAINT `FK_29EB` FOREIGN KEY (`site_id`) REFERENCES `site` (`pv_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_DII0` FOREIGN KEY (`modepaiement_id`) REFERENCES `mode_paiement` (`mp_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;





# Dump of table mode_paiement
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mode_paiement`;

CREATE TABLE `mode_paiement` (
  `mp_id` int(11) NOT NULL AUTO_INCREMENT,
  `mp_nom` varchar(255) NOT NULL,
  `mp_virgule` int(11) NOT NULL DEFAULT 0,
  `societe` int(11) NOT NULL,
  PRIMARY KEY (`mp_id`),
  KEY `mp_societe` (`societe`),
  CONSTRAINT `mode_paiement_ibfk_1` FOREIGN KEY (`societe`) REFERENCES `societe` (`s_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;





# Dump of table parametres
# ------------------------------------------------------------

DROP TABLE IF EXISTS `parametres`;

CREATE TABLE `parametres` (
  `cs_id` int(11) NOT NULL,
  `cs_code` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci NOT NULL,
  `cs_libelle` varchar(255) DEFAULT NULL,
  `cs_is_valid` tinyint(10) DEFAULT NULL,
  `message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci DEFAULT NULL,
  `societe` int(11) DEFAULT NULL,
  `site` int(11) DEFAULT NULL,
  PRIMARY KEY (`cs_id`),
  KEY `societe` (`societe`),
  KEY `INDEX_J8AG` (`site`),
  CONSTRAINT `FK_I3RM` FOREIGN KEY (`site`) REFERENCES `site` (`pv_id`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `FK_V9XA` FOREIGN KEY (`societe`) REFERENCES `societe` (`s_id`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;





# Dump of table roles
# ------------------------------------------------------------

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id_action` int(11) NOT NULL AUTO_INCREMENT,
  `code` int(11) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_action`),
  UNIQUE KEY `INDEX_ZUPU` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;





# Dump of table site
# ------------------------------------------------------------

DROP TABLE IF EXISTS `site`;

CREATE TABLE `site` (
  `pv_id` int(11) NOT NULL AUTO_INCREMENT,
  `pv_nom` varchar(255) NOT NULL,
  `pv_code` varchar(20) NOT NULL,
  `pv_description` varchar(255) DEFAULT NULL,
  `pv_ville` varchar(255) DEFAULT NULL,
  `pv_pays` varchar(255) DEFAULT NULL,
  `pv_get_emplacement` smallint(6) NOT NULL,
  `societe` int(11) NOT NULL,
  PRIMARY KEY (`pv_id`),
  UNIQUE KEY `INDEX_IXVF` (`pv_code`),
  KEY `pv_societe` (`societe`),
  CONSTRAINT `site_ibfk_1` FOREIGN KEY (`societe`) REFERENCES `societe` (`s_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;





# Dump of table societe
# ------------------------------------------------------------

DROP TABLE IF EXISTS `societe`;

CREATE TABLE `societe` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_nom` varchar(255) NOT NULL,
  `s_activite` varchar(255) NOT NULL,
  `s_adresse` varchar(255) DEFAULT NULL,
  `s_boite_postal` varchar(255) DEFAULT NULL,
  `s_pays` varchar(255) NOT NULL,
  `s_region` varchar(255) DEFAULT NULL,
  `s_telephone` varchar(255) DEFAULT NULL,
  `s_nc` varchar(255) NOT NULL,
  `s_rccm` varchar(255) NOT NULL,
  `s_regime_fiscal` varchar(255) NOT NULL,
  `s_devise` varchar(255) NOT NULL,
  `s_logo` varchar(255) DEFAULT NULL,
  `s_fovicon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;





# Dump of table taxe
# ------------------------------------------------------------

DROP TABLE IF EXISTS `taxe`;

CREATE TABLE `taxe` (
  `tax_id` int(11) NOT NULL AUTO_INCREMENT,
  `tax_nom` varchar(255) NOT NULL,
  `type` int(11) NOT NULL COMMENT '0 pour fixe et 1 pour pourcentage%',
  `tax_valeur` double NOT NULL,
  `tax_nature` int(11) NOT NULL COMMENT '0 pour nature vente et 1 pour nature Achat',
  `tax_is_retenue` int(11) NOT NULL COMMENT '0 pour non retenue et 1 pour retenue a la source',
  `societe` int(11) NOT NULL,
  PRIMARY KEY (`tax_id`),
  KEY `tax_societe` (`societe`),
  CONSTRAINT `taxe_ibfk_1` FOREIGN KEY (`societe`) REFERENCES `societe` (`s_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;





# Dump of table tiers
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tiers`;

CREATE TABLE `tiers` (
  `cl_id` int(11) NOT NULL AUTO_INCREMENT,
  `cl_code` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci NOT NULL,
  `cl_nom` varchar(255) NOT NULL,
  `cl_nc` varchar(255) DEFAULT NULL,
  `cl_rccm` varchar(255) DEFAULT NULL,
  `cl_telephone` varchar(255) DEFAULT NULL,
  `cl_email` varchar(255) DEFAULT NULL,
  `cl_statut_fiscal` int(11) NOT NULL COMMENT 'Statut fiscal 1 pour Imposable et 0 pour exonérer et -1 pour Aucun',
  `cl_description` varchar(255) DEFAULT NULL,
  `cl_is_defaut` smallint(6) NOT NULL,
  `cl_type` int(11) NOT NULL COMMENT 'type de tiers 0 pour client et 1 pour fournisseur',
  `condition_paiement` int(11) DEFAULT NULL,
  `zone` int(11) DEFAULT NULL,
  `taxe` int(11) DEFAULT NULL,
  `groupe` int(11) DEFAULT NULL,
  `societe` int(11) NOT NULL,
  PRIMARY KEY (`cl_id`),
  UNIQUE KEY `INDEX_LTSC` (`cl_code`),
  UNIQUE KEY `cl_nc` (`cl_nc`),
  UNIQUE KEY `in_rccm` (`cl_rccm`),
  KEY `cl_zone_distribution` (`zone`),
  KEY `cl_societe` (`societe`),
  KEY `cl_condition_paiement` (`condition_paiement`),
  KEY `in_type` (`cl_type`),
  KEY `INDEX_M2UC` (`taxe`),
  KEY `FK_RW3B` (`groupe`),
  CONSTRAINT `FK_RW3B` FOREIGN KEY (`groupe`) REFERENCES `groups` (`id`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `FK_S79M` FOREIGN KEY (`taxe`) REFERENCES `taxe` (`tax_id`) ON UPDATE SET NULL,
  CONSTRAINT `tiers_ibfk_1` FOREIGN KEY (`societe`) REFERENCES `societe` (`s_id`) ON DELETE CASCADE,
  CONSTRAINT `tiers_ibfk_2` FOREIGN KEY (`zone`) REFERENCES `zone_distribution` (`zd_id`) ON DELETE SET NULL,
  CONSTRAINT `tiers_ibfk_3` FOREIGN KEY (`condition_paiement`) REFERENCES `ligne_condition_paiement` (`lcp_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;





# Dump of table tiers_to_site
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tiers_to_site`;

CREATE TABLE `tiers_to_site` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `tiers_id` int(11) NOT NULL,
  `site_id` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`t_id`),
  KEY `INDEX_XQM3` (`tiers_id`),
  KEY `INDEX_BQMS` (`site_id`),
  CONSTRAINT `FK_E368` FOREIGN KEY (`tiers_id`) REFERENCES `tiers` (`cl_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_UBZJ` FOREIGN KEY (`site_id`) REFERENCES `site` (`pv_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;





# Dump of table unite_mesure
# ------------------------------------------------------------

DROP TABLE IF EXISTS `unite_mesure`;

CREATE TABLE `unite_mesure` (
  `um_id` int(11) NOT NULL AUTO_INCREMENT,
  `um_code` varchar(255) NOT NULL,
  `um_libelle` varchar(255) NOT NULL,
  `um_is_reference` int(11) NOT NULL COMMENT '1 pour oui et 0 pour non c''est pas l''unité de référence',
  `societe` int(11) NOT NULL,
  PRIMARY KEY (`um_id`),
  KEY `um_societe` (`societe`),
  CONSTRAINT `unite_mesure_ibfk_1` FOREIGN KEY (`societe`) REFERENCES `societe` (`s_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;





# Dump of table utilisateur
# ------------------------------------------------------------

DROP TABLE IF EXISTS `utilisateur`;

CREATE TABLE `utilisateur` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_nom_prenom` varchar(255) NOT NULL,
  `u_telephone` varchar(255) DEFAULT NULL,
  `u_adresse` varchar(255) DEFAULT NULL,
  `u_user_name` varchar(255) NOT NULL,
  `u_password` varchar(255) NOT NULL,
  `u_email` varchar(255) DEFAULT NULL,
  `u_pwd_text` varchar(255) DEFAULT NULL,
  `site` int(11) DEFAULT NULL,
  `societe` int(11) NOT NULL,
  `groupe` int(11) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  KEY `u_societe` (`societe`),
  KEY `u_site` (`site`),
  KEY `INDEX_TKUM` (`groupe`),
  CONSTRAINT `FK_F41U` FOREIGN KEY (`groupe`) REFERENCES `groups` (`id`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`societe`) REFERENCES `societe` (`s_id`) ON DELETE CASCADE,
  CONSTRAINT `utilisateur_ibfk_2` FOREIGN KEY (`site`) REFERENCES `site` (`pv_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;





# Dump of table zone_distribution
# ------------------------------------------------------------

DROP TABLE IF EXISTS `zone_distribution`;

CREATE TABLE `zone_distribution` (
  `zd_id` int(11) NOT NULL AUTO_INCREMENT,
  `zd_code` varchar(255) NOT NULL,
  `zd_libelle` varchar(255) DEFAULT NULL,
  `site_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`zd_id`),
  KEY `INDEX_N200` (`site_id`),
  CONSTRAINT `FK_5CHN` FOREIGN KEY (`site_id`) REFERENCES `site` (`pv_id`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;





# Dump of views
# ------------------------------------------------------------

# Creating temporary tables to overcome VIEW dependency errors


/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

# Dump completed on 2025-08-23T17:31:02+01:00
