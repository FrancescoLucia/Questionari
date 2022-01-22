package it.unibas.questionari.modello;

public class Compilazione {

    private int codice;
    private boolean esito;
    private int tempoCompilazione;

    public Compilazione(int codice, boolean esito, int tempoCompletamento) {
        this.codice = codice;
        this.esito = esito;
        this.tempoCompilazione = tempoCompletamento;
    }

    public int getCodice() {
        return codice;
    }

    public boolean isEsito() {
        return esito;
    }

    public int getTempoCompilazione() {
        return tempoCompilazione;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Compilazione{");
        sb.append("codice=").append(codice);
        sb.append(", esito=").append(esito);
        sb.append(", tempoCompletamento=").append(tempoCompilazione);
        sb.append('}');
        return sb.toString();
    }

    // Per HashMap
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.codice;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compilazione other = (Compilazione) obj;
        return this.codice == other.codice;
    }

}
