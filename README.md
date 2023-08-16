# Order Management Microservice

This project is an order management microservice built using Spring Boot 3.1.2, MySQL 8, and Java 17.

## Features

- Manage products, items, and orders in a database.
- Perform CRUD (Create, Read, Update, Delete) operations on products, items, and orders.
- Calculate total amounts for orders based on items.

## Technologies Used

- Spring Boot 3.1.2
- Spring Data JPA
- MySQL 8
- Java 17
- Maven

## Getting Started

1. Clone this repository to your local machine:

    ```bash
    git clone https://github.com/shrasel/kn-microservice-for-erp.git
    ```

2. Set up your MySQL database and configure the database connection in `src/main/resources/application.yml`.

3. Build and run the application:

    ```bash
    cd kn-microservice-for-erp
    mvn spring-boot:run
    ```

4. Access the application at `http://localhost:8080` in your web browser or API client.

## API Endpoints

The following API endpoints are available:

- `GET /products`: Get a list of all products.
- `GET /items`: Get a list of all items.
- `GET /orders`: Get a list of all orders.
- `POST /products`: Create a new product.
- `POST /items`: Create a new item.
- `POST /orders`: Create a new order.
- More endpoints for updating and deleting records are available.

## Contributing

Contributions are welcome! Feel free to open issues and submit pull requests.

