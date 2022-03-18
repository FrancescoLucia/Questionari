package it.unibas.questionari.modello;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author francesco
 */
public class Questionario implements Comparable<Questionario> {

    private String codice;
    private String descrizione;
    private int difficolta;
    private String argomento;
    private List<Compilazione> listaCompilazioni = new ArrayList<>();

    public Questionario(String codice, String descrizione, int difficolta, String argomento) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.difficolta = difficolta;
        this.argomento = argomento;
    }

    public String getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getDifficolta() {
        return difficolta;
    }

    public String getArgomento() {
        return argomento;
    }

    public List<Compilazione> getListaCompilazioni() {
        return listaCompilazioni;
    }

    public void addCompilazione(Compilazione compilazione) {
        this.listaCompilazioni.add(compilazione);
    }

    @Override
    public int compareTo(Questionario altro) {
        return Integer.compare(this.getDifficolta(), altro.getDifficolta());
    }
    
    public boolean nessunaRisposta() {
        return listaCompilazioni.size() == 0;
    }

    public boolean verificaOrdineCompilazioni() {
        if (this.listaCompilazioni.isEmpty()) {
            throw new IllegalArgumentException("Nessuna compilazione inserita");
        }
        for (int i = 0; i < this.listaCompilazioni.size() - 1; i++) {
            if (listaCompilazioni.get(i).getTempoCompilazione() > listaCompilazioni.get(i + 1).getTempoCompilazione()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Questionario{");
        sb.append("codice=").append(codice);
        sb.append(", descrizione=").append(descrizione);
        sb.append(", difficolta=").append(difficolta);
        sb.append(", argomento=").append(argomento);
        sb.append('}');
        return sb.toString();
    }

}
