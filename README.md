java -jar target/QuizMaster-App-0.0.1-SNAPSHOT.jar
# QuizMaster-App

QuizMaster-App is a dynamic quiz application designed to test your knowledge across various topics. It provides an interactive and engaging learning experience for users of all ages. The app is easy to use, responsive, and designed with scalability in mind.

---

## Features

- **Multiple-choice quizzes:** Users can answer multiple-choice questions in different categories.
- **Instant feedback:** Get immediate results for each question.
- **Score tracking:** See your total score at the end of each quiz.
- **Responsive UI:** Works seamlessly on desktops, tablets, and mobile devices.
- **Extensible:** Easily add new quizzes or topics.
- **User-friendly interface:** Minimalist and intuitive design for smooth navigation.

---

## Tech Stack

- **Frontend:** HTML, CSS, JavaScript (or React if applicable)
- **Backend (if any):** Node.js, Express.js
- **Database (if any):** MongoDB / Firebase / LocalStorage
- **Version Control:** Git & GitHub

> Adjust the stack according to what your app actually uses.

---

## Installation

1. Clone the repository:
```bash
git clone https://github.com/VyshrawanP/QuizMaster-App.git
java -version
mvn -version
mvn clean install
mvn spring-boot:run
java -jar target/QuizMaster-App-0.0.1-SNAPSHOT.jar

from applications properties
spring.datasource.url=jdbc:mysql://localhost:3306/quizdb
spring.datasource.username=root
spring.datasource.password=yourpassword
server.port=8080

spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

