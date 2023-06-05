package LAB.Es13;

import puzzleboard.*;
import java.util.*;

public class rompicapo15 
{
    //VARIABILI DI ISTANZA
    private static int dim;                             // Dimensione della tavoletta
    private static int[][] tavoletta;                   // Rappresentazione interna della tavoletta
    public static PuzzleBoard gui;                      // Oggetto per la visualizzazione grafica
    public int posX = -1, posY = -1;                    // Posizione del tassello selezionato
    public int vuotoX = -1, vuotoY = -1;                // Posizione dello spazio vuoto
    private List<Integer> numbers = new ArrayList<>();  // Lista dei numeri da mescolare

    //Costruttore
    public rompicapo15(int n)
    {
        gui = new PuzzleBoard(n); // Crea la visualizzazione grafica della tavoletta
        mescolaNumeri(n); // Inizializza la lista dei numeri da mescolare
    
        tavoletta = new  int[n+1][n+1]; // Inizializza la rappresentazione interna della tavoletta
        dim = n; // Salva la dimensione della tavoletta
  
        for (int i = 0; i < tavoletta.length; i++) {
            for (int j = 0; j < tavoletta.length; j++) {
                if(i==0 || j==0)
                {
                    tavoletta[i][j]=-1; // Imposta i bordi della tavoletta come valori negativi
                }
                else
                {
                    tavoletta[i][j] = numbers.get(0); // Assegna i numeri mescolati alla tavoletta
                    numbers.remove(0);
                }
            }            
        }

        stampaMatrice(tavoletta); // Stampa la rappresentazione interna della tavoletta
        aggiornaTavoletta(); // Aggiorna la visualizzazione grafica della tavoletta
    }

    // Genera una sequenza casuale di numeri da 1 a dim*dim-1
    public void mescolaNumeri(int x) {

        int cont =-1;
        int d = x*x;

        for (int i = 0; i < d; i++) {
            cont++;
            numbers.add(cont); // Aggiunge i numeri da 0 a (dimensione^2 - 1) alla lista
        }

        Collections.shuffle(numbers); // Mescola i numeri
    }

    // Stampa la matrice
    public static void stampaMatrice(int mat[][])
    {
        // Loop through all rows
        for (int[] row : mat)
            System.out.println(Arrays.toString(row)); 
    }

    // Verifica se i tasselli sono ordinati
    public boolean isCorrect()
    {
        boolean flag = true;
        int i, j;
        i = dim;
        j = dim;
        int check = (int) Math.pow(dim,2); // Numero da controllare

        if(tavoletta[dim][dim]==0) // Se l'ultimo elemento è lo spazio vuoto
        {
            while (flag && i >=1) 
            {
                j=dim;
                while(j>=1)
                {
                    if(i == dim && j == dim)
                    {
                        flag = true; // Il tassello vuoto è nella posizione corretta
                        check--;

                    }
                    else if(tavoletta[i][j]==check)
                    {
                        flag=true; // Il tassello vuoto è nella posizione corretta
                        check--;
                    }
                    else
                    {
                        flag=false; // Almeno un tassello è fuori posizione
                    }
                    j--;
                }

                i--;
            
            }
        }
        else
            flag = false; // L'ultimo elemento non è lo spazio vuoto

        return flag; // Restituisce true se i tasselli sono ordinati, false altrimenti
    }

    //Verifica possibilità di spostamento
    public boolean controllaSpostamento()
    {
        int n = gui.get(); // Ottiene il numero del tassello selezionato
        
        for (int i = 1; i <= dim; i++) 
        {
            for (int j = 1; j <= dim; j++) 
            {
                if(tavoletta[i][j] == n)
                {
                    posX = j; // Memorizza la colonna del tassello selezionato
                    posY = i; // Memorizza la riga del tassello selezionato
                }
            }
        }

        if( (posX > 1 && posX<=dim) && tavoletta[posY][posX-1] == 0) // Controllo spostamento a sinistra
        {
            vuotoX = posX-1; // Memorizza la colonna dello spazio vuoto
            vuotoY = posY; // Memorizza la riga dello spazio vuoto
            return true;
        }
        else if( (posY > 1 && posY<=dim) && tavoletta[posY-1][posX] == 0 ) // Controllo spostamento in alto
        {
            vuotoX = posX; // Memorizza la colonna dello spazio vuoto
            vuotoY = posY-1; // Memorizza la riga dello spazio vuoto
            return true;
        }
        else if( (posX>=1 && posX < dim) && tavoletta[posY][posX+1] == 0) // Controllo spostamento a destra
        {
            vuotoX = posX+1; // Memorizza la colonna dello spazio vuoto
            vuotoY = posY; // Memorizza la riga dello spazio vuoto
            return true;
        }
        else if( (posY>=1 && posY < dim) && tavoletta[posY+1][posX] == 0) // Controllo spostamento in basso
        {
            vuotoX = posX; // Memorizza la colonna dello spazio vuoto
            vuotoY = posY+1; // Memorizza la riga dello spazio vuoto
            return true;
        }
        else 
            return false; // Nessun possibile spostamento
    }

    //Sposta il tassello selezionato nello spazio vuoto
    public void spostaTassello()
    {
        if(controllaSpostamento())
        {
            tavoletta[vuotoY][vuotoX] = tavoletta[posY][posX]; // Sposta il tassello
            tavoletta[posY][posX] = 0; // Imposta lo spazio vuoto nella vecchia posizione del tassello
            aggiornaTavoletta(); // Aggiorna la visualizzazione grafica della tavoletta
        }
    }

    // Aggiorna la visualizzazione grafica della tavoletta
    public void aggiornaTavoletta()
    {
        
        for (int i = 1; i <= dim; i++) 
        {

            for (int j = 1; j <= dim; j++) 
            {
                int x = tavoletta[i][j];
                gui.setNumber(i, j, x);
                gui.display();
            }
            
        }

        if(isCorrect())
            System.out.println("Hai vinto");

       
    }
    
    public static void main(String[] args) 
    {
        rompicapo15 a = new rompicapo15(4);
        a.aggiornaTavoletta();

        while (!a.isCorrect()) 
        {
            a.spostaTassello();
        }
    }

}