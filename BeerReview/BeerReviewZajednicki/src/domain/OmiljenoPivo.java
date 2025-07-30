package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class OmiljenoPivo extends AbstractDomainObject {

    private Long korisnikID;
    private Long pivoID;
    private Date datumDodavanja;

    public OmiljenoPivo(Long korisnikID, Long pivoID, Date datumDodavanja) {
        this.korisnikID = korisnikID;
        this.pivoID = pivoID;
        this.datumDodavanja = datumDodavanja;
    }

    public OmiljenoPivo() {
    }

    @Override
    public String nazivTabele() {
        return "omiljenopivo";
    }

    @Override
    public String alijas() {
        return "op";
    }

    @Override
    public String join() {
        return ""; // Nema joinova za sada
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            OmiljenoPivo op = new OmiljenoPivo(
                rs.getLong("korisnikid"),
                rs.getLong("pivoid"),
                rs.getTimestamp("datumdodavanja") != null ? new Date(rs.getTimestamp("datumdodavanja").getTime()) : null
            );
            lista.add(op);
        }
        // Ne zatvarati rs ovde
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(korisnikid, pivoid, datumdodavanja)";
    }

    @Override
    public String uslov() {
        return "korisnikid = " + korisnikID + " AND pivoid = " + pivoID;
    }

    @Override
    public String vrednostiZaInsert() {
        // formatiraj datum u 'yyyy-MM-dd HH:mm:ss' za MySQL timestamp
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datumStr = datumDodavanja != null ? "'" + sdf.format(datumDodavanja) + "'" : "NULL";

        return korisnikID + ", " + pivoID + ", " + datumStr;
    }

    @Override
    public String vrednostiZaUpdate() {
        // Ne menjamo ništa jer su ključevi, i datum se ne menja
        return "";
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

    public Long getPivoID() {
        return pivoID;
    }

    public void setPivoID(Long pivoID) {
        this.pivoID = pivoID;
    }

    public Date getDatumDodavanja() {
        return datumDodavanja;
    }

    public void setDatumDodavanja(Date datumDodavanja) {
        this.datumDodavanja = datumDodavanja;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof OmiljenoPivo)) return false;
        OmiljenoPivo other = (OmiljenoPivo) obj;
        return korisnikID != null && pivoID != null &&
               korisnikID.equals(other.getKorisnikID()) &&
               pivoID.equals(other.getPivoID());
    }

    @Override
    public int hashCode() {
        int result = korisnikID != null ? korisnikID.hashCode() : 0;
        result = 31 * result + (pivoID != null ? pivoID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OmiljenoPivo [korisnikID=" + korisnikID + ", pivoID=" + pivoID + "]";
    }
}
