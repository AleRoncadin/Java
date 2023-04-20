package Lezione36_37_38;

public class memoization {

    public static long fib(int n){ // n >= 0
        if(n < 2){
            return 1;
        } else {
            return (fib(n-2) + fib(n-1));
        }
    }

    public static long fibM(int n) 
    {
        long[] mem = new long[n + 1];

        for (int i = 0; i < n; i++) 
            mem[i] = UNKNOWN;
        
        return fibMem(n, mem);
    }

    private static final int UNKNOWN = -1;

    //Procedura di fibonacci SENZA RICORSIVA: DAJE
    private static long fibMem(int n, long[] mem)
    {
        if(mem[n] == UNKNOWN)
        {
            if(n < 2)
                mem[n] = 1;
            else
                mem[n] = fibMem(n-2, mem) + fibMem(n-1, mem);
        }

        return mem[n];
    }

    public static long manh(int i, int j){
        if(i == 0 || j == 0){
            return 1;
        } else {
            return manh(i-1,j) + manh(i, j-1);
        }
    }

    //Inizializzo la matrice
    public static long manhM(int i, int j)
    {
        long[][] mem = new long[i+1][j+1];

        for (int k = 0; k <= i; k++) 
            for (int l = 0; l <= j; l++) 
                mem[k][l] = UNKNOWN;
                
        return manhMem(i, j, mem);
    }

    //Calcola il numero di percorsi di manhattan con una matrice
    private static long manhMem(int i, int j, long[][] mem)
    {
        if(mem[i][j] == UNKNOWN)
        {
            if(i == 0 || j == 0)
                mem[i][j] = 1;
            else
                mem[i][j] = manhMem(i-1, j, mem) + manhMem(i, j-1, mem);
        }

        return mem[i][j];
    }

    //Versione alternativa SENZA RICORSIONE
    public static long manhOP(int i, int j)
    {
        long[][] mem = new long[i+1][j+1];

        for (int k = 0; k <=i; k++) 
        {
            for (int l = 0; l <=j; l++) 
            {
                if(k == 0 || l == 0)
                    mem[k][l] = 1;
                else
                    mem[k][l] = mem[k-1][l] + mem[k][l-1];
            }
        }

        return mem[i][j];
    }

    public static int llcs(String u, String v){
        int m = u.length();
        int n = v.length();

        int[][] mem = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                mem[i][j] = UNKNOWN;
            }
        }

        return llcsMem(u, v, mem);
    }

    private static int llcsMem(String u, String v, int[][] mem){
        int m = u.length();
        int n = v.length();

        if(mem[m][n] == UNKNOWN){
            if((m == 0) || (n == 0)){
                mem[m][n] = 0;
            } else if (u.charAt(0) == v.charAt(0)){
                mem[m][n] = 1 + llcsMem(u.substring(1), v.substring(1), mem);
            } else {
                mem[m][n] =  Math.max(llcsMem(u.substring(1), v, mem), llcsMem(u, v.substring(1), mem));
            }
        }
        
        return mem[m][n];
    }

    public static int llcsRec(String u, String v){ // tradotta da scheme
        int m = u.length();
        int n = v.length();

        if((m == 0) || (n == 0)){
            return 0;
        } else if (u.charAt(0) == v.charAt(0)){
            return 1 + llcs(u.substring(1), v.substring(1));
        } else {
            return Math.max(llcs(u.substring(1), v), llcs(u, v.substring(1)));
        }
    }

    public static String lcs(String u, String v){
        int m = u.length();
        int n = v.length();

        String[][] mem = new String[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                mem[i][j] = null;
            }
        }

        return lcsMem(u, v, mem);
    }

    private static String lcsMem(String u, String v, String[][] mem){
        int m = u.length();
        int n = v.length();

        if(mem[m][n] == null){
            if((m == 0) || (n == 0)){
                mem[m][n] = "";
            } else if (u.charAt(0) == v.charAt(0)){
                mem[m][n] = 1 + lcsMem(u.substring(1), v.substring(1), mem);
            } else {
                mem[m][n] = longer(lcsMem(u.substring(1), v, mem), lcsMem(u, v.substring(1), mem));
            }
        }
        
        return mem[m][n];
    }

    private static String longer(String u, String v){
        int m = u.length();
        int n = v.length();

        if(m < n){
            return v;
        } else if(m > n){
            return u;
        } else if(Math.random() < 0.5) {  // se sono uguali, allora a volte esce u a volte v
            return v;
        } else {
            return u;
        }
    }

    public static int llcsDP(String u, String v){ // DP sta per dinamic programming
        
        int m = u.length();
        int n = v.length();
        int[][] mem = new int[m+1][n+1];

        for(int i = 0; i <= n; i++){
            mem[0][i] = 0;
        }

        for(int i = 1; i <= m; i++){
            mem[i][0] = 0;
        }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(u.charAt(m-i) == v.charAt(n-j)){
                    mem[i][j] = 1 + mem[i-1][j-1];
                } else{
                    mem[i][j] = Math.max(mem[i-1][j], mem[i][j-1]);
                }
            }
        }

        return mem[m][n];
    }
}
