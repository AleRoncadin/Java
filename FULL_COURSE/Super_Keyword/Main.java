package FULL_COURSE.Super_Keyword;

public class Main {
    public static void main(String args[]){
        
        // super = si riferisce alla classe padre di un oggetto

        Hero hero1 = new Hero("Batman", 50, "$$$");
        Hero hero2 = new Hero("Superman", 51, "everything");


        System.out.println(hero1.name);
        System.out.println(hero1.age);
        System.out.println(hero1.power);

        System.out.println(hero2.toString());
    }
}
