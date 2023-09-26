# Product Application README

## Table of Contents
- [Introduction](#introduction)
- [Architecture](#architecture)
- [Files and Components](#files-and-components)
    - [Product List JSP](#product-list-jsp)
    - [Add Product JSP](#add-product-jsp)
    - [Update Product JSP](#update-product-jsp)
    - [Java Classes](#java-classes)
- [Conclusion](#conclusion)

## Introduction

## ERD
![ERD](https://github.com/AhmedShalabi01/Fawry-Internship-Summer2023/assets/119356507/de5b3fdb-23f0-44b6-89f4-bc308c3433ac)


Welcome to the Product Application README. This document provides a comprehensive overview of the Product Application, its architecture, components, and detailed explanations of each file and Java class. The Product Application allows users to manage products, including adding, updating, and deleting them.

## Architecture

The Product Application follows a standard Spring MVC (Model-View-Controller) architecture, which separates the application into three main components:

1. **Model**: Represents the application's data and business logic. In this application, the data model includes `Category`, `Product`, and `ProductModel` classes. These classes define the structure of categories and products and manage data transfer between the frontend and backend.

2. **View**: Represents the user interface (UI) of the application. The views in this application are implemented using JavaServer Pages (JSP). The JSP files provide user-friendly interfaces for managing products, including listing, adding, and updating them.

3. **Controller**: Handles user requests and manages the application's workflow. The `ProductController` class is responsible for handling requests related to product management, such as listing, searching, adding, updating, and deleting products. It communicates with the `ProductService` to perform these actions.

## Files and Components

### Product List JSP

**Description**
- **Title**: Product List
- **Styling**: The page uses CSS for styling, providing a clean and user-friendly interface.
- **Script Libraries**: The page includes the Swal (SweetAlert2) library for displaying confirmation dialogs.

**Functionality**
- Displays a list of products in a table.
- Allows users to search for products by name or ID.
- Provides options to delete and update individual products.

**Usage**
- The JSP file serves as the user interface for managing products in your application. It integrates with the Spring MVC framework and interacts with the `ProductController` to perform various product-related operations.

### Add Product JSP

**Description**
- **Title**: Add Product
- **Styling**: The page uses CSS for styling, providing a clean and user-friendly interface.
- **Script Libraries**: The page includes the Swal (SweetAlert2) library for displaying confirmation dialogs.

**Functionality**
- Allows users to enter product details, including name, price, and category.
- Performs client-side validation to ensure that all required fields are filled.
- Validates the price to ensure it's greater than zero.
- Displays a confirmation dialog upon successful submission.

**Category Selection**
- Provides a dropdown menu for selecting the product's category.
- Retrieves category options from the server, ensuring accurate category selection.

**Confirmation Dialog**
- Displays a confirmation dialog to confirm the addition of a new product.
- Provides feedback to the user about the success of the product creation.

**Usage**
- The JSP file serves as the user interface for adding new products to your application. It integrates with the Spring MVC framework and interacts with the `ProductController` to handle product creation.

### Update Product JSP

**Description**
- **Title**: Update Product
- **Styling**: The page uses CSS for styling, providing a clean and user-friendly interface.
- **Script Libraries**: The page includes the Swal (SweetAlert2) library for displaying confirmation dialogs.

**Functionality**
- Displays the current product name and price in input fields for editing.
- Allows users to modify the product's name and price.
- Performs client-side validation to ensure that required fields are filled and that the price is greater than zero.
- Displays a confirmation dialog upon successful submission to confirm the changes.

**Confirmation Dialog**
- Displays a confirmation dialog when the user clicks the "Update Product" button.
- Provides options to save or discard changes.
- Informs the user about the success or cancellation of the update operation.

**Usage**
- The JSP file serves as the user interface for updating product details in your application. It integrates with the Spring MVC framework and interacts with the `ProductController` to handle product updates.

### Java Classes

#### `Category`, `Product`, and `ProductModel` Classes

- These classes define the data model for categories and products in your application.
- They are annotated with `@Entity` and `@Table` to define the database structure.
- Relationships between `Category` and `Product` are established using JPA annotations.
- The `ProductModel` class is used for data transfer between the frontend and backend.

#### `ProductMapper` Interface

- The `ProductMapper` interface defines methods for mapping between `Product` entities and `ProductModel` objects. It uses the MapStruct library for mapping.

#### Repository Interfaces

- `CategoryRepository` and `ProductRepository` are Spring Data JPA repository interfaces for interacting with the database.

#### `ProductService` Class

- The `ProductService` class provides business logic for managing products.
- It uses `ProductRepository`, `CategoryRepository`, and `ProductMapper` for data operations.
- Methods include fetching products, adding, updating, and deleting products.

#### `ProductController` Class

- The `ProductController` class is a Spring MVC controller responsible for handling requests related to product management.
- It uses the `ProductService` to perform actions such as listing, searching, adding, updating, and deleting products.

## Conclusion

These files and Java classes collectively create a functional product management application. The JSP files provide user interfaces for managing products, while the Java classes handle data operations and business logic.

## Output
![1](https://github.com/AhmedShalabi01/Fawry-Internship-Summer2023/assets/119356507/15daeff0-44a6-4f80-8fdd-35fb1cf7cb9f)
![2](https://github.com/AhmedShalabi01/Fawry-Internship-Summer2023/assets/119356507/00e7e39c-e35a-4c1d-8576-321aa8dea7b1)
![3](https://github.com/AhmedShalabi01/Fawry-Internship-Summer2023/assets/119356507/22f7f9e8-9a5c-4fc3-81d3-0539c9586d13)
![4](https://github.com/AhmedShalabi01/Fawry-Internship-Summer2023/assets/119356507/2b80414d-d92c-42e7-ab2a-a8fc6f53b984)
![5](https://github.com/AhmedShalabi01/Fawry-Internship-Summer2023/assets/119356507/e0f9c3c3-0929-4f97-a1ad-89ade28bf4d2)
![6](https://github.com/AhmedShalabi01/Fawry-Internship-Summer2023/assets/119356507/7ac82818-63d0-44a7-8d5c-bbd285a02d9d)
![7](https://github.com/AhmedShalabi01/Fawry-Internship-Summer2023/assets/119356507/21529751-1758-4f0f-b3ef-38c9e3e3c280)
![8](https://github.com/AhmedShalabi01/Fawry-Internship-Summer2023/assets/119356507/17cf7be7-d4ae-4052-a39e-d5d81f4fff18)
![9](https://github.com/AhmedShalabi01/Fawry-Internship-Summer2023/assets/119356507/ad9d4e8b-78c5-4fd9-87e7-219e85632e6c)
![10](https://github.com/AhmedShalabi01/Fawry-Internship-Summer2023/assets/119356507/325dc7fb-9010-467a-8298-4600c63a8924)
![11](https://github.com/AhmedShalabi01/Fawry-Internship-Summer2023/assets/119356507/9cb6dfce-f1a0-4fcd-ac07-fb1cb4243370)


