package hash;

/**
 *
 * @author victor
 */
public class Main {
    final static short X = 1;
    final static short O = 2;
    public static void main(String[] args) {
        Player p1 = new HumanPlayer("Jogador Humano", X);
        Player p2 = new MinimaxPlayer("Inteligência Artificial 2", O);
        Game game = new Game(p1, p2);
        game.start();
    }
    
}
