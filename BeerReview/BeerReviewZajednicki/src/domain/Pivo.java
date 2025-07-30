package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Pivo extends AbstractDomainObject {

    private Long pivoID;
    private Pivara pivara;
    private String naziv;
    private String opis;
    private Double cena;
    private Date datumDodavanja;

    public Pivo(Long pivoID, Pivara pivara, String naziv, String opis, Double cena, Date datumDodavanja) {
        this.pivoID = pivoID;
        this.pivara = pivara;
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
        this.datumDodavanja = datumDodavanja;
    }

    public Pivo() {
    }

    @Override
    public String nazivTabele() {
        return "pivo";
    }

    @Override
    public String alijas() {
        return "p";
    }

    @Override
    public String join() {
        return "JOIN pivara pv ON p.pivaraid = pv.pivaraid";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Pivara pivara = new Pivara();
            pivara.setPivaraID(rs.getLong("pivaraid"));  // bez prefiksa, mala slova
            pivara.setNaziv(rs.getString("naziv"));
            pivara.setEmail(rs.getString("email"));
            pivara.setLozinka(rs.getString("lozinka"));
            pivara.setTelefon(rs.getString("telefon"));
            pivara.setDatumKreiranja(rs.getDate("datumkreiranja"));

            Pivo pivo = new Pivo(
                rs.getLong("pivoid"),
                pivara,
                rs.getString("naziv"),
                rs.getString("opis"),
                rs.getDouble("cena"),
                rs.getDate("datumdodavanja")
            );
            lista.add(pivo);
        }
        // Ne zatvarati rs ovde!
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(pivaraid, naziv, opis, cena, datumdodavanja)";
    }

    @Override
    public String uslov() {
        return "pivoid = " + pivoID;
    }

    @Override
    public String vrednostiZaInsert() {
        return pivara.getPivaraID() + ", '" + naziv + "', '" + opis + "', " + cena + ", '" + new java.sql.Date(datumDodavanja.getTime()) + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "pivaraid = " + pivara.getPivaraID() +
               ", naziv = '" + naziv + "'" +
               ", opis = '" + opis + "'" +
               ", cena = " + cena +
               ", datumdodavanja = '" + new java.sql.Date(datumDodavanja.getTime()) + "'";
    }

    @Override
    public String uslovZaSelect() {
        return "";
    }

    // Getteri i setteri
    public Long getPivoID() {
        return pivoID;
    }

    public void setPivoID(Long pivoID) {
        this.pivoID = pivoID;
    }

    public Pivara getPivara() {
        return pivara;
    }

    public void setPivara(Pivara pivara) {
        this.pivara = pivara;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Date getDatumDodavanja() {
        return datumDodavanja;
    }

    public void setDatumDodavanja(Date datumDodavanja) {
        this.datumDodavanja = datumDodavanja;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pivo)) return false;
        Pivo other = (Pivo) obj;
        return pivoID != null && pivoID.equals(other.getPivoID());
    }

    @Override
    public int hashCode() {
        return pivoID != null ? pivoID.hashCode() : 0;
    }
}
