DROP TABLE IF EXISTS TBL_EMPLOYEES;

CREATE TABLE TBL_EMPLOYEES
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name  VARCHAR(250) NOT NULL,
    email      VARCHAR(250) DEFAULT NULL
);
DROP TABLE IF EXISTS studentrecords;
create table studentrecords
(
    id        int primary key auto_increment,
    address   varchar(30),
    firstname varchar(30),
    lastname  varchar(30)
);

DROP TABLE IF EXISTS myemployee;
create table myemployee
(
    id        int primary key auto_increment,
    firstname varchar(30),
    lastname  varchar(30),
    age       int,
    city      varchar(30)
);