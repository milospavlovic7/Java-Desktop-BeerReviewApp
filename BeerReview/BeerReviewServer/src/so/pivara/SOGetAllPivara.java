package so.pivara;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Pivara;
import java.util.ArrayList;
import so.AbstractSO;

public class SOGetAllPivara extends AbstractSO {

    private ArrayList<Pivara> listaPivara;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pivara)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Pivara!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        listaPivara = (ArrayList<Pivara>) (ArrayList<?>) DBBroker.getInstance().select(ado);
    }

    public ArrayList<Pivara> getLista() {
        return listaPivara;
    }
}
