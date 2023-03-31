package LAB.Problema10;

public class StringSList {
    
    private final boolean empty;
    private final String first;
    private final StringSList rest;

    // lista vuota
    public static final StringSList NULL_INT_S_LIST = new StringSList();

    // costruttore per liste vuote
    public StringSList(){
        empty = true;
        first = "";
        rest = null;
    }

    public StringSList(String first, StringSList sl){      // costruttore per liste non vuote
        empty = false;
        this.first = first;
        rest = sl;
    }

    public boolean isNull(){
        return empty;
    }

    public String car(){
        return first;
    }

    public StringSList cdr(){
        return rest;
    }

    public StringSList cons(String e){
        return new StringSList(e, this);
        // con this mette l'istanza che ha fatto quella richiesta
    }

    public String toString(){   

        if(this.isNull()) {  // puoi scrivere anche solamente isNull senza il this
            return "()";
        } else {
            
            String txt = "(" + this.car();
            StringSList r = this.cdr();

            while(!r.isNull()) {
                txt += ", " + r.car();
                r =  r.cdr();
            }

            return txt + ")";
        }
    }

    public int length(){

        if (this.isNull()) {
            return 0;
        } else {
            return 1 + this.cdr().length();
        }
    }

    public boolean equals(StringSList k){

        // i primi if NON SONO UGUALI!

        if (k == null) {                   // se k è uguale a null
            return false;
        } else if (k.isNull()) {           // se k è vuota               (NULL è diverso da VUOTA)
            return isNull();
        } else if (this.isNull()) {         // se il destinatario è vuoto
            return false;
        } else if (k.car() == this.car()){      // confronta ogni volta k primo carattere
            return this.cdr().equals(k.cdr());
        } else {                            // se iniziano con elementi diversi torna false
            return false;
        }
    }

    public String listRef(int n){
        if (this.isNull()){
            return "";
        } else {
            String m = "";
            StringSList supporto = this;

            for(int i=0; i<=n; i++){
                m = supporto.car();
                supporto = supporto.cdr();              
            }

            return m;
        }
    }

    public StringSList append(StringSList e){
        if (this.isNull()){
            return e;
        } else {
            return cdr().append(e).cons(car());
        }
    }

    public StringSList reverse(){
        
        // per chiamare il metodo reverse con la ricorsione:
        // return reverseRec(NULL_INT_S_LIST);

        
        // reverse in modo imperativo

        StringSList sl = this;                 // è la lista originale
        StringSList rl = NULL_INT_S_LIST;      // è una lista vuota

        while (! sl.isNull() ) {
            rl = rl.cons(sl.car());
            sl = sl.cdr();
        }

        return rl;

    }

}
