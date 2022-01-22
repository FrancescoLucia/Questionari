package it.unibas.questionari.persistenza;

import it.unibas.questionari.modello.Archivio;

/**
 *
 * @author francesco
 */
public interface IDAOArchivio {

    Archivio carica(String nomeFile) throws DAOException;

}
