package service;

import controller.ClientController;
import domain.*;
import forms.korisnik.*;

import java.util.ArrayList;
import java.util.Date;

public class KorisnikService {
    private static KorisnikService instance;

    private Korisnik ulogovaniKorisnik;
    private Pivara selektovanaPivara;
    private Pivo selektovanoPivo;
    private Recenzija selektovanaRecenzija;

    private ArrayList<Pivara> svePivare = new ArrayList<>();
    private ArrayList<Pivo> svaPiva = new ArrayList<>();
    private ArrayList<OmiljenoPivo> omiljenaPiva = new ArrayList<>();
    private ArrayList<Korisnik> sviKorisnici = new ArrayList<>();
    private ArrayList<Recenzija> sveRecenzije = new ArrayList<>();

    private KorisnikMainForm mainForm;
    private PanelNalogKorisnik panelNalogKorisnik;
    private PanelPretraga panelPretraga;
    private PanelRecenzije panelRecenzije;

    private KorisnikService() {}

    public static KorisnikService getInstance() {
        if (instance == null) {
            instance = new KorisnikService();
        }
        return instance;
    }

    public void inicijalnoUcitavanje() throws Exception {
        svePivare = ClientController.getInstance().getAllPivara();
        svaPiva = ClientController.getInstance().getAllPivo();
        sveRecenzije = ClientController.getInstance().getAllRecenzija();
        sviKorisnici = ClientController.getInstance().getAllKorisnik();

        if (!svePivare.isEmpty()) selektovanaPivara = svePivare.get(0);

        ArrayList<Pivo> pivaZaPivaru = getPivaZaPivaru(selektovanaPivara);
        if (!pivaZaPivaru.isEmpty()) selektovanoPivo = pivaZaPivaru.get(0);
    }
    
    public void osveziDugme() throws Exception{
        inicijalnoUcitavanje();
        panelRecenzije.inicijalizacija();
    }

    public void registerKorisnik(String ime, String prezime, String telefon, String email, String password, String confirmPassword) throws Exception {
        if (!password.equals(confirmPassword) || password.length() < 2) {
            throw new Exception("Lozinke se ne poklapaju ili su premale.");
        }
        Korisnik korisnik = new Korisnik(null, ime, prezime, email, password, telefon, new Date());
        ulogovaniKorisnik = ClientController.getInstance().registerKorisnik(korisnik);
    }

    public void loginKorisnik(String email, String lozinka) throws Exception {
        Korisnik korisnik = new Korisnik();
        korisnik.setEmail(email);
        korisnik.setLozinka(lozinka);
        ulogovaniKorisnik = ClientController.getInstance().loginKorisnik(korisnik);
    }

    public Korisnik updateKorisnik(String ime, String prezime, String telefon, String email, String oldPassword, String newPassword) throws Exception {
        if (!ulogovaniKorisnik.getLozinka().equals(oldPassword)) {
            throw new Exception("Stara lozinka nije ispravna.");
        }
        Korisnik updated = new Korisnik(
            ulogovaniKorisnik.getKorisnikID(), ime, prezime, email, newPassword, telefon, ulogovaniKorisnik.getDatumKreiranja()
        );
        ulogovaniKorisnik = ClientController.getInstance().updateKorisnik(updated);
        return ulogovaniKorisnik;
    }

    public void deleteKorisnik() throws Exception {
        ClientController.getInstance().deleteKorisnik(ulogovaniKorisnik);
        ulogovaniKorisnik = null;
    }

    public void ucitajOmiljenaPiva() throws Exception {
        OmiljenoPivo omiljenoPivo = new OmiljenoPivo();
        omiljenoPivo.setKorisnikID(ulogovaniKorisnik.getKorisnikID());
        omiljenaPiva = ClientController.getInstance().getAllOmiljenoPivoZaKorisnika(omiljenoPivo);
    }

    public boolean jePivoOmiljeno(Pivo pivo) {
        return omiljenaPiva.stream().anyMatch(op -> op.getPivoID().equals(pivo.getPivoID()));
    }

    public void dodajUOmiljena(Pivo pivo) throws Exception {
        OmiljenoPivo omiljenoPivo = new OmiljenoPivo();
        omiljenoPivo.setKorisnikID(ulogovaniKorisnik.getKorisnikID());
        omiljenoPivo.setPivoID(selektovanoPivo.getPivoID());
        OmiljenoPivo novo = ClientController.getInstance().addOmiljenoPivo(omiljenoPivo);
        omiljenaPiva.add(novo);
    }

    public void ukloniIzOmiljenih(Pivo pivo) throws Exception {
        OmiljenoPivo omiljenoPivo = new OmiljenoPivo();
        omiljenoPivo.setKorisnikID(ulogovaniKorisnik.getKorisnikID());
        omiljenoPivo.setPivoID(selektovanoPivo.getPivoID());
        ClientController.getInstance().deleteOmiljenoPivo(omiljenoPivo);
        omiljenaPiva.removeIf(op -> op.getPivoID().equals(pivo.getPivoID()));
    }

    public void addRecenzija(Recenzija recenzija) throws Exception {
        sveRecenzije.add(ClientController.getInstance().addRecenzija(recenzija));
    }
    
    public void deleteRecenzija(Recenzija recenzija) throws Exception {
        ClientController.getInstance().deleteRecenzija(recenzija);
        sveRecenzije.removeIf(r -> r.getRecenzijaID().equals(recenzija.getRecenzijaID()));
    }

    public ArrayList<Pivo> getPivaZaPivaru(Pivara pivara) {
        ArrayList<Pivo> rezultat = new ArrayList<>();
        for (Pivo pivo : svaPiva) {
            if (pivo.getPivara().equals(pivara)) rezultat.add(pivo);
        }
        return rezultat;
    }

    public ArrayList<Recenzija> getRecenzijeZaSelektovanoPivo() {
        ArrayList<Recenzija> rezultat = new ArrayList<>();
        for (Recenzija r : sveRecenzije) {
            if (r.getPivoID().equals(selektovanoPivo.getPivoID())) rezultat.add(r);
        }
        return rezultat;
    }

    public String getProsecnaOcenaZaSelektovanoPivo() {
        ArrayList<Recenzija> recenzije = getRecenzijeZaSelektovanoPivo();
        if (selektovanoPivo == null || recenzije.isEmpty()) return "/";

        double suma = 0;
        for (Recenzija r : recenzije) suma += r.getOcena();

        return String.format("%.2f", suma / recenzije.size());
    }

    public void createMainForm() {
        mainForm = new KorisnikMainForm();
        mainForm.setVisible(true);
    }

    public void kreirajPanele() {
        panelNalogKorisnik = new PanelNalogKorisnik();
        panelPretraga = new PanelPretraga();
        panelRecenzije = new PanelRecenzije();
    }

    // Getteri i setteri

    public Korisnik getUlogovaniKorisnik() { return ulogovaniKorisnik; }
    public void setUlogovaniKorisnik(Korisnik korisnik) { this.ulogovaniKorisnik = korisnik; }

    public Pivara getSelektovanaPivara() { return selektovanaPivara; }
    public void setSelektovanaPivara(Pivara pivara) { this.selektovanaPivara = pivara; }

    public Pivo getSelektovanoPivo() { return selektovanoPivo; }
    public void setSelektovanoPivo(Pivo pivo) { this.selektovanoPivo = pivo; }

    public Recenzija getSelektovanaRecenzija() { return selektovanaRecenzija; }
    public void setSelektovanaRecenzija(Recenzija r) { this.selektovanaRecenzija = r; }

    public ArrayList<Pivara> getSvePivare() { return svePivare; }
    public ArrayList<Pivo> getSvaPiva() { return svaPiva; }
    public ArrayList<OmiljenoPivo> getOmiljenaPiva() { return omiljenaPiva; }
    public ArrayList<Korisnik> getSviKorisnici() { return sviKorisnici; }
    public ArrayList<Recenzija> getSveRecenzije() { return sveRecenzije; }

    public KorisnikMainForm getMainForm() { return mainForm; }
    public PanelNalogKorisnik getPanelNalogKorisnik() { return panelNalogKorisnik; }
    public PanelPretraga getPanelPretraga() { return panelPretraga; }
    public PanelRecenzije getPanelRecenzije() { return panelRecenzije; }
}
