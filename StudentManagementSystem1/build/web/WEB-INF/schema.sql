/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Yoges
 * Created: 28 Sept 2026
 */
CREATE DATABASE IF NOT EXISTS college_db;
USE college_db;

DROP TABLE IF EXISTS students;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    department VARCHAR(50) NOT NULL,
    cgpa DOUBLE NOT NULL
);

INSERT INTO students (name, email, department, cgpa) 
VALUES ('Rahul Sharma', 'rahul@example.com', 'CSE', 8.75);
INSERT INTO students (name, email, department, cgpa) 
VALUES ('Rahul', 'rahul@examp.com', 'CSE', 8.85);
INSERT INTO students (name, email, department, cgpa) 
VALUES ('Sharma', 'rahul@exa.com', 'CSE', 9.75);
INSERT INTO students (name, email, department, cgpa) 
VALUES ('Rahu', 'rahul@exe.com', 'ECE', 8.95);


SELECT * FROM students;

