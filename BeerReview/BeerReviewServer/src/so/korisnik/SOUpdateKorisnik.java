package so.korisnik;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Korisnik;
import java.util.ArrayList;
import so.AbstractSO;

public class SOUpdateKorisnik extends AbstractSO {

    private Korisnik azuriraniKorisnik;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Korisnik)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Korisnik!");
        }

        Korisnik novi = (Korisnik) ado;

        if (novi.getKorisnikID() == null) {
            throw new Exception("Korisnik mora imati ID kako bi se izvršilo ažuriranje.");
        }

        // Provera da li postoji korisnik sa istim emailom ali različitim ID-jem
        ArrayList<Korisnik> sviKorisnici =
                (ArrayList<Korisnik>) (ArrayList<?>) DBBroker.getInstance().select(novi);

        for (Korisnik k : sviKorisnici) {
            if (k.getEmail().equalsIgnoreCase(novi.getEmail())
                    && !k.getKorisnikID().equals(novi.getKorisnikID())) {
                throw new Exception("Email adresa je već u upotrebi kod drugog korisnika.");
            }
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
        azuriraniKorisnik = (Korisnik) ado;
    }

    public Korisnik getKorisnik() {
        return azuriraniKorisnik;
    }
}
