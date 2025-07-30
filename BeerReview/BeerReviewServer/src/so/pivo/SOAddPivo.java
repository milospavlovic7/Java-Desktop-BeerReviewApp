package so.pivo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Pivo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author milos
 */
public class SOAddPivo extends AbstractSO {

    private Pivo novoPivo;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pivo)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Pivo!");
        }

        Pivo p = (Pivo) ado;

        if (p.getNaziv() == null || p.getNaziv().isEmpty()) {
            throw new Exception("Naziv piva mora biti unet!");
        }

        if (p.getOpis() == null || p.getOpis().isEmpty()) {
            throw new Exception("Opis piva mora biti unet!");
        }

        if (p.getCena() == null || p.getCena() <= 0) {
            throw new Exception("Cena piva mora biti veća od 0!");
        }

        if (p.getDatumDodavanja() == null) {
            throw new Exception("Datum dodavanja mora biti unet!");
        }

        ArrayList<Pivo> piva = (ArrayList<Pivo>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Pivo postojeci : piva) {
            if (postojeci.getNaziv().equalsIgnoreCase(p.getNaziv()) &&
                postojeci.getPivara().getPivaraID().equals(p.getPivara().getPivaraID())) {
                throw new Exception("Pivo sa tim nazivom već postoji za tu pivaru!");
            }
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        PreparedStatement ps = DBBroker.getInstance().insert(ado);
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            Long generatedId = rs.getLong(1);
            ((Pivo) ado).setPivoID(generatedId);
        }
        novoPivo = (Pivo) ado;
    }

    public Pivo getPivo() {
        return novoPivo;
    }
}
