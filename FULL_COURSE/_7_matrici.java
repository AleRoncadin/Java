package FULL_COURSE;
public class _7_matrici {
    public static void main(String args[]){
        
        String[][] cars = new String[2][2];

        String[][] names = { 
                                {"Audi", "Ferrari"}, 
                                {"Lambo", "Tesla"} 
                            };

        cars[0][0] = "Audi";
        cars[0][1] = "Ferrari";
        cars[1][0] = "Lambo";
        cars[1][1] = "Tesla";

        for(int i = 0; i < cars.length; i++){
            System.out.println();
            for (int j = 0; j < cars[i].length; j++){
                System.out.println("\t" + cars[i][j]);
            }
        }
    }
}
