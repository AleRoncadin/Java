package FULL_COURSE.Super_Keyword;

public class Hero extends Person {

    String power;

    Hero(String name, int age, String power){

        // name e age sono presi dalla classe padre Person
        // al posto di mettere
        //      this.name = name
        //      this.age = age
        // metto super(name, age)
        // super invia i parametri al costruttore della classe padre
        super(name, age);
        this.power = power;
    }

    // puoi usare super per chiamare un metodo che è nella classe padre
    public String toString(){
        return this.power + " " + super.toString();
    }
}
