package FULL_COURSE;
public class _6_array {
    public static void main(String[] args){
        
        String[] cars = new String[3];
        String[] names = {"Pedro", "Claudio"};

        cars[0] = "Camaro";
        cars[1] = "Corvette";
        cars[2] = "Tesla";

        for(int i = 0; i < names.length; i++)
        {
            System.out.println("\t"+ names[i]);
        }
    }
}
