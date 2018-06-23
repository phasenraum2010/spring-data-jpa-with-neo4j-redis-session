#!/usr/bin/env bash

source bin/run-config.sh

function create_postgresql_user_and_databases_on_localhost(){
    psql -c 'select * from version();' -U postgres
    psql -U postgres < jpa-drop-user-and-databases.sql
    psql -U postgres < jpa-create-user-and-databases.sql
}

create_postgresql_user_and_databases_on_localhost


