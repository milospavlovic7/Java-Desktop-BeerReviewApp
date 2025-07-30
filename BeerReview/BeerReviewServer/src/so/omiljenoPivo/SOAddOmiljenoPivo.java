package so.omiljenoPivo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.OmiljenoPivo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import so.AbstractSO;

public class SOAddOmiljenoPivo extends AbstractSO {

    private OmiljenoPivo omiljenoPivo;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof OmiljenoPivo)) {
            throw new Exception("Prosleđeni objekat nije instanca klase OmiljenoPivo!");
        }

        OmiljenoPivo op = (OmiljenoPivo) ado;

        // Proveri da li već postoji ta veza
        ArrayList<OmiljenoPivo> lista = (ArrayList<OmiljenoPivo>) (ArrayList<?>) DBBroker.getInstance().select(op);
        for (OmiljenoPivo postojeci : lista) {
            if (postojeci.getKorisnikID().equals(op.getKorisnikID()) &&
                postojeci.getPivoID().equals(op.getPivoID())) {
                throw new Exception("Ovo pivo je već dodato u omiljena za korisnika!");
            }
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        OmiljenoPivo op = (OmiljenoPivo) ado;

        // Dodaj trenutni datum i vreme
        op.setDatumDodavanja(new Date());

        PreparedStatement ps = DBBroker.getInstance().insert(op);
        ResultSet rs = ps.getGeneratedKeys();

        omiljenoPivo = op;
    }

    public OmiljenoPivo getOmiljenoPivo() {
        return omiljenoPivo;
    }
}
