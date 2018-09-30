package hash;

/**
 *
 * @author victor
 */
public class MinimaxPlayer extends Player {
    IA ia;
    public MinimaxPlayer(String name, short symbol) {
        super(name, symbol);
        ia = new IA(symbol);
    }


    @Override
    public void play(Board board) {
        Board newBoard = ia.IaPlayed(board).getBoard();
        board.replaceBoard(newBoard);
    }
}
