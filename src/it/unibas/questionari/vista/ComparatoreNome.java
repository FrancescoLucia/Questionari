
import it.unibas.questionari.vista.ProvaSorting;
import java.util.Comparator;

 public class ComparatoreNome implements Comparator<ProvaSorting> {

        @Override
        public int compare(ProvaSorting t, ProvaSorting t1) {
            return t.getNome().compareTo(t1.getNome());
        }
        
    }