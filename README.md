# 🍺 Java Desktop BeerReviewApp

**Java Desktop BeerReviewApp** is a desktop application for beer rating and reviewing. The app uses Swing GUI, client-server architecture via Java sockets, a MySQL database, and the MVC pattern. It supports two types of users – **User** and **Brewery** – interacting through an intuitive interface.

---

## 🧩 Key Features

- ✅ **Registration and login** for both user types (User and Brewery)
- 🧾 **Users** can:
  - Add reviews and rate beers
  - Search beers and breweries
  - Follow favorite beers
  - Edit their profile
  - Delete their account, reviews, and beers from their favorites list
- 🏭 **Breweries** can:
  - Add new beers
  - View reviews of their beers
  - Edit information about their beers
  - Edit their profile
  - Delete their account and their beers
- 🔗 Client-server communication via **Java sockets**
- 🗃 Connection to **MySQL** database
- 🧠 Organized code using the **MVC architecture**

---

## 🛠 Technologies

- **Java SE**
- **Java Swing** (GUI)
- **Socket Programming** (TCP/IP)
- **MySQL**
- **NetBeans IDE**
- **MVC (Model-View-Controller)** pattern

---

## 📁 Project Structure

```
BeerReviewProject/
│
├── client/            # GUI application used by users and breweries
├── server/            # Server handling requests and database communication
├── shared/            # Shared models and classes (DTOs, entities, etc.)
└── README.md
```

---

## 🧪 Running the Application Locally

1. **Clone the repository:**

   ```bash
   git clone https://github.com/milospavlovic7/Java-Desktop-BeerReviewApp.git
   ```

2. **Import the SQL database:**

   Import the provided `.sql` file (if available) into your MySQL using Workbench or phpMyAdmin.

3. **Start the server:**

   - Open the `server` project in NetBeans and run the main class (`Main`).

4. **Start the client application:**

   - Open the `client` project in NetBeans and run the main class (`Main`).

5. **Create user accounts and test the app.**

---

## 📄 License

This project is open-source and intended for educational and personal use.

---

## 👨‍💻 Author

- Miloš Pavlović  
- [GitHub: milospavlovic7](https://github.com/milospavlovic7)
