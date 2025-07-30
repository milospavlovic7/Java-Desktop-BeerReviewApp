package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Recenzija extends AbstractDomainObject {

    private Long recenzijaID;
    private Long korisnikID;
    private Long pivoID;
    private String sadrzaj;
    private int ocena;
    private Date datumKreiranja;
    private String uslovSelect = "";

    public Recenzija(Long recenzijaID, Long korisnikID, Long pivoID, String sadrzaj, int ocena, Date datumKreiranja) {
        this.recenzijaID = recenzijaID;
        this.korisnikID = korisnikID;
        this.pivoID = pivoID;
        this.sadrzaj = sadrzaj;
        this.ocena = ocena;
        this.datumKreiranja = datumKreiranja;
    }

    public Recenzija() {
    }

    @Override
    public String nazivTabele() {
        return "recenzija";
    }

    @Override
    public String alijas() {
        return "rec";
    }

    @Override
    public String join() {
        // Za sada nema join-ova
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Recenzija r = new Recenzija(
                rs.getLong("recenzijaid"),
                rs.getLong("korisnikid"),
                rs.getLong("pivoid"),
                rs.getString("sadrzaj"),
                rs.getInt("ocena"),
                rs.getDate("datumkreiranja") // koristi getDate za DATE tip
            );
            lista.add(r);
        }
        // Ne zatvaraj rs ovde, radi se van metode
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(korisnikid, pivoid, sadrzaj, ocena, datumkreiranja)";
    }

    @Override
    public String uslov() {
        return "recenzijaid = " + recenzijaID;
    }

    @Override
    public String vrednostiZaInsert() {
        // datumkreiranja mora da se ubaci jer nema DEFAULT u bazi ili ako ga ima možeš ga izostaviti
        // ako koristiš CURRENT_DATE kao default u bazi, možeš izostaviti datum ovde
        return korisnikID + ", " + pivoID + ", '" + sadrzaj + "', " + ocena + ", '" + new java.sql.Date(datumKreiranja.getTime()) + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        // Ovde dodaj uslov WHERE negde u servisu ili metodi koja poziva update
        return "korisnikid = " + korisnikID +
               ", pivoid = " + pivoID +
               ", sadrzaj = '" + sadrzaj + "'" +
               ", ocena = " + ocena +
               ", datumkreiranja = '" + new java.sql.Date(datumKreiranja.getTime()) + "'";
    }

    @Override
    public String uslovZaSelect() {
        return uslovSelect;
    }


    // Getteri i setteri

    public Long getRecenzijaID() {
        return recenzijaID;
    }

    public void setRecenzijaID(Long recenzijaID) {
        this.recenzijaID = recenzijaID;
    }

    public Long getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(Long korisnikID) {
        this.korisnikID = korisnikID;
    }

    public Long getPivoID() {
        return pivoID;
    }

    public void setPivoID(Long pivoID) {
        this.pivoID = pivoID;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public String getUslovSelect() {
        return uslovSelect;
    }

    public void setUslovSelect(String uslovSelect) {
        this.uslovSelect = uslovSelect;
    }

    @Override
    public String toString() {
        return "Recenzija ID: " + recenzijaID + ", Ocena: " + ocena + ", Sadržaj: " + sadrzaj;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Recenzija)) return false;
        Recenzija other = (Recenzija) obj;
        return recenzijaID != null && recenzijaID.equals(other.getRecenzijaID());
    }

    @Override
    public int hashCode() {
        return recenzijaID != null ? recenzijaID.hashCode() : 0;
    }
}
