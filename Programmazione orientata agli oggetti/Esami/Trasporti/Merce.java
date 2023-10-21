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
        if(q > 0)
            this.quantita = q;
    }

    public String getTipo(){
        return this.tipo.toString();
    }

    public void setTipo(String t){
        if(isElementInEnum(t))
            this.tipo = tipoMerce.valueOf(t);
    }

    private static boolean isElementInEnum(String t){
        for(tipoMerce val : tipoMerce.values()){
            if(val.name().equals(t)){
                return true;
            }
        }
        return false;
    }
}