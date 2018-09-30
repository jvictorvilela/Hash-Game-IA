package hash;

/**
 *
 * @author victor
 */
public class Main {
    final static short X = 1;
    final static short O = 2;
    public static void main(String[] args) {
        Game game = new Game();
        Player p1 = new HumanPlayer("Jogador Humano", X);
        Player p2 = new MinimaxPlayer("Inteligência Artificial", O);
        game.start(p1, p2);
    }
    
}
