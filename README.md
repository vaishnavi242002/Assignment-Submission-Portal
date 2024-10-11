# **Assignment Submission Portal - Backend**

### **Overview**

This project is a backend system for an **Assignment Submission Portal**, where two types of users—**Admins** and **Users**—interact with the platform. The primary goal is to allow users to submit assignments and enable admins to review, accept, or reject them.

- **Users**: Users can register, log in, and upload assignments. Each assignment includes a user ID, a task description, and the admin to whom the assignment is tagged.
  
- **Admins**: Admins have special privileges. They can register, log in, view assignments that are specifically tagged to them, and decide to either accept or reject those submissions. The admin's dashboard includes the name of the user who submitted the assignment, the task details, and a timestamp indicating when the submission was made.

The system is designed to handle multiple users and admins, and role-based access ensures that admins can only manage the assignments assigned to them. The backend is built with **Spring Boot** and **MongoDB** as the database, ensuring flexibility and scalability for data management.

---

### **Features**

#### **1. User Registration and Authentication**
- **Users** can register themselves with the platform via a `/register` endpoint.
- Once registered, users can log in using their credentials through the `/login` endpoint. Upon successful authentication, they can perform assignment-related operations.

#### **2. Assignment Submission**
- After logging in, a user can submit an assignment using the `/upload` endpoint. The assignment consists of:
  - `userId`: The user’s unique identifier.
  - `task`: A description of the task (e.g., "Hello World").
  - `admin`: The name of the admin assigned to review the task.
  
#### **3. Admin Registration and Authentication**
- Admins can also register via `/register`, similar to users, and log in via the `/login` endpoint.
  
#### **4. Admin Dashboard**
- **Admins** can view all assignments tagged to them using the `/assignments` endpoint. Each entry includes:
  - The user's name.
  - The task description.
  - A timestamp for when the assignment was submitted.
  
#### **5. Accept or Reject Assignments**
- After reviewing an assignment, admins can either **accept** or **reject** submissions using:
  - `/assignments/:id/accept` for accepting assignments.
  - `/assignments/:id/reject` for rejecting assignments.
  
#### **6. Role-based Authorization**
- The system is designed with **role-based access control (RBAC)**, ensuring that only authenticated admins can access assignment management features, while regular users are limited to submitting assignments.

#### **7. Error Handling and Validation**
- All input fields are validated to prevent incomplete or incorrect data from being submitted. Proper error messages are provided for invalid or unauthorized actions.

---

### **Screenshots**

#### **1. Postman Testing**

Below is a screenshot of the Postman testing for user registration, login, and assignment submission:

![Postman Testing Screenshot](./Images/Postman%20Testing%20API%20Screenshot.png)

#### **2. MongoDB User and Admin Data**

Here are screenshots of the MongoDB database showing the structure of user and admin data entries:

- **User Data:**
  ![MongoDB User Data Screenshot](./Images/MongoDB%20User%20Data.png)

- **Admin Data:**
  ![MongoDB Admin Data Screenshot](./Images/MongoDB%20Admin%20Data.png)




---

### **Prerequisites**

Before you begin, ensure you have the following installed:

- **Java 17+**
- **Maven** (for project dependency management)
- **MongoDB** (running instance, either local or cloud-based like MongoDB Atlas)
- **Postman** (optional, for API testing)

---

### **Installation and Setup Instructions**

1. **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/assignment-portal.git
    cd assignment-portal
    ```

2. **Set up MongoDB:**
    - Ensure MongoDB is running locally or configure a cloud instance (e.g., MongoDB Atlas).
    - Create a database and note the connection URI (e.g., `mongodb://localhost:27017/assignment-portal`).

3. **Configure the application properties:**
    - Open `src/main/resources/application.properties` and configure the MongoDB connection string:
      ```properties
      spring.data.mongodb.uri=mongodb://localhost:27017/assignment-portal
      ```
      
4. **Build and run the project:**
    - Build the project using Maven:
      ```bash
      mvn clean install
      ```
    - Run the Spring Boot application:
      ```bash
      mvn spring-boot:run
      ```

5. **Testing the API using Postman:**
    - Import the Postman collection provided in the repository or create your own requests for the available endpoints.

---

### **API Endpoints**

#### **User Endpoints:**
- `POST /register` - Register a new user.
- `POST /login` - User login.
- `POST /upload` - Upload an assignment.
- `GET /admins` - Fetch all admins.

#### **Admin Endpoints:**
- `POST /register` - Register a new admin.
- `POST /login` - Admin login.
- `GET /assignments` - View assignments tagged to the admin.
- `POST /assignments/:id/accept` - Accept an assignment.
- `POST /assignments/:id/reject` - Reject an assignment.

---







