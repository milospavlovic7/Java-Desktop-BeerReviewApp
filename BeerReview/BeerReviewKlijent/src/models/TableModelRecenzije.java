package models;

import controller.ClientController;
import domain.Korisnik;
import domain.Recenzija;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class TableModelRecenzije extends AbstractTableModel {

    private final String[] columnNames = {"Korisnik", "Opis", "Ocena"};
    private final List<Recenzija> recenzije;

    public TableModelRecenzije(List<Recenzija> recenzije) {
        this.recenzije = recenzije;
    }

    @Override
    public int getRowCount() {
        return recenzije.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Recenzija r = recenzije.get(rowIndex);
        switch (columnIndex) {
            case 0:
                Korisnik korisnik = null;
            try {
                korisnik = getKorisnikById(r.getKorisnikID());
            } catch (Exception ex) {
                Logger.getLogger(TableModelRecenzije.class.getName()).log(Level.SEVERE, null, ex);
            }
                return korisnik != null ? korisnik.getIme() + " " + korisnik.getPrezime() : "Nepoznat";
            case 1:
                String sadrzaj = r.getSadrzaj();
                return sadrzaj.length() > 15 ? sadrzaj.substring(0, 15) + "..." : sadrzaj;
            case 2:
                return r.getOcena();
            default:
                return null;
        }
    }

    private Korisnik getKorisnikById(Long id) throws Exception {
        for (Korisnik k : ClientController.getInstance().getAllKorisnik()) {
            if (k.getKorisnikID().equals(id)) {
                return k;
            }
        }
        return null;
    }

    public Recenzija getRecenzijaAt(int rowIndex) {
        return recenzije.get(rowIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Možda kasnije koristiš Renderer/Editor za kolonu "Akcije"
        return columnIndex == 3;
    }
}
