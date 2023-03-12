package FULL_COURSE;
import java.util.ArrayList;

public class _12_2D_ArrayList {
    public static void main(String args[]){

        ArrayList<ArrayList<String>> groceryList = new ArrayList<>();

        ArrayList<String> bakeryList = new ArrayList<>();
        bakeryList.add("pasta");
        bakeryList.add("bread");
        bakeryList.add("donuts");

        ArrayList<String> produceList = new ArrayList<>();
        produceList.add("tomatoes");
        produceList.add("zucchini");
        produceList.add("peppers");

        groceryList.add(bakeryList);
        groceryList.add(produceList);

        System.out.println(groceryList);
        System.out.println(groceryList.get(0).get(0));
        System.out.println();

        for (int i = 0; i < groceryList.size(); i++){
            System.out.println();
            for (int j = 0; j < groceryList.get(i).size(); j++){
                System.out.println(groceryList.get(i).get(j));
            }
        }
    }
}
