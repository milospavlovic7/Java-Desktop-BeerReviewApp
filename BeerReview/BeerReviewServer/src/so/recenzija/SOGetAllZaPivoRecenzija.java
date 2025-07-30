package so.recenzija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Pivo;
import domain.Recenzija;
import java.util.ArrayList;
import so.AbstractSO;

public class SOGetAllZaPivoRecenzija extends AbstractSO {

    private ArrayList<Recenzija> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pivo)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Pivo!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        Pivo pivo = (Pivo) ado;

        Recenzija r = new Recenzija();
        r.setPivoID(pivo.getPivoID());
        r.setRecenzijaID(null); // sigurnosno
        r.setKorisnikID(null);

        // privremeno ovde filter u SQL
        r.setUslovSelect("WHERE pivoid = " + pivo.getPivoID()); // ako dodaš ovu metodu u Recenzija
        lista = (ArrayList<Recenzija>) (ArrayList<?>) DBBroker.getInstance().select(r);
    }

    public ArrayList<Recenzija> getLista() {
        return lista;
    }
}
