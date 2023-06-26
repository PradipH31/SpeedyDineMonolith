CREATE DATABASE speedy_dine;
USE DATABASE speedy_dine;

-- Create the Restaurant table
CREATE TABLE restaurant (
  restaurant_id BIGINT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL
);

-- Insert sample data
INSERT INTO restaurant (restaurant_id, name, address)
VALUES
  (1, 'The Italian Trattoria', '123 Main Street, Cityville'),
  (2, 'La Petite Brasserie', '456 Elm Street, Townsville'),
  (3, 'Sushi House', '789 Oak Avenue, Villageland'),
  (4, 'Café Bistro', '567 Pine Lane, Townsville'),
  (5, 'Mama Mia Pizzeria', '321 Elm Street, Cityville'),
  (6, 'Steakhouse Grill', '876 Oak Avenue, Villageland'),
  (7, 'Asian Fusion', '234 Main Street, Cityville'),
  (8, 'Taco Fiesta', '987 Maple Road, Villageland'),
  (9, 'Burger Joint', '543 Oak Avenue, Townsville'),
  (10, 'Sizzling BBQ', '654 Elm Street, Cityville'),
  (11, 'Seafood Paradise', '876 Pine Lane, Townsville'),
  (12, 'The French Bistro', '345 Main Street, Cityville'),
  (13, 'Mexican Cantina', '678 Oak Avenue, Villageland'),
  (14, 'Pizza Express', '432 Elm Street, Cityville'),
  (15, 'Indian Spice', '987 Maple Road, Villageland'),
  (16, 'Thai Delight', '321 Main Street, Townsville'),
  (17, 'Gourmet Deli', '765 Oak Avenue, Cityville'),
  (18, 'Healthy Greens', '543 Pine Lane, Townsville'),
  (19, 'Sushi Master', '876 Elm Street, Cityville'),
  (20, 'BBQ Smokehouse', '234 Main Street, Villageland');
