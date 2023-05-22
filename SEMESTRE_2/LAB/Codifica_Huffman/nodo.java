package SEMESTRE_2.LAB.Codifica_Huffman;

public class nodo implements Comparable<nodo>
{
    private final char car;     // è il carattere associato al nodo
    private final int peso;     // è il peso del nodo
    private final nodo sin;     // è il figlio sinistro del nodo
    private final nodo des;     // è il figlio destro del nodo

    // il peso rappresenta il numero di volte 
    // in cui un carattere appare all'interno del testo

    // ogni nodo possiede due figli, uno sinistro e uno destro
    // questi figli possono essere delle foglie o dei nodi interni

    // i nodi con peso maggiore sono vicini alla radice
    // i nodi con peso minore sono più lontanti dalla radice

    // le foglie rappresentano un singolo carattere
    // i nodi interni rappresentano combinazioni di più caratteri

    public nodo( char c, int w)
    {
        car = c;
        peso = w;
        sin = null;
        des = null;
    }

    public nodo(nodo l , nodo r)
    {
        car = (char) 0;
        peso = l.peso() + r.peso();
        sin = l;
        des = r;
    }

    public boolean foglia() 
    {
        // capire se è foglia o no, vedendo se non ha fogli a sinistra e a destra
        return sin == null;
    }

    public char simbolo()
    {
        // restituisce il simbolo (carattere) associato al nodo
        return car;
    }

    public int peso()
    {
        // restituisce il peso, ovvero il numero di occorrenze del carattere
        // associato al nodo
        return peso;
    }

    public nodo sinistro() 
    {
        // restituisce il figlio sinistro del nodo
        return sin;
    }

    public nodo destro()
    {
        // restituisce il figlio destro del nodo
        return des;
    }

    public int compareTo(nodo altro)
    {
        // confronta il nodo attuale con un altro nodo
        // passato come parametro in base al loro peso

        // se il peso del nodo attuale è minore di quello passato, ritorna -1
        if(this.peso < altro.peso())
            return -1;
        // se il peso del nodo attuale è uguale di quello passato, ritorna 0
        else if(this.peso == altro.peso())
            return 0;
        else
            return 1;

    }
}
