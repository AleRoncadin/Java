package SEMESTRE_2.LAB.Codifica_Huffman;

// la classe rappresenta la coppia di un nodo e un percorso
// il nodo rappresenta un nodo dell'albero di Huffman
// il percorso si riferisce a quello della radice dell'albero al nodo

public class coppia
{
    public final nodo nodo;
    public final String percorso; 

    public coppia(nodo nodo, String percorso)
    {
        this.nodo = nodo;
        this.percorso = percorso;
    }
}
