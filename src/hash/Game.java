package hash;

import java.util.Scanner;

/**
 *
 * @author victor
 */
public class Game {
    
    Scanner input;
    Board board;
    public Game() {
        board = new Board();
        input = new Scanner(System.in);
    }
    

    public void start(Player player1, Player player2) {
        int aux = 0;
        short check;
        boolean fim = false;
        while(!fim) {
            
            if (aux%2 == 0) {
                System.out.println("Vez de "+player1.getName()+" ("+player1.getSymbolName()+") :");
                player1.play(board);
            } else {
                System.out.println("Vez de "+player2.getName()+" ("+player2.getSymbolName()+") :");
                player2.play(board);
            }
            
            aux++;
            System.out.println("");
            board.printBoard();
            System.out.println("");
            check = board.check();
            switch (check) {
                case (1) :
                    if (player1.getSymbol() == 1) {
                        System.out.println(player1.getName()+" ganhou!");
                    } else {
                        System.out.println(player2.getName()+" ganhou!");

                    }
                    fim = true;
                    break;
                case (2) :
                    if (player1.getSymbol() == 2) {
                        System.out.println(player1.getName()+" ganhou!");
                    } else {
                        System.out.println(player2.getName()+" ganhou!");

                    }                       
                    fim = true;
                    break;
                case (-1) :
                    System.out.println("Empate!");
                    fim = true;
                    break;
            }
        }
        
    }
    
    
    
    
}
