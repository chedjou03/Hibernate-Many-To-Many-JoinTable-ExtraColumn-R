CREATE USER 'student'@'localhost' IDENTIFIED BY 'student';

GRANT ALL PRIVILEGES ON * . * TO 'student'@'localhost';

ALTER USER 'student'@'localhost' IDENTIFIED WITH mysql_native_password BY 'student';