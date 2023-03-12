package FULL_COURSE.Static_Keyword;

public class Friend {
    
    static int numberOfFriends;
    String name;

    Friend(String name){
        this.name = name;
        numberOfFriends++;
    }

    static void displayFriends(){
        System.out.println("You have " + numberOfFriends + " friends");
    }
}
