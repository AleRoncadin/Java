package FULL_COURSE;
import java.util.Scanner;

public class _1_user_input{
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println("How old are you?");
        int age = scanner.nextInt();
        scanner.nextLine();                                                     // pulisce lo scanner

        System.out.println("What is your fav food?");
        String food = scanner.nextLine();

        System.out.println("Hello " + name + " you are " + age + " years old");
        System.out.println("Your fav food is " + food);

        scanner.close();
    }
}

