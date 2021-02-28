#!/bin/bash

psql postgres -c "CREATE ROLE bitweb WITH LOGIN PASSWORD 'ajutine123';"
psql postgres -c "CREATE DATABASE bitweb WITH OWNER bitweb
    ENCODING 'UTF8' LC_COLLATE 'C' LC_CTYPE 'C' TEMPLATE template0;"
psql postgres -c "GRANT ALL PRIVILEGES ON DATABASE bitweb TO bitweb;"
