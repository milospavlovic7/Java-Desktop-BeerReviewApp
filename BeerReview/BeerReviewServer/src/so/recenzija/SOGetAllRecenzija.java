package so.recenzija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Recenzija;
import java.util.ArrayList;
import so.AbstractSO;

public class SOGetAllRecenzija extends AbstractSO {

    private ArrayList<Recenzija> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Recenzija)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Recenzija!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        lista = (ArrayList<Recenzija>) (ArrayList<?>) DBBroker.getInstance().select(ado);
    }

    public ArrayList<Recenzija> getLista() {
        return lista;
    }
}
