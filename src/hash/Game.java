package com.mycompany.camera.lixo;

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
        input = new Scanner(System.in);
    }

    public void start() {
        board = new Board();
        int aux = 0;
        short resultado = board.JOGO_NAO_ACABOU;

        while (resultado == board.JOGO_NAO_ACABOU) {
            jogadores[aux % 2].play(board);
            aux++;
            board.printBoard();
            resultado = board.check();
        }

        if (resultado == board.EMPATE) {
            System.out.println("Empate!");
        } else {
            System.out.println(resultado + " ganhou!");
        }

    }

}
