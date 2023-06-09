package Lezione41;

// per poter usare variabili di istanza di tipo procedurale importo quel
// package

/*
 * Board b;
 * 
 * b = new Board(n);            [scacchiera vuota dimensione nxn]
 * 
 * b.size(); : int              [dimensione della scacchiera, cioè n]
 * 
 * b.queensOn(); : int          [è il numero delle regine]
 * 
 * b.underAttack(i, j); : bool  [dice se la casella è sotto attacco]
 * 
 * b.addQueen(i, j); : Board    [i, j sono le coordinate e arrivano fino a n]
 * 
 * b.arrangement();  : String
 * 
 */

 public class Board 
 {
     //Variabili d'istanza
     private static final String ROWS = " 123456789ABCDEF";
     private static final String COLUMNS = " abcdefghijklmno";
     private final int dimensione;
     private int numRegine;
     private String config;  // --> configurazione della scacchiera
 
     //Predicato da usare in underAttack
     private int[] righe;
     private int[] colonne;
     private int[] diagAsc;
     private int[] diagDesc;
 
 
     //Costruttore di scacchiera VUOTA
     public Board(int n)
     {
         dimensione = n;
         numRegine = 0;
         righe = new int[n];
         colonne = new int[n];
         diagAsc = new int[2*n-1];
         diagDesc = new int[2*n-1];
 
         //Riempimento degli array
         for (int i = 0; i < n; i++) 
         {
             righe[i] = 0;
             colonne[i] = 0;
         }
 
         for (int i = 0; i < 2*n-1; i++) 
         {
             diagAsc[i] = 0;
             diagDesc[i] = 0;
         }
 
         config = " ";
       
     }
 
 
     //Restituisce la dimensione della scacchiera
     public int size()
     {
         return dimensione;
     }                           
 
     //Restituisce il numero di regine sulla scacchiera in quel momento
     public int queensOn()
     {
         return numRegine;
     }
 
     //Verifica se la casella selezionata è sotto attacco o meno
     public boolean underAttack(int i, int j)
     {
         int n = dimensione;
         return (righe[i-1] > 0 || colonne[j-1] > 0 || diagAsc[i-j+n-1] > 0 || diagDesc[i+j-2] > 0);
     }
 
     //Aggiunge una regina nella casella scelta
     public void addQueen(int i, int j)
     {
         int n = dimensione;
 
         numRegine ++;
         righe[i-1] = righe[i-1] + 1;
         colonne[j-1] = colonne[j-1] + 1;
         diagAsc[i-j+n-1] = diagAsc[i-j+n-1] + 1;
         diagDesc[i+j-2] = diagDesc[i+j-2] + 1;
         config = config + COLUMNS.charAt(j) + ROWS.charAt(i) + " ";
     }
 
     //Rimuove una regina per continuare a controllare le soluzione
     public void removeQueen(int i, int j)
     {
         int n = dimensione;
 
         numRegine --;
 
         righe[i-1] = righe[i-1] - 1;
         colonne[j-1] = colonne[j-1] - 1;
         diagAsc[i-j+n-1] = diagAsc[i-j+n-1] - 1;
         diagDesc[i+j-2] = diagDesc[i+j-2] - 1;
 
         String position = "" + COLUMNS.charAt(j) + ROWS.charAt(i);
         int index = config.indexOf(position);
 
         config = config.substring(0, index) + config.substring(index+3);
     }
 
 
     //Restituisce la configurazione della scacchiera
     public String arrangement() 
     {
         return config;
     }
 
     //Restiruisce la configurazione in formato testuale
     public String toString()
     {
         return "[" + arrangement() + "]";
     }
 
 }