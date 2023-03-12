package FULL_COURSE.Constructor;

// con i costruttori puoi creare più oggetti con attributi diversi

public class Main {
    public static void main(String args[]){

        Human rick = new Human("Rick", 65, 79);
        Human bro = new Human("Bro", 43, 68);
        
        // Array di oggetti
        Human[] humans = new Human[2];
        humans[0] = rick;
        humans[1] = bro;

        // puoi fare anche:
        //Human[] humans = {rick, bro};

        System.out.println(rick.name);
        bro.eat();

        System.out.println(rick);
        System.out.println(rick.toString());
    }
}
