package FULL_COURSE;
public class _9_strings_tips {
    public static void main(String args[]){
        
        String name = "Ale";
        boolean res;

        res = name.equals("ale");           // torna false
        System.out.println(res);

        res = name.equalsIgnoreCase("ale");           // torna true
        System.out.println(res);

        // lenght()
        // charAt(1)         è char
        // indexOf("o")      è int
        // isEmpty()         è bool
        // toUpperCase()
        // toLowerCase()
        // .trim()          rimuove gli spazi

        String name2 = name.replace('e', 'i');

        String vuoto = " ";

        System.out.println(vuoto.isBlank());            // torna true se ci sono spazi
        System.out.println(vuoto.isEmpty());            // torna false se ci sono spazi
    }
}
