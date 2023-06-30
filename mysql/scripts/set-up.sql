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
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
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

-- Create the MenuItem table
CREATE TABLE
  menu_item (
    item_id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    ingredients VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    availability BOOLEAN NOT NULL,
    preparation_time INT NOT NULL,
    image VARCHAR(255),
    allergen_information VARCHAR(255),
    restaurant_id BIGINT NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurant (restaurant_id)
  );

-- Insert sample data for menu items
INSERT INTO
  menu_item (
    item_id,
    name,
    description,
    ingredients,
    price,
    availability,
    preparation_time,
    image,
    allergen_information,
    restaurant_id
  )
VALUES
  (
    1,
    'Margherita Pizza',
    'Classic pizza with tomato sauce and mozzarella cheese',
    'Tomato sauce, mozzarella cheese, basil',
    10.99,
    true,
    20,
    'margherita.jpg',
    'Contains dairy',
    5
  ),
  (
    2,
    'Pepperoni Pizza',
    'Pizza topped with pepperoni slices',
    'Tomato sauce, mozzarella cheese, pepperoni',
    12.99,
    true,
    25,
    'pepperoni.jpg',
    'Contains dairy, pork',
    5
  ),
  (
    3,
    'Spaghetti Bolognese',
    'Pasta with meat sauce',
    'Spaghetti, ground beef, tomato sauce, onions, garlic',
    13.99,
    true,
    30,
    'spaghetti.jpg',
    'Contains gluten, dairy',
    1
  ),
  (
    4,
    'Steak Frites',
    'Grilled steak served with french fries',
    'Beef steak, salt, pepper, french fries',
    22.99,
    true,
    35,
    'steak.jpg',
    'Contains beef',
    6
  ),
  (
    5,
    'Chicken Teriyaki',
    'Grilled chicken with teriyaki sauce',
    'Chicken breast, teriyaki sauce, soy sauce, garlic, ginger',
    16.99,
    true,
    30,
    'chicken_teriyaki.jpg',
    'Contains soy',
    3
  ),
  (
    6,
    'Cheeseburger',
    'Classic burger with cheese',
    'Beef patty, cheese, lettuce, tomato, onion',
    9.99,
    true,
    20,
    'cheeseburger.jpg',
    'Contains beef, dairy',
    9
  ),
  (
    7,
    'Shrimp Pad Thai',
    'Stir-fried rice noodles with shrimp',
    'Rice noodles, shrimp, eggs, bean sprouts, peanuts',
    14.99,
    true,
    25,
    'pad_thai.jpg',
    'Contains shellfish, peanuts',
    3
  ),
  (
    8,
    'Caesar Salad',
    'Traditional salad with romaine lettuce, croutons, and Caesar dressing',
    'Romaine lettuce, croutons, Parmesan cheese, Caesar dressing',
    8.99,
    true,
    15,
    'caesar_salad.jpg',
    'Contains gluten, dairy',
    4
  ),
  (
    9,
    'Fish and Chips',
    'Battered and fried fish with french fries',
    'Fish fillet, batter, french fries, tartar sauce',
    11.99,
    true,
    30,
    'fish_and_chips.jpg',
    'Contains gluten, fish',
    6
  ),
  (
    10,
    'Mushroom Risotto',
    'Creamy risotto with mushrooms',
    'Arborio rice, mushrooms, vegetable broth, onions, Parmesan cheese',
    15.99,
    true,
    40,
    'mushroom_risotto.jpg',
    'Contains gluten, dairy',
    2
  ),
  (
    11,
    'Sushi Combo',
    'Assortment of sushi rolls and nigiri',
    'Fresh fish, sushi rice, seaweed, soy sauce, wasabi, pickled ginger',
    18.99,
    true,
    30,
    'sushi_combo.jpg',
    'Contains fish',
    3
  ),
  (
    12,
    'Croissant Sandwich',
    'Buttery croissant filled with ham and cheese',
    'Croissant, ham, cheese, lettuce, tomato',
    7.99,
    true,
    15,
    'croissant_sandwich.jpg',
    'Contains gluten, pork, dairy',
    4
  ),
  (
    13,
    'Chicken Tikka Masala',
    'Chicken cooked in a creamy tomato-based sauce',
    'Chicken, tomato sauce, yogurt, spices, basmati rice',
    16.99,
    true,
    35,
    'chicken_tikka_masala.jpg',
    'Contains dairy',
    7
  ),
  (
    14,
    'Beef Stir-Fry',
    'Sliced beef stir-fried with vegetables',
    'Beef, bell peppers, onions, broccoli, soy sauce',
    17.99,
    true,
    25,
    'beef_stir_fry.jpg',
    'Contains soy',
    7
  ),
  (
    15,
    'Margherita Pasta',
    'Pasta with tomato sauce and mozzarella cheese',
    'Penne pasta, tomato sauce, mozzarella cheese, basil',
    12.99,
    true,
    30,
    'margherita_pasta.jpg',
    'Contains gluten, dairy',
    1
  ),
  (
    16,
    'Chicken Satay',
    'Grilled chicken skewers with peanut sauce',
    'Chicken breast, peanut sauce, soy sauce, garlic, ginger',
    13.99,
    true,
    25,
    'chicken_satay.jpg',
    'Contains peanuts',
    7
  ),
  (
    17,
    'Vegetable Curry',
    'Mixed vegetables cooked in a flavorful curry sauce',
    'Assorted vegetables, curry sauce, coconut milk, spices, rice',
    14.99,
    true,
    35,
    'vegetable_curry.jpg',
    'Contains coconut',
    8
  ),
  (
    18,
    'Caprese Salad',
    'Salad with fresh mozzarella, tomatoes, and basil',
    'Mozzarella cheese, tomatoes, fresh basil, balsamic glaze',
    9.99,
    true,
    15,
    'caprese_salad.jpg',
    'Contains dairy',
    4
  ),
  (
    19,
    'Chicken Shawarma',
    'Grilled marinated chicken wrapped in pita bread',
    'Chicken, pita bread, garlic sauce, pickles, tomatoes',
    10.99,
    true,
    20,
    'chicken_shawarma.jpg',
    'Contains gluten',
    2
  ),
  (
    20,
    'Vegan Buddha Bowl',
    'Nourishing bowl with a variety of vegetables, grains, and dressing',
    'Quinoa, mixed vegetables, chickpeas, avocado, tahini dressing',
    13.99,
    true,
    25,
    'vegan_buddha_bowl.jpg',
    'Contains sesame',
    8
  );

-- Create customers table
CREATE TABLE
  customer (
    customer_id BIGINT PRIMARY KEY,
    address VARCHAR(255),
    phone_number VARCHAR(20),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user (user_id)
  );

-- Insert sample data
INSERT INTO
  customer (customer_id, address, phone_number, user_id)
VALUES
  (1, '123 Main Street', '123-456-7890', 1),
  (2, '456 Elm Street', '987-654-3210', 2),
  (3, '789 Oak Avenue', '456-789-1230', 3),
  (4, '567 Pine Lane', '555-123-4567', 4);

-- Create the orders table
CREATE TABLE
  orders (
    order_id BIGINT PRIMARY KEY,
    menu_item_ids VARCHAR(255),
    customer_id BIGINT NOT NULL,
    order_date DATE NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    is_completed BOOLEAN NOT NULL,
    delivery_address VARCHAR(255) NOT NULL,
    special_instructions VARCHAR(255),
    FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
  );

-- Insert sample data
INSERT INTO
  orders (
    order_id,
    menu_item_ids,
    customer_id,
    order_date,
    total_price,
    is_completed,
    delivery_address,
    special_instructions
  )
VALUES
  (
    1,
    '1,2,3',
    1,
    '2023-06-29',
    35.99,
    true,
    '123 Main Street, Cityville',
    'No onions'
  ),
  (
    2,
    '4,5',
    2,
    '2023-06-30',
    26.50,
    false,
    '456 Elm Street, Townsville',
    'Extra cheese'
  ),
  (
    3,
    '6',
    1,
    '2023-07-01',
    9.99,
    false,
    '789 Oak Avenue, Villageland',
    'Spicy'
  ),
  (
    4,
    '7,8,9',
    3,
    '2023-07-02',
    41.75,
    true,
    '567 Pine Lane, Townsville',
    NULL
  ),
  (
    5,
    '10,11',
    2,
    '2023-07-03',
    34.99,
    true,
    '321 Elm Street, Cityville',
    NULL
  );