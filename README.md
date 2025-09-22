 Marvellous DBMS
-------------------------------------------------------------------------------

Project Title   : Customized Database Management System (MarvellousDBMS)  
Author          : Sakshi Pankaj Borhade  
Language        : Java 
Main File       : Customized_Database_Management_System.java  
Dependencies    : Java JDK  

DESCRIPTION
-------------------------------------------------------------------------------

Marvellous DBMS is a console-based custom database management system implemented 
in Java. It mimics basic functionalities of a relational DBMS for managing 
"Employee" records in memory, using Java collections and serialization.

It provides features such as:

 - Inserting new employee records
 - Searching based on fields like ID, name, age, address, salary
 - Deleting records using various filters
 - Updating employee salary
 - Performing aggregate operations (MAX, MIN, SUM, AVG, COUNT)
 - Saving and restoring data using Java object serialization

This system does not use any external database engine; it is a fully Java-based 
in-memory implementation using `LinkedList`.


FEATURES
-------------------------------------------------------------------------------

1. Insert new employee records  
2. View all employee records  
3. Search by:
   - Employee ID
   - Employee Name
   - Age
   - Address
   - Salary  
4. Delete records by:
   - Employee ID
   - Name
   - Age
   - Address
   - Salary  
5. Aggregate functions:
   - MAX(Salary)
   - MIN(Salary)
   - SUM(Salary)
   - AVG(Salary)
   - COUNT(*)  
6. Update salary for a given employee ID  
7. Save and load database using file-based backup (serialization)


HOW TO COMPILE AND RUN
-------------------------------------------------------------------------------

1. Save the file as:
       Customized_Database_Management_System.java

2. Open terminal/command prompt and navigate to the folder containing the file.

3. Compile the program:
       javac Customized_Database_Management_System.java

4. Run the program:
       java Customized_Database_Management_System

5. Use the on-screen menu to interact with the database.


BACKUP AND RESTORE
-------------------------------------------------------------------------------

- Backup is automatically saved to a file named `MarvellousDBMS.ser`
- Upon starting the application, it tries to restore from the file
- If the file is not found, a new database instance is created


EMPLOYEE RECORD FORMAT
-------------------------------------------------------------------------------

Each employee record contains the following fields:

   - EmpId      : Unique (auto-incremented) ID (assigned automatically)
   - EmpName    : Employee Name (String)
   - EmpAge     : Employee Age (int)
   - EmpAddress : Employee Address (String)
   - EmpSalary  : Employee Salary (int)
