public class Lis {

  public static int llis( int[] s ) { // s[i] > 0 per i in [0,n-1], dove n = s.length

    return llisRec( s, 0, 0 );
  }

  private static int llisRec( int[] s, int i, int t ) {

    // il metodo restituisce la lunghezza della sottosequenza crescente più lunga
    // a partire dalla posizione i
    // prende in input: 
    // - un array di interi
    // - l'indice i che indica la posizione corrente nell'array
    // - il valore t che rappresenta l'ultimo elemento della sottosequenza crescente più lunga
    //   trovata fino a quel momento

    if ( i == s.length ) { // in questo caso l'array è vuoto quindi ritorna 0
      return 0;
    } 

    // se l'elemento corrente è minore o uguale a all'ultimo elemento t
    // allora non può essere incluso nella sottosequenza e richiama se stesso
    // incrementando i
    else if ( s[i] <= t ) {
      return llisRec( s, i+1, t );
    } 

    // se l'elemento corrente è maggiore di t allora può essere incluso nella sottosequenza
    // viene richiamato il metodo due volte:
    // la prima parte 1+llisRec(s,i+1,s[i]) include l'elemento corrente
    // mentre la seconda non include l'elemento corrente s[i], ma t
    // infine viene restituito il massimo dei due valori con Math.max
    else {
      return Math.max( 1+llisRec(s,i+1,s[i]), llisRec(s,i+1,t) );
    }
  }

  public static void main(String args[]){
    
    //prova mem1
    System.out.println(Mem1.llisMem(new int[] {5,4,3,2,1}));
    System.out.println(Mem1.llisMem(new int[] {2,3,5,3,4}));
    System.out.println(Mem1.llisMem(new int[] {1,2,3,4,5}));
    
    //prova mem2
    System.out.println(Mem2.llisMem(new int[] {2, 7, 5, 7, 4}));
    System.out.println(Mem2.llisMem(new int[] {47, 38, 39, 25, 44}));
    System.out.println(Mem2.llisMem(new int[] {27, 90, 7, 29, 49, 8, 53, 1, 28, 6}));
  }
}