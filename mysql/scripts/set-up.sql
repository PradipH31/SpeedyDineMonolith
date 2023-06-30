USE `speedy_dine`;

-- Create the Restaurant table
CREATE TABLE
  restaurant (
    restaurant_id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20),
    email VARCHAR(255),
    opening_hours VARCHAR(255),
    cuisine_type VARCHAR(255),
    delivery_radius DOUBLE,
    average_rating DOUBLE,
    owner VARCHAR(255),
    website VARCHAR(255)
  );

-- Insert sample data for restaurants
INSERT INTO
  restaurant (
    restaurant_id,
    name,
    address,
    phone_number,
    email,
    opening_hours,
    cuisine_type,
    delivery_radius,
    average_rating,
    owner,
    website
  )
VALUES
  (
    1,
    'The Italian Trattoria',
    '123 Main Street, Cityville',
    '123-456-7890',
    'italiantrattoria@example.com',
    '9 AM - 10 PM',
    'Italian',
    5.0,
    4.5,
    'John Doe',
    'https://italiantrattoria.com'
  ),
  (
    2,
    'La Petite Brasserie',
    '456 Elm Street, Townsville',
    '987-654-3210',
    'lapetitebrasserie@example.com',
    '8 AM - 9 PM',
    'French',
    4.0,
    4.2,
    'Jane Smith',
    'https://lapetitebrasserie.com'
  ),
  (
    3,
    'Sushi House',
    '789 Oak Avenue, Villageland',
    '456-789-1230',
    'sushihouse@example.com',
    '11 AM - 10 PM',
    'Japanese',
    6.0,
    4.7,
    'David Johnson',
    'https://sushihouse.com'
  ),
  (
    4,
    'Café Bistro',
    '567 Pine Lane, Townsville',
    '555-123-4567',
    'cafebistro@example.com',
    '7 AM - 6 PM',
    'Café',
    3.0,
    4.0,
    'Sarah Thompson',
    'https://cafebistro.com'
  ),
  (
    5,
    'Mama Mia Pizzeria',
    '321 Elm Street, Cityville',
    '444-567-8901',
    'mamamiapizzeria@example.com',
    '10 AM - 9 PM',
    'Italian',
    4.5,
    4.8,
    'Michael Brown',
    'https://mamamiapizzeria.com'
  ),
  (
    6,
    'Steakhouse Grill',
    '876 Oak Avenue, Villageland',
    '777-890-1234',
    'steakhousegrill@example.com',
    '5 PM - 10 PM',
    'Steakhouse',
    7.5,
    4.9,
    'Emily Davis',
    'https://steakhousegrill.com'
  ),
  (
    7,
    'Asian Fusion',
    '234 Main Street, Cityville',
    '888-111-2222',
    'asianfusion@example.com',
    '11:30 AM - 10 PM',
    'Asian',
    4.0,
    4.3,
    'Jennifer Lee',
    'https://asianfusion.com'
  ),
  (
    8,
    'Taco Fiesta',
    '987 Maple Road, Villageland',
    '999-333-4444',
    'tacofiesta@example.com',
    '10 AM - 9 PM',
    'Mexican',
    5.0,
    4.7,
    'Robert Wilson',
    'https://tacofiesta.com'
  ),
  (
    9,
    'Burger Joint',
    '543 Oak Avenue, Townsville',
    '777-555-8888',
    'burgerjoint@example.com',
    '11 AM - 10 PM',
    'American',
    4.5,
    4.6,
    'Jessica Martinez',
    'https://burgerjoint.com'
  );

-- Create the user table
CREATE TABLE
  user (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    roles VARCHAR(255) NOT NULL
  );

-- Insert sample data
INSERT INTO
  user (username, password, email, roles)
VALUES
  (
    'pradip',
    '$2a$10$Qd1auiVDBB030fEHbbiib.9lCBOqZwxMeMxuXG/2jjVMP5X2m2aCG',
    'pradip@gmail.com',
    'USER,ADMIN'
  ),
  (
    'alice',
    '$2a$10$Qd1auiVDBB030fEHbbiib.9lCBOqZwxMeMxuXG/2jjVMP5X2m2aCG',
    'alice@gmail.com',
    'USER'
  ),
  (
    'bob',
    '$2a$10$Qd1auiVDBB030fEHbbiib.9lCBOqZwxMeMxuXG/2jjVMP5X2m2aCG',
    'bob@gmail.com',
    'USER'
  ),
  (
    'charlie',
    '$2a$10$Qd1auiVDBB030fEHbbiib.9lCBOqZwxMeMxuXG/2jjVMP5X2m2aCG',
    'charlie@gmail.com',
    'USER'
  ),
  (
    'dave',
    '$2a$10$Qd1auiVDBB030fEHbbiib.9lCBOqZwxMeMxuXG/2jjVMP5X2m2aCG',
    'dave@gmail.com',
    'USER'
  ),
  (
    'eve',
    '$2a$10$Qd1auiVDBB030fEHbbiib.9lCBOqZwxMeMxuXG/2jjVMP5X2m2aCG',
    'eve@gmail.com',
    'USER'
  ),
  (
    'frank',
    '$2a$10$Qd1auiVDBB030fEHbbiib.9lCBOqZwxMeMxuXG/2jjVMP5X2m2aCG',
    'frank@gmail.com',
    'USER'
  ),
  (
    'grace',
    '$2a$10$Qd1auiVDBB030fEHbbiib.9lCBOqZwxMeMxuXG/2jjVMP5X2m2aCG',
    'grace@gmail.com',
    'USER'
  ),
  (
    'harry',
    '$2a$10$Qd1auiVDBB030fEHbbiib.9lCBOqZwxMeMxuXG/2jjVMP5X2m2aCG',
    'harry@gmail.com',
    'USER'
  );

