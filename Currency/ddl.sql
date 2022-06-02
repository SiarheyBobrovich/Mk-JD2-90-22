CREATE SCHEMA IF NOT EXISTS hibernate
    AUTHORIZATION postgres;

CREATE SEQUENCE IF NOT EXISTS hibernate.currencies_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

ALTER SEQUENCE local.events_id_sequence
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS hibernate.currencies
(
    id bigint NOT NULL DEFAULT nextval('hibernate.currencies_id_seq'::regclass),
    code character varying(3) COLLATE pg_catalog."default" NOT NULL,
    name character varying(15) COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default" NOT NULL,
    create_date timestamp without time zone NOT NULL,
    update_date timestamp without time zone NOT NULL,
    CONSTRAINT currencies_pkey PRIMARY KEY (id),
    CONSTRAINT currencies_code_key UNIQUE (code),
    CONSTRAINT currencies_id_key UNIQUE (id),
    CONSTRAINT currencies_name_key UNIQUE (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS hibernate.currencies
    OWNER to postgres;