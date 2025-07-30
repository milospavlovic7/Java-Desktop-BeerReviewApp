package so.pivo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Pivara;
import domain.Pivo;
import java.util.ArrayList;

/**
 * Sistem operacija za vraćanje svih piva za određenu pivaru.
 */
public class SOGetAllPivoZaPivaru {

    private ArrayList<Pivo> lista;

    public void templateExecute(Pivara pivara) {
        try {
            // Anonimna klasa Pivo da bi se promenio uslov za SELECT
            AbstractDomainObject pivoZaSelect = new Pivo() {
                @Override
                public String uslovZaSelect() {
                    return "WHERE p.pivaraid = " + pivara.getPivaraID();
                }
            };

            lista = (ArrayList<Pivo>) (ArrayList<?>) DBBroker.getInstance().select(pivoZaSelect);

        } catch (Exception ex) {
            ex.printStackTrace();
            lista = new ArrayList<>();
        }
    }

    public ArrayList<Pivo> getLista() {
        return lista;
    }
}
