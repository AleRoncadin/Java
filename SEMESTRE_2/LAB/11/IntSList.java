// questa classe rappresenta una lista di interi in stile di scheme.

public class IntSList {                    // Scheme-Like Lists of int


  // ----- Costante lista vuota
  public static final IntSList NULL_INTLIST = new IntSList();
  
  
  
  private final boolean empty;             
  private final int first;                 
  private final IntSList rest;
  
  
  // ----- Operazioni di base sulle liste, mutuate da Scheme

  public IntSList() {                      // creazione di una lista vuota
                                           // Scheme: null
    this.empty = true;
    this.first = 0;                             // valore irrilevante in questo caso
    this.rest = null;
  }
  
  public IntSList( int e, IntSList il ) {  // creazione di una lista non vuota:
                                           // Scheme: cons
    this.empty = false;
    this.first = e;
    this.rest = il;
  }
  
  
  public boolean isNull() {                // verifica se una lista e' vuota, in Scheme: null?
    return empty;
  }
  
  public int car() {                       // primo elemento di una lista, in Scheme: car
    return first;                          // si assume: lista non vuota
  }
  
  
  public IntSList cdr() {                  // resto di una lista, in Scheme: cdr
    return rest;                           // si assume: lista non vuota
  }
  
  public IntSList cons( int e ) {          // costruzione di nuove liste, in Scheme: cons
    return new IntSList( e, this );
  }
  
  public int length() {                    // lunghezza di una lista, in Scheme: length
    if (isNull() ) {                      
      return 0;
    } else {
      return ( 1 + cdr().length() );       
    }                                      
  }
  
  public int listRef( int k ) {            // elemento in posizione k, in Scheme: list-ref
    if ( k == 0 ) {
      return car();                        
    } else {
      return ( cdr().listRef(k-1) );       
                                           
    }
  }                                        

  public static boolean findElement(IntSList lista, int el) {

    // la funzione restituisce true se l'elemento dato come parametro è presente 
    // nella lista data anch'essa come parametro

    boolean result = false;                   // variabile di controllo che ritorneremo a fine procedura

    for( int i=0; i<lista.length(); i++ ){
      if ( el == lista.listRef(i) ) {         // se el corrisponde all'elemento in posizione i nella lista
        result = true;
      }
    }
    //  se la condizione dell'if non viene mai soddisfatta vuol dire che l'elemento non è presente
    //  per cui restituisco il valore assegnatogli inizialmente
    return result;
  }

  public boolean equals( IntSList il ) {   // contronto di liste, in Scheme: equal?

    // restituisce true se la lista è uguale alla lista data come parametro

    if ( isNull() || il.isNull() ) {
      return ( isNull() && il.isNull() );
    } else if ( car() == il.car() ) {
      return cdr().equals( il.cdr() );
    } else {
      return false;
    }
  }
  
  
  public IntSList append( IntSList il ) {  // fusione di liste, in Scheme: append

    // ritorna una nuova lista che è la concatenazione della lista originale con quella
    // data come parametro

    if ( isNull() ) {
      return il;
    } else {
      // return new IntSList( car(), cdr().append(il) );
      return ( cdr().append(il) ).cons( car() );
    }
  }
  
  
  public IntSList reverse() { // rovesciamento di una lista, in Scheme: reverse

    // restituisce una stringa rovesciata

    return reverseRec( new IntSList() );
  }
  
  private IntSList reverseRec( IntSList re ) {
  
    if ( isNull() ) {                      
      return re;
    } else {
      // return cdr().reverseRec( new IntSList(car(),re) );
      return cdr().reverseRec( re.cons(car()) );
    }
  }
  
  
  // ----- Rappresentazione testuale (String) di una lista
  public String toString() {          
    if ( isNull() ) {
      return "()";
    } else {
      String rep = "(" + car();
      IntSList r = cdr();
      while ( !r.isNull() ) {
        rep = rep + ", " + r.car();
        r = r.cdr();
      }
      return ( rep + ")" );
    }
  }


}  // class IntSList

