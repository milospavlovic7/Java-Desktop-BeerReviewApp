package models;

import domain.Pivo;
import domain.Pivara;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelPretraga extends AbstractTableModel {

    private final String[] columnNames = {"Naziv", "Tip"};
    private final List<Object> lista;  // može biti lista Pivo ili Pivara objekata

    public TableModelPretraga(List<Object> lista) {
        this.lista = lista;
    }

    public List<Object> getLista() {
        return lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
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
        Object obj = lista.get(rowIndex);

        if (obj instanceof Pivo) {
            Pivo pivo = (Pivo) obj;
            if (columnIndex == 0) {
                return pivo.getNaziv();
            } else if (columnIndex == 1) {
                return "Pivo";
            }
        }

        if (obj instanceof Pivara) {
            Pivara pivara = (Pivara) obj;
            if (columnIndex == 0) {
                return pivara.getNaziv();
            } else if (columnIndex == 1) {
                return "Pivara";
            }
        }

        return null; // ako nije ni Pivo ni Pivara
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // tabela nije editabilna
    }
    
    public Object getObjectAt(int rowIndex) {
        return lista.get(rowIndex);
    }
}
