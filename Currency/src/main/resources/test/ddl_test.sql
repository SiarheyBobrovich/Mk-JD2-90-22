DROP TABLE IF EXISTS hibernate.currencies;

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
