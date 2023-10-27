package Trasporti;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in); // Create a Scanner object

    public static void main(String[] args){
        ArrayList<Viaggio> viaggi = new ArrayList<>();

        // viaggio di prova iniziale
        inserisciProva(viaggi);
        
        Manager manager = new Manager();
        scegliOpzione(manager, viaggi);       
    }

    /**
     * metodo che mostra al manager tutte le opzioni che può scegliere
     * @param manager
     * @param viaggi
     */
    private static void scegliOpzione(Manager manager, ArrayList<Viaggio> viaggi){
        while(true){
            System.out.println("Scegli cosa vuoi fare: ");
            System.out.println("[1] Prenotare un nuovo viaggio");
            System.out.println("[2] Cercare un viaggio");
            System.out.println("[3] Modificare un viaggio");
            System.out.println("[0] Esci");
            switch(input.nextLine()){
                case "1":
                    manager.prenotaViaggio(viaggi);
                    break;
                case "2":
                    manager.cercaViaggio(viaggi);
                    break;
                case "3":
                    manager.modificaViaggio(viaggi);
                    break;
                case "0":
                    System.exit(0);
            }
        }
    }

    /**
     * metodo per inserire un viaggio iniziale
     * @param viaggi
     */
    private static void inserisciProva(ArrayList<Viaggio> viaggi){
        Partenza p = new Partenza("Pordenone", LocalDate.parse("2023-01-12"));
        Destinazione d = new Destinazione("Trieste", LocalDate.parse("2023-01-15"));
        CittaIntermedie ci = new CittaIntermedie(new ArrayList<String>(Arrays.asList("Udine", "Gorizia")));
        Merce m = new Merce(20, "Liquidi");
        Autocarro a = new Autocarro("Autotreno", 2);
        Viaggio v = new Viaggio(p, d, ci, m, a);
        v.setDescrizione();
        viaggi.add(v);
    }
}
