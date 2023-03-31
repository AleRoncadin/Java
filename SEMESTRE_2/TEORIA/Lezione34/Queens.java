package Lezione34;

/*
 * Board b;
 * 
 * b = new Board(n);            [scacchiera vuota dimensione nxn]
 * 
 * b.size(); : int              [dimensione della scacchiera, cioè n]
 * 
 * b.queensOn(); : int          [è il numero delle regine]
 * 
 * b.underAttack(i, j); : bool  [dice se la casella è sotto attacco]
 * 
 * b.addQueen(i, j); : Board    [i, j sono le coordinate e arrivano fino a n]
 * 
 * b.arrangement();  : String
 * 
 */

public class Queens{
    public static void main(String args[]){

    }

    public static BoardSList listaDiSoluzioni(int n){
        return listaDiCompletamenti(new Board(n));
    }

    private static BoardSList listaDiCompletamenti(Board b){
        int n = b.size();
        int q = b.queensOn();

        if(q == n){
            return BoardSList.NULL_BOARDLIST.cons(b);
        } else {
            int i = q + 1;
            BoardSList list = BoardSList.NULL_BOARDLIST;

            for(int j = 1; j <= n; j++){

                if( !b.underAttack(i,j) ){
                    b.addQueen(i,j);        
                    list = list.append(listaDiCompletamenti(b.addQueen(i,j)));
                }
            }

            return list;
        }
    }
}