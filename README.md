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
/Projekat
│
├── /BeerReviewKlijent
│   ├── /controller
│   │   └── ClientController.java
│   ├── /forms
│   │   ├── IzborTipaKorisnikaForm.form
│   │   ├── IzborTipaKorisnikaForm.java
│   │   ├── /korisnik
│   │   │   ├── DodajRecenzijuForm.form
│   │   │   ├── DodajRecenzijuForm.java
│   │   │   ├── KorisnikLoginForm.form
│   │   │   ├── KorisnikLoginForm.java
│   │   │   ├── KorisnikMainForm.form
│   │   │   ├── KorisnikMainForm.java
│   │   │   ├── KorisnikRegisterForm.form
│   │   │   ├── KorisnikRegisterForm.java
│   │   │   ├── PanelNalogKorisnik.form
│   │   │   ├── PanelNalogKorisnik.java
│   │   │   ├── PanelPretraga.form
│   │   │   ├── PanelPretraga.java
│   │   │   ├── PanelRecenzije.form
│   │   │   └── PanelRecenzije.java
│   │   └── /pivara
│   │       ├── DodajPivoForm.form
│   │       ├── DodajPivoForm.java
│   │       ├── PanelNalogPivara.form
│   │       ├── PanelNalogPivara.java
│   │       ├── PanelPiva.form
│   │       ├── PanelPiva.java
│   │       ├── PivaraLoginForm.form
│   │       ├── PivaraLoginForm.java
│   │       ├── PivaraMainForm.form
│   │       ├── PivaraMainForm.java
│   │       ├── PivaraRegisterForm.form
│   │       └── PivaraRegisterForm.java
│   ├── /models
│   │   ├── TableModelPretraga.java
│   │   └── TableModelRecenzije.java
│   ├── /service
│   │   ├── KorisnikService.java
│   │   └── PivaraService.java
│   └── /session
│       └── Session.java
│
├── /BeerReviewServer
│   ├── /controller
│   │   └── ServerController.java
│   ├── /db
│   │   └── DBBroker.java
│   ├── /forms
│   │   ├── KonfiguracijaBaze.form
│   │   ├── KonfiguracijaBaze.java
│   │   ├── ServerForm.form
│   │   └── ServerForm.java
│   ├── /so
│   │   ├── AbstractSO.java
│   │   ├── /korisnik
│   │   │   ├── SODeleteKorisnik.java
│   │   │   ├── SOGetAllKorisnik.java
│   │   │   ├── SOLoginKorisnik.java
│   │   │   ├── SORegisterKorisnik.java
│   │   │   └── SOUpdateKorisnik.java
│   │   ├── /omiljenoPivo
│   │   │   ├── SOAddOmiljenoPivo.java
│   │   │   ├── SODeleteOmiljenoPivo.java
│   │   │   └── SOGetAllOmiljenoPivoZaKorisnika.java
│   │   ├── /pivara
│   │   │   ├── SODeletePivara.java
│   │   │   ├── SOGetAllPivara.java
│   │   │   ├── SOLoginPivara.java
│   │   │   ├── SORegisterPivara.java
│   │   │   └── SOUpdatePivara.java
│   │   ├── /pivo
│   │   │   ├── SOAddPivo.java
│   │   │   ├── SODeletePivo.java
│   │   │   ├── SOGetAllPivo.java
│   │   │   ├── SOGetAllPivoZaPivaru.java
│   │   │   └── SOUpdatePivo.java
│   │   └── /recenzija
│   │       ├── SOAddRecenzija.java
│   │       ├── SODeleteRecenzija.java
│   │       ├── SOGetAllRecenzija.java
│   │       ├── SOGetAllZaPivoRecenzija.java
│   │       ├── SOGetRecenzija.java
│   │       └── SOUpdateRecenzija.java
│   └── /thread
│       ├── ThreadClient.java
│       └── ThreadServer.java
│
├── /BeerReviewZajednicki
│   ├── /domain
│   │   ├── AbstractDomainObject.java
│   │   ├── Korisnik.java
│   │   ├── OmiljenoPivo.java
│   │   ├── Pivara.java
│   │   ├── Pivo.java
│   │   └── Recenzija.java
│   └── /transfer
│       ├── Request.java
│       ├── Response.java
│       └── /util
│           ├── Operation.java
│           └── ResponseStatus.java
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
