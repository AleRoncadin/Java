package SEMESTRE_2.LAB.Codifica_Huffman;

import huffman_toolkit.*;

public class fileRandom {
    public static void creaRandomFile(String nomeFile)
    {
        // prende in input il nome del file da creare

        //InputTextFile in = new InputTextFile(nomeFile);
        OutputTextFile out = new OutputTextFile(nomeFile);

        int dimFile = 4096;

        // ciclo per scrivere 4096 caratteri casuali nel file
        for (int i = 0; i < dimFile; i++) 
        {
            // Math.random() genera un numero tra 0 e 1
            // che viene moltiplicato per 128
            // e convertito in intero con .abs
            // per poi convertirlo in char con il casting
            char c = (char) Math.abs(128*Math.random());

            out.writeChar(c);
        }

        out.close();

    }
}
