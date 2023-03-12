package FULL_COURSE;
public class _14_printf {
    public static void main(String args[]){

        boolean myBoolean = true;
        char myChar = 'e';
        String myString = "Bro";
        int myInt = 19;
        double myDouble = 2_001_018.14;

        System.out.printf("%b", myBoolean);
        System.out.printf("%c", myChar);
        System.out.printf("%s", myString);
        System.out.printf("%d", myInt);
        System.out.printf("%f", myDouble);

        // minimum number of characters to be written as output
        System.out.printf("Hello %10s", myString);          // ci devono essere almeno 10 caratteri, myString = Bro,
                                                                   // quindi scrivi 7 spazi prima per avere 10 caratteri

        System.out.printf("Hello %-10s", myString);         // gli spazi vengono messi dopo il nome

        // limitare il numero di cifre dopo la virgola
        System.out.printf("You have this much money: %.2f", myDouble);      // limita di 2 cifre dopo la virgola
        System.out.printf("You have this much money: %,f", myDouble);      // mette la virgola sul 1,000 e su 2,000,000



    }
}
