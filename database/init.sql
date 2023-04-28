-- Users Table
CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    mobile_number VARCHAR(15) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    password_salt VARCHAR(255) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(255),
    gender ENUM('Male', 'Female', 'Other'),
    date_of_birth DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Vehicles Table
CREATE TABLE Vehicles (
    vehicle_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    vehicle_make VARCHAR(50),
    vehicle_model VARCHAR(50),
    vehicle_color VARCHAR(50),
    vehicle_license_plate VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Parking Centers Table
CREATE TABLE ParkingCenters (
    center_id INT PRIMARY KEY AUTO_INCREMENT,
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
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Parking Slots Table
CREATE TABLE ParkingSlots (
    slot_id INT PRIMARY KEY AUTO_INCREMENT,
    center_id INT NOT NULL,
    slot_number INT NOT NULL,
    slot_size ENUM('Small', 'Medium', 'Large'),
    slot_type ENUM('Covered', 'Uncovered', 'Indoor', 'Outdoor'),
    slot_availability ENUM('Available', 'Occupied'),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (center_id) REFERENCES ParkingCenters(center_id)
);

-- Bookings Table
CREATE TABLE Bookings (
    booking_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    slot_id INT NOT NULL,
    booking_start_time DATETIME NOT NULL,
    booking_end_time DATETIME NOT NULL,
    booking_duration INT,
    booking_status ENUM('Booked', 'Cancelled', 'Expired', 'Completed'),
    payment_amount DECIMAL(10, 2),
    payment_status ENUM('Pending', 'Approved', 'Declined'),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (slot_id) REFERENCES ParkingSlots(slot_id)
);

-- Payments Table
CREATE TABLE Payments (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    booking_id INT NOT NULL,
    payment_method ENUM('Credit Card', 'Debit Card', 'Paypal'),
    payment_amount DECIMAL(10, 2),
    payment_status ENUM('Pending', 'Approved', 'Declined'),
    payment_time DATETIME,
    FOREIGN KEY (booking_id) REFERENCES Bookings(booking_id)
);

-- Ratings Table
CREATE TABLE Ratings (
    rating_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    center_id INT NOT NULL,
    rating_score INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (center_id) REFERENCES ParkingCenters(center_id)
);

-- Reviews Table
CREATE TABLE Reviews (
    review_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    center_id INT NOT NULL,
    rating_score INT NOT NULL,
    review_comment VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (center_id) REFERENCES ParkingCenters(center_id)
);

