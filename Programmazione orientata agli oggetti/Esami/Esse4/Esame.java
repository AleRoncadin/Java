package Esse4;

import java.time.LocalDate;
import lombok.*;

@Data
public class Esame {
    private String nomeEsame;
    private LocalDate data;
    private int voto;
    private String giudizio;
}
