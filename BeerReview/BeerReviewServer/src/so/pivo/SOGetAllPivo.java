package so.pivo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Pivo;
import java.util.ArrayList;
import so.AbstractSO;

public class SOGetAllPivo extends AbstractSO {

    private ArrayList<Pivo> listaPiva;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pivo)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Pivo!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        listaPiva = (ArrayList<Pivo>) (ArrayList<?>) DBBroker.getInstance().select(ado);
    }

    public ArrayList<Pivo> getListaPiva() {
        return listaPiva;
    }
}
