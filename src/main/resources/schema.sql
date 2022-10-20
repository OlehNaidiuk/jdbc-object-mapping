CREATE TABLE user
(
    id         INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(40),
    last_name  VARCHAR(60),
    age        INT,
    gender     ENUM ('MALE', 'FEMALE'),
    CONSTRAINT check_age CHECK (age > 0 and age <= 123)
);
