package FULL_COURSE.Classi_Figlie;

public class Car extends Vehicle {  // classe figlia di Vehicle
    int wheels = 4;
    int doors = 4;


    // se c'è override significa che il metodo compare sia nella classe
    // padre che nella classe figlia. Quando nel main viene chiamato
    // car.go() viene chiamato questo metodo, non quello presente nella
    // classe padre
    
    @Override
    void go(){
        System.out.println("The car is moving");
    }
}
