CREATE DATABASE jdbc;

use jdbc;

CREATE TABLE `student`(
     `id` int(11) NOT NULL AUTO_INCREMENT,
     `admission_number` int(11)   NULL
     `branch`  varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
     `college`  varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
     `dob`   datetime(6)  NULL,
     `email` varchar(255) COLLATE latin1_general_cs NOT NULL,
     `gender`  varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
     `mobile_number` varchar(255) COLLATE latin1_general_cs NOT NULL,
     `name`  varchar(255) COLLATE latin1_general_cs NOT NULL,
     `usn`   varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
     `year_of_admission` int(11) NULL,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;