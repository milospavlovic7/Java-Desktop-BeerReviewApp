/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.pivo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Pivo;
import so.AbstractSO;

/**
 *
 * @author milos
 */
public class SOUpdatePivo extends AbstractSO {

    private Pivo azuriranoPivo;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pivo)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Pivo!");
        }

        Pivo pivo = (Pivo) ado;

        if (pivo.getPivoID() == null) {
            throw new Exception("Pivo mora imati ID kako bi se izvršilo ažuriranje.");
        }

        if (pivo.getNaziv() == null || pivo.getNaziv().isBlank()) {
            throw new Exception("Naziv piva ne sme biti prazan.");
        }

        if (pivo.getCena() == null || pivo.getCena() <= 0) {
            throw new Exception("Cena mora biti veća od 0.");
        }

        if (pivo.getOpis() == null || pivo.getOpis().isBlank()) {
            throw new Exception("Opis ne sme biti prazan.");
        }

        if (pivo.getPivara() == null || pivo.getPivara().getPivaraID() == null) {
            throw new Exception("Pivo mora imati validnu pivaru.");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
        azuriranoPivo = (Pivo) ado;
    }

    public Pivo getPivo() {
        return azuriranoPivo;
    }
}
