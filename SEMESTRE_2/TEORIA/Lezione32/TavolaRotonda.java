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
    private IntSList coda;
    
    public TavolaRotonda(int n){
        this.numero = n;
        this.brocca = 1;
        this.altri = intervallo(2, n);
        this.coda = IntSList.NULL_INT_S_LIST;
    }

    private TavolaRotonda(int numero, int brocca, IntSList altri, IntSList coda){
        this.numero = numero;
        this.brocca = brocca;
        this.altri = altri;
        this.coda = coda;
    }

    public int cavalieriRimasti(){
        return numero;
    }

    public int cavaliereConBrocca(){
        return brocca;
    }

    public TavolaRotonda servi(){
        if (numero > 1){
            if (altri.isNull()){
                return new TavolaRotonda(numero-1, brocca, coda.reverse().cdr(), IntSList.NULL_INT_S_LIST);
            } else {
                return new TavolaRotonda(numero-1, brocca, altri.cdr(), coda);
            }         
        } else {
            return this;
        }
    }

    public TavolaRotonda passa(){

        if (numero > 1){
            if(altri.isNull()){

                // crea una lista con un solo elemento
                IntSList il = coda.cons(brocca);

                return new TavolaRotonda(numero, il.car(), il.cdr(), IntSList.NULL_INT_S_LIST);

            } else{
                return new TavolaRotonda(numero, altri.car(), altri.cdr(), coda.cons(brocca));
            }
        } else {
            return this;
        }

        
    }

    private static IntSList intervallo(int inf, int sup){
        /*if (inf > sup){
            return IntSList.NULL_INT_S_LIST;
        } else {
            return intervallo(inf+1, sup).cons(inf);
        }*/

        IntSList il = IntSList.NULL_INT_S_LIST;
        for(int k=sup; k>=inf; k--){
            il = il.cons(k);
        }
        
        return il;
    }
}
