package StudentePrincipale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Principale_ {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        Studente studente = new Studente();
        Studente studente2 = new Studente("Giovanni", "Bortolussi", LocalDate.of(2005, 10, 20), "4B", "IA");
        inserisciInformazioni(studente);
        System.out.println("------------------------------------");
        stampaInformazioni(studente);
        System.out.println("------------------------------------");
        stampaInformazioni(studente2);
    }

    private static void inserisciInformazioni(Studente studente) throws Exception, IOException {
        // Prendi in input il nome e lo setta all'oggetto studente
        System.out.println("Inserisci il nome dello studente: ");
        String nome = reader.readLine();
        studente.setNome(nome);
 
        // Prendi in input il cognome e lo setta all'oggetto studente
        System.out.println("Inserisci il cognome dello studente: ");
        studente.setCognome(reader.readLine());
           
        // Prendi in input la data di nascita e lo setta all'oggetto studente
		try{
			System.out.println("Inserisci l'anno di nascita dello studente: ");
            int anno = Integer.parseInt(reader.readLine());
            System.out.println("Inserisci il mese di nascita dello studente: ");
            int mese = Integer.parseInt(reader.readLine());
            System.out.println("Inserisci il giorno di nascita dello studente: ");
            int giorno = Integer.parseInt(reader.readLine());
            studente.setDataNascita(anno, mese, giorno);
		} catch(Exception e){
			System.err.println("Inserisci una data valida: " + e.getMessage());
		}

        // Prendi in input la classe e lo setta all'oggetto studente
        System.out.println("Inserisci la classe dello studente: ");
        studente.setClasse(reader.readLine());
    
        // Prendi in input la specializzazione e lo setta all'oggetto studente
        try{
            System.out.println("Inserisci la specializzazione dello studente: ");
            studente.setSpecializzazione(reader.readLine());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    }

    private static void stampaInformazioni(Studente studente) {
        try {
            System.out.println(studente.toString());
        } catch (Exception e) {
            System.err.println("Impossibile stampare dati: " + e.getMessage());
        }
    }
}