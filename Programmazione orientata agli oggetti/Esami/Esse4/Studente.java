package Esse4;

import java.util.List;
import lombok.*;

// this is a shortcut for @ToString, @EqualsAndHashCode, @Getter on 
// all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor
@Data
public class Studente {
    private @NonNull String nome;
    private @NonNull String cognome;
    private int matricola;
    private List<Corso> corsiIscritti;
    private int annoCorso;
    private int CFUOttenuti;
    private boolean isInRegola;
    private boolean isFuoriCorso = controllaFuoriCorso(annoCorso);
    private List<Esame> esamiSostenuti;
    
    /**
     * verifica se lo studente è fuori-corso o in-corso
     * @param annoCorso indica l'anno di corso che sta frequentando lo studente
     * @return true lo studente è fuori-corso, false se è in-corso
     */
    boolean controllaFuoriCorso(int annoCorso){
        if (annoCorso > 3){
            return true;
        }else{
            return false;
        }
    }

}
