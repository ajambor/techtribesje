CREATE USER 'techtribesje'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, LOCK_TABLES ON techtribesje.* to 'techtribesje'@'localhost';

GRANT ALL PRIVILEGES ON techtribesje_test.* to 'test'@'localhost' IDENTIFIED BY 'password';

