package SEMESTRE_2.LAB.Esercitazione_Codifica_Java;

public class Es2 {
    public static void main(String args[]){
        String compl = onesComplement("101001100");
        System.out.println(compl);
    }
    
    public static String onesComplement(String bin){
        
        String compl = "";

        for(int i = 0; i < bin.length(); i++){
            compl += (bin.charAt(i) == '0') ? ('1') : ('0');           
        }

        return compl;
    }
}

/*if (bin.charAt(i) == '0'){
                compl += '1';
            }
            else{
                compl += '0';
            }*/