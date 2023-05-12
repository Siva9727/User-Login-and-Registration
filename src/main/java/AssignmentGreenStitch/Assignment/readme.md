# Backend Assignment README

This project showcases the implementation of security using Spring Boot 3.0 and JSON Web Tokens (JWT). It includes several features to enhance the security and authentication process. Below is a detailed description of the features and technologies used in this project.

## Features

### User Registration and Login
The project provides endpoints for user registration and login. Users can register by providing their credentials, and upon successful registration, they can log in using their registered username and password.

### JWT Authentication
JSON Web Tokens (JWT) are used for authentication purposes. Upon successful login, a JWT token is generated and sent to the client. Subsequent requests to protected endpoints require the client to include this token in the request header for authentication.

### Password Encryption
User passwords are securely encrypted using BCrypt, a popular hashing algorithm for password hashing. This ensures that passwords are not stored in plain text format and enhances the security of user data.

### Role-based Authorization
The project includes role-based authorization using Spring Security. Different user roles can be assigned, such as admin or regular user, and specific endpoints can be restricted to certain roles. This ensures that only authorized users can access protected resources.

### Customized Access Denied Handling
When a user tries to access a restricted resource without the necessary authorization, a custom access denied handler is triggered. This handler provides an appropriate error response to the user, indicating that access is denied.

### Logout Mechanism
The project implements a logout mechanism to allow users to invalidate their session and terminate their authentication. When a user logs out, the JWT token becomes invalid, and subsequent requests using that token will be rejected.

### Refresh Token
A refresh token mechanism is implemented to allow users to obtain a new JWT token without having to log in again. This helps improve user experience by reducing the frequency of logins. Users can exchange their valid refresh token for a new JWT token.

## Technologies

The project utilizes the following technologies:

* **Spring Boot 3.0**: A framework that simplifies the development of Java applications, providing features such as auto-configuration and easy dependency management.
* **Spring Security**: A powerful security framework for Java applications, offering authentication, authorization, and other security features.
* **JSON Web Tokens (JWT)**: A compact and self-contained method for transmitting information securely as a JSON object, commonly used for authentication purposes.
* **BCrypt**: A widely-used password hashing algorithm that ensures passwords are securely stored by applying hashing and salting techniques.
* **Maven**: A build automation tool that simplifies the management of Java projects, handling dependency resolution and project build processes.

## Getting Started

To get started with the project, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/your-repo.git`
2. Install the required dependencies using Maven: `mvn install`
3. Configure the project according to your needs, such as database connection settings or JWT token expiration times.
4. Build and run the application: `mvn spring-boot:run`
5. Access the application through the provided endpoints and test the various features.

Feel free to explore the project code and modify it as necessary to suit your requirements.

## Contributing

If you would like to contribute to this project, please follow these guidelines:

1. Fork the repository.
2. Create a new branch for your feature or bug fix: `git checkout -b my-feature`
3. Make your modifications and commit them: `git commit -am 'Add new feature'`
4. Push to the branch: `git push origin my-feature`
5. Submit a pull request outlining your changes.
