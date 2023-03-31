package LAB.Problema10;
import LAB.Esercitazione.btrTranslate;

public class btr_List {

    public static StringSList listaBTR(String btr, int n){

        if (btr.isEmpty() || n == 0){
            return StringSList.NULL_INT_S_LIST;

        } else if (btr == ""){

            StringSList lista = StringSList.NULL_INT_S_LIST;
            
            for(int i=0; i<=n; i++){
                lista = lista.cons("");
            }

            return lista;

        } else {

            StringSList lista = StringSList.NULL_INT_S_LIST;
            String btr_succ = btr;

            for(int i=0; i<n; i++){
                lista = lista.cons(btr_succ);
                btr_succ = btrTranslate.btrSucc(btr_succ);
            }

            return lista.reverse();
        }

    }

    

}
