package Lezioni28;

// MCD
// mcm

public class Lezione2{

    public static void main(String args[]){

        int maxcm = mcd(15, 20);
        int mincm = mcm(15, 20);
        int ufetto = ufo(14);

        System.out.println("MCD: " + maxcm);
        System.out.println("mcm: " + mincm);

        stampaPrimi(500);

        System.out.println("UFO: " + ufetto);

    }

    // MCD
    public static int mcd(int x, int y){

        while(x != y){

            if (x < y){
               y = y - x;
            } else {
                x = x - y;
            }
        }

        return x;
    }

    // mcm
    public static int mcm(int m, int n){
        
        int x = m;

        while(x % n > 0){
            x = x + m;
        }

        return x;
    }

    public static boolean isPrime(int n){

        if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        } else {
            for (int a=3; a<=Math.sqrt(n); a+=2){
                if(n % a == 0){
                    return false;
                }
            } 
            return true;
        }
    }

    public static void stampaPrimi(int n){

        System.out.println("Numeri primi fino a " + n);

        for (int k=2; k<=n; k++){
            if(isPrime(k)) {
                System.out.println("\t" + k);
            }
        }
    }

    public static int ufo(int x){

        int[] u = new int[x+1];
        int i = 0;
        u[0] = x;

        while(x > 1){
            x = x / 2;
            i++;
            u[i] = x;
        }

        int y = 1;

        for(int j = i - 1; j >= 0; j--){
            if(u[j]%2 == 0){
                y = 2 * y - 1;
            } else {
                y = 2 * y + 1;
            }
        }
        return y;
    }
}