package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;

public class Korisnik extends AbstractDomainObject {

    private Long korisnikID;
    private String ime;
    private String prezime;
    private String email;
    private String lozinka;
    private String telefon;
    private Date datumKreiranja;

    public Korisnik(Long korisnikID, String ime, String prezime, String email,
                    String lozinka, String telefon, Date datumKreiranja) {
        this.korisnikID = korisnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka = lozinka;
        this.telefon = telefon;
        this.datumKreiranja = datumKreiranja;
    }

    public Korisnik() {
    }

    @Override
    public String nazivTabele() {
        return "korisnik";  // naziv tabele tačno onako kako je u bazi, bez razmaka
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Korisnik k = new Korisnik(
                    rs.getLong("korisnikID"),
                    rs.getString("ime"),
                    rs.getString("prezime"),
                    rs.getString("email"),
                    rs.getString("lozinka"),
                    rs.getString("telefon"),
                    rs.getDate("datumKreiranja")
            );
            lista.add(k);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (ime, prezime, email, lozinka, telefon, datumKreiranja) ";
    }

    @Override
    public String uslov() {
        return " korisnikID = " + korisnikID;
    }

    @Override
    public String vrednostiZaInsert() {
        // korisnikID je AUTO_INCREMENT, ne ubacujemo ga eksplicitno u insert
        return "'" + ime + "', '" + prezime + "', '" + email + "', '" +
               lozinka + "', '" + telefon + "', '" + new java.sql.Date(datumKreiranja.getTime()) + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " ime = '" + ime + "', prezime = '" + prezime + "', email = '" + email + "', " +
               "lozinka = '" + lozinka + "', telefon = '" + telefon + "', datumKreiranja = '" + new java.sql.Date(datumKreiranja.getTime()) + "' ";
    }

    @Override
    public String uslovZaSelect() {
        return "";
    }

    // Getteri i setteri

    public Long getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(Long korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Korisnik other = (Korisnik) obj;
        return this.korisnikID != null && this.korisnikID.equals(other.korisnikID);
    }

    @Override
    public int hashCode() {
        return korisnikID != null ? korisnikID.hashCode() : 0;
    }
}
