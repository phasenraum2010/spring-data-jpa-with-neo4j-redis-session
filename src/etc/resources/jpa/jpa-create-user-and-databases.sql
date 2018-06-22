CREATE USER jpa_neo4j WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  REPLICATION;

GRANT pg_monitor, pg_read_all_settings, pg_read_all_stats, pg_signal_backend, pg_stat_scan_tables, postgres TO jpa_neo4j WITH ADMIN OPTION;


CREATE DATABASE jpa_neo4j_int
    WITH
    OWNER = jpa_neo4j
    ENCODING = 'UTF8'
    LC_COLLATE = 'de_DE.UTF-8'
    LC_CTYPE = 'de_DE.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE DATABASE jpa_neo4j_prod_cloud_heroku
    WITH
    OWNER = jpa_neo4j
    ENCODING = 'UTF8'
    LC_COLLATE = 'de_DE.UTF-8'
    LC_CTYPE = 'de_DE.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE DATABASE jpa_neo4j_ci_travis
    WITH
    OWNER = jpa_neo4j
    ENCODING = 'UTF8'
    LC_COLLATE = 'de_DE.UTF-8'
    LC_CTYPE = 'de_DE.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
