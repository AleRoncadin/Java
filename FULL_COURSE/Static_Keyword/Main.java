package FULL_COURSE.Static_Keyword;

public class Main {

    public static void main(String args[]){
        
        // con static non serve creare l'oggetto

        Friend friend1 = new Friend("Matteo");
        Friend friend2 = new Friend("Marco");
        Friend friend3 = new Friend("Ilaria");
        Friend friend4 = new Friend("Giovanni");

        // se il metodo e la variabile che conta gli amici non sono statici
        // non posso farlo
        Friend.displayFriends();
    }

}


