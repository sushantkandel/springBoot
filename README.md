Materials Manipulator 
====
# Introduction
This is inconvinent and high cost generator over longterm ,keeping the hard copy record of your materials available.  To solve the problem and increase the efficiency,Here it comes **Material Analyzer**.This API helps you to Create,  Delete,Update and List the materials through your Database.Which make you data acquistion more effective and enhanced.

# Naming Convention Used:

* **Variable       :** Staring with small letter following Camelcase approach.

* **Method name    :** Staring with small letter following Camelcase approach.

* **Class name     :** Starting with Capital letter following Camelcase approach.

* **Interface name :** Starting with Capital letter following Camelcase approach.

* **Package name   :** writing in small letter and path is defined by using(.) between the directories.
# Technology Used :

* **Java 1.8**

* **Spring boot web framework**

* **Spring JPA**

* **Hibernet 5.3.9**

* **Maven Project**

* **Postman**
---
# Operation and Details :
In this API we are sending the request to perform the operation through the help of Postman.If the given request is mapped sucessfully in the controller class then the mapped function in the controller is executed.Function call the service that is wired in it and call the respective mentioned method.All the business logic were written in the service class. In order to work with the Database also to use the JPA service extended by the Repository Interface ,Repository interface is Autowired in the service class.So that we can utilize the given CRUDE inbuilt function.For your own operation function which you haven't found in the JPA Repository you dont have to implement the function,you only have to define the method signature only because the JPA Repository is injelligent enough to know what to do on the behalf of the given method signature.But to write the signature you have to follow the syntax rule.Below we are explaning the Details of the verious terms used to perform the action.  
# HTTP Request Method Used :

* **GET   :** The GET method is used to retrieve information from the given server using a given URI(_Uniform Resource Identifier_). Requests using GET should only retrieve data and should have no other effect on the data.  
  **URI in ProductController :**  
         _/categories/{id}/products_ :  this is used to get all the product present in the given id categories.  
         _/categories/{categoryId}/products/{id}_ :this is used to get the product of the mentioned id present in the categoryId.    
         **URI in CategoryController:**  
         _/categories_ :This is used to get all the categories present.  
         _/categories/{id}_ :This is used to get all the categories by its id.

* **POST  :** A POST request is used to send data to the server.

* **PUT   :** Replaces all the current representations of the target resource with the uploaded content.

* **DELETE:** Removes all the current representations of the target resource given by URI(_Uniform Resource Identifier_).



