# Quiz Management System
Welcome to my little back-end development project!

---

This project is GUI-based using Swing to manage, build and answer quiz questions. A GUI (graphical user interface) means the user can interact with the application through buttons, multiple windows, and other features.
- Each quiz has a unique code that allows guest users to complete one
---

# Requirements

## Language Used

 Java

## Database

MySQL

## IDE

I used VSCode, however Eclipse is ideal. 
- **If using VSCode make sure to install MySQL Shell extension**

# To Run This Project
As mentioned MySQL is used in this application. If using a different database you must find the necessary jar file for java connection.

---

**Following queries are needed in order to not get a database error**
```
CREATE TABLE actors(id int primary key auto_increment, fname varchar(50), uname varchar(50), pass varchar(50));
CREATE TABLE userQuestions(id int, quizcode varchar(5), total int);
CREATE TABLE questions(quizcode varchar(5), question varchar(255), option1 varchar(255), option2 varchar(255), option3 varchar(255), option4 varchar(255)); 
CREATE TABLE quizquestions(quizcode varchar(5), qno int, opno int);
```
