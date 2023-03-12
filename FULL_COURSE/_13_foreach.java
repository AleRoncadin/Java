package FULL_COURSE;
import java.util.ArrayList;

public class _13_foreach {
    public static void main(String args[]){
        // for-each è più facile da leggere rispetto al for

        String[] animals = {"cat", "bird", "rat"};
        ArrayList<String> names = new ArrayList<>();

        names.add("pedro");
        names.add("claudio");
        names.add("fonty");
        names.add("beppe");

        //si legge: for every string in array
        for(String i : animals){
            System.out.println(i);
        }
    }
}
