package Trasporti;

public class Viaggio {
    private static int numeroViaggi = 0;
    private Partenza partenza;
    private Destinazione destinazione;
    private CittaIntermedie cittaIntermedie;
    private Merce merce;
    private Autocarro autocarro;
    private String descrizione;

    // costruttore per viaggi SENZA città intermedie
    public Viaggio(Partenza p, Destinazione d, Merce m, Autocarro a){
        this.setPartenza(p);
        this.setDestinazione(d);
        this.setMerce(m);
        this.setAutocarro(a);
        this.setDescrizione();
    } 

    // costruttore per viaggi CON città intermedie
    public Viaggio(Partenza p, Destinazione d, CittaIntermedie ci, Merce m, Autocarro a){
        this.setPartenza(p);
        this.setDestinazione(d);
        this.setCittaIntermedie(ci);
        this.setMerce(m);
        this.setAutocarro(a);
        this.setDescrizione();
    }    

    public Partenza getPartenza(){
        return this.partenza;
    }

    public void setPartenza(Partenza p){
        this.partenza = p;
    }

    public Destinazione getDestinazione(){
        return this.destinazione;
    }

    public void setDestinazione(Destinazione d){
        this.destinazione = d;
    }

    public CittaIntermedie getCittaIntermedie(){
        return this.cittaIntermedie;
    }

    public void setCittaIntermedie(CittaIntermedie ci){
        this.cittaIntermedie = ci;
    }

    public Merce getMerce(){
        return this.merce;
    }

    public void setMerce(Merce m){
        this.merce = m;
    }

    public Autocarro getAutocarro(){
        return this.autocarro;
    }

    public void setAutocarro(Autocarro a){
        this.autocarro = a;
    }

    public String getDescrizione(){
        return this.descrizione;
    }

    public void setDescrizione(){
        this.descrizione = "Viaggio n. " + numeroViaggi + "\n "
                    + "Partenza: " + partenza.getCittaPartenza() + " " + partenza.getDataPartenza() + "\n"
                    + "Destinazione: " + destinazione.getCittaDestinazione() + " " + destinazione.getDataDestinazione() + "\n"
                    + "Citta Intermedie: " + cittaIntermedie.getCittaIntermedie() + "\n"
                    + "Merce: " + merce.getTipo() + ", " + merce.getQuantita() + " kg";
    }
}
