package SEMESTRE_2.LAB.Codifica_Huffman;

public class Main {
    public static void main(String[] args) 
    {
        fileRandom.creaRandomFile("fileDiTesto\\out.txt");
        huffman.comprimi("fileDiTesto\\out.txt", "fileDiTesto\\outCompresso.txt");   
    }
}
