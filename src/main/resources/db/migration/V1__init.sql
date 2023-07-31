CREATE TABLE IF NOT EXISTS record
(
    id         BIGSERIAL PRIMARY KEY,
    uuid       UUID                     NOT NULL UNIQUE,
    created    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated    TIMESTAMP WITH TIME ZONE,
    client_id  VARCHAR(200) UNIQUE         NOT NULL,
    record_name  varchar(100) NOT NULL,
    description TEXT

);

CREATE TABLE IF NOT EXISTS document
(
    id         BIGSERIAL PRIMARY KEY,
    uuid       UUID                     NOT NULL UNIQUE,
    created    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated    TIMESTAMP WITH TIME ZONE,
    record_id  BIGSERIAL,
    file_name  varchar(100) NOT NULL,
    file_description varchar(200),
    file_url varchar(200)
);
