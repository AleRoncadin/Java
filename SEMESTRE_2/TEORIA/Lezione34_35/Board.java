package Lezione34_35;

import java.util.function.*;

// per poter usare variabili di istanza di tipo procedurale importo quel
// package

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

public class Board {

    // queste variabile possono essere private
    private static final String ROWS = "0123456789ABCDEF";
    private static final String COLS = "abcdefghijklmno";
    private final int size;
    private final int queens;     // numero di regine

    // BiPredicate si trova dentro la libreria importata
    private final BiPredicate<Integer,Integer> attack;

    private final String config;
    
    public Board(int n){
        this.size = n;
        this.queens = 0;
        this.attack = (x, y) -> false;   // (lambda (x, y) false) in scheme
        this.config = " ";
    }

    private Board(int n, int q, BiPredicate<Integer,Integer> a, String c){
        this.size = n;
        this.queens = q;
        this.attack = a;
        this.config = c;
    }

    public int size(){
        return this.size;
    }

    public int queensOn(){
        return this.queens;
    }

    public boolean underAttack(int i, int j){
        return attack.test(i, j);    // (attack i j) in scheme
    }

    public Board addQueen(int i, int j){
        return new Board(
                        this.size, 
                        this.queens+1, 
                        (x, y) -> (x == i) || (y == j) 
                                    || (x-y == i-j) || (x+y == i+j)
                                    || attack.test(x, y), 
                        config + COLS.charAt(j) + ROWS.charAt(i) + " "
                        );
    }

    public String arrangement(){
        return config;
    }

    public String toString(){
        return "[" + arrangement() + "]";
    }
}