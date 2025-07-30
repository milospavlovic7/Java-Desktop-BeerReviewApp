package so.omiljenoPivo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.OmiljenoPivo;
import java.util.ArrayList;

/**
 * Vraća sva omiljena piva za korisnika.
 */
public class SOGetAllOmiljenoPivoZaKorisnika {

    private ArrayList<OmiljenoPivo> lista;

    public void templateExecute(OmiljenoPivo omiljenoPivo) {
        try {
            AbstractDomainObject ado = new OmiljenoPivo() {
                @Override
                public String uslovZaSelect() {
                    return "WHERE korisnikid = " + omiljenoPivo.getKorisnikID();
                }
            };

            lista = (ArrayList<OmiljenoPivo>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        } catch (Exception ex) {
            ex.printStackTrace();
            lista = new ArrayList<>();
        }
    }

    public ArrayList<OmiljenoPivo> getLista() {
        return lista;
    }
}
