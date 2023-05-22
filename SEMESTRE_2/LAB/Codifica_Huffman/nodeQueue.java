package SEMESTRE_2.LAB.Codifica_Huffman;

public class nodeQueue 
{
    //VARIABILI DI ISTANZA
    private static nodo[] coda;

    //Costruttore
    public nodeQueue()
    {
        coda = new nodo[128];
    }

    //restituisce il numero di elementi contenuti nella coda
    public static int size()
    {
        int numNodi = 0, index = 0;

        while(coda[index] != null)
        {
            numNodi ++;
            index ++;
        }

        return numNodi;

    }

    //restituisce l’elemento con “peso minore” (senza rimuoverlo dalla coda)
    public static nodo peek()
    {
        return coda[0];
    }

    //restituisce e rimuove dalla coda l’elemento con “peso minore”
    public static nodo poll()
    {
        nodo primo;

        primo = coda[0];
        coda[0] = null;



        return primo;

    }

    //aggiunge un nuovo elemento n alla coda
    public static void add(nodo n)
    {
        int index = size();

        // aggiunge n alla fine della coda
        coda[index] = n;

        nodo temp;

        // ordino la coda in base al peso dei nodi dopo averlo aggiunto
        while (index > 0 && coda[index].peso() < coda[index-1].peso()){

            // se il peso di n è minore del nodo precedente
            // allora vengono scambiati
            temp = coda[index];
            coda[index] = coda[index-1];
            coda[index-1] = temp;
            
            index--;
        }
    }
}