package hash;

/**
 *
 * @author victor
 */
public class IA {
    final short PLAYED_X = 1;
    final short PLAYED_O = 2;
    final boolean MAX = true;
    final boolean MIN = false;
    private short symbol;
    public IA(short symbol) {
        this.symbol = symbol;
    }
    
    // IA Faz a jogada
    public Node IaPlayed(Board board) {
        // gera a árvore
        PlayTree tree = new PlayTree(board, symbol);        
        // chama minimax() para filhos da raiz
        short max = -2;
        Node bestPlayed = null;
        
        for (Node node : tree.getRoot().getChildren()) {
            short minimaxValue = minimax(node, MIN);
            if (minimaxValue > max) {
                max = minimaxValue;
                bestPlayed = node;
            }
        }
        
        return bestPlayed;
    }
    
    public short minimax(Node node, boolean minimax) {
        if (node.getChildren().size() == 0) { // nó folha
            return utility(node, symbol);
        }
        if (minimax == MAX) {
            short max = -2;
            for (Node aux : node.getChildren()) {
                short minimaxValue = minimax(aux, !minimax);
                if (minimaxValue > max) {
                    max = minimaxValue;
                }
            }
            return max;
        }
        if (minimax == MIN) {
            short min = 2;
            for (Node aux : node.getChildren()) {
                short minimaxValue = minimax(aux, !minimax);
                if (minimaxValue < min) {
                    min = minimaxValue;
                }
            }
            return min;
        }
        return 0;
    }
    
    public short utility(Node node, short max) {
        short check = node.getBoard().check();
        
        if (max == PLAYED_O) {
            switch (check) {
                case -1:
                    return 0;
                case 1:
                    return -1;
                case 2:
                    return 1;
            }
        } else {
            switch (check) {
                case -1:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return -1;
            }
        }
        
        return 0;
    }
}
