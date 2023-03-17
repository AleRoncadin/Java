package FULL_COURSE.Modifiers.package1;
import FULL_COURSE.Modifiers.package2.*;  // importo il package 2

public class A {
    public static void main(String args[]){

        C c = new C();

        // non posso stampare c.default_message perché non è public
        System.out.println(c.public_message);

    }
}
