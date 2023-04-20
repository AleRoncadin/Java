package Lezioni28;

public class Lezione3 {
    public static void main(String args[]){
        int ufetto = ufo(15);
        int ls = longSize(40);

        System.out.println(ufetto);
        System.out.println(ls);
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

    public static int longSize(int n){
        return (int) (Math.log(n) / Math.log(2) + 1);
    }

    public static int btrVal(String btr){
        
        int n = 0;

        for(int i = 0; i < btr.length(); i++){
            n = 3 * n + btdVal(btr.charAt(i));
        }

        return n;
    }

    public static int btdVal(char btd){        
        switch(btd){
            case '-':
                return -1;
            case '.':
                return 0;
            case '+':
                return +1;
            default:
                return 0;
        }
    }
}
