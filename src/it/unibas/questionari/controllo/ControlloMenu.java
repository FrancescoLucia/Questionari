/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unibas.questionari.controllo;

import it.unibas.questionari.Applicazione;
import it.unibas.questionari.Costanti;
import it.unibas.questionari.modello.Archivio;
import it.unibas.questionari.persistenza.DAOException;
import it.unibas.questionari.persistenza.IDAOArchivio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author francesco
 */
public class ControlloMenu {
    
    private final static Logger logger = LoggerFactory.getLogger(ControlloMenu.class);

    private Action azioneCarica = new AzioneCarica();
    private Action azioneVerificaCompilazioni = new AzioneVerificaCompilazioni();
    private Action azioneEsci = new AzioneEsci();
    private Action azioneCambiaTema = new AzioneCambiaTema();

    class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica l'archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt c"));
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            IDAOArchivio daoArchivio = Applicazione.getInstance().getdAOArchivio();
            try {
                Archivio archivio = daoArchivio.carica("");
                Applicazione.getInstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
                Applicazione.getInstance().getControlloPrincipale().getAzioneVerificaQuestionario().setEnabled(true);
                Applicazione.getInstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                getAzioneVerificaCompilazioni().setEnabled(true);

                String messaggio = "Sono stati caricati " + archivio.getListaQuestionari().size() + " questionari";
                Applicazione.getInstance().getFrame().mostraMessaggio(messaggio);
            } catch (DAOException ex) {
                logger.error("ERRORE nel caricare i dati");
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Errore durante il caricamento dei dati");
            }
        }

    }

    class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt e"));
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.exit(0);
        }

    }

    class AzioneVerificaCompilazioni extends AbstractAction {

        public AzioneVerificaCompilazioni() {
            this.putValue(NAME, "Verifica Compilazioni");
            this.putValue(SHORT_DESCRIPTION, "Verifica se sono presenti risposte duplicate");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt v"));

            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            boolean risultato = archivio.verificaCompilazioni();
            String messaggio;
            if (risultato) {
                messaggio = "L'archivio non presenta compilazioni duplicate";
            } else {
                messaggio = "ATTENZIONE: L'archivio contiene compilazioni duplicate";
            }
            Applicazione.getInstance().getFrame().mostraMessaggio(messaggio);
        }

    }

    class AzioneCambiaTema extends AbstractAction {

        public AzioneCambiaTema() {
            this.putValue(NAME, "Cambia tema");
            this.putValue(SHORT_DESCRIPTION, "Cambia il tema tra dark e light");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_T);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt t"));
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            String tema = (String) Applicazione.getInstance().getModello().getBean(Costanti.TEMA);
            if (tema.equals(Costanti.TEMA_DARK)) {
                Applicazione.getInstance().getModello().putBean(Costanti.TEMA, Costanti.TEMA_LIGHT);
            } else {
                Applicazione.getInstance().getModello().putBean(Costanti.TEMA, Costanti.TEMA_DARK);
            }
            //Applicazione.getInstance().getModello().putBean(Costanti.TEMA, tema.equals(Costanti.TEMA_DARK) ? Costanti.TEMA_LIGHT : Costanti.TEMA_DARK);
            try {
                Applicazione.getInstance().getFrame().aggiornaTema();
            } catch (UnsupportedLookAndFeelException ex) {
                logger.warn("Look and feel non supportato");
            }
        }

    }

    public Action getAzioneCarica() {
        return azioneCarica;
    }

    public Action getAzioneVerificaCompilazioni() {
        return azioneVerificaCompilazioni;
    }

    public Action getAzioneEsci() {
        return azioneEsci;
    }

    public Action getAzioneCambiaTema() {
        return azioneCambiaTema;
    }

}
