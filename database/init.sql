-- Users Table
CREATE TABLE Users (
    user_id SERIAL PRIMARY KEY,
    user_type VARCHAR(6) CHECK (
        user_type IN ('Admin', 'User', 'ParkOwner', 'SecurityGuard')
    ),
    mobile_number VARCHAR(15) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    password_salt VARCHAR(255) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(255),
    gender VARCHAR(6) CHECK (gender IN ('Male', 'Female', 'Other')),
    date_of_birth DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- Vehicles Table
CREATE TABLE Vehicles (
    vehicle_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    vehicle_make VARCHAR(50),
    vehicle_model VARCHAR(50),
    vehicle_color VARCHAR(50),
    vehicle_license_plate VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);
-- Parking Centers Table
CREATE TABLE ParkingCenters (
    center_id SERIAL PRIMARY KEY,
    center_name VARCHAR(100) NOT NULL,
    center_address VARCHAR(255) NOT NULL,
    center_city VARCHAR(100) NOT NULL,
    center_state VARCHAR(100) NOT NULL,
    center_country VARCHAR(100) NOT NULL,
    center_postal_code VARCHAR(20) NOT NULL,
    center_latitude DECIMAL(10, 8),
    center_longitude DECIMAL(11, 8),
    center_image VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- Parking Blocks Table
CREATE TABLE ParkingBlocks (
    block_id SERIAL PRIMARY KEY,
    center_id INT NOT NULL,
    block_number INT NOT NULL,
    block_size VARCHAR(7) CHECK (block_size IN ('Small', 'Medium', 'Large')),
    block_type VARCHAR(9) CHECK (
        block_type IN ('Covered', 'Uncovered', 'Indoor', 'Outdoor')
    ),
    block_availability VARCHAR(9) CHECK (block_availability IN ('Available', 'Occupied')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (center_id) REFERENCES ParkingCenters(center_id)
);
-- Bookings Table
CREATE TABLE Bookings (
    booking_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    block_id INT NOT NULL,
    booking_start_time TIMESTAMP NOT NULL,
    booking_end_time TIMESTAMP NOT NULL,
    booking_duration INT,
    booking_status VARCHAR(10) CHECK (
        booking_status IN ('Booked', 'Cancelled', 'Expired', 'Completed')
    ),
    payment_amount DECIMAL(10, 2),
    payment_status VARCHAR(9) CHECK (
        payment_status IN ('Pending', 'Approved', 'Declined')
    ),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (block_id) REFERENCES ParkingBlocks(block_id)
);
-- Payments Table
CREATE TABLE Payments (
    payment_id SERIAL PRIMARY KEY,
    booking_id INT NOT NULL,
    payment_method VARCHAR(11) CHECK (
        payment_method IN ('Credit Card', 'Debit Card', 'Paypal')
    ),
    payment_amount DECIMAL(10, 2),
    payment_status VARCHAR(9) CHECK (
        payment_status IN ('Pending', 'Approved', 'Declined')
    ),
    payment_time TIMESTAMP,
    FOREIGN KEY (booking_id) REFERENCES Bookings(booking_id)
);
-- Ratings and Reviews Table
CREATE TABLE RatingsAndReviews (
    rating_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    center_id INT NOT NULL,
    rating_score INT NOT NULL CHECK (
        rating_score >= 1
        AND rating_score <= 10
    ),
    review_comment VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (center_id) REFERENCES ParkingCenters(center_id)
);