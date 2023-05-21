package ESAMI;

public class i20_06_2022 {
    
    // Esercizio 1 A
    public static boolean heapCheckA(double[] v) {

        int n = v.length;
        int i, j;

        for (i = 1; i < n; i++) {
            j = i * 2;
            if (j < n && v[i] > v[j]) {
                return false;
            }
            j++;
            if (j < n && v[i] > v[j]) {
                return false;
            }
        }
        return true;
    }

    // Esercizio 1 B
    public static boolean heapCheckB(double[] v) {

        int n = v.length;
        int i, j;

        for (i = 0; i < n; i++) {

            j = 2*i + 1;

            if (j < n && v[j] > v[i]) {
                return false;
            }

            j++;

            if (j < n && v[j] > v[i]) {
                return false;
            }
        }
        return true;
    }

    public final static int UNKNOWN = -1;

    // Esercizio 2 A
    public static int llds(double[] s){

        int n = s.length;
        double[] mem = new double[n];

        for (int i = 0; i< n; i++){
            mem[i] = UNKNOWN;
        }

        return lldsRec(s, UNKNOWN, mem);
    }

    private static int lldsRec(double[] s, int k, double[] mem){
        if(mem == ){

        }

        return ;
    }

    public static void main(String args[]){

        boolean hc1 = heapCheckA( new double[] { 5.0, 3.1, 5.7, 3.1, 8.5, 6.0, 3.8, 4.2, 9.3 } );
        boolean hc2 = heapCheckA( new double[] { 5.0, 3.1, 5.7, 3.1, 8.5, 6.0, 3.0, 4.2, 9.3 } );
        boolean hc3 = heapCheckB( new double[] { 8.5, 4.7, 8.5, 2.8, 3.2, 5.0, 6.3, 1.5, 2.6 } );
        boolean hc4 = heapCheckB( new double[] { 8.5, 4.7, 8.5, 2.8, 4.8, 5.0, 6.3, 1.5, 2.6 } );

        System.out.println(hc1);
        System.out.println(hc2);
        System.out.println(hc3);
        System.out.println(hc4);
    }

}
