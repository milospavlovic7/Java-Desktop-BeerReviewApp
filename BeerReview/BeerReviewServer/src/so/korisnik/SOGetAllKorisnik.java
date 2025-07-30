/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.korisnik;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Korisnik;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author milos
 */
public class SOGetAllKorisnik extends AbstractSO{

    private ArrayList<Korisnik> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Korisnik)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Korisnik!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        lista = (ArrayList<Korisnik>) (ArrayList<?>) DBBroker.getInstance().select(ado);
    }

    public ArrayList<Korisnik> getLista() {
        return lista;
    }
    
}
