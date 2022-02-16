CREATE TABLE IF NOT EXISTS users
(
    user_id           BIGSERIAL                                          NOT NULL
        CONSTRAINT users_pk
            PRIMARY KEY,
    user_role         VARCHAR(64) DEFAULT 'ANONYMOUS'::CHARACTER VARYING NOT NULL,
    user_name         VARCHAR(64),
    surname           VARCHAR(64),
    email             VARCHAR(64),
    year_of_birth     VARCHAR(4),
    place_of_birth    VARCHAR(128),
    current_position  VARCHAR(65),
    address_of_living VARCHAR(128)
);

ALTER TABLE users
    OWNER TO postgres;
