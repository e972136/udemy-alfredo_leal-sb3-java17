DROP TABLE IF EXISTS room;

CREATE TABLE `room`(
    `room_id` int NOT NULL AUTO_INCREMENT,
    `hotel_id` int NOT NULL,
    `room_name` VARCHAR(100) NOT NULL,
    `room_avaible` varchar(100) NOT NULL,
    PRIMARY KEY (`room_id`)
);

INSERT INTO `room` (`hotel_id`,`room_name`,`room_avaible`)
    VALUES (1,'pieza 201','Si');

INSERT INTO `room` (`hotel_id`,`room_name`,`room_avaible`)
    VALUES (1,'pieza 301','Si');

INSERT INTO `room` (`hotel_id`,`room_name`,`room_avaible`)
    VALUES (2,'pieza 101','No');