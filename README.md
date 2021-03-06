Material Analyzer
====
## Introduction
This is inconvinent and high cost generator over longterm ,keeping the hard copy record of your materials available.  To solve the problem and increase the efficiency,Here it comes **Material Analyzer**.This API helps you to Create,  Delete,Update and List the materials through your Database.Which make you data acquistion more effective and enhanced.

## Naming Convention Used:

* **Variable       :** Staring with small letter following Camelcase approach.

* **Method name    :** Staring with small letter following Camelcase approach.

* **Class name     :** Starting with Capital letter following Camelcase approach.

* **Interface name :** Starting with Capital letter following Camelcase approach.

* **Package name   :** writing in small letter and path is defined by using(.) between the directories.
## Technology Used :

* **Java 1.8**

* **Spring boot web framework**

* **Spring JPA**

* **Hibernet 5.3.9**

* **Maven Project**

* **Postman**
---
## Operation and Details :
In this API we are sending the request to perform the operation through the help of Postman.If the given request is mapped sucessfully in the controller class then the mapped function in the controller is executed.Function call the service that is wired in it and call the respective mentioned method.All the business logic were written in the service class. In order to work with the Database also to use the JPA service extended by the Repository Interface ,Repository interface is Autowired in the service class.So that we can utilize the given CRUD inbuilt function.For your own operation function which you haven't found in the JPA Repository you dont have to implement the function,you only have to define the method signature only because the JPA Repository is injelligent enough to know what to do on the behalf of the given method signature.But to write the signature you have to follow the syntax rule.Below we are explaning the Details of the verious terms used to perform the action.  
## HTTP Request Method Used :

* **GET   :** The GET method is used to retrieve information from the given server using a given URI(_Uniform Resource Identifier_). Requests using GET should only retrieve data and should have no other effect on the data.  
  **URI in ProductController :**  
         _**/categories/{id}/products**_ :  this is used to get all the product present in the given id categories.  
         _**/categories/{categoryId}/products/{id}**_ :this is used to get the product of the mentioned id present in the categoryId.    
         **URI in CategoryController:**  
         _**/categories**_ :This is used to get all the categories present.  
         _**/categories/{id}**_ :This is used to get the categories by its id.

* **POST  :** A POST request is used to send data to the server.  
  **URI in ProductController :**  
          _**/categories/{categoryId}/products**_ :This is used to add the product to the mentioned categoryId.  
  **URI in CategoryController:**  
          _**/categories**_ :This is used to add the new category. 
  
* **PUT   :** Replaces all the current representations of the target resource with the uploaded content.  
  **URI in ProductController :**  
          _**/categories/{categoryId}/products**_ :Replace the current product with the uploaded product.  
  **URI in CategoryController:**  
          _**/categories**_ :Replace the current category with the uploaded category.  

* **DELETE:** Removes all the current representations of the target resource given by URI(_Uniform Resource Identifier_).  
  **URI in ProductController :**    
         _**/categories/{categoryId}/products/{id}**_ :Remove the product of the given id.  
  **URI in CategoryController:**  
           _**/categories/{id}**_ :Remove the category of the given id.
           
##  Project Structure image :  
![Capture1](https://user-images.githubusercontent.com/30270813/57764589-7874ec00-7723-11e9-8563-124591adaf88.JPG)
## References :  
1 [Java Brains][example].

  [example]: https://www.youtube.com/watch?v=msXL2oDexqw&list=PLqq-6Pq4lTTbx8p2oCgcAQGQyqN8XeA1x  
  
2 [Baeldung][example1].

  [example1]: https://www.baeldung.com/spring-boot   
  
3 [Spring By pivotal][example2].

  [example2]: https://spring.io/guides/gs/spring-boot/   
  
4 [In 28 minutes][example3].

  [example3]: https://www.youtube.com/user/rithustutorials  

  


