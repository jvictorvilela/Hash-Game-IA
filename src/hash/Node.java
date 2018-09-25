package hash;

import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class Node {
    private Board board;
    private ArrayList<Node> children;

    public Node(Board board) {
        this.board = board;
        children = new ArrayList<Node>();
    }
    
    public void addSon(Node node) {
        children.add(node);
    }
    
    public Board getBoard() {
        return board;
    }
    
    public ArrayList<Node> getChildren() {
        return children;
    }
}
