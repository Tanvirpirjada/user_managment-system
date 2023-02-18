# user_managment-system
Creat user managment system

# User Management System

This project we devlope user management system in where we performe a verious crud Operations. And also do some validation on some Atrributes of user ex phone number , email etc.

# framework and languges
* Springboot framework is used
* Java is Used for code

# Data flows

* UI(postman or localhost 8080 made requests)

# 1 Cotroller
* Cotroller -> requestcome from ui and  execute mathod in cotroller based on end points. In controller various mathods are available Ex
->Add user : http://localhost:8080/saveuser

->getuser  : http://localhost:8080/getuser 

->Updateuser :http://localhost:8080/http://localhost:8080/updateuser/id/{id}

->deleteuser : http://localhost:8080/http://localhost:8080/deleteuser/id/{id}

and also do some validation;

* form controller service methods are call where our main buisness logic is wriiten

# 2 service

* the methods are called and its get data from databse with help of repository layer

# 3 Repository 
repository layes is help to connect with database 

# used databse
->H2

# data Structure
->  ArrayList, String array


