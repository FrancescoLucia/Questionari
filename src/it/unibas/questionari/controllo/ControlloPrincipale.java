/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unibas.questionari.controllo;

import it.unibas.questionari.Applicazione;
import it.unibas.questionari.Costanti;
import it.unibas.questionari.modello.Archivio;
import it.unibas.questionari.modello.Questionario;
import it.unibas.questionari.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

/**
 *
 * @author francesco
 */
public class ControlloPrincipale {

    private Action azioneCerca = new AzioneCerca();
    private Action azioneVerificaQuestionario = new AzioneVerificaQuestionario();

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca questionari");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt e"));
            
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            String argomento = vistaPrincipale.getCampoArgomento();
            int difficolta = vistaPrincipale.getCampoDifficolta();
            
            if (argomento.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Seleziona un argomento");
                return;
            }
            
            if (difficolta == 0) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Seleziona una difficolta'");
                return;
            }
            
            Archivio  archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            List<Questionario> listaQuestionari = archivio.cercaQuestionari(argomento, difficolta);
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_QUESTIONARI, listaQuestionari);
            vistaPrincipale.aggiornaDati();
        }

    }

    private class AzioneVerificaQuestionario extends AbstractAction {

        public AzioneVerificaQuestionario() {
            this.putValue(NAME, "Verifica Questionario");
            this.putValue(SHORT_DESCRIPTION, "Verifica se i risultati sono in ordine crescente per il questionario selezionato");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt v"));
            
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            Integer selezionato = Applicazione.getInstance().getVistaPrincipale().getQuestionarioSelezionato();
            if (selezionato == null) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Nessun questionario selezionato");
                return;
            }
            List<Questionario> listaQuestionari = (List<Questionario>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_QUESTIONARI);
            Questionario questionario = listaQuestionari.get(selezionato);
            if (questionario.nessunaRisposta()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Il questionario \"" + questionario.getCodice() + "\" non contiene compilazioni");
                return;
            }
            String messaggio;
            if (questionario.verificaOrdineCompilazioni()) {
                messaggio = "Le compilazioni del questionario \"" + questionario.getCodice() + "\" sono ordinate";
            } else {
                messaggio = "Le compilazioni del questionario \"" + questionario.getCodice() + "\" NON sono ordinate";
            }
            Applicazione.getInstance().getFrame().mostraMessaggio(messaggio);
        }

    }

    public Action getAzioneCerca() {
        return azioneCerca;
    }

    public Action getAzioneVerificaQuestionario() {
        return azioneVerificaQuestionario;
    }

}
