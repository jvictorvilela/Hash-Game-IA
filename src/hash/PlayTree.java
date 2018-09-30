package hash;

import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class PlayTree {
    final short PLAYED_X = 1;
    final short PLAYED_O = 2;
    private Node root;
    public PlayTree(Board board, short symbol) {
        this.root = new Node(board);
        generateTree(root, symbol);
    }
    
    public void generateTree(Node node, short symbol) { // symbol indica de quem é a vez no momento (X ou O)
        if (node.getBoard().check() != 0) {
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (node.getBoard().getMatrix()[i][j] == 0) {
                    Board board = new Board(node.getBoard().copyMatrix()); // faz uma copia do tabuleiro do nó
                    if (symbol == PLAYED_X) {
                        board.play(i+1, j+1, board.PLAYED_X);
                    } else {
                        board.play(i+1, j+1, board.PLAYED_O);
                    }
                    node.addSon(new Node(board));
                }
            }
        }
        
        for (Node aux : node.getChildren()) {
            if (symbol == 1) {
                generateTree(aux, (short)2);
            } else {
                generateTree(aux, (short)1);
            }
        }
    }
    
    public Node getRoot() {
        return root;
    }
    
}
