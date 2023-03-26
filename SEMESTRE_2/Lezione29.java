

public class Lezione29{
    public static void main(String args[]){
        System.out.println(logSize(20));
    }

    private static int logSize(int n){
        return ((int) (Math.log(n) / Math.log(2)) + 1);
    }
}