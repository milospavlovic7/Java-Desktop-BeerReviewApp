# 🍺 Java Desktop BeerReviewApp

**Java Desktop BeerReviewApp** je desktop aplikacija za ocenjivanje i recenziju piva. Aplikacija koristi Swing GUI, klijent-server arhitekturu preko Java soketa, MySQL bazu podataka i MVC obrazac. Omogućava interakciju dva tipa korisnika – **Korisnik** i **Pivara** – kroz intuitivan korisnički interfejs.

---

## 🧩 Ključne funkcionalnosti

- ✅ **Registracija i prijava** za oba tipa korisnika (korisnik i pivara)
- 🧾 **Korisnici** mogu:
  - Dodavati recenzije i ocene piva
  - Pretraživati piva i pivare
  - Pratiti omiljena piva
  - Uređivati svoj profil
- 🏭 **Pivare** mogu:
  - Dodavati nova piva
  - Pratiti i moderirati recenzije svojih piva
  - Uređivati informacije o pivari
- 🔗 Klijent-server komunikacija putem **Java soketa**
- 🗃 Povezanost sa **MySQL** bazom podataka
- 🧠 Organizacija koda po **MVC arhitekturi**

---

## 🛠 Tehnologije

- **Java SE**
- **Java Swing** (GUI)
- **Socket Programming** (TCP/IP)
- **MySQL**
- **NetBeans IDE**
- **MVC (Model-View-Controller)** obrazac

---

## 📁 Struktura projekta

Recenzije Piva Projekat/
│
├── klijent/ # GUI aplikacija koju koriste korisnici i pivare
├── server/ # Server koji obradi zahteve i komunicira sa bazom
├── zajednicki/ # Deljeni modeli i klase (DTO, entiteti, itd.)
└── README.md

yaml
Copy
Edit

---

## 🧪 Pokretanje aplikacije (lokalno)

1. **Kloniraj repozitorijum:**
   ```bash
   git clone https://github.com/milospavlovic7/Java-Desktop-BeerReviewApp.git
Importuj SQL bazu:
U MySQL Workbench/phpMyAdmin importuj priloženi .sql fajl (ako postoji).

Pokreni server:

Otvori server projekat u NetBeans-u i pokreni glavnu klasu (Main)

Pokreni klijentsku aplikaciju:

Otvori klijent projekat i pokreni glavnu klasu (Main)

Kreiraj korisničke naloge i testiraj aplikaciju
