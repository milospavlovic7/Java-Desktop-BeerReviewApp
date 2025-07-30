package so.pivara;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Pivara;
import java.util.ArrayList;
import so.AbstractSO;

public class SOLoginPivara extends AbstractSO {

    private Pivara ulogovanaPivara;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pivara)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Pivara!");
        }
        Pivara pivara = (Pivara) ado;

        if (pivara.getEmail() == null || pivara.getEmail().isBlank()) {
            throw new Exception("Email je obavezan.");
        }
        if (pivara.getLozinka() == null || pivara.getLozinka().isBlank()) {
            throw new Exception("Lozinka je obavezna.");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        Pivara p = (Pivara) ado;

        System.out.println("Pokušaj logovanja sa: Email = '" + p.getEmail() + "', Lozinka = '" + p.getLozinka() + "'");

        ArrayList<Pivara> pivare = (ArrayList<Pivara>) (ArrayList<?>) DBBroker.getInstance().select(p);

        System.out.println("Pivare u bazi:");
        for (Pivara pivara : pivare) {
            System.out.println(" - Email: '" + pivara.getEmail() + "', Lozinka: '" + pivara.getLozinka() + "'");

            if (pivara.getEmail().equalsIgnoreCase(p.getEmail().trim()) &&
                pivara.getLozinka().trim().equals(p.getLozinka().trim())) {
                this.ulogovanaPivara = pivara;
                System.out.println("Pivara uspešno pronađena i ulogovana.");
                return;
            }
        }

        System.out.println("Ne postoji pivara sa tim kredencijalima.");
        throw new Exception("Ne postoji pivara sa tim kredencijalima.");
    }

    public Pivara getPivara() {
        return ulogovanaPivara;
    }
}
