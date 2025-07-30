package controller;

import domain.*;
import so.korisnik.*;
import so.pivara.*;
import so.pivo.*;
import so.recenzija.*;
import so.omiljenoPivo.*;

import java.util.ArrayList;

public class ServerController {

    private static ServerController instance;

    private ServerController() {}

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    // Korisnik
    public Korisnik loginKorisnik(Korisnik korisnik) throws Exception {
        SOLoginKorisnik so = new SOLoginKorisnik();
        so.templateExecute(korisnik);
        return so.getKorisnik();
    }

    public Korisnik registerKorisnik(Korisnik korisnik) throws Exception {
        SORegisterKorisnik so = new SORegisterKorisnik();
        so.templateExecute(korisnik);
        return so.getKorisnik();
    }

    public Korisnik updateKorisnik(Korisnik korisnik) throws Exception {
        SOUpdateKorisnik so = new SOUpdateKorisnik();
        so.templateExecute(korisnik);
        return so.getKorisnik();
    }

    public void deleteKorisnik(Korisnik korisnik) throws Exception {
        new SODeleteKorisnik().templateExecute(korisnik);
    }

    public ArrayList<Korisnik> getAllKorisnik() throws Exception {
        SOGetAllKorisnik so = new SOGetAllKorisnik();
        so.templateExecute(new Korisnik());
        return so.getLista();
    }

    // Pivara
    public Pivara loginPivara(Pivara pivara) throws Exception {
        SOLoginPivara so = new SOLoginPivara();
        so.templateExecute(pivara);
        return so.getPivara();
    }

    public Pivara registerPivara(Pivara pivara) throws Exception {
        SORegisterPivara so = new SORegisterPivara();
        so.templateExecute(pivara);
        return so.getPivara();
    }

    public Pivara updatePivara(Pivara pivara) throws Exception {
        SOUpdatePivara so = new SOUpdatePivara();
        so.templateExecute(pivara);
        return so.getPivara();
    }

    public void deletePivara(Pivara pivara) throws Exception {
        new SODeletePivara().templateExecute(pivara);
    }

    public ArrayList<Pivara> getAllPivara() throws Exception {
        SOGetAllPivara so = new SOGetAllPivara();
        so.templateExecute(new Pivara());
        return so.getLista();
    }

    // Pivo
    public Pivo addPivo(Pivo pivo) throws Exception {
        SOAddPivo so = new SOAddPivo();
        so.templateExecute(pivo);
        return so.getPivo();
    }

    public Pivo updatePivo(Pivo pivo) throws Exception {
        SOUpdatePivo so = new SOUpdatePivo();
        so.templateExecute(pivo);
        return so.getPivo();
    }

    public void deletePivo(Pivo pivo) throws Exception {
        new SODeletePivo().templateExecute(pivo);
    }
    
    public ArrayList<Pivo> getAllPivoZaPivaru(Pivara pivara) throws Exception {
        SOGetAllPivoZaPivaru so = new SOGetAllPivoZaPivaru();
        so.templateExecute(pivara);
        return so.getLista();
    }

    public ArrayList<Pivo> getAllPivo() throws Exception {
        SOGetAllPivo so = new SOGetAllPivo();
        so.templateExecute(new Pivo());
        return so.getListaPiva();
    }

    // Recenzija
    public Recenzija addRecenzija(Recenzija recenzija) throws Exception {
        SOAddRecenzija so = new SOAddRecenzija();
        so.templateExecute(recenzija);
        return so.getRecenzija();
    }

    public Recenzija updateRecenzija(Recenzija recenzija) throws Exception {
        SOUpdateRecenzija so = new SOUpdateRecenzija();
        so.templateExecute(recenzija);
        return so.getRecenzija();
    }

    public void deleteRecenzija(Recenzija recenzija) throws Exception {
        new SODeleteRecenzija().templateExecute(recenzija);
    }

    public Recenzija getRecenzija(Recenzija recenzija) throws Exception {
        SOGetRecenzija so = new SOGetRecenzija();
        so.templateExecute(recenzija);
        return so.getRecenzija();
    }
    
    public ArrayList<Recenzija> getAllRecenzija() throws Exception {
        SOGetAllRecenzija so = new SOGetAllRecenzija();
        so.templateExecute(new Recenzija()); // prazan objekat, bez filtera
        return so.getLista();
    }

    public ArrayList<Recenzija> getAllZaPivoRecenzija(Pivo pivo) throws Exception {
        SOGetAllZaPivoRecenzija so = new SOGetAllZaPivoRecenzija();
        so.templateExecute(pivo);
        return so.getLista();
    }

    // Omiljeno pivo
    public OmiljenoPivo addOmiljenoPivo(OmiljenoPivo omiljenoPivo) throws Exception {
        SOAddOmiljenoPivo so = new SOAddOmiljenoPivo();
        so.templateExecute(omiljenoPivo);
        return so.getOmiljenoPivo(); // Pretpostavljamo da setuje unutar `SO`
    }

    public void deleteOmiljenoPivo(OmiljenoPivo omiljenoPivo) throws Exception {
        new SODeleteOmiljenoPivo().templateExecute(omiljenoPivo);
    }

    public ArrayList<OmiljenoPivo> getAllOmiljenoPivoZaKorisnika(OmiljenoPivo omiljenoPivo) throws Exception {
        SOGetAllOmiljenoPivoZaKorisnika so = new SOGetAllOmiljenoPivoZaKorisnika();
        so.templateExecute(omiljenoPivo);
        return so.getLista();
    }
}
