package it.unibas.questionari.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author francesco
 */
public class Archivio {

    private List<Questionario> listaQuestionari = new ArrayList<>();

    public Archivio() {
    }

    public List<Questionario> getListaQuestionari() {
        return listaQuestionari;
    }

    public List<Questionario> cercaQuestionari(String argomento, int difficoltaMinima) {
        List<Questionario> risultato = new ArrayList<>();
        for (Questionario questionario : listaQuestionari) {
            if (questionario.getArgomento().equals(argomento) && questionario.getDifficolta() >= difficoltaMinima) {
                risultato.add(questionario);
            }
        }

        Collections.sort(risultato);
        return risultato;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Archivio{");
        sb.append("listaQuestionari=").append(listaQuestionari);
        sb.append('}');
        return sb.toString();
    }

    public void addQuestionario(Questionario questionario) {
        listaQuestionari.add(questionario);
    }

    public boolean verificaCompilazioni() {
        List<Compilazione> listaCompilazioni = unisciCompilazioni();
        
        for (Compilazione compilazione : listaCompilazioni) {
            if (contaOccorrenze(compilazione.getCodice(), listaCompilazioni) > 1) {
                return false;
            }
        }
        
        return true;
    }
    
    private List<Compilazione> unisciCompilazioni() {
        List<Compilazione> risultato = new ArrayList<>();
        for (Questionario questionario : listaQuestionari) {
            risultato.addAll(questionario.getListaCompilazioni());
        }
        return risultato;
    }
    
    private int contaOccorrenze(int codice, List<Compilazione> lista) {
        int conta = 0;
        for (Compilazione compilazione : lista) {
            if (compilazione.getCodice() == codice) {
                conta++;
            }
        }
        return conta;
        
    }
}
