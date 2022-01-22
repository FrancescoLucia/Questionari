package it.unibas.questionari;

import it.unibas.questionari.controllo.ControlloMenu;
import it.unibas.questionari.controllo.ControlloPrincipale;
import it.unibas.questionari.modello.Modello;
import it.unibas.questionari.persistenza.DAOArchivioMock;
import it.unibas.questionari.persistenza.IDAOArchivio;
import it.unibas.questionari.vista.Frame;
import it.unibas.questionari.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

/**
 *
 * @author francesco
 */
public class Applicazione {

    private static Applicazione singleton = new Applicazione();

    public static Applicazione getInstance() {
        return singleton;
    }

    private Applicazione() {
    }

    public void inizializza() {

        vistaPrincipale = new VistaPrincipale();
        frame = new Frame();
        vistaPrincipale.inizializza();
        frame.inizializza();

    }

    private Modello modello = new Modello();
    private IDAOArchivio dAOArchivio = new DAOArchivioMock();

    private VistaPrincipale vistaPrincipale;
    private Frame frame;

    private ControlloMenu controlloMenu = new ControlloMenu();
    private ControlloPrincipale controlloPrincipale = new ControlloPrincipale();

    public static Applicazione getSingleton() {
        return singleton;
    }

    public Modello getModello() {
        return modello;
    }

    public IDAOArchivio getdAOArchivio() {
        return dAOArchivio;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public Frame getFrame() {
        return frame;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }
        });

    }

}
