package FULL_COURSE;
import java.util.Scanner;

public class _4_math_class {
    public static void main(String[] args){

        double x = 3.4;
        double y = 10;

        double max = Math.max(x,y);
        double min = Math.min(x,y);
        int abs = (int) Math.abs(y);
        double sqrt = Math.sqrt(y);
        double round = Math.round(x);
        double ceil = Math.ceil(x);         // arrotonda per eccesso 
        double floor = Math.floor(x);       // arrotonda per difetto


        System.out.println(max + ", " + min+ ", " + abs+ ", " + sqrt+ ", " + round+ ", " + ceil+ ", " + floor);

        Ipotenusa();
    }

    public static void Ipotenusa(){
        double x;
        double z;
        double y;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter x value: ");
        x = scanner.nextDouble();
        System.out.println("Enter y value: ");
        y = scanner.nextDouble();

        z = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));

        System.out.println("Value of z is: " + z);

        scanner.close();
    }
}
