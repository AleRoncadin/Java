public class Queens {

  public static int numberOfSolutions( int n ) {
    
    // ritorna il numero di soluzioni creando una scacchiera di dimensione n
    // e la passa al metodo numberOfCompletions()

    return numberOfCompletions( new Board(n) );
  }

  private static int numberOfCompletions( Board b ) {

    // ritorna il numero di modi in cui è possibile collocare le regine sulla
    // scacchiera in modo che nessuna minacci le altre.

    int n = b.size();
    int q = b.queensOn();

    // se il numero di regine è uguale alla dimensione, allora le regine
    // sono state collocate correttamente e ritorna 1
    if ( q == n )
    {
      return 1;
    } 
    else 
    {
      int count = 0;

      // colloca una regina nella riga successiva
      int i = q + 1;

      // e in tutte le colonne disponibili da 1 a n
      for (int j = 1; j <= n; j++) {
        // se la posizione non è minacciata il metodo richiama se stesso con la nuova scacchiera
        if ( !b.isUnderAttack(i,j) ) {
          // somma il numero di completamenti trovati
          count = count + numberOfCompletions( b.addQueen(i,j) );
      }}
      return count;
    }
  }

  public static void main( String args[]) {

    for(int i = 1; i <= 10; i++) {
       System.out.println("Dimensione: " + i + "\t N. Soluzioni: " + numberOfSolutions(i));
    }
  }
}  // class Queens