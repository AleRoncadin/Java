public class Board {

    private static final String ROW = "123456789ABCDEF";
    private static final String COL = "abcdefghijklmno";
    private final int size;
    private int queens;
    private IntSList row, col, dg1, dg2;
    private String config;

    //creazione di una scacchiera vuota
    public Board(int n){
        size = n;
        queens = 0;
        row = new IntSList();
        col = new IntSList();
        dg1 = new IntSList();
        dg2 = new IntSList();
        config = " ";
    }

    private Board(Board b, int i, int j){
        
        // viene creata una nuova scacchiera aggiungendo una regina.
        // la nuova scacchiera ha la stessa dimensione, 
        // ma il numero di regine è maggiore di uno.
        // le liste sono aggiornate con la nuova posizione della regina
        // la configurazione è aggiornata con la nuova posizione della regina

        size = b.size();
        queens = b.queensOn()+1;
        row = b.row.cons(i);
        col = b.col.cons(j);
        dg1 = b.dg1.cons(i-j);
        dg2 = b.dg2.cons(i+j);
        config = b.arrangemet() + " " + COL.charAt(j) + ROW.charAt(i);;
    }

    // restituisce la dimensione della scacchiera
    public int size(){
        return size;
    }

    // ritorna il numero di regine collocate sulla scacchiera
    public int queensOn(){
        return queens;
    }

    public boolean isUnderAttack(int i, int j){

        // verifica se la posizione di coordinate <i,j> è minacciata da una regina
        // quindi controlla se:
        // i è presente nella lista delle righe
        // j è presente nella lista delle colonne
        // i-j è presente nella lista delle diagonali ascendenti
        // i+j è presente nella lista delle diagonali discendenti

        return(
            IntSList.findElement(row,i)   ||
            IntSList.findElement(col,j)   ||
            IntSList.findElement(dg1,i-j) ||
            IntSList.findElement(dg2,i+j)
        );
    }

    public String arrangemet(){
        // ritorna la codifica testuale della configurazione (string)
        return config;
    }

    public Board addQueen(int i, int j){
       // crea una nuova scacchiera a partire dalla scacchiera corrente 
       // aggiungendo una regina in posizone <i,j> alla configurazione di b (board)
       return new Board(this,i,j);
    }
    
    // Restituisce la configurazione sotto forma di stringa
    public String toString(){
        return "[" +  arrangemet() + " ]";
    }
}
