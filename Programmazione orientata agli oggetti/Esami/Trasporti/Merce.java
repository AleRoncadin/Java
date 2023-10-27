package Trasporti;

public class Merce {

    public enum tipoMerce {
        Colli_fusi,
        Liquidi,
        Gas,
        Da_frigo
    }

    private double quantita;
    private tipoMerce tipo;

    public Merce(double q, String t){
        this.setQuantita(q);
        this.setTipo(t);
    }

    public double getQuantita(){
        return this.quantita;
    }

    public void setQuantita(double q){
        this.quantita = q;
    }

    public String getTipo(){
        return this.tipo.toString();
    }

    public void setTipo(String t){
        this.tipo = tipoMerce.valueOf(t);
    }

    /**
     * verifica se un certo valore è presente nell'enum contenente tipi di merci
     * @param t stringa data in input
     */
    public static boolean isTipoInEnum(String t){
        for(tipoMerce val : tipoMerce.values()){
            if(val.name().equals(t)){
                return true;
            }
        }
        return false;
    }
}