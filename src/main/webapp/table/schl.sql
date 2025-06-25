CREATE DATABASE IF NOT EXISTS schljsp;
USE schljsp;

-- Personnel table with improved column names
CREATE TABLE IF NOT EXISTS personnel (
    student_id BIGINT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100),
    password_hash VARCHAR(60)
);

CREATE TABLE IF NOT EXISTS product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL DEFAULT 0,
    image LONGBLOB,
    -- image_url VARCHAR(255), -- removed
    -- personnel_id BIGINT, -- removed
    -- FOREIGN KEY (personnel_id) REFERENCES personnel(student_id)
);

CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT,
    product_name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES personnel(student_id)
);

-- Insert sample data into personnel table
INSERT INTO personnel (student_id, first_name, last_name, email, password_hash) VALUES 
(1, 'John', 'Doe', 'john.doe@example.com', '$2a$10$examplehashforjohn');

-- Insert sample data into product table
-- Note: You will need to insert images as BLOBs using a script or tool, not plain SQL here.

