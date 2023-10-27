package Trasporti;

public interface Citta {

    public static enum partenzeDestinazioni {
        Udine,
        Pordenone,
        Gorizia,
        Trieste,
        Padova,
        Venezia,
        Verona,
        Milano,
        Trentino,
        Piemonte,
        Aosta,
        Brescia,
        Torino
    }

    /**
     * metodo per verificare se un certo valore è presente
     * nell'enum contenente i nomi delle citta
     * @param t stringa data in input
     */
    public static boolean isCittaInEnum(String t){
        for(partenzeDestinazioni val : partenzeDestinazioni.values()){
            if(val.name().equals(t)){
                return true;
            }
        }
        return false;
    }
}
