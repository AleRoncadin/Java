package SEMESTRE_2.LAB.Problema11;

/*  liste nello stile di Scheme:
    
        SList<T> sl;
        T e;

        Torna null:
        new SList<T>() : SList<T>   --> null        in Scheme

        sl.isNull()    : boolean    --> null?       in Scheme
        sl.car()       : T          --> car         in Scheme
        sl.cdr()       : SList<T>   --> cdr         in Scheme
        sl.cons(e)     : SList<T>   --> cons        in Scheme

        sl.length()    : int        --> length      in Scheme
        sl.equals()    : boolean    --> equal       in Scheme
        sl.listRef(i)  : T          --> list-ref    in Scheme
        sl.append(i)   : SList<T>   --> append      in Scheme
        sl.reverse()   : SList<T>   --> reverse     in Scheme

*/

public class SList<T> {
    
    // con final posso inserire i valori solo nei costruttori, negli altri metodi no
    //private final boolean empty;
    private final T first;
    private final SList<T> rest;

    /**  creiamo una lista vuota:
    * il vantaggio è che abbiamo un nome simbolico quindi non dobbiamo riccorere
    * al costruttore
    */
    //public static final SList<T> NULL_INT_S_LIST = new SList();

    public SList(){      // costruttore per liste vuote
        //empty = true;
        first = null;
        rest = null;
    }

    public SList(T e, SList<T> sl){      // costruttore per liste non vuote
        //empty = false;
        this.first = e;
        rest = sl;
    }

    public boolean isNull(){
        return (first == null);
    }

    public T car(){
        return first;
    }

    public SList<T> cdr(){
        return rest;
    }

    public SList<T> cons(T e){
        return new SList<T>(e, this);
        // con this mette l'istanza che ha fatto quella richiesta
    }

    public String toString(){   

        if(this.isNull()) {  // puoi scrivere anche solamente isNull senza il this
            return "()";
        } else {
            
        String txt = "(" + this.car();
        SList<T> r = this.cdr();

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

    public boolean equals (SList<T> sl){

        // i primi if NON SONO UGUALI!

        if (sl == null) {                   // se il è uguale a null
            return false;
        } else if (sl.isNull()) {           // se il è vuota               (NULL è diverso da VUOTA)
            return isNull();
        } else if (this.isNull()) {         // se il destinatario è vuoto
            return false;
        } else if (sl.car().equals(car())){      // confronta ogni volta il primo carattere
            return cdr().equals(sl.cdr());
        } else {                            // se iniziano con elementi diversi torna false
            return false;
        }
    }

    public T listRef(int n){
        if (this.isNull()){
            return null;
        } else {

            T m = null;
            SList<T> supporto = this;

            for(int i=0; i<=n; i++){
                m = supporto.car();
                supporto = supporto.cdr();              
            }

            return m;
        }
    }

    public SList<T> append (SList<T> sl){
        if (this.isNull()){
            return sl;
        } else {
            return cdr().append(sl).cons(car());
        }
    }

    public SList<T> reverse(){
        
        // chiama il metodo reverse con la ricorsione
        // return reverseRec(NULL_INT_S_LIST);

        
        // reverse in modo imperativo

        SList<T> sl = this;                 // è la lista originale
        SList<T> rl = new SList<T>();      // è una lista vuota

        while (! sl.isNull() ) {
            rl = rl.cons(sl.car());
            sl = sl.cdr();
        }

        return rl;

    }

    /**
     * Reverse con la ricorsione
     */
    private SList<T> reverseRec (SList<T> rl){       // rl = reverse list
        if (this.isNull()){
            return rl;
        } else {
            return this.cdr().reverseRec(rl.cons(this.car()));
        }
    }
}
