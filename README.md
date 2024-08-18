# Ecommerce Web App

This is a full-stack ecommerce web application built using Spring Boot, React, MySQL, Razorpay, and Material UI.

## Features

- User authentication and authorization
- Product browsing and searching
- Shopping cart functionality
- Order placement and tracking
- Payment integration with Razorpay
- Responsive and user-friendly UI using Material UI

## Technologies Used

- Spring Boot: A Java-based framework for building backend services
- React: A JavaScript library for building user interfaces
- MySQL: A relational database management system
- Razorpay: A payment gateway integration service
- Material UI: A UI component library for React applications

## Prerequisites

Before running the application, make sure you have the following installed:

- Java Development Kit (JDK)
- Node.js and npm
- MySQL database server

## Getting Started

1. Clone the repository:

    ```
    git clone https://github.com/royaals/ecommerce-webapp.git
    ```

2. Set up the backend:

    - Navigate to the `backend` directory:

      ```
      cd eccommerce-webapp/backend
      ```

    - Install the dependencies:

      ```
      mvn install
      ```

    - Start the backend server:

      ```
      mvn spring-boot:run
      ```

3. Set up the frontend:

    - Navigate to the `frontend` directory:

      ```
      cd eccommerce-webapp/frontend
      ```

    - Install the dependencies:

      ```
      npm install
      ```

    - Start the frontend server:

      ```
      npm start
      ```

4. Access the application:

    Open your web browser and visit `http://localhost:3000` to access the ecommerce web app.

## Configuration

To configure the application, you can modify the following files:

- `backend/src/main/resources/application.properties`: Configure the database connection and other backend properties.
- `frontend/src/config.js`: Configure the API endpoints and other frontend properties.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more information.
