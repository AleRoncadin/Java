package FULL_COURSE.Abstraction;

public abstract class Vehicle {
    
    String name;

    Vehicle(String name){
        this.name = name;
    }

    // puoi dichiarare il metodo astratto ma non può avere un body
    // quindi nella classe figlia ci sarà l'override del metodo
    abstract void go(); 
}
