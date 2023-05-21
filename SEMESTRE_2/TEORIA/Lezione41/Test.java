package Lezione41;

public class Test {

    public static SList<Integer> intervallo (int inf, int sup){
        if (inf > sup){

            // 2 modi per ritornare una lista vuota:

            // return new SList<Integer>();
            return new SList<Integer>();
            
            // dato che NULL_INT_S_LIST è statico non serve istanziare un oggetto
            // questo modo è più efficiente del primo

        } else {
            return intervallo(inf+1, sup).cons(inf);
        }
    }

    public static void main(String args[]){
        SList<Integer> lista = intervallo(1, 6);
        SList<Integer> lista2 = intervallo(7, 9);

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
