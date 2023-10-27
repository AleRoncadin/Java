package Trasporti;

import java.util.ArrayList;

import Trasporti.Citta.partenzeDestinazioni;

public class CittaIntermedie {
    private partenzeDestinazioni[] cittaIntermedie;
    
    public CittaIntermedie(ArrayList<String> citta){
        this.setCittaIntermedie(citta);
    }

    public ArrayList<String> getCittaIntermedie(){
        ArrayList<String> nomiCitta = new ArrayList<>();  // array list per stampare le altre mete
        for(int i = 0; i < cittaIntermedie.length; i++){
            nomiCitta.add(cittaIntermedie[i].name());
        }
        return nomiCitta;
    }
    

    public void setCittaIntermedie(ArrayList<String> nomiCitta){
        this.cittaIntermedie = new partenzeDestinazioni[nomiCitta.size()];
        for(int i = 0; i < nomiCitta.size(); i++){
            this.cittaIntermedie[i] = partenzeDestinazioni.valueOf(nomiCitta.get(i));
        }
    }
}
