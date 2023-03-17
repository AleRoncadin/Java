package FULL_COURSE.Encapsulation;

import java.time.Year;

public class Main {
    
    // Encapsulation = gli attributi della classe sono privati e sono accessibili solamente da metodi getters e setters
    
    // Gli attributi vanno messi quasi sempre PRIVATE, se non si c'è una ragione valida per metterli PUBLIC o PROTECTED
    
    public static void main(String args[]){
        Car car1 = new Car("Tesla", "T50", 2021);
        Car car2 = new Car("Ferrari", "F20", 2018);
        Car car3 = new Car(car1);


        // System.out.println(car.make);  non posso stamparlo perché è private

        // uso il getter per accedere all'attributo

        System.out.println("CAR 1:");
        System.out.println("- " + car1.getMake());
        System.out.println("- " + car1.getModel());
        System.out.println("- " + car1.getYear());

        System.out.println("\nCAR 2:");
        System.out.println("- " + car2.getMake());
        System.out.println("- " + car2.getModel());
        System.out.println("- " + car2.getYear());

        System.out.println("\nCAR 3:");
        System.out.println("- " + car3.getMake());
        System.out.println("- " + car3.getModel());
        System.out.println("- " + car3.getYear());

        // per cambiare gli attributi privati uso i setters

        car1.setYear(2022);              // cambio l'anno
        System.out.println("\n" + car1.getYear());

        // copiare attributi oggetti
        car2.copy(car1);

        System.out.println("\nCAR 2:");
        System.out.println("- " + car2.getMake());
        System.out.println("- " + car2.getModel());
        System.out.println("- " + car2.getYear());
    }
}
