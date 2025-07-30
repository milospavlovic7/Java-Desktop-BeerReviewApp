package so.pivara;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Pivara;
import java.util.ArrayList;
import so.AbstractSO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SORegisterPivara extends AbstractSO {

    private Pivara kreiranaPivara;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pivara)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Pivara!");
        }

        Pivara nova = (Pivara) ado;

        // Provera da li već postoji pivara sa istim emailom
        ArrayList<Pivara> pivare =
                (ArrayList<Pivara>) (ArrayList<?>) DBBroker.getInstance().select(nova);

        for (Pivara p : pivare) {
            if (p.getEmail().equalsIgnoreCase(nova.getEmail())) {
                throw new Exception("Pivara sa datim emailom već postoji.");
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
            Pivara pivara = (Pivara) ado;
            pivara.setPivaraID(generatedId);
            kreiranaPivara = pivara;
        } else {
            throw new Exception("Neuspešno kreiranje pivare, ID nije vraćen.");
        }
        rs.close();
        ps.close();
    }

    public Pivara getPivara() {
        return kreiranaPivara;
    }
}
