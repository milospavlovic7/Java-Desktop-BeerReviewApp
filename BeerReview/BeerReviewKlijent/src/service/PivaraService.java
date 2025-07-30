package service;

import controller.ClientController;
import domain.Korisnik;
import domain.Pivara;
import domain.Pivo;
import domain.Recenzija;
import forms.pivara.PanelNalogPivara;
import forms.pivara.PanelPiva;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PivaraService {

    private static PivaraService instance;
    private Pivara ulogovanaPivara;
    private Pivo selektovanoPivo;
    private List<Pivo> allPiva;
    private ArrayList<Recenzija> sveRecenzije = new ArrayList<>();
    private ArrayList<Korisnik> sviKorisnici = new ArrayList<>();
    
    private PanelNalogPivara panelNalogPivara;
    private PanelPiva panelPiva;
    
    private PivaraService() {}

    public static PivaraService getInstance() {
        if (instance == null) {
            instance = new PivaraService();
        }
        return instance;
    }
    
    public void inicijalnoUcitavanje() throws Exception {
        allPiva = ClientController.getInstance().getAllPivo();
        sveRecenzije = ClientController.getInstance().getAllRecenzija();
        sviKorisnici = ClientController.getInstance().getAllKorisnik();
    }
    
    public void osveziDugme() throws Exception{
        inicijalnoUcitavanje();
        panelPiva.inicijalizacija();
    }

    public void registerPivara(String naziv, String email, String telefon, String lozinka, String confirmLozinka) throws Exception {
        if (!lozinka.equals(confirmLozinka)) {
            throw new Exception("Lozinke se ne poklapaju.");
        }
        Pivara pivara = new Pivara(null, naziv, email, lozinka, telefon, new Date());
        ulogovanaPivara = ClientController.getInstance().registerPivara(pivara);
    }

    public Pivara loginPivara(String email, String lozinka) throws Exception {
        Pivara pivara = new Pivara();
        pivara.setEmail(email);
        pivara.setLozinka(lozinka);
        ulogovanaPivara = ClientController.getInstance().loginPivara(pivara);
        return ulogovanaPivara;
    }
    
    public Pivara updatePivara(String naziv,  String telefon, String email, String oldPassword, String newPassword) throws Exception {
        if (!ulogovanaPivara.getLozinka().equals(oldPassword)) {
            throw new Exception("Stara lozinka nije ispravna.");
        }
        Pivara updated = new Pivara(
                ulogovanaPivara.getPivaraID(), naziv, email, newPassword, telefon, ulogovanaPivara.getDatumKreiranja()
        );
        ulogovanaPivara = ClientController.getInstance().updatePivara(updated);
        return ulogovanaPivara;
    }

    public void deletePivara() throws Exception {
        ClientController.getInstance().deletePivara(ulogovanaPivara);
        ulogovanaPivara = null;
    }

    public Pivo addPivo(String naziv, String opis, Double cena) throws Exception {
        if (naziv == null || naziv.isEmpty()) {
            throw new Exception("Naziv ne sme biti prazan.");
        }
        if (opis == null || opis.isEmpty()) {
            throw new Exception("Opis ne sme biti prazan.");
        }
        if (cena == null || cena <= 0) {
            throw new Exception("Cena mora biti veća od 0.");
        }

        Pivo pivo = new Pivo(null, ulogovanaPivara, naziv, opis, cena, new Date());
        selektovanoPivo = ClientController.getInstance().addPivo(pivo);
        return selektovanoPivo;
    }
    
    public Pivo updatePivo(Pivo updatedPivo) throws Exception {
        Pivo p = ClientController.getInstance().updatePivo(updatedPivo);
        selektovanoPivo = p;
        return p;
    }
    
    public void deletePivo(Pivo pivo) throws Exception {
        ClientController.getInstance().deletePivo(pivo);
        refreshAllPiva();
        selektovanoPivo = null;
    }
    
    public Pivara getUlogovanaPivara() {
        return ulogovanaPivara;
    }

    public void setUlogovanaPivara(Pivara ulogovanaPivara) {
        this.ulogovanaPivara = ulogovanaPivara;
    }

    public void setSelektovanoPivo(Pivo selektovanoPivo) {
        this.selektovanoPivo = selektovanoPivo;
    }

    public Pivo getSelektovanoPivo() {
        return selektovanoPivo;
    }

    public List<Pivo> getAllPiva() {
        return allPiva;
    }
    
    public void refreshAllPiva() throws Exception{
        allPiva = ClientController.getInstance().getAllPivoZaPivaru(ulogovanaPivara);
    }
    
     public void ucitajSveRecenzije() throws Exception {
        // Učitaj sve recenzije, možeš pozvati i sa servera ako imaš API za to
        sveRecenzije = ClientController.getInstance().getAllRecenzija();
    }

    public void ucitajSveKorisnike() throws Exception {
        sviKorisnici = ClientController.getInstance().getAllKorisnik();
    }

    public ArrayList<Recenzija> getSveRecenzije() {
        return sveRecenzije;
    }

    public ArrayList<Korisnik> getSviKorisnici() {
        return sviKorisnici;
    }

    public ArrayList<Recenzija> getRecenzijeZaSelektovanoPivo() {
        ArrayList<Recenzija> rezultat = new ArrayList<>();
        if (selektovanoPivo == null) return rezultat;

        for (Recenzija r : sveRecenzije) {
            if (r.getPivoID().equals(selektovanoPivo.getPivoID())) {
                rezultat.add(r);
            }
        }
        return rezultat;
    }

    public String getProsecnaOcenaZaSelektovanoPivo() {
        if (selektovanoPivo == null) return "/";

        double zbir = 0;
        int broj = 0;

        for (Recenzija r : sveRecenzije) {
            if (r.getPivoID().equals(selektovanoPivo.getPivoID())) {
                zbir += r.getOcena();
                broj++;
            }
        }

        if (broj == 0) return "/";

        double prosecna = zbir / broj;
        // formatiraj sa dve decimale (možeš prilagoditi)
        return String.format("%.2f", prosecna);
    }

    public Korisnik getKorisnikById(Long id) {
        for (Korisnik k : sviKorisnici) {
            if (k.getKorisnikID().equals(id)) {
                return k;
            }
        }
        return null;
    }

    public void kreirajPanele() {
        panelNalogPivara = new PanelNalogPivara();
        panelPiva = new PanelPiva();
    }

    public PanelNalogPivara getPanelNalogPivara() {
        return panelNalogPivara;
    }

    public void setPanelNalogPivara(PanelNalogPivara panelNalogPivara) {
        this.panelNalogPivara = panelNalogPivara;
    }

    public PanelPiva getPanelPiva() {
        return panelPiva;
    }

    public void setPanelPiva(PanelPiva panelPiva) {
        this.panelPiva = panelPiva;
    }

    
    
}
