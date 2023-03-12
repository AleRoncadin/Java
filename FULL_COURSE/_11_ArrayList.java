package FULL_COURSE;
import java.util.ArrayList;

public class _11_ArrayList {
    public static void main(String args[]){
        // ArrayList sono array in cui gli elementi possono essere aggiunti e rimossi dopo la compilazione

        ArrayList<String> food = new ArrayList<String>();

        food.add("pizza");
        food.add("hamburger");
        
        food.set(0, "sushi");
        food.remove(2);
        food.clear();            // toglie tutti gli elementi

        for (int i = 0; i < food.size(); i++){
            System.out.println(food.get(i));
        }
    }
}
