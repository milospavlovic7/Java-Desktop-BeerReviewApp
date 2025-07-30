package so.korisnik;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Korisnik;
import java.util.ArrayList;
import so.AbstractSO;

public class SOLoginKorisnik extends AbstractSO {

    private Korisnik ulogovaniKorisnik;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Korisnik)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Korisnik!");
        }
        Korisnik korisnik = (Korisnik) ado;

        if (korisnik.getEmail() == null || korisnik.getEmail().isBlank()) {
            throw new Exception("Email je obavezan.");
        }
        if (korisnik.getLozinka() == null || korisnik.getLozinka().isBlank()) {
            throw new Exception("Lozinka je obavezna.");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        Korisnik k = (Korisnik) ado;

        System.out.println("Pokušaj logovanja sa: Email = '" + k.getEmail() + "', Lozinka = '" + k.getLozinka() + "'");

        ArrayList<Korisnik> korisnici = (ArrayList<Korisnik>) (ArrayList<?>) DBBroker.getInstance().select(k);

        System.out.println("Korisnici u bazi:");
        for (Korisnik korisnik : korisnici) {
            System.out.println(" - Email: '" + korisnik.getEmail() + "', Lozinka: '" + korisnik.getLozinka() + "'");

            if (korisnik.getEmail().equalsIgnoreCase(k.getEmail().trim()) &&
                korisnik.getLozinka().trim().equals(k.getLozinka().trim())) {
                this.ulogovaniKorisnik = korisnik;
                System.out.println("Korisnik uspešno pronađen i ulogovan.");
                return;
            }
        }

        System.out.println("Ne postoji korisnik sa tim kredencijalima.");
        throw new Exception("Ne postoji korisnik sa tim kredencijalima.");
    }



    public Korisnik getKorisnik() {
        return ulogovaniKorisnik;
    }
}
