package it.unibas.questionari.modello;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author francesco
 */
public class Modello {

    private Map<String, Object> beans = new HashMap<>();

    public void putBean(String chiave, Object bean) {
        this.beans.put(chiave, bean);
    }

    public Object getBean(String chiave) {
        return this.beans.get(chiave);
    }

}
