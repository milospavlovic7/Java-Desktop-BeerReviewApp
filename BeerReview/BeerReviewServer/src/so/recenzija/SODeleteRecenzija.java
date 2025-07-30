package so.recenzija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Recenzija;
import so.AbstractSO;

public class SODeleteRecenzija extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Recenzija)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Recenzija!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }
}
