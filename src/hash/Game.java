package hash;

import java.util.Scanner;

/**
 *
 * @author victor
 */
public class Game {

    Scanner input;
    Board board;
    final Player[] jogadores;

    public Game(Player p1, Player p2) {
        jogadores = new Player[2];
        jogadores[0] = p1;
        jogadores[1] = p2;
        board = new Board();
        input = new Scanner(System.in);
    }

    public void start() {
        int aux = 0;
        short check;
        boolean fim = false;
        while (!fim) {
            jogadores[aux % 2].play(board);

            aux++;
            board.printBoard();
            check = board.check();
            switch (check) {
                case (1):
                    System.out.println(jogadores[0].getName() + " ganhou!");
                    break;
                case (2):
                    System.out.println(jogadores[1].getName() + " ganhou!");
                    break;
                case (-1):
                    System.out.println("Empate!");

                    break;
            }
            fim = check != 0;
        }

    }

}
