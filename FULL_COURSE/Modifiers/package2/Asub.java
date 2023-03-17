package FULL_COURSE.Modifiers.package2;
import FULL_COURSE.Modifiers.package1.*;      // importo il package che contiene la classe A

public class Asub extends A{
    public static void main(String args[]){

        C c = new C();
        System.out.println(c.default_message);

    }
}
