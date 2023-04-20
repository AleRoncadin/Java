package Lezione30_31;

/*  liste nello stile di Scheme:
    
        IntSList sl;

        Torna null:
        new IntSList() : IntSList   --> null        in Scheme

        sl.isNull()    : boolean    --> null?       in Scheme
        sl.car()       : int        --> car         in Scheme
        sl.cdr()       : IntSList   --> cdr         in Scheme
        sl.cons(n)     : IntSList   --> cons        in Scheme

        sl.length()    : int        --> length      in Scheme
        sl.equals()    : boolean    --> equal       in Scheme
        sl.listRef(i)  : int        --> list-ref    in Scheme
        sl.append(i)   : IntSList   --> append      in Scheme
        sl.reverse()   : IntSList   --> reverse     in Scheme

*/

public class IntSList {
    
    // con final posso inserire i valori solo nei costruttori, negli altri metodi no
    private final boolean empty;
    private final int first;
    private final IntSList rest;

    /**  creiamo una lista vuota:
    * il vantaggio è che abbiamo un nome simbolico quindi non dobbiamo riccorere
    * al costruttore
    */
    public static final IntSList NULL_INT_S_LIST = new IntSList();

    public IntSList(){      // costruttore per liste vuote
        empty = true;
        first = 0;
        rest = null;
    }

    public IntSList(int first, IntSList il){      // costruttore per liste non vuote
        empty = false;
        this.first = first;
        rest = il;
    }

    public IntSList(int n){      // costruttore per liste non vuote
        empty = false;
        first = n;
        rest = NULL_INT_S_LIST;
    }

    public boolean isNull(){
        return empty;
    }

    public int car(){
        return first;
    }

    public IntSList cdr(){
        return rest;
    }

    public IntSList cons(int n){
        return new IntSList(n, this);
        // con this mette l'istanza che ha fatto quella richiesta
    }

    public String toString(){   

        if(this.isNull()) {  // puoi scrivere anche solamente isNull senza il this
            return "()";
        } else {
            
            String txt = "(" + this.car();
            IntSList r = this.cdr();

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

    public boolean equals(IntSList il){

        // i primi if NON SONO UGUALI!

        if (il == null) {                   // se il è uguale a null
            return false;
        } else if (il.isNull()) {           // se il è vuota               (NULL è diverso da VUOTA)
            return isNull();
        } else if (this.isNull()) {         // se il destinatario è vuoto
            return false;
        } else if (il.car() == car()){      // confronta ogni volta il primo carattere
            return cdr().equals(il.cdr());
        } else {                            // se iniziano con elementi diversi torna false
            return false;
        }
    }

    public int listRef(int n){
        if (this.isNull()){
            return 0;
        } else {
            int m = 0;
            IntSList supporto = this;

            for(int i=0; i<=n; i++){
                m = supporto.car();
                supporto = supporto.cdr();              
            }

            return m;
        }
    }

    public IntSList append(IntSList il){
        if (this.isNull()){
            return il;
        } else {
            return cdr().append(il).cons(car());
        }
    }

    public IntSList reverse(){
        
        // chiama il metodo reverse con la ricorsione
        // return reverseRec(NULL_INT_S_LIST);

        
        // reverse in modo imperativo

        IntSList il = this;                 // è la lista originale
        IntSList rl = NULL_INT_S_LIST;      // è una lista vuota

        while (! il.isNull() ) {
            rl = rl.cons(il.car());
            il = il.cdr();
        }

        return rl;

    }

    /**
     * Reverse con la ricorsione
     */
    private IntSList reverseRec(IntSList rl){       // rl = reverse list
        if (this.isNull()){
            return rl;
        } else {
            return this.cdr().reverseRec(rl.cons(this.car()));
        }
    }
}
