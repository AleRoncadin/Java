package Lezione32;
import Lezione30_31.IntSList;

/**
 * TavolaRotonda t = new TavolaRotonda(n);
 * 
 * t.cavalieriRimasti()     : int
 * t.cavaliereConBrocca()   : int   (etichetta)
 * 
 * t.servi()                : TavolaRotonda
 * t.passa()                : TavolaRotonda
 * 
 */

public class TavolaRotonda {

    private int numero;
    private int brocca;
    private IntSList altri;
    
    public TavolaRotonda(int n){
        this.numero = n;
        this.brocca = 1;
        this.altri = intervallo(2, n);
    }

    private TavolaRotonda(int numero, int brocca, IntSList altri){
        this.numero = numero;
        this.brocca = brocca;
        this.altri = altri;
    }

    public int cavalieriRimasti(){
        return numero;
    }

    public int cavaliereConBrocca(){
        return brocca;
    }

    public TavolaRotonda servi(){
        return new TavolaRotonda(numero-1, brocca, altri.cdr());
    }

    public TavolaRotonda passa(){

        if (numero > 1){
            // crea una lista con un solo elemento
            IntSList lista = IntSList.NULL_INT_S_LIST.cons(brocca);

            return new TavolaRotonda(numero, altri.car(), altri.cdr().append(lista));
        
        } else {
            return this;
        }

        
    }

    private static IntSList intervallo(int inf, int sup){
        if (inf > sup){
            return IntSList.NULL_INT_S_LIST;
        } else {
            return intervallo(inf+1, sup).cons(inf);
        }
    }
}
