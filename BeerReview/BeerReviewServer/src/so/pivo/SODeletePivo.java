package so.pivo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Pivo;
import so.AbstractSO;

public class SODeletePivo extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pivo)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Pivo!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }
}
