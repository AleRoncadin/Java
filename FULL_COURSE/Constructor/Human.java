package FULL_COURSE.Constructor;

public class Human {
    
    String name;
    int age;
    double weight;

    Human(String name, int age, double weight){
        
        this.name = name;
        this.age = age;
        this.weight = weight;

        // sarebbe:
            // rick.name = name
            // rick.age = age;
            // rick.weight = weight;
    }

    public String toString(){
        return name + " " + age + " " + (int)weight;
    }

    void eat(){
        System.out.println(this.name + " is eating");
    }
}
