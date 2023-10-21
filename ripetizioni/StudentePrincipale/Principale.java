package StudentePrincipale;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Principale {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        // crea due oggetti Studente
        Studente studente = new Studente();
        Studente studente2 = new Studente("Giovanni", "Bortolussi", LocalDate.of(2005, 10, 05), "4B", "IA");
        try {
            inserisciInformazioni(studente);
            System.out.println("------------------ STUDENTE 1 ------------------");
            stampaInformazioni(studente);
            System.out.println("------------------ STUDENTE 2 ------------------");
            stampaInformazioni(studente2);
            
        } catch (Exception e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }

    private static void inserisciInformazioni(Studente studente) throws Exception {
        try {
            inserimentoNome(studente);
            inserimentoCognome(studente);
            inserimentoData(studente);
            inserimentoClasse(studente);
            inserimentoSpecializzazione(studente);
        } catch (Exception e) {
            System.err.println("Errore: " + e.getMessage());
            inserisciInformazioni(studente); // Richiedi all'utente di reinserire i dati in caso di errore
        }
    }

    private static void inserimentoNome(Studente studente){
        while(true){
            try {
                System.out.println("Inserisci il nome dello studente");
                String nome = reader.readLine();
                if (nome != null && !nome.isEmpty()) { // controllo validità input
                    studente.setNome(nome);
                    break; // esci dal while
                } else {
                    System.err.println("Nome non valido, riprova.");
                }
            } catch (Exception e) {
                System.err.println("Errore: " + e.getMessage());
            }
        }
    }

    private static void inserimentoCognome(Studente studente){
        while(true){
            try {
                System.out.println("Inserisci il cognome dello studente");
                String cognome = reader.readLine();
                if (cognome != null && !cognome.isEmpty()) { // controllo validità input
                    studente.setCognome(cognome);
                    break; // esci dal while
                } else {
                    System.err.println("Cognome non valido, riprova.");
                }
            } catch (Exception e) {
                System.err.println("Errore: " + e.getMessage());
            }
        }
    }

    private static void inserimentoData(Studente studente){
        while(true){
            try {
                System.out.println("Inserisci l'anno di nascita");
                int anno = Integer.parseInt(reader.readLine());
                System.out.println("Inserisci il mese di nascita");
                int mese = Integer.parseInt(reader.readLine());
                System.out.println("Inserisci il giorno di nascita");
                int giorno = Integer.parseInt(reader.readLine());

                // controlla se l'input inserito ha senso
                if (anno >= 1970 && anno <= 2015 && mese >= 1 && mese <= 12
				    && giorno >= 1 && giorno <= 31) {
                        studente.setDataNascita(anno, mese, giorno);
                        break; // termina il while
                } else {
                    System.out.println("Data non valida");
                }
            } catch (Exception e){
                System.err.println(e.getMessage());
                continue; // ritorna all'inizio del while
            }
        }
    }

    private static void inserimentoClasse(Studente studente){
        while (true) {
            try {
                System.out.println("Inserisci la classe dello studente: ");
                String classe = reader.readLine();
                // controlla se la classe è null o vuota
                if (classe != null && !classe.isEmpty()) {
                    // controlla se la classe ha lunghezza 2
                    if(classe.length() == 2){
                        char firstChar = classe.charAt(0); // deve essere un numero (1-5)
                        char secondChar = classe.charAt(1); // deve essere una lettera

                        // controlla se il primo carattere è un numero compreso tra 1 e 5
                        // e se il secondo carattere è una lettera
                        if (firstChar >= '1' && firstChar <= '5' && Character.isLetter(secondChar)) {
                            studente.setClasse(classe);
                            break;
                        } else {
                            System.err.println("Classe non valida, riprova.");
                        }
                    } else {
                        System.err.println("Lunghezza errata, riprova");
                    }
                } else {
                    System.err.println("Classe nulla, riprova.");
                }
            } catch (Exception e) {
                System.err.println("Errore: " + e.getMessage());
            }
        }
    }

    private static void inserimentoSpecializzazione(Studente studente) {
        boolean flag = true; // variabile booleana ausiliaria per uscire nel while sotto
        
        while (flag) {
            try {
                System.out.println("Inserisci la specializzazione dello studente: ");
                String specializzazione = reader.readLine();

                if (specializzazione != null) {
                    switch (specializzazione.toUpperCase()) {
                        case "IA":
                        case "ET":
                        case "MM":
                        case "MP":
                        case "CM":
                            studente.setSpecializzazione(specializzazione);
                            flag = false; // per uscire dal while
                            break;           
                        default:
                            System.err.println("Specializzazione non valida, riprova.");
                    }
                } else{
                    System.err.println("Specializzazione non valida, riprova.");
                }
            } catch (Exception e){
                System.err.println("Errore: " + e.getMessage());
            }
        }

    }

    private static void stampaInformazioni(Studente studente) {
        try{
            System.out.println(studente.toString());
        } catch (Exception e){
            System.err.println("Errore: " + e.getMessage());
        }
        
    }
}
