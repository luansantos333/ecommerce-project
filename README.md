# E-commerce System

This project is an e-commerce system that allows for the management of users, products, categories,and orders. The system offers features for browsing a product catalog, managing a shopping cart, and placing orders. 

![image](https://github.com/user-attachments/assets/07c93f0c-d0e1-4c53-861e-b88b253b4370)


## Features

### User Registration

- **Users**: Each user has the following data:
  - Name
  - Email
  - Phone
  - Date of Birth
  - Access Password

- **User Types**:
  - **Customer**: Standard user with access to the product catalog and shopping cart.
  - **Administrator**: User with access to the administrative area to manage users, products, and categories.

- **Registration and Navigation**:
  - Unregistered users can sign up for the system, browse the product catalog, and access the shopping cart.
  - Customers can update their registration, place orders, and view their own orders.

### Product Registration

- **Products**: Each product has the following data:
  - Name
  - Description
  - Price
  - Image

- **Product Catalog**:
  - Products are displayed in a catalog that can be filtered by product name.
  - Product details are available for viewing.

### Shopping Cart

- **Cart Management**:
  - Add and remove items from the shopping cart.
  - Change the quantities of each item in the cart.

### Orders

- **Order Registration**:
  - When an order is placed, it is saved in the system with the status "pending payment".
  - Order data:
    - Time it was saved
    - Order status
    - List of items, including product and quantity

- **Order Status**:
  - Pending payment
  - Paid
  - Shipped
  - Delivered
  - Canceled

- **Payment**:
  - The time of payment is recorded when the order is paid.

### Administrative Area

- **Administrator Features**:
  - Access to register and manage users.
  - Access to register and manage products.
  - Access to register and manage categories.

## Technologies Used

- SpringBoot 
- Hibernate
- SQL
- JPQL
- Git
- OAuth2
- JWT Token

## Installation Instructions

1. Clone the repository:
  ` 
   git clone [https://github.com/luansantos333/repo.git](https://github.com/luansantos333/ecommerce-project.git]
   Navegue até o diretório do projeto:
   cd nome-do-projeto
  `

2.Configure the environment (include details about database configuration, environment variables, etc.).

Compile and run the project:  

    mvn install
    mvn spring-boot:run

  Environment variables for dev profile
  
    ${DB_DEV_HOSTNAME}
    
    ${DB_DEV_USERNAME}
    
    ${DB_DEV_PASSWORD}

# Use cases

![image](https://github.com/user-attachments/assets/b6ee832e-bef4-4434-b691-0a9ad0b56269)

