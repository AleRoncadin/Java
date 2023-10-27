package Trasporti;

public class Autocarro {
    public enum tipoAutocarro{
        Auto_SW,
        Scudo,
        Furgone,
        Furgone_Centinato,
        Motrice,
        Bilico,
        Mega,
        Autotreno
    }

    private tipoAutocarro tipo;
    private int numeroAutocarri;

    public Autocarro(String t, int n){
        this.setTipo(t);
        this.setNumeroAutocarri(n);
    }

    public tipoAutocarro getTipo(){
        return this.tipo;
    }

    public void setTipo(String t){
        this.tipo = tipoAutocarro.valueOf(t);
    }

    public int getNumeroAutocarri(){
        return this.numeroAutocarri;
    }

    public void setNumeroAutocarri(int n){
        this.numeroAutocarri = n;
    }

    /**
     * verifica se un certo valore è presente nell'enum contenente tipi di autocarri
     * @param t stringa data in input
     */
    public static boolean isTipoInEnum(String t){
        for(tipoAutocarro val : tipoAutocarro.values()){
            if(val.name().equals(t)){
                return true;
            }
        }
        return false;
    }
}
