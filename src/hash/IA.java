package hash;

/**
 *
 * @author victor
 */
public class IA {
    final boolean MAX = true;
    final boolean MIN = false;
    public IA() {
        
    }
    
    // IA Faz a jogada
    public Node IaPlayed(Board board) {
        // gera a árvore
        PlayTree tree = new PlayTree(board);        
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
            return utility(node);
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
    
    public short utility(Node node) {
        short check = node.getBoard().check();
        switch (check) {
            case -1:
                return 0;
            case 1:
                return -1;
            case 2:
                return 1;
        }
        return 0;
    }
}
