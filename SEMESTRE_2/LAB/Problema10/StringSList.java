package SEMESTRE_2.LAB.Problema10;

public class StringSList {

    // costante di lista vuota
    public static final StringSList NULL_STRINGLIST = new StringSList();
    
    // variabili di istanza
    private final boolean empty;
    private final String first;
    private final StringSList rest;

    public StringSList(){
        empty = true;
        first = "";                             // valore irrilevante in questo caso
        rest = null;
    }

    public StringSList(String e, StringSList sl){
        empty = false;
        first = e;
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

    public StringSList cons( String e ){
        return new StringSList( e, this );
    }

    public int length(){
        if (isNull()){
            return 0;
        } else {
            return (1 + cdr().length());
        }
    }

    public String listRef( int k ){
        if (k==0){
            return car();
        } else {
            return ( cdr().listRef(k-1) );
        }
    }

    public boolean equals( StringSList sl ){
        if ( isNull() || sl.isNull() ) {
            return ( isNull() && sl.isNull() );
          } else if ( car() == sl.car() ) {
            return cdr().equals( sl.cdr() );
          } else {
            return false;
          }
    }

    public StringSList append( StringSList sl ){
        if ( isNull() ) {
            return sl;
          } else {
            // return new IntSList( car(), cdr().append(il) );
            return ( cdr().append(sl) ).cons( car() );
          }
    }

    public StringSList reverse(){
        if(isNull()){
            return NULL_STRINGLIST;
        } else {
            return cdr().reverse();
        }
    }

    public String toString(){
        if ( isNull() ) {
            return "()";
          } else {
            String rep = "(" + car();
            StringSList r = cdr();
            while ( !r.isNull() ) {
              rep = rep + ", " + r.car();
              r = r.cdr();
            }
            return ( rep + ")" );
          }
    }
}
