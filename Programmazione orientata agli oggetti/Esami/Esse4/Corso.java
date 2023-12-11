package Esse4;

import lombok.*;
import java.util.List;

// this is a shortcut for @ToString, @EqualsAndHashCode, @Getter on 
// all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor
@Data
public class Corso {
    private @NonNull String nomeCorso;
    private @NonNull String docente;
    private int CFU;
    private List<String> prerequisiti = null;
    private int anno;

    public void setCFU(int cfu) {
        assert cfu >= 0 : "CFU devono essere maggiori o uguali a 0";
        CFU = cfu;
    }

    public void setAnno(int a) {
        assert a > 0 : "Anno maggiore di 0!";
        anno = a;
    }
}
