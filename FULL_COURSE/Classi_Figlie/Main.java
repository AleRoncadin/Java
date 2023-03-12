package FULL_COURSE.Classi_Figlie;

public class Main {
    public static void main(String args[]){
        
        Car car = new Car();
        Bicycle bike = new Bicycle();

        bike.stop();

        car.go();

        System.out.println(car.wheels);
        System.out.println(bike.pedals);

    }
}
