package so.omiljenoPivo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.OmiljenoPivo;
import so.AbstractSO;

public class SODeleteOmiljenoPivo extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof OmiljenoPivo)) {
            throw new Exception("Prosleđeni objekat nije instanca klase OmiljenoPivo!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }
}
