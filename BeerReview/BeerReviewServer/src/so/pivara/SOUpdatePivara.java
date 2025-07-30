package so.pivara;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Pivara;
import java.util.ArrayList;
import so.AbstractSO;

public class SOUpdatePivara extends AbstractSO {

    private Pivara azuriranaPivara;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pivara)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Pivara!");
        }

        Pivara nova = (Pivara) ado;

        if (nova.getPivaraID() == null) {
            throw new Exception("Pivara mora imati ID kako bi se izvršilo ažuriranje.");
        }

        // Provera da li postoji pivara sa istim nazivom ali različitim ID-jem
        ArrayList<Pivara> svePivare =
                (ArrayList<Pivara>) (ArrayList<?>) DBBroker.getInstance().select(nova);

        for (Pivara p : svePivare) {
            if (p.getNaziv().equalsIgnoreCase(nova.getNaziv())
                    && !p.getPivaraID().equals(nova.getPivaraID())) {
                throw new Exception("Naziv pivare je već u upotrebi kod druge pivare.");
            }
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
        azuriranaPivara = (Pivara) ado;
    }

    public Pivara getPivara() {
        return azuriranaPivara;
    }
}
