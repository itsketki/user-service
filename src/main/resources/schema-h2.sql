DROP TABLE IF EXISTS ADDRESS;
DROP TABLE IF EXISTS USER;

CREATE TABLE USER(
  employee_id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  title VARCHAR(10) NOT NULL,
  gender VARCHAR(20) NOT NULL,
  address_id INT
);
CREATE TABLE ADDRESS(
  id INT AUTO_INCREMENT PRIMARY KEY,
  street VARCHAR(250) NOT NULL,
  city VARCHAR(50) NOT NULL,
  state VARCHAR(50) NOT NULL,
  post_code VARCHAR(10) NOT NULL
);
alter table USER add constraint fk_address_id FOREIGN KEY (address_id) references ADDRESS(id);


