#!/bin/bash

DB_NAME="tasks.db"

SQL_CREATE_TABLE="CREATE TABLE tasks (
    id TEXT PRIMARY KEY NOT NULL,
    name TEXT NOT NULL,
    createdDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    status TEXT NOT NULL
);"

echo "Criando banco de dados: $DB_NAME..."

sqlite3 $DB_NAME "$SQL_CREATE_TABLE"