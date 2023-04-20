package Lezioni28;


// plurale
// femminile
// lato più lungo foglio A4
// btr-val e btd-val

public class Lezione1{

    public static void main(String args[]){

        boolean femm = femminile("betulla");
        String nome = plurale("betulla");
        double lato = s(15);
        int btr_val = btrVal("-.+.+-+.+-+");
        
        System.out.println(femm);
        System.out.println(nome);
        System.out.println(lato);
        System.out.println(btr_val);
    }

    public static String pluraleF(String sf){
        return sf.substring(0, sf.length()-1).concat("e");
    }

    public static String pluraleM(String sm){
        return sm.substring(0, sm.length()-1).concat("i");
    }

    public static boolean femminile(String s){
        return (s.substring(s.length()-1).equals("a"));
    //  return (s.CharAt(s.length()-1).equals('a'));
    }

    public static String plurale(String s){
        if (femminile(s))
            return pluraleF(s);
        else
            return pluraleM(s);
    }

    public static double s(int k){
        final double s0 = Math.pow(2, 0.25);
        final double s1 = Math.pow(2, -0.25);

        if(k >= 2){
            return (s (k-2) / 2);
        }
        else{
            return ((k==0) ? s0 : s1);
        }
    }

    public static int btdVal(String btd){
        
        switch(btd){
            case "-":
                return -1;
            case ".":
                return 0;
            case "+":
                return +1;
            default:
                return 0;
        }
    }

    public static int btrVal(String btr){
        int k = btr.length()-1;
        if (k==0){
            return btdVal(String.valueOf(btr.charAt(0)));
        } else{
            return (3 * btrVal(btr.substring(0, k)) + btdVal(String.valueOf(btr.charAt(k))));
        }
    }
}