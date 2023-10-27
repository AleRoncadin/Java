package Trasporti;

import java.time.LocalDate;

public class Destinazione implements Citta{

    private partenzeDestinazioni cittaDestinazione;
    private LocalDate dataDestinazione;

    public Destinazione(String d, LocalDate dd){
        this.setCittaDestinazione(d);
        this.setDataDestinazione(dd);
    }

    public String getCittaDestinazione() {
        return cittaDestinazione.toString();
    }

    public void setCittaDestinazione(String d) {
        this.cittaDestinazione = partenzeDestinazioni.valueOf(d);
    }

    public LocalDate getDataDestinazione(){
        return dataDestinazione;
    }

    public void setDataDestinazione(LocalDate dd){
        this.dataDestinazione = dd;
    }

}
