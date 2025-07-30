package so.pivara;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Pivara;
import so.AbstractSO;

public class SODeletePivara extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pivara)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Pivara!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }
}
