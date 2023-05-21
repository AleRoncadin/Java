public class Mem2 {
 
  public static int llisMem(int s[]){ 

    // prende in input un array di interi
    // s[i] > 0 per i in [0,n-1], dove n = s.length

    int n = s.length;

    // creazione matrice di dimensione (n+1)x(n+1)
    int [][] mem = new int[n+1][n+1];

    // ogni elemento della matrice viene inizializzato a -1
    for(int i=0;i<=n;i++){
        for(int k=0;k<=n;k++){
            mem[i][k]=-1;       
        }
    }

    return llisMemRec(s,mem,0,n);
  }

  private static int llisMemRec(int s[],int mem[][], int i, int j){

    // i è la posizione corrente nell'array
    // j indica l'ultimo elemento della sottosequenza crescente più lunga

    int n = s.length;
    int t;  // t è l'ultimo elemento

    if (j == n){  // se j è uguale alla lunghezza dell'array
      t = 0;      // allora la sottosequenza comune è vuota
    } else {      // altrimenti
      t = s[j];   // viene inizializzato all'elemento dell'array s
    }             // di indice j

    // controlla se l'elemento è a uguale a -1, se è così allora non è ancora stato calcolato
    if(mem[i][j]==-1){
      if ( i == n ) { // controlla se l'indice è uguale alla lunghezza, ritorna 0 se è vero
        mem[i][j]= 0;
      } 
      
      // se l'elemento corrente è minore o uguale a all'ultimo elemento t
      // allora non può essere incluso nella sottosequenza e richiama se stesso
      // incrementando i  
      else if ( s[i] <= t ) {
        mem[i][j]=llisMemRec( s,mem, i+1, j );
      } 
      
      // se l'elemento corrente è maggiore di t allora può essere incluso nella sottosequenza
      // viene richiamato il metodo due volte:
      // la prima parte 1+llisRec(s,mem,i+1,i) include l'elemento corrente i
      // mentre la seconda esclude l'elemento corrente, quindi metto j invece di i
      // infine viene restituito il massimo dei due valori con Math.max
      else {
        mem[i][j]= Math.max( 1+llisMemRec(s,mem,i+1,i), llisMemRec(s,mem,i+1,j) );
      }
    }
    return mem[i][j];
  }
}
