package Trasporti;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    static Scanner input = new Scanner(System.in); // Create a Scanner object

    /**
     * prenota un nuovo viaggio inserendo tutte le informazioni necessarie (partenza, destinazione, merce, autocarro)
     * @param viaggi lista dei viaggi
     */
    public void prenotaViaggio(ArrayList<Viaggio> viaggi) {
        Partenza partenza = impostaPartenza();
        Destinazione destinazione = impostaDestinazione();
        CittaIntermedie cittaIntermedie = impostaCittaIntermedie();
        Merce merce = impostaMerce();
        Autocarro autocarro = impostaAutocarro();
        Viaggio viaggio = new Viaggio(partenza, destinazione, cittaIntermedie, merce, autocarro);
        viaggio.setDescrizione();
        viaggi.add(viaggio);

    }

    /**
     * cerca un viaggio tra quelli disponibili in base alla partenza, destinazione o autocarro
     * @param viaggi lista dei viaggi
     */
    public void cercaViaggio(ArrayList<Viaggio> viaggi) {
        System.out.println("Come vuoi cercare il viaggio prenotato?");
        System.out.println("[1] Per citta di partenza");
        System.out.println("[2] Per data di partenza");
        System.out.println("[3] Per citta di destinazione");
        System.out.println("[4] Per data di destinazione");
        System.out.println("[5] Per autocarro");
        switch (input.nextLine()) {
            case "1":
                cercaViaggioCittaPartenza(viaggi);
                break;
            case "2":
                cercaViaggioDataPartenza(viaggi);
                break;
            case "3":
                cercaViaggioCittaDestinazione(viaggi);
                break;
            case "4":
                cercaViaggioDataDestinazione(viaggi);
                break;
            case "5":
                cercaViaggioTipoAutocarro(viaggi);
                break;
            default:
                System.out.println("Errore");
        }
    }

    /**
     * modifica un viaggio esistente cambiando le sue informazioni
     * @param viaggi lista dei viaggi
     */
    public void modificaViaggio(ArrayList<Viaggio> viaggi) {
        System.out.println("Che viaggio vuoi modificare?");
        stampaViaggi(viaggi);
        while (true) {
            try {
                int nViaggio = Integer.parseInt(input.nextLine());
                if (nViaggio < 0 || nViaggio > viaggi.size()) {
                    System.out.println("Indice errato, riprova");
                } else {
                    modificaViaggioSelezionato(nViaggio, viaggi);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Errore");
                modificaViaggio(viaggi);
            }
        }
    }

    /**
     * metodo ausiliario per "modificaViaggio" per cambiare le informazioni del viaggio selezionato
     * @param nViaggio ID del viaggio selezionato
     * @param viaggi lista dei viaggi
     */
    public void modificaViaggioSelezionato(int nViaggio, ArrayList<Viaggio> viaggi){
        System.out.println("Modificare viaggio n. " + nViaggio);
        viaggi.get(nViaggio).setPartenza(impostaPartenza()); // cambia partenza
        viaggi.get(nViaggio).setDestinazione(impostaDestinazione()); // cambia partenza
        System.out.println("Viaggio n. " + nViaggio + " modificato:");
        viaggi.get(nViaggio).getDescrizione();
    }

    /**
     * stampa la Descrizionerizione di ogni viaggio (il suo ID, partenza, destinazione, merce, autocarro)
     * @param viaggi lista dei viaggi
     */
    public void stampaViaggi(ArrayList<Viaggio> viaggi) {
        for (Viaggio v : viaggi) {
            System.out.println("------------------------------------------------");
            System.out.println(v.getDescrizione());
        }
        System.out.println("------------------------------------------------");
    }

    /**
     * imposta la data e la città di partenza
     * @return oggetto Partenza con citta e data di partenza
     */
    public Partenza impostaPartenza() {
        String cittaPartenza;

        while (true) {
            System.out.println("Inserisci la città di partenza: ");
            String p = input.nextLine();
            if (Citta.isCittaInEnum(p)) {
                cittaPartenza = p;
                break;
            } else {
                System.out.println("Città non presente");
            }
        }

        LocalDate dataPartenza = controllaData("partenza");        
        return new Partenza(cittaPartenza, dataPartenza);
    }

    /**
     * imposta la data e la città di destinazione
     * @return oggetto Destinazione con citta e data di destinazione
     */
    public Destinazione impostaDestinazione() {
        String cittaDestinazione;

        while (true) {
            System.out.println("Inserisci la città di destinazione: ");
            String d = input.nextLine();
            if (Citta.isCittaInEnum(d)) {
                cittaDestinazione = d;
                break;
            } else {
                System.out.println("Città non presente");
            }
        }

        LocalDate dataDestinazione = controllaData("destinazione");
        return new Destinazione(cittaDestinazione, dataDestinazione);
    }

    /**
     * imposta la citta intermedie percorse durante il viaggio
     * @return oggetto CittaIntermedie con all'interno la lista delle citta percorse nel viaggio
     */
    public CittaIntermedie impostaCittaIntermedie() {
        ArrayList<String> cittaList = new ArrayList<>();

        while (true) {
            System.out.println("Inserire citta intermedie? ('n' per uscire dal loop)");
            String nomeCitta = input.nextLine();
            if (nomeCitta.startsWith("n")) {
                break;
            } else if (Citta.isCittaInEnum(nomeCitta)) {
                cittaList.add(nomeCitta);
            } else {
                System.out.println("Città non presente");
            }
        }

        // mettere un controllo se la lista è vuota
        try{
            return new CittaIntermedie(cittaList);
        } catch (Exception e){
            System.out.println("Errore");
            return impostaCittaIntermedie();
        }
        
    }

    /**
     * imposta la quantità in kg e il tipo di merce che viene trasportata
     * @return oggetto Merce con quantità in kg e il tipo di merce
     */
    public Merce impostaMerce() {
        double quantita;
        String tipoMerce;
        while (true) {
            System.out.println("Inserisci il tipo di merce: ");
            String t = input.nextLine();
            if (Merce.isTipoInEnum(t)) {
                tipoMerce = t;
                break;
            } else {
                System.out.println("Questo tipo non esiste");
            }
        }

        while (true) {
            System.out.println("Inserisci la quantita di merce: ");
            try {
                double q = Double.parseDouble(input.nextLine());
                if (q > 0) {
                    quantita = q;
                    break;
                } else {
                    System.out.println("Inserisci un dato valido");
                }
            } catch (Exception e) {
                System.out.println("Inserisci un dato valido");
                continue;
            }
        }

        return new Merce(quantita, tipoMerce);
    }

    /**
     * imposta il numero e il tipo di autocarri
     * @return oggetto Autocarro con numero e tipo
     */
    public Autocarro impostaAutocarro(){
        int numeroAutocarri;
        String tipoAutocarro;
        while (true) {
            System.out.println("Inserisci il tipo di autocarro: ");
            String t = input.nextLine();
            if (Autocarro.isTipoInEnum(t)) {
                tipoAutocarro = t;
                break;
            } else {
                System.out.println("Questo tipo non esiste");
            }
        }

        while (true) {
            System.out.println("Inserisci il numero di autocarri: ");
            try {
                int n = Integer.parseInt(input.nextLine());
                if (n > 0) {
                    numeroAutocarri = n;
                    break;
                } else {
                    System.out.println("Inserisci un dato valido");
                }
            } catch (Exception e) {
                System.out.println("Inserisci un dato valido");
                continue;
            }
        }

        return new Autocarro(tipoAutocarro, numeroAutocarri);
    }

    /**
     * cerca un viaggio in base alla citta di partenza
     * @param viaggi lista dei viaggi
     * @return descrizione del viaggio, quindi restituisce tutte le sue informazioni
     */
    public String cercaViaggioCittaPartenza(ArrayList<Viaggio> viaggi) {
        System.out.println("Inserisci la citta di partenza: ");
        String cittaPartenza = input.nextLine();

        for (Viaggio v : viaggi) {
            if (v.getPartenza().getCittaPartenza().equals(cittaPartenza)) {
                return v.getDescrizione();
            }
        }
        return "Nessun viaggio con quella città di partenza";
    }

    /**
     * cerca un viaggio in base alla data di partenza
     * @param viaggi lista dei viaggi
     * @return descrizione del viaggio, quindi restituisce tutte le sue informazioni
     */
    public String cercaViaggioDataPartenza(ArrayList<Viaggio> viaggi) {

        LocalDate dataPartenza = controllaData("partenza");


        for (Viaggio v : viaggi) {
            if (v.getPartenza().getDataPartenza().equals(dataPartenza)) {
                return v.getDescrizione();
            }
        }
        return "Nessun viaggio con quella data di partenza";
    }

    /**
     * cerca un viaggio in base alla citta di destinazione
     * @param viaggi lista dei viaggi
     * @return descrizione del viaggio, quindi restituisce tutte le sue informazioni
     */
    public String cercaViaggioCittaDestinazione(ArrayList<Viaggio> viaggi) {
        System.out.println("Inserisci la citta di destinazione: ");
        String cittaDestinazione = input.nextLine();

        for (Viaggio v : viaggi) {
            if (v.getDestinazione().getCittaDestinazione().equals(cittaDestinazione)) {
                return v.getDescrizione();
            }
        }
        return "Nessun viaggio con quella città di destinazione";
    }

    /**
     * cerca un viaggio in base alla data di destinazione
     * @param viaggi lista dei viaggi
     * @return descrizione del viaggio, quindi restituisce tutte le sue informazioni
     */
    public String cercaViaggioDataDestinazione(ArrayList<Viaggio> viaggi) {
        
        LocalDate dataDestinazione = controllaData("destinazione");


        for (Viaggio v : viaggi) {
            if (v.getDestinazione().getDataDestinazione().equals(dataDestinazione)) {
                return v.getDescrizione();
            }
        }
        return "Nessun viaggio con quella data di destinazione";
    }

    /**
     * cerca un viaggio in base al tipo di autocarro
     * @param viaggi lista dei viaggi
     * @return descrizione del viaggio, quindi restituisce tutte le sue informazioni
     */
    public String cercaViaggioTipoAutocarro(ArrayList<Viaggio> viaggi) {
        String tipo;

        while(true){
            System.out.println("Inserisci il tipo di autocarro: ");
            tipo = input.nextLine();  
            if(Autocarro.isTipoInEnum(tipo)){
                break;
            }              
            else{
                System.out.println("Questo tipo non esiste");
            }              
        }
        
        for (Viaggio v : viaggi) { // viaggi è un ArrayList contenente oggetti Viaggio
            if (v.getAutocarro().getTipo().equals(Autocarro.tipoAutocarro.valueOf(tipo))) {
                //return v.getDescrizione();
                return "viaggio trovato";
            }
        }
        return "Nessun autocarro di quel tipo è in viaggio";
    }

    /**
     * controlla la data che viene inserita dal manager (di partenza e destinazione) per evitare crash del programma
     * @param val stringa che contiene il valore "partenza" o "destinazione"
     * @return restituisce la data
     */
    private LocalDate controllaData(String val){

        LocalDate data;

        while(true){
            try{
                System.out.println("Inserisci la data di " + val + ": ");
                data = LocalDate.parse(input.nextLine());
                break;
            } catch (Exception e){
                System.out.println("Devi inserire una data corretta (yyyy-mm-dd)");
                continue;
            }         
        }

        return data;
    }
}
