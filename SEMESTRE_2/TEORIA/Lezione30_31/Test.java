package Lezione30_31;

public class Test {
    
    /** 
     * La funzione torna una lista: inserisci i valori inferiore e superiore
     * ESEMPIO: se inf = 3, sup = 9, la lista sarà --> (3, 4, 5, 6, 7, 8, 9 )
    */
    public static IntSList intervallo(int inf, int sup){
        
        if (inf > sup){

            // 2 modi per ritornare una lista vuota:

            // return new IntSList();
            return IntSList.NULL_INT_S_LIST;
            
            // dato che NULL_INT_S_LIST è statico non serve istanziare un oggetto
            // questo modo è più efficiente del primo

        } else {
            return intervallo(inf+1, sup).cons(inf);
        }
    }

    /**
     * @param args
     */
    public static void main(String args[]){
        
        IntSList lista = intervallo(1, 6);
        IntSList lista2 = intervallo(7, 9);

        System.out.println(lista.toString());
        System.out.println(lista.isNull());
        System.out.println(lista.car());
        System.out.println(lista.cdr());
        System.out.println(lista.length());
        
        System.out.println("LIST-REF di " + lista.toString());
        System.out.println("\t" + lista.listRef(3));
        System.out.println("\t" + lista.listRef(0));
        System.out.println("\t" + lista.listRef(1) + "\n");

        System.out.println(lista.cons(2));
        
        System.out.println(lista.append(lista2));

        System.out.println(lista.reverse());
    }
}
