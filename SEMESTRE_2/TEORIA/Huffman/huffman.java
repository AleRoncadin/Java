package Huffman;

import huffman_toolkit.*;
import java.util.*;

public class huffman
{
    public static int[] freqChar(String src) 
    {
        // questa funzione prende in input il percorso del file e restituisce un array di interi
        // che rappresenta la frequenza di ogni carattere all'interno del file

        InputTextFile in = new InputTextFile(src);      // leggi il contenuto del file

        int[] conto = new int[InputTextFile.CHARS];     // array di interi di lunghezza pari al numero
                                                        // di caratteri dentro il file

        for (int i = 0; i < conto.length; i++) 
        {
            conto[i] = 0;                               // ogni elemento dell'array viene settato a 0
        }

        while (in.textAvailable())       // legge il contenuto del file carattere per carattere                      
        {
            char c = in.readChar();                     
            conto[c] = conto[c] + 1;        
        }

        // dopo questo ciclo while l'array conto contiene le frequenze di ogni carattere
        // contenuto dentro il file 

        in.close();

        return conto;
    }

    public static nodo alberoHuffman(int[] freq) 
    {
        // prende in input l'array "conto" dato dal metodo precedente 
        // e restituisce la radice dell'albero di Huffman
        // costruito a partire da tali frequenze
        
        // crea una coda di nodi
        PriorityQueue<nodo> coda = new PriorityQueue<nodo>();

        for (int i = 0; i < freq.length; i++) 
        {
            if(freq[i] > 0)
            {
                // crea un nuovo nodo foglia per ogni carattere
                // che appare più di una volta nel testo
                nodo n = new nodo((char) i, freq[i]);
                coda.add(n);
            }
        }

        while (coda.size() > 1) 
        {
            // estrae 2 nodi con peso minore dalla coda
            nodo l = coda.poll();
            nodo r = coda.poll();

            // crea un nuovo nodo che ha come figli i due nodi estratti prima
            nodo rad = new nodo(l, r);
            // inserisce il nodo nella coda
            coda.add(rad);
        }
        // il ciclo si ripet finché rimane un unico nodo
        // che è la radice dell'albero di Huffman

        return coda.poll();
    }
    
    public static String[] tabHuffman(nodo rad)
    {
        // il metodo prende in input la radice data dal metodo sopra
        // ritorna un array di stringhe che contiene la codifica
        // di ogni carattere

        // InputTextile.CHARS è il numero di caratteri nel file
        // tab è un array di stringhe di lunghezza pari a InputTextFile.CHARS
        String[] tab = new String[InputTextFile.CHARS];
        // fa la codifica di Huffman per ogni carattere
        compilaTab(rad, "", tab);

        return tab;
    }

    private static void compilaTab(nodo n, String cod, String[] tab) 
    {
        // il metodo visita l'albero di Huffman e fa la codifica per ogni carattere
        // prende in input:
        // un nodo dell'albero di Huffaman
        // una stringa che rappresenta la codifica corrente del nodo
        // un array di stringhe che è la tabella di codifica di Huffman

        if(n.foglia())  // se il nodo è una foglia
        // salva la codifica del carattere nell'array di stringhe
            tab[n.simbolo()] = cod;
        else
        {   // se il nodo non è una foglia
            // si scende nei figli che stanno a sinistra e a destra

            // se scende nella parte sinistra dell'albero si aggiunge 0 alla codifica       
            compilaTab(n.sinistro(), cod + "0", tab);
            // se scende nella parte destra dell'albero si aggiunge 1 alla codifica
            compilaTab(n.destro(), cod + "1", tab);
        }
    }

    public static String codificaAlbero(nodo n){

        // prende in input la radice e ritorna la codifica dell'albero in stringa

        if(n.foglia()){             // se il nodo è una foglia
            char c = n.simbolo();

            if(c == '@' || c == '\\'){
                return "\\" + c;
            } else {
                return "" + c;
            }
        } else {
            // se non è una foglia ritorna '@' con la codifica della parte 
            // sinistra e destra dell'albero
            return "@" + codificaAlbero(n.sinistro()) + codificaAlbero(n.destro());
        }
    }

    private static void comprimi(String src, String dst) 
    {
        // prende in input l'handle del file sorgente e del file destinazione
        // comprime il file sorgente usando l'algoritmo di Huffman e scrive il 
        // file compresso in dst.

        // in questo array c'è la frequenza con cui ogni carattere appare in src
        int[] freq = freqChar(src);
        // il nodo contiene la radice dell'albero di Huffman di freq
        nodo radice = alberoHuffman(freq);
        // l'array di stringhe contiene la codifica di ogni carattere
        String[] tab = tabHuffman(radice); 

        InputTextFile in = new InputTextFile(src);
        OutputTextFile out = new OutputTextFile(dst);

        while(in.textAvailable())
        {
            char c = in.readChar();     // per ogni carattere letto
            out.writeCode(tab[c]);      // scrive la codifica del carattere in dst
        }

        in.close();
        out.close();
    }

    public static nodo ripristinaALbero(InputTextFile in) 
    {
        // in input è da specificare il file e ritorna un nodo che rappresenta
        // la radice dell'albero di Huffman ricostruito seguendo la codifica 
        // testuale dell'albero.

        // Questo metodo quindi forma l'albero di Huffman partendo dalla codifica
        // testuale fatta nel metodo codificaAlbero.

        char c = in.readChar();     // legge il primo carattere dal file

        if(c == '@')   // se c='@' allora il nodo ha 2 figli
        {
            nodo l = ripristinaALbero(in);  // legge il sottoalbero sinistro
            nodo r = ripristinaALbero(in);  // legge il sottoalbero destro

            return new nodo(l, r);  // ritorna con quei sottoalberi come figli
        }
            
        else 
            if(c == '\\')   // se c='\' allora il prossimo carattere è un escape
                c = in.readChar();      // legge il prossimo carattere
        
        // se c non è né '@' né '\', allora il nodo corrente è una foglia
        // crea un nuovo nodo con parametri;
        // - il carattere letto
        // - frequenza pari a 0
        return new nodo(c, 0);
    }

    private static void decomprimi(String src, String dst) 
    {
        // il metodo legge il file sorgente, lo decodifica usando l'albero di Huffman
        // e scrive il file decompresso nel file di destinazione

        // crea gli oggetti per leggere e scrivere i file
        InputTextFile in = new InputTextFile(src);
        OutputTextFile out = new OutputTextFile(dst);

        // ricostruisce l'albero a partire dal file sorgente
        nodo radice = ripristinaALbero(in);
        // 'conto' rappresenta il numero di caratteri da decomprire
        int conto = Integer.parseInt(in.readTextLine());
        String dummy = in.readTextLine();

        // il ciclo legge ogni carattere e lo decodifica con l'albero di Huffman
        for(int i=0; i<conto; i++)
        {
            nodo n = radice;

            do 
            {
                // legge il bit e decide se scendere nella parte sinistra o destra

                int bit = in.readBit();
                n = (bit==0) ? n.sinistro() : n.destro();

                // il ciclo continua finchè n non è una foglia
            } while (!n.foglia());

            // quando n è una foglia legge il suo carattere e lo scrive in dst
            char c = n.simbolo();
            out.writeChar(c);
        }

        in.close();
        out.close();
    }
}
