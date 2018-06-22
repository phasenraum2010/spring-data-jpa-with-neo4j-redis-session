#!/usr/bin/env bash

psql -c 'select * from version();'  -U postgres

psql -U postgres < jpa-drop-user-and-databases.sql
psql -U postgres < jpa-create-user-and-databases.sql
