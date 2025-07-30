package so.korisnik;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Korisnik;
import java.util.ArrayList;
import so.AbstractSO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SORegisterKorisnik extends AbstractSO {

    private Korisnik kreiraniKorisnik;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Korisnik)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Korisnik!");
        }

        Korisnik novi = (Korisnik) ado;

        // Provera da li već postoji korisnik sa istim emailom
        ArrayList<Korisnik> korisnici =
                (ArrayList<Korisnik>) (ArrayList<?>) DBBroker.getInstance().select(novi);

        for (Korisnik k : korisnici) {
            if (k.getEmail().equalsIgnoreCase(novi.getEmail())) {
                throw new Exception("Korisnik sa datim emailom već postoji.");
            }
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        PreparedStatement ps = DBBroker.getInstance().insert(ado);

        // Dobijanje generisanog ključa (ID-a)
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            Long generatedId = rs.getLong(1);
            Korisnik korisnik = (Korisnik) ado;
            korisnik.setKorisnikID(generatedId);
            kreiraniKorisnik = korisnik;
        } else {
            throw new Exception("Neuspešno kreiranje korisnika, ID nije vraćen.");
        }
        rs.close();
        ps.close();
    }

    public Korisnik getKorisnik() {
        return kreiraniKorisnik;
    }
}
