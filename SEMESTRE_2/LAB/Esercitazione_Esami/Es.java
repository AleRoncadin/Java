package LAB.Esercitazione_Esami;
import huffman_toolkit.*;
//import LAB.Codifica_Huffman.*;
import java.util.*;

public class Es {

    private static final int UNKNOWN = -1;
    
    // Es. 1
    public static int llcs3M(String t, String u, String v) {

        int l = t.length();
        int m = u.length();
        int n = v.length();

        int [][][] mem = new int[l+1][m+1][n+1];

        for (int i = 0; i <= t.length(); i++) {
            for (int j = 0; j <= u.length(); j++) {
                for (int z = 0; z <= v.length(); z++) {
                    mem[i][j][z] = UNKNOWN;
                }
            }
        }
        
        return llcs3Mem(t, u, v, mem);
    }

    private static int llcs3Mem(String t, String u, String v, int[][][] mem) {

        int l = t.length();
        int m = u.length();
        int n = v.length();

        if (l == 0 || m == 0 || n == 0) {
            return 0;
        }
        if (mem[l][m][n] == UNKNOWN) {
            if (t.charAt(0) == u.charAt(0) && u.charAt(0) == v.charAt(0)) {
                mem[l][m][n] = 1 + llcs3Mem(t.substring(1), u.substring(1), v.substring(1), mem);
            } else {
                mem[l][m][n] = Math.max(Math.max(llcs3Mem(t.substring(1), u, v, mem), llcs3Mem(t, u.substring(1), v, mem)), llcs3Mem(t, u , v.substring(1), mem));
            }
        }
        
        return mem[l][m][n];
    }

    // Es. 2
    public static boolean simmetrica(double[][] m){

        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m.length; j++){
                if(m[i][j] != m[j][i]){
                    return false;
                }
            }
        }

        return true;
    }

    // Es. 3
    /*public static boolean isFreeRow(int i){

    }*/

    public static void addQueen(String pos){

    }

    // Es. 4
    /*public static int shortestCodeLength( nodo root ) {
        int sc = ;
        Stack<nodo> stack = new Stack<nodo>();
        Stack<Integer> depth = new Stack<Integer>();
        stack.push( root );
        depth.push( 0 );
        do {
        nodo n = ;
        int d = ;
        if ( n.isLeaf() ) {
        sc = Math.min( sc, d );
        } else if ( d+1 < ) {
       
       
       
       
        }
        } while ( );
        return sc;
    }*/

    // Es. 5
    public static double[] closestPair(double[] array){

        int k = 0;

        for(int i = 0; i < array.length; i++){
            
        }
    }

    public static void main(String args[]){

        // Es. 1
        int llcs = llcs3M("Attrito", "Atrio", "Attruso");
        System.out.println(llcs);


    }
    
}
