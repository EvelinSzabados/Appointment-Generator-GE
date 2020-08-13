CREATE TABLE `scheduled_patient` (

`id` bigint(20) NOT null auto_increment,

`first_name` varchar(255) DEFAULT NULL,

`last_name` varchar(255) DEFAULT NULL,

`exam_datetime` datetime,

PRIMARY KEY (`id`)

);
