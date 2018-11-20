/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Predmet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milos Dragovic
 */
public class ModelTabelePredmeti extends AbstractTableModel {

    ArrayList<Predmet> lista;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabelePredmeti() {
        this.lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Predmet p = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getAdvokat();
            case 1:
                return p.getK();
            case 2:
                return sdf.format(p.getDatum());
            case 3:
                return p.getNaziv();
            default:
                return "Pogresan izbor";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Advokat";
            case 1:
                return "Klijent";
            case 2:
                return "Datum";
            case 3:
                return "Naziv predmeta";
            default:
                return "Pogresan izbor";
        }
    }

    public void dodajPredmet(Predmet predmet) {
        lista.add(predmet);
        fireTableDataChanged();
    }

    public void obtisiPredmet(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

    public ArrayList<Predmet> vratiListu() {
        return lista;
    }

}
