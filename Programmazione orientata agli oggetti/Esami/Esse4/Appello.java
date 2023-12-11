package Esse4;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import Esse4.TipoEsame.tipoEsame;
import lombok.*;

// this is a shortcut for @ToString, @EqualsAndHashCode, @Getter on 
// all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor
@Data
public class Appello {
    private String nome;
    private boolean isRemoto;
    private @NonNull LocalDate data;
    private @NonNull LocalTime ora;
    private int durata;
    private @NonNull String aula;
    private @NonNull String tipo; // finale, parziale, orale
    private List<Esame> prerequisiti;
    private int numStudenti;
    private List<Studente> studenti; // lista di studenti iscritti all'appello

    /**
     * verifica se il tipo di esame è presente nell'enum contenente tutti i tipi d'esame
     * @param t tipo di esame da controllare
     */
    public void isTipoInEnum(){
        for(tipoEsame val : tipoEsame.values()){
            if(val.name().equalsIgnoreCase(tipo)){
                return;
            }
        }
        tipo = "PARZIALE";  // di default, se il tipo di esame non è corretto viene fissato a parziale
        
    }

    /**
     * incrementa il numero di studenti iscritti all'appello
     */
    public void incrementaNumeroStudenti(){
        numStudenti++;
    }
    
    /**
     * aggiungi lo studente alla lista degli studenti iscritti all'appello
     * @param studente
     */
    public void addStudente(Studente studente){
        studenti.add(studente);
    }
}
