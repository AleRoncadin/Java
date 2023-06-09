package Lezione32;

public class GiuseppeFlavio {

    public static int ultimoCavaliere(int n) {
        TavolaRotonda t = new TavolaRotonda(n);

        while(t.cavalieriRimasti() > 1){
            t = t.servi();
            t = t.passa();
        }

        return t.cavaliereConBrocca();
    }

    public static void main(String args[]){
        System.out.println(ultimoCavaliere(10000));
    }
}
