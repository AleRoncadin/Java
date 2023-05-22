package SEMESTRE_2.LAB.Codifica_Huffman;

// la classe rappresenta un frame utilizzato per ricostruire l'albero
// di Huffman dal file di input.

public class frame 
{
    public int stato;       // è lo stato del frame
    public nodo sin, des;   // sin e des sono i figli sinistro e destro
    
    public frame()
    {
        stato = 0;
        sin = null;
        des = null;
    }
}