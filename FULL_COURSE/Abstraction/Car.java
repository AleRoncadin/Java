package FULL_COURSE.Abstraction;

public class Car extends Vehicle{

    Car(String name){
        super(name);
    }

    @Override
    void go() {
        System.out.println("The driver is driving a " + this.name);
    }
    
}
