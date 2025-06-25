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
    image_url VARCHAR(255),
    personnel_id BIGINT,
    FOREIGN KEY (personnel_id) REFERENCES personnel(student_id)
);

CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL
);

-- Insert sample data into personnel table
INSERT INTO personnel (student_id, first_name, last_name, email, password_hash) VALUES 
(1, 'John', 'Doe', 'john.doe@example.com', '$2a$10$examplehashforjohn');

-- Insert sample data into product table
INSERT INTO product (product_name, price, quantity, image_url, personnel_id) VALUES 
('Shawarma Rice', 85, 10, 'img1.jpg', 1),
('Pork Cutlet', 75, 5, 'img2.jpg', 1),
('Chicken Cutlet', 75, 20, 'img3.jpg', 1),
('Hot Dog', 15, 15, 'img4.jpg', 1),  
('Pancit Canton', 30, 10, 'img5.jpg', 1),
('Beef Shawarma', 90, 8, 'img6.jpg', 1),
('Cheeseburger', 60, 12, 'img7.jpg', 1),
('Chicken Adobo', 65, 6, 'img8.jpg', 1),
('Ice Lemon Tea', 20, 10, 'img9.jpg', 1),
('Ice Blue Gatorade', 20, 10, 'img10.jpg', 1),
('Tuna Sandwich', 50, 20, 'img11.jpg', 1),
('Veggie Wrap', 55, 15, 'img12.jpg', 1);

