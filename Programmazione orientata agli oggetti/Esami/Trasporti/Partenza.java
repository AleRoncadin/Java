package Trasporti;

import java.time.LocalDate;

public class Partenza implements Citta{

    private partenzeDestinazioni cittaPartenza;
    private LocalDate dataPartenza;

    public Partenza(String d, LocalDate dd){
        this.setCittaPartenza(d);
        this.setDataPartenza(dd);
    }

    public String getCittaPartenza() {
        return cittaPartenza.toString();
    }

    public void setCittaPartenza(String d) {
        this.cittaPartenza = partenzeDestinazioni.valueOf(d);
    }

    public LocalDate getDataPartenza(){
        return dataPartenza;
    }

    public void setDataPartenza(LocalDate dd){
        this.dataPartenza = dd;
    }

}
