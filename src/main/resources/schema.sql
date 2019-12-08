DROP TABLE IF EXISTS billionaires;
DROP TABLE IF EXISTS student;
create table student
(
    id integer not null,
    name varchar(255) not null,
    dob DATETIME not null,
    primary key(id)
);

DROP TABLE IF EXISTS billionaires;

CREATE TABLE billionaires (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);
