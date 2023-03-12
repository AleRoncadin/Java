package FULL_COURSE;
public class _8_switches {
    public static void main(String[] args){
        
        String day = "Pizza";

        switch(day) {
            case "Sunday":
                System.out.println("It is Sunday");
                break;
            case "Friday":
                System.out.println("It is Friday");
                break;
            case "Monday":
                System.out.println("It is Monday");
                break;

            // ...

            default:
                System.out.println("This is not a day!");
            
        }

        System.out.println("Nice!!!");
    }
}
