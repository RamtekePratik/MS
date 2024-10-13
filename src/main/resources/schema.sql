CREATE TABLE employee (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255),
    name VARCHAR(255),
    department_id int NOT NULL,
    FOREIGN KEY (department_id) references department(id)
);