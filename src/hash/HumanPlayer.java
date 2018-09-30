package hash;
import java.util.Scanner;

/**
 *
 * @author victor
 */
public class HumanPlayer extends Player {
    
    Scanner input;
    
    public HumanPlayer(String name, short symbol) {
        super(name, symbol);
        input = new Scanner(System.in);
    }


    @Override
    public void play(Board board) {
        while (!board.play(input.nextInt(), input.nextInt(), symbol)) {
            System.out.println("Jogada inválida! Tente novamente...");
        }
    }
}
