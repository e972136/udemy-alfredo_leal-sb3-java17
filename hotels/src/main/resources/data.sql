DROP TABLE IF EXISTS hotel;

CREATE TABLE `hotel` (
    `hotel_id` int NOT NULL AUTO_INCREMENT,
    `hotel_name` varchar(100) NOT NULL,
    `hotel_address` varchar(100) NOT NULL,
    PRIMARY KEY (`hotel_id`)
);

INSERT INTO `hotel` (`hotel_name`, `hotel_address`)
    VALUES ('Hotel Patito', 'Salida al bordo');

INSERT INTO `hotel` (`hotel_name`, `hotel_address`)
    VALUES ('Hotel vaquita', 'calle el rasto');