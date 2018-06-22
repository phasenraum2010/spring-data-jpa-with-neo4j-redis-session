#!/usr/bin/env bash


#source conf.sh

#export DATASOURCE_URL='jdbc:postgresql://localhost:5432/kandidatentravis?user=kandidatentravis&password=kandidatentravispwd'

#export DATASOURCE_USERNAME=kandidatentravis
#export DATASOURCE_PASSWORD=kandidatentravispwd

#export BTW17_JPA_HIBERNATE_DDL_AUTO=drop-create

#psql -U kandidatentravis < etc/drop-tables.sql

function database_setup () {
    psql -U kandidatentravis < etc/drop-tables.sql
    #psql -c 'DROP DATABASE kandidatentest;' -U postgres
    #psql -c 'DROP USER kandidatentest;' -U postgres
    #psql -c 'DROP ROLE kandidatentest;' -U postgres
    #psql -c "CREATE USER kandidatentest WITH PASSWORD 'kandidatentestpwd' LOGIN SUPERUSER INHERIT CREATEDB CREATEROLE NOREPLICATION;" -U postgres
    #psql -c 'GRANT pg_signal_backend, postgres TO kandidatentest WITH ADMIN OPTION;' -U postgres
    #psql -c "CREATE DATABASE kandidatentest WITH OWNER = kandidatentest TEMPLATE = template1 ENCODING = 'UTF8' LC_COLLATE = 'de_DE.UTF-8' LC_CTYPE = 'de_DE.UTF-8' CONNECTION LIMIT = -1;" -U postgres
    psql -c 'select * from version();' -U kandidatentravis
    psql -c '\l' -U postgres
    psql -c '\dg' -U postgres
    psql -c '\dn' -U postgres
}


./mvnw clean install -DskipTests=true -Dmaven.javadoc.skip=true -B -V
./mvnw -e -Pdevelopment -Dspring.profiles.active=development clean install dependency:tree site site:deploy -Dtest=ApplicationTest -B -V
./mvnw -e -Pproduction -Dspring.profiles.active=production clean install dependency:tree site site:deploy -Dtest=ApplicationTest -B -V

exit 0
