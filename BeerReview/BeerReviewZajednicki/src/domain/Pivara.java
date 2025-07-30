package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Pivara extends AbstractDomainObject {

    private Long pivaraID;
    private String naziv;
    private String email;
    private String lozinka;
    private String telefon;
    private Date datumKreiranja;

    public Pivara(Long pivaraID, String naziv, String email, String lozinka, String telefon, Date datumKreiranja) {
        this.pivaraID = pivaraID;
        this.naziv = naziv;
        this.email = email;
        this.lozinka = lozinka;
        this.telefon = telefon;
        this.datumKreiranja = datumKreiranja;
    }

    public Pivara() {
    }

    @Override
    public String nazivTabele() {
        return "pivara";
    }

    @Override
    public String alijas() {
        return "p";
    }

    @Override
    public String join() {
        return ""; // Nema JOIN-a
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Pivara p = new Pivara(
                rs.getLong("pivaraid"),
                rs.getString("naziv"),
                rs.getString("email"),
                rs.getString("lozinka"),
                rs.getString("telefon"),
                rs.getDate("datumkreiranja")
            );
            lista.add(p);
        }
        // Ne zatvarati rs ovde, radi to pozivač metode
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(naziv, email, lozinka, telefon, datumkreiranja)";
    }

    @Override
    public String uslov() {
        return "pivaraid = " + pivaraID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + naziv + "', '" + email + "', '" + lozinka + "', '" + telefon + "', '" + new java.sql.Date(datumKreiranja.getTime()) + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "naziv = '" + naziv + "', email = '" + email + "', lozinka = '" + lozinka + "', telefon = '" + telefon + "', datumkreiranja = '" + new java.sql.Date(datumKreiranja.getTime()) + "'";
    }

    @Override
    public String uslovZaSelect() {
        return "";
    }

    // Getteri i setteri
    public Long getPivaraID() {
        return pivaraID;
    }

    public void setPivaraID(Long pivaraID) {
        this.pivaraID = pivaraID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
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
        return naziv;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pivara)) return false;
        Pivara other = (Pivara) obj;
        return pivaraID != null && pivaraID.equals(other.getPivaraID());
    }

    @Override
    public int hashCode() {
        return pivaraID != null ? pivaraID.hashCode() : 0;
    }
}
