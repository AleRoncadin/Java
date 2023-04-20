package SEMESTRE_2.LAB.Esercitazione_Codifica_Java;

public class Es1 {
    public static void main(String args[]){
        String btr = btr_succ("-+.+--+-..");
        System.out.println(btr);
    }

    public static String btr_succ(String btr){

        int n = btr.length();
        char lsb = btr.charAt(n-1);
        String pre;
        if (n == 1){
            if (lsb == '+'){
                return "+-";
            }
            else{
                return "+";
            }
        } else{
            pre = btr.substring(0, n-1);
            if (lsb == '+'){
                return btr_succ(pre) + "-";
            }
            else{
                return ((lsb == '-') ? (pre + ".") : (pre + "+"));
            }
        }       
    }
}
