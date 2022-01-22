/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unibas.questionari.vista;

import it.unibas.questionari.modello.Questionario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author francesco
 */
public class ModelloTabellaQuestionari extends AbstractTableModel {

    private List<Questionario> questionari = new ArrayList<>();

    public void setQuestionari(List<Questionario> questionari) {
        this.questionari = questionari;
    }

    @Override
    public int getRowCount() {
        return this.questionari.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Questionario questionario = questionari.get(row);
        if (column == 0) {
            return questionario.getCodice();
        } else if (column == 1) {
            return questionario.getDescrizione();
        } else if (column == 2) {
            return questionario.getDifficolta();
        } else if (column == 3) {
            return questionario.getArgomento();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Codice";
        } else if (column == 1) {
            return "Descrizione";
        } else if (column == 2) {
            return "Difficoltà";
        } else if (column == 3) {
            return "Argomento";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2) {
            return Integer.class;
        }
        return String.class;
    }
    
    

    
    public void aggiornaContenuto() {
        fireTableDataChanged();
    }
}
