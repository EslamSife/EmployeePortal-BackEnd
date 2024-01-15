Employee Information Portal
Overview
This project consists of an Angular frontend (EmployeePortal-FrontEnd) and a Spring Boot backend (EmployeePortal-BackEnd), containerized using Docker. The application allows users to view, add, delete, and update employee data in a tabular format.

Prerequisites
Docker installed on your machine.
Docker Hub account (optional, for pulling images).
Running the Application
Step 1: Pull Docker Images
Pull the images from Docker Hub:

bash
Copy code
docker pull eslamsife91/employee-portal-front-end
docker pull eslamsife91/employee-portal-spring-backend
Step 2: Run Backend Container
Start the Spring Boot backend:

bash
Copy code
docker run -p 9090:8080 eslamsife91/employee-portal-spring-backend
Step 3: Run Frontend Container
Start the Angular frontend:

bash
Copy code
docker run -p 8080:80 eslamsife91/employee-portal-front-end
Step 4: Access the Application
Open a web browser and navigate to http://localhost:8080.

GitHub Repositories
Frontend: EmployeePortal-FrontEnd
Backend: EmployeePortal-BackEnd
Feel free to adjust the content to better match your project's specifics and any additional instructions you might want to include. This template provides a basic guide for users to set up and run your application.
