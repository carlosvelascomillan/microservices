# create database
CREATE DATABASE IF NOT EXISTS patients;
CREATE DATABASE IF NOT EXISTS patientHistory;

CREATE TABLE IF NOT EXISTS PATIENTS(
   uuid varchar(100) NOT NULL,
   name varchar(10) NOT NULL,
   last_name varchar(10) NOT NULL,
   date_created DATE,
   birth_date DATE,
   PRIMARY KEY (uuid )
);