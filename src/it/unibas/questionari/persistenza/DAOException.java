package it.unibas.questionari.persistenza;

/**
 *
 * @author francesco
 */
public class DAOException extends Exception {

    public DAOException() {
    }

    /**
     * Constructs an instance of <code>DAOException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public DAOException(String msg) {
        super(msg);
    }
}
