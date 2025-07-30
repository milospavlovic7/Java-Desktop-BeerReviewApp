package so.recenzija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Recenzija;
import so.AbstractSO;

public class SOUpdateRecenzija extends AbstractSO {

    private Recenzija recenzija;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Recenzija)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Recenzija!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        recenzija = (Recenzija) ado;
        DBBroker.getInstance().update(recenzija);
    }

    public Recenzija getRecenzija() {
        return recenzija;
    }
}
