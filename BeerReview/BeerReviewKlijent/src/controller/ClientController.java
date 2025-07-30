package controller;

import domain.*;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ClientController {

    private static ClientController instance;
    private AbstractDomainObject ulogovani;

    private ClientController() {}

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    // --- KORISNIK ---
    public Korisnik loginKorisnik(Korisnik korisnik) throws Exception {
        return (Korisnik) sendRequest(Operation.LOGIN_KORISNIK, korisnik);
    }

    public Korisnik registerKorisnik(Korisnik korisnik) throws Exception {
        return (Korisnik) sendRequest(Operation.REGISTER_KORISNIK, korisnik);
    }

    public Korisnik updateKorisnik(Korisnik korisnik) throws Exception {
        return (Korisnik) sendRequest(Operation.UPDATE_KORISNIK, korisnik);
    }

    public void deleteKorisnik(Korisnik korisnik) throws Exception {
        sendRequest(Operation.DELETE_KORISNIK, korisnik);
    }

    public ArrayList<Korisnik> getAllKorisnik() throws Exception {
        return (ArrayList<Korisnik>) sendRequest(Operation.GET_ALL_KORISNIK, null);
    }

    // --- PIVARA ---
    public Pivara loginPivara(Pivara pivara) throws Exception {
        return (Pivara) sendRequest(Operation.LOGIN_PIVARA, pivara);
    }

    public Pivara registerPivara(Pivara pivara) throws Exception {
        return (Pivara) sendRequest(Operation.REGISTER_PIVARA, pivara);
    }

    public Pivara updatePivara(Pivara pivara) throws Exception {
        return (Pivara) sendRequest(Operation.UPDATE_PIVARA, pivara);
    }

    public void deletePivara(Pivara pivara) throws Exception {
        sendRequest(Operation.DELETE_PIVARA, pivara);
    }

    public ArrayList<Pivara> getAllPivara() throws Exception {
        return (ArrayList<Pivara>) sendRequest(Operation.GET_ALL_PIVARA, null);
    }

    // --- PIVO ---
    public Pivo addPivo(Pivo pivo) throws Exception {
        return (Pivo) sendRequest(Operation.ADD_PIVO, pivo);
    }

    public Pivo updatePivo(Pivo pivo) throws Exception {
        return (Pivo) sendRequest(Operation.UPDATE_PIVO, pivo);
    }

    public void deletePivo(Pivo pivo) throws Exception {
        sendRequest(Operation.DELETE_PIVO, pivo);
    }
    
    public ArrayList<Pivo> getAllPivoZaPivaru(Pivara pivara) throws Exception {
        return (ArrayList<Pivo>) sendRequest(Operation.GET_ALL_PIVO_ZA_PIVARU, pivara);
    }

    public ArrayList<Pivo> getAllPivo() throws Exception {
        return (ArrayList<Pivo>) sendRequest(Operation.GET_ALL_PIVO, null);
    }

    // --- RECENZIJA ---
    public Recenzija addRecenzija(Recenzija recenzija) throws Exception {
        return (Recenzija) sendRequest(Operation.ADD_RECENZIJA, recenzija);
    }

    public Recenzija updateRecenzija(Recenzija recenzija) throws Exception {
        return (Recenzija) sendRequest(Operation.UPDATE_RECENZIJA, recenzija);
    }

    public void deleteRecenzija(Recenzija recenzija) throws Exception {
        sendRequest(Operation.DELETE_RECENZIJA, recenzija);
    }
    
    public ArrayList<Recenzija> getAllRecenzija() throws Exception {
        return (ArrayList<Recenzija>) sendRequest(Operation.GET_ALL_RECENZIJA, null);
    }

    public ArrayList<Recenzija> getRecenzijeZaPivo(Pivo pivo) throws Exception {
        return (ArrayList<Recenzija>) sendRequest(Operation.GET_RECENZIJE_ZA_PIVO, pivo);
    }

    // --- OMILJENO PIVO ---
    public OmiljenoPivo addOmiljenoPivo(OmiljenoPivo omiljenoPivo) throws Exception {
        return (OmiljenoPivo) sendRequest(Operation.ADD_OMILJENO_PIVO, omiljenoPivo);
    }

    public void deleteOmiljenoPivo(OmiljenoPivo omiljenoPivo) throws Exception {
        sendRequest(Operation.DELETE_OMILJENO_PIVO, omiljenoPivo);
    }

    public ArrayList<OmiljenoPivo> getAllOmiljenoPivoZaKorisnika(OmiljenoPivo omiljenoPivo) throws Exception {
        return (ArrayList<OmiljenoPivo>) sendRequest(Operation.GET_ALL_OMILJENO_PIVO_ZA_KORISNIKA, omiljenoPivo);
    }

    // --- UTILITY ---
    private Object sendRequest(int operation, Object data) throws Exception {
        Request request = new Request(operation, data);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(request);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response response = (Response) in.readObject();

        if (response.getResponseStatus().equals(ResponseStatus.ERROR)) {
            throw response.getException();
        } else {
            return response.getData();
        }
    }

    public void setUlogovani(AbstractDomainObject ulogovani) {
        this.ulogovani = ulogovani;
    }

    public AbstractDomainObject getUlogovani() {
        return ulogovani;
    }
}
