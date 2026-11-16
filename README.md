This is a README about my computer store database system. 

This project was a fun project for me to understand and learn more about JAVA. 
I wanted to create a database for a pseudo computer store.
The store and all the names, ids and any details in this project are made up for the project's sake.

The goal of this project was to create a system that will be able to handle an employee that works as a cashier.
The employee will have a line of customers he is helping at the moment, and he will be able to add customers to this line,
remove customers, and change details about them like: amount paid, VIP status.
As well as a manager that has much more options to change because he has more permissions.

The program has the following classes and methods:


Customer - class that represents a customer in a store.
The customer has the following fields:
name - the name of the customer.
id - the id of the customer.
amount paid - the amount the customer paid at the store.
is vip - is he a vip customer or not.

Customer has getters and setters and the function:
ApplyDisc - apply a discount to the customer if he is a VIP customer.



Employee - class that represents an employee in a store. 
The employee has the following fields:
name - the name of the employee.
id - the id of the employee.
salary - the amount of money the employee gets.
customer line - a queue implemented with a linked list, stores the customers the employee is serving.

Employee has getters and setters and the following methods:

Is_customers_getting_served - checks if the employee is currently serving customers.

Is_customer_in_line - checks if a specific customer is currently in the employee's queue.

enqueue_line - adds a customer to the end of the employee's queue if they are not already in it.

search_customer - searches for a customer in the queue using an ID, returns the searched customer if found.

dequeue_line - removes a customer from the queue, while maintaining the FIFO order of the queue.

PrintLine - prints the queue of customers.

Product - an abstract class that represents a general product to be used in the project. 
We can inherit from this class and by 
that create an item category for the warehouse (like I did with keyboards). 

Product has the following fields:
id - the id to sort the product in the warehouse.
type - the type of product it is (keyboard, mouse, monitor, etc.).
price - the price of the product.
warranty - the warranty for the product.

Product has setters and getters and the following methods:
toString - print the details of the product.

ApplyDiscount - applies a discount to the product price given the discount percentage. 

ApplyVat - calculate the product price including 18% standard VAT. 

change_warranty - changes the warranty of the product by the type of change, "add" adds more time,
"subtract" for removing time from the warranty.



ProductLink - a class that acts like a linked list of products. 
ProductLink has the following fields:

Product - the actual product the node is handling.
nextNode - the next product after the current product in the list.

ProductLink has setters and getters and the following methods:
toString - prints all the details of the node.

PrintList - prints the entire list from head to tail.




Keyboards - a class that represents a Keyboard Product.
Inherits from Product.
Keyboard has the following fields:
id, type, price, warranty.

Keyboards inherits the following methods:
ApplyDiscount - applies a discount to the product price given the discount percentage. 

ApplyVat - calculate the product price including 18% standard VAT. 

change_warranty - changes the warranty of the product by the type of change, "add" adds more time,
"subtract" for removing time from the warranty.


Supplier - a class that represents a supplier for the warehouse. 
The supplier holds items that he brings with him. 

Supplier has the following fields:
 name - the name of the supplier.
 phone number - the phone number of the supplier.
 company name - the name of the company he works for.
 product list - the list of products the supplier carries with him, these items can be removed from the 
 list and transferred to the warehouse.
 
Supplier has getters and setters and the following methods:
isListEmpty - checks if the list of products is empty.

Is_Product_in_the_list - takes the id of the product and checks if the product is in the list.
 
addLastProduct - adds a given product to the end of the list if the product is not already there.

removeProduct - removes a product by its id from the list.


Warehouse - a class to represent a store warehouse. The warehouse stores items, lists of suppliers
and employees that are allowed in the warehouse.

Warehouse has the following fields:
warehouse_employees - an array of size 10 to hold all the employees that are in the warehouse.
warehouse_suppliers - an array of size 10 to hold all the suppliers that are in the warehouse.
item_stack - a stack that represents the actual shelves that hold products in the warehouse.

Warehouse has getters and setters and the following methods:
toString - prints all the details of the warehouse. 

CountArraySlots - a helper method to count the number of filled spots in the array.

Add_New_employee - creates a minimal employee object and inserts it into the first empty spot in the array.

Add_employee - adds an existing employee object and inserts it into the first empty spot in the array.

Search_employee - searches for an employee with a given id and returns the object.

Is_employee_in_array - checks if an employee with the given id is in the employee array.

Remove_employee - removes an employee with the given name and id from the employee array and sorts the array.  

Show_employees - prints every employee in the employee array. 

Add_New_supplier - creates a minimal supplier object and inserts it into the first empty spot in the array.

Add_supplier - adds an existing supplier object and inserts it into the first empty spot in the array.

Is_supplier_in_array - checks if the given supplier phone is in the supplier array.

Remove_supplier - removes the given supplier phone from the supplier array.

Show_suppliers - prints all the suppliers in the supplier array.

Add_to_warehouse_from_supplier - takes the given id and removes the product with that id from the supplier with the given phone number,
 after it is removed the product gets added to the warehouse stack.
 
Is_product_in_warehouse - checks if the given product id is in the warehouse.

search_product - searches for the given product id in the warehouse and returns it if it is found.

remove_product_from_warehouse - looks for the given product id in the warehouse stack and removes it.




Link - a class that represents a node in a linked list.
Link has the following fields: 
data - represents the data in the node.
next - represents the next node for the data structure. 



MyLinkedList - a custom implementation of a singly linked list.
MyLinkedList has the following fields:
Node - represents a node in the list.

MyLinkedList has getters and setters and the following methods:
length - counts and returns the total number of nodes in the linked list.

isEmpty - checks if the linked list is empty.

addLast - adds the given node to the end of the list.

removeFirst - removes a node from the head of the list.

toString - prints the list.



MyStack - an interface for a stack data structure.
It has the following methods:
push - pushes a node to the top of the stack.

pop - removes a node from the top of the stack.

isEmpty - checks if the stack is empty.




MyLinkedStack - a stack implemented with a linked list, using the LIFO order. 
Stack has the following fields:
node - represents a node in the stack.

MyLinkedStack has the following methods:
isStackEmpty - checks if the stack is empty.

push - inserts a new product onto the top of the stack.

pop - removes a product from the top of the stack. 

toString - prints the products currently in the stack.





MyQueue - an interface for a queue data structure.
It has the following methods:

isQueueEmpty - checks if the queue is empty.

Dequeue - removes an object from the front of the queue.

Enqueue - adds an object to the end of the queue.



LinkedQueue - represents a queue implemented with a linked list based on the FIFO order, it implements the MyQueue interface.
It has the following fields:
queueNode - represents a linked list that holds a node inside of it. 

It has the following methods: 
isQueueEmpty - checks if the queue currently contains any elements.

Dequeue - removes a customer from the front of the queue in a FIFO order.

Enqueue - takes a customer and inserts him into the queue.

printLinkedQueue - prints the queue.


The program has a testing class: 
MainTester - inside this class I tested the various methods from the various classes. 
* the class is commented out and will need to be uncommented out to work. When you use this class you have to 
* comment out the Main class, so java and the compiler won't scream that there are 2 main methods in 1 program and 
* the program won't know which of them to use. So make sure to comment out Main when using MainTester.

Main - the main class that needs to be run for the program to start.


* all the names and ids and anything related to reality are made up and were written for testing purposes.
