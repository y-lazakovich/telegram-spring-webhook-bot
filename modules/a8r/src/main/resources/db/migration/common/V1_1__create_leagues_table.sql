CREATE TABLE leagues
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    version BIGINT DEFAULT 0 NOT NULL
);
