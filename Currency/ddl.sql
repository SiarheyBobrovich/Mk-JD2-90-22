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
    version bigint NOT NULL,
    code character varying(3) COLLATE pg_catalog."default" NOT NULL,
    name character varying(22) COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default" NOT NULL,
    dt_create timestamp without time zone NOT NULL,
    dt_update timestamp without time zone NOT NULL,
    CONSTRAINT currencies_pkey PRIMARY KEY (id),
    CONSTRAINT currencies_code_key UNIQUE (code)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS hibernate.currencies
    OWNER to postgres;