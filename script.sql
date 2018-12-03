DROP DATABASE IF EXISTS `spring_security_demo_plaintext`;

CREATE DATABASE IF NOT EXISTS `spring_security_demo_plaintext`;
USE `spring_security_demo_plaintext`;

#
# Table structure for `users`
#
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar (50) NOT NULL,
  `password` varchar (50) NOT NULL,
  `enabled` tinyint (1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



#
# Inserting data for table `users`
# non-hashed passwords.
#
INSERT INTO `users`
    VALUES
      ('john', '{noop}test1', 1),
      ('mary', '{noop}test12', 1),
      ('suzanne', '{noop}test123', 1);


#
# Table structure for `authorities`
#
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar (50) NOT NULL,
  `authority` varchar (5) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
  CONSTRAINT `authorities_ibfk_1`
  FOREIGN KEY (`username`)
  REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



#
# Inserting data for table `authorities`
#
INSERT INTO `authorities`
    VALUES
      ('john', 'ROLE_EMPLOYEE'),
      ('mary', 'ROLE_EMPLOYEE'),
      ('mary', 'ROLE_MANAGER'),
      ('suzanne', 'ROLE_EMPLOYEE'),
      ('suzanne', 'ROLE_MANAGER'),
      ('suzanne', 'ROLE_ADMIN');



