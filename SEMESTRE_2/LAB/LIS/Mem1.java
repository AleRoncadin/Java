// implementa una versione "memoizzata dell'algoritmo"

public class Mem1 {
    
    public static int llisMem(int s[]){ // s[i] > 0 per i in [0,n-1], dove n = s.length

        // prende in input un array di interi

        int n = s.length;

        // creazione matrice di dimensione (n+1)x(n+1)
        int [][] mem = new int[n+1][n+1];

        // ogni elemento della matrice viene inizializzato a -1
        for(int i=0;i<=n;i++){
            for(int k=0;k<=n;k++){
                mem[i][k]=-1;       
            }
        }
        return llisMemRec(s,mem,0,0);
    }

    private static int llisMemRec(int s[],int mem[][], int i, int t){

        // prende in input: 
            // - un array di interi s
            // - l'indice i che indica la posizione corrente nell'array
            // - il valore t che è l'ultimo elemento della sottosequenza crescente più lunga 
            //      trovata fino a quel momento

        int n = s.length;

        // controlla se l'elemento è a uguale a -1, se è così allora non è ancora stato calcolato
        if(mem[i][t]==-1){
            if ( i == n ) { // controlla se l'indice è uguale alla lunghezza, ritorna 0 se è vero
                mem[i][t]= 0;
            } 

            // se l'elemento corrente è minore o uguale a all'ultimo elemento t
            // allora non può essere incluso nella sottosequenza e richiama se stesso
            // incrementando i           
            else if ( s[i] <= t ) {
                mem[i][t]=llisMemRec( s,mem, i+1, t );
            } 
            
            // se l'elemento corrente è maggiore di t allora può essere incluso nella sottosequenza
            // viene richiamato il metodo due volte:
            // la prima parte 1+llisRec(s,mem,i+1,s[i]) include l'elemento corrente
            // mentre la seconda esclude l'elemento corrente s[i], e metto t
            // infine viene restituito il massimo dei due valori con Math.max
            else {
                mem[i][t]= Math.max( 1+llisMemRec(s,mem,i+1,s[i]), llisMemRec(s,mem,i+1,t) );
            }
        }
        return mem[i][t];
    }
}