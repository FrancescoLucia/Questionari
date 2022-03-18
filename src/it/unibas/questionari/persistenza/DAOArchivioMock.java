/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unibas.questionari.persistenza;

import it.unibas.questionari.Costanti;
import it.unibas.questionari.modello.Archivio;
import it.unibas.questionari.modello.Compilazione;
import it.unibas.questionari.modello.Questionario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author francesco
 */
public class DAOArchivioMock implements IDAOArchivio {
    
    public final static Logger logger = LoggerFactory.getLogger(DAOArchivioMock.class);

    @Override
    public Archivio carica(String nomeFile) throws DAOException {
        logger.debug("Caricamento archivio");
        Archivio archivio = new Archivio();

        Questionario q1 = new Questionario("codice1", "Questionario n.1", 3, Costanti.ITALIANO);

        q1.addCompilazione(new Compilazione(1, true, 10));
        q1.addCompilazione(new Compilazione(2, true, 120));
        q1.addCompilazione(new Compilazione(3, false, 70));
        q1.addCompilazione(new Compilazione(4, false, 150));

        Questionario q2 = new Questionario("codice2", "Questionario n.2", 2, Costanti.GEOGRAFIA);

        q2.addCompilazione(new Compilazione(5, false, 40));
        q2.addCompilazione(new Compilazione(6, true, 70));
        q2.addCompilazione(new Compilazione(7, false, 90));
        q2.addCompilazione(new Compilazione(8, true, 100));

        Questionario q3 = new Questionario("codice3", "Questionario n.3", 4, Costanti.STORIA);

        Questionario q4 = new Questionario("codice4", "Questionario n.4", 5, Costanti.ITALIANO);

        q4.addCompilazione(new Compilazione(10, true, 70));
        q4.addCompilazione(new Compilazione(9, false, 40));
        q4.addCompilazione(new Compilazione(11, false, 90));
        q4.addCompilazione(new Compilazione(12, true, 100));

        Questionario q5 = new Questionario("codice5", "Questionario n.5", 2, Costanti.ITALIANO);

        q5.addCompilazione(new Compilazione(13, false, 40));
        q5.addCompilazione(new Compilazione(14, true, 70));
        q5.addCompilazione(new Compilazione(16, true, 100));
        q5.addCompilazione(new Compilazione(15, false, 90));

        Questionario q6 = new Questionario("codice6", "Questionario n.6", 3, Costanti.STORIA);

        q6.addCompilazione(new Compilazione(18, true, 70));
        q6.addCompilazione(new Compilazione(19, false, 90));
        q6.addCompilazione(new Compilazione(20, true, 100));
        q6.addCompilazione(new Compilazione(17, false, 40));

        archivio.addQuestionario(q1);
        archivio.addQuestionario(q2);
        archivio.addQuestionario(q3);
        archivio.addQuestionario(q4);
        archivio.addQuestionario(q5);
        archivio.addQuestionario(q6);
        
        logger.info("Caricati " + archivio.getListaQuestionari().size() + " questionari");

        return archivio;
    }
}
