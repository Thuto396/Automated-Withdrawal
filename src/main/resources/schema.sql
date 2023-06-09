
CREATE TABLE IF NOT EXISTS investors (

id SERIAL PRIMARY KEY,
name VARCHAR(100) NOT NULL,
surname VARCHAR(100) NOT NULL,
date_of_birth DATE NOT NULL,
address VARCHAR(255) NOT NULL,
mobile_number VARCHAR(20) NOT NULL,
email VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS products (

id SERIAL PRIMARY KEY,
investor_id INT NOT NULL,
type VARCHAR(20) NOT NULL,
name VARCHAR(100) NOT NULL,
balance NUMERIC(10, 2) NOT NULL,
FOREIGN KEY (investor_id) REFERENCES investors (id)
);

