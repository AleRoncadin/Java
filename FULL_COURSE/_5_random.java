package FULL_COURSE;
import java.util.Random;

public class _5_random {
    public static void main(String[] args){

        Random random = new Random();

        int x = random.nextInt(6);      // genera da 0 a 5
        x = random.nextInt(6) + 1;        // genera da 1 a 6

        double y = random.nextDouble();       // genera un numero decimale tra 0 e 1

        boolean z = random.nextBoolean();       // genera o true o false

        System.out.println(x);
    }
}
