# Quiz Management System
Welcome to my little back-end development project!

---

This project is GUI-based using Swing to manage, build and answer quiz questions. A GUI (graphical user interface) means the user can interact with the application through buttons, multiple windows, and other features.
- Each quiz has a unique code that allows guest users to complete one
---

# Screenshot
<p align="center"><strong>Login</strong></p>
<p align="center"><img width="703" alt="Login" src="https://github.com/baranove16/Quiz-System/assets/89663127/e713177e-59fc-42ed-8927-1bd79b70e649">
 </p>

<p align="center"><strong>Create Quiz</strong></p>
<p align="center"><img width="800" alt="Create Quiz" src="https://github.com/baranove16/Quiz-System/assets/89663127/d43dfdba-e9c2-4f45-8fa2-abe107bf9eb9">
</p>

<p align="center"><strong>View Quizzes</strong></p>
<p align="center"><img width="799" alt="View Quizzes" src="https://github.com/baranove16/Quiz-System/assets/89663127/92df5995-108b-46d5-81fb-4c5dbc187f1b"></p>


# Requirements

---

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
